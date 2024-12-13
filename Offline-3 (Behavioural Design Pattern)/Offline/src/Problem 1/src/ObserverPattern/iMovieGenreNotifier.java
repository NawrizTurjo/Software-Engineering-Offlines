package ObserverPattern;

public interface iMovieGenreNotifier {
    void subscribe(MovieObserver user);

    void subscribe(MovieObserver user, Genre genre);

    void unsubscribe(MovieObserver user);

    void unsubscribe(MovieObserver user, Genre genre);

    void uploadMovie(String movieName, Genre genre);

    void shutdown();
}
