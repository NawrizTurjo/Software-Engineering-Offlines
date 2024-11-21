package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class MovieGenres {
    private Genre genre;
    private List<String> movies = new ArrayList<>();

    public MovieGenres(Genre genre) {
        this.genre = genre;
    }

    public void addMovie(String movie) {
        movies.add(movie);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(genre).append(": ");
        if (movies.isEmpty()) {
            sb.append("No movies available");
            return sb.toString();
        }
        for (int i = 0; i < movies.size(); i++) {
            sb.append(movies.get(i));
            if (i != movies.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}
