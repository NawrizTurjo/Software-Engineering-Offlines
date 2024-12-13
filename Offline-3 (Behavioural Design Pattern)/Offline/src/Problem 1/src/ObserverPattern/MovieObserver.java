package ObserverPattern;

import java.util.Set;

public interface MovieObserver {
    void notify(String movieName, Genre genre);

    String getName();

    void addNotifier(MovieGenreNotifier notifier);

    void removeNotifier(MovieGenreNotifier notifier);

    void addFavoriteGenre(Genre genre);

    void removeFavoriteGenre(Genre genre);

    MovieGenreNotifier getNotifiers();

    Set<Genre> getFavoriteGenres();
}
