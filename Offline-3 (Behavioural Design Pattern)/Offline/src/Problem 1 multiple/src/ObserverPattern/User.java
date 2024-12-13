package ObserverPattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements MovieObserver {
    private String name;
    private Set<Genre> favoriteGenres = new HashSet<>();
    private List<MovieGenreNotifier> notifiers = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addFavoriteGenre(Genre genre) {
        if(favoriteGenres.contains(genre)) {
            return;
        }
        if (favoriteGenres.add(genre)) {
            for (MovieGenreNotifier notifier : notifiers) {
                notifier.subscribe(this, genre);
            }
        }
    }

    public List<MovieGenreNotifier> getNotifiers() {
        return notifiers;
    }

    public void addNotifier(MovieGenreNotifier notifier) {
        if (notifiers.contains(notifier)) {
            return;
        }
        notifiers.add(notifier);
        for (Genre genre : favoriteGenres) {
            notifier.subscribe(this, genre);
        }
    }

    public void removeNotifier(MovieGenreNotifier notifier) {
        if (notifiers.isEmpty()) {
            return;
        }
        notifiers.remove(notifier);
    }

    public void removeFavoriteGenre(Genre genre) {
        favoriteGenres.remove(genre);
        if (notifiers.isEmpty()) {
            return;
        }
        for (MovieGenreNotifier notifier : notifiers) {
            notifier.unsubscribe(this, genre);
        }
    }

    public Set<Genre> getFavoriteGenres() {
        return favoriteGenres;
    }

    @Override
    public void notify(String movieName, Genre genre) {
        System.out.println("Notification to " + name + ": New " + genre + " movie uploaded: " + movieName);
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
