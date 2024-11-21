package ObserverPattern;

public interface MovieObserver {
    void notify(String movieName, Genre genre);
}
