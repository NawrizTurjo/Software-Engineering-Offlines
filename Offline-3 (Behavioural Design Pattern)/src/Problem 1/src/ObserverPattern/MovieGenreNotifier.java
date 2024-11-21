package ObserverPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class MovieGenreNotifier {
    private Map<Genre, Set<User>> genreSubscribers = new HashMap<>();
    private ExecutorService executor = Executors.newCachedThreadPool();

    public void subscribe(User user) {
        for (Genre genre : user.getFavoriteGenres()) {
            subscribe(user, genre); // Use the updated single-genre subscription method
            // System.out.println("Subscribers for " + genre + ": " +
            // genreSubscribers.get(genre));
        }
    }

    public void subscribe(User user, Genre genre) {
        genreSubscribers.computeIfAbsent(genre, g -> new HashSet<>()).add(user);
        if (!user.getNotifiers().contains(this)) {
            user.addNotifier(this);
        }
    }

    public void unsubscribe(User user, Genre genre) {
        Set<User> subscribers = genreSubscribers.get(genre);
        if (subscribers != null) {
            subscribers.remove(user);
        }
    }

    public void unsubscribe(User user) {
        for (Genre genre : user.getFavoriteGenres()) {
            unsubscribe(user, genre);
        }
        if (user.getNotifiers().contains(this)) {
            user.removeNotifier(this);
        }
    }

    public void uploadMovie(String movieName, Genre genre) {
        System.out.println("Uploading new " + genre + " movie: " + movieName);
        Set<User> subscribers = genreSubscribers.get(genre);

        if (subscribers != null) {
            for (User user : subscribers) {
                if (user.getFavoriteGenres().contains(genre)) {
                    executor.submit(() -> user.notify(movieName, genre));
                }
            }
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}