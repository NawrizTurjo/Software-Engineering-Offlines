package ObserverPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class MovieGenreNotifier implements iMovieGenreNotifier {
    private Map<Genre, Set<MovieObserver>> genreSubscribers = new HashMap<>();
    // private ExecutorService executor = Executors.newCachedThreadPool();
    private ForkJoinPool executor = ForkJoinPool.commonPool();

    public void subscribe(MovieObserver user) {
        for (Genre genre : user.getFavoriteGenres()) {
            subscribe(user, genre); // Use the updated single-genre subscription method
            // System.out.println("Subscribers for " + genre + ": " +
            // genreSubscribers.get(genre));
        }
    }

    public void subscribe(MovieObserver user, Genre genre) {
        genreSubscribers.computeIfAbsent(genre, g -> new HashSet<>()).add(user);
        // if (!user.getNotifiers().contains(this)) {
        // user.addNotifier(this);
        // }
        if (user.getNotifiers() == null) {
            user.addNotifier(this);
        }
    }

    public void unsubscribe(MovieObserver user, Genre genre) {
        Set<MovieObserver> subscribers = genreSubscribers.get(genre);
        if (subscribers != null) {
            subscribers.remove(user);
        }
    }

    public void unsubscribe(MovieObserver user) {
        for (Genre genre : user.getFavoriteGenres()) {
            unsubscribe(user, genre);
        }
        // if (user.getNotifiers().contains(this)) {
        // user.removeNotifier(this);
        // }
        if (user.getNotifiers() != null) {
            user.removeNotifier(this);
        }
    }

    public void uploadMovie(String movieName, Genre genre) {
        System.out.println("Uploading new " + genre + " movie: " + movieName);
        Set<MovieObserver> subscribers = genreSubscribers.get(genre);

        if (subscribers != null) {
            for (MovieObserver user : subscribers) {
                if (user.getFavoriteGenres().contains(genre)) {
                    executor.submit(() -> user.notify(movieName, genre));
                    // new Thread(() -> user.notify(movieName, genre)).start();
                }
            }
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}