package ObserverPattern;

import java.util.HashSet;
import java.util.Set;

public class User implements MovieObserver {
    private String name;
    private Set<Genre> favoriteGenres = new HashSet<>();
    private MovieGenreNotifier notifiers;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addFavoriteGenre(Genre genre) {
        if (favoriteGenres.contains(genre)) {
            return;
        }
        if (favoriteGenres.add(genre) && notifiers != null) {
            notifiers.subscribe(this, genre);
        }
    }

    public MovieGenreNotifier getNotifiers() {
        return this.notifiers;
    }

    public void addNotifier(MovieGenreNotifier notifier) {
        if (notifiers != null) {
            return;
        }
        notifiers = notifier;
        for (Genre genre : favoriteGenres) {
            notifier.subscribe(this, genre);
        }
    }

    public void removeNotifier(MovieGenreNotifier notifier) {
        if (notifiers == null) {
            return;
        }
        notifiers = null;
    }

    public void removeFavoriteGenre(Genre genre) {
        favoriteGenres.remove(genre);
        if (notifiers == null) {
            return;
        }
        // for (MovieGenreNotifier notifier : notifiers) {
        notifiers.unsubscribe(this, genre);
        // }
    }

    public Set<Genre> getFavoriteGenres() {
        return favoriteGenres;
    }

    @Override
    public void notify(String movieName, Genre genre) {
        // System.out.println("Notification to " + name + ": New " + genre + " movie
        // uploaded: " + movieName);
        System.out.println("Notification to " + name + ": New " + genre + " movie uploaded: " + movieName
                + " (Thread ID: " + Thread.currentThread().threadId() + ")");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(name).append("\n");
        sb.append("Favorite Genres: ");
        for (Genre genre : favoriteGenres) {
            sb.append(genre).append(" ");
        }
        return sb.toString();
    }
}
