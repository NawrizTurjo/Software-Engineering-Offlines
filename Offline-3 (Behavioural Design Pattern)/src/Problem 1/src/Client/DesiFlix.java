package Client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ObserverPattern.*;

public class DesiFlix {
    // public static void printNotifierNames(Map<String, MovieGenreNotifier>
    // notifiers) {
    // System.out.print("Notifiers: ");
    // for (String notifierName : notifiers.keySet()) {
    // System.out.print(notifierName + " ");
    // }
    // System.out.println();
    // }

    public static void printUserNames(Map<String, MovieObserver> users) {
        System.out.println("-------------------Users-------------------");
        for (String userName : users.keySet()) {
            System.out.println(users.get(userName));
        }
        System.out.println("-------------------------------------------");
    }

    public static void printGenres() {
        System.out.print("Available Genres: " + Arrays.toString(Genre.values()));
        System.out.println();
    }

    public static void printMovies(Map<Genre, MovieGenres> movieLibrary) {
        System.out.println("Movie Library: ");
        for (Genre genre : movieLibrary.keySet()) {
            System.out.println(movieLibrary.get(genre));
        }
    }

    public static void main(String[] args) {
        // Create movie genre notifier
        iMovieGenreNotifier notifier = new MovieGenreNotifier();

        Map<String, MovieObserver> users = new HashMap<>();
        Map<Genre, MovieGenres> movieLibrary = new HashMap<>();

        // for (Genre genre : Genre.values()) {
        // movieLibrary.put(genre, new MovieGenres(genre));
        // }
        // Create users
        MovieObserver user1 = new User("Alice");
        MovieObserver user2 = new User("Bob");
        MovieObserver user3 = new User("Charlie");
        users.put(user1.getName(), user1);
        users.put(user2.getName(), user2);
        users.put(user3.getName(), user3);

        // Users set their favorite genres
        user1.addFavoriteGenre(Genre.THRILLER);

        user2.addFavoriteGenre(Genre.HORROR);
        user2.addFavoriteGenre(Genre.COMEDY);

        user3.addFavoriteGenre(Genre.THRILLER);

        // Subscribe users to their preferred genres
        notifier.subscribe(user1);
        user1.addFavoriteGenre(Genre.COMEDY);

        notifier.subscribe(user2);

        notifier.subscribe(user3);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        // Upload movies
        notifier.uploadMovie("Haunted House", Genre.HORROR);
        movieLibrary.computeIfAbsent(Genre.HORROR, g -> new MovieGenres(g)).addMovie("Haunted House");
        notifier.uploadMovie("Laugh Out Loud", Genre.COMEDY);
        movieLibrary.computeIfAbsent(Genre.COMEDY, g -> new MovieGenres(g)).addMovie("Laugh Out Loud");
        notifier.uploadMovie("The Detective", Genre.THRILLER);
        movieLibrary.computeIfAbsent(Genre.THRILLER, g -> new MovieGenres(g)).addMovie("The Detective");

        Scanner sc = new Scanner(System.in);
        while (true) {
            // printNotifierNames(notifiers);
            System.out.print("Enter command (user, movie,showLibrary, exit): ");
            String command = sc.nextLine();
            if (command.equalsIgnoreCase("user")) {
                System.out.println("Updating User information...");
                System.out.print("Enter user name: ");
                String userName = sc.nextLine();
                MovieObserver user = users.get(userName);
                if (user == null) {
                    System.out.print("User not found. Creating new user...");
                    user = new User(userName);
                    users.put(userName, user);
                }
                System.out.println("User: " + user);
                System.out.print("Add/Remove: ");
                String action = sc.nextLine();
                if (!action.equalsIgnoreCase("add") && !action.equalsIgnoreCase("remove")) {
                    System.out.println("Invalid action. Please enter add or remove.");
                    continue;
                }
                System.out.print("Enter genre: ");
                String genreStr = sc.nextLine();
                String genres = Arrays.toString(Genre.values());
                if (!genres.contains(genreStr.toUpperCase())) {
                    System.out.println("Invalid genre. Available genres are: " + genres);
                    continue;
                }
                Genre genre = Genre.valueOf(genreStr.toUpperCase());

                if (genre == null) {
                    System.out.print("Invalid genre available genres are:" + Genre.values());
                    continue;
                }
                if (action.equalsIgnoreCase("add")) {
                    user.addFavoriteGenre(genre);
                    notifier.subscribe(user, genre);
                } else if (action.equalsIgnoreCase("remove")) {
                    user.removeFavoriteGenre(genre);
                    notifier.unsubscribe(user, genre);
                } else {
                    System.out.println("Invalid action");
                }
                // System.out.print("Enter genre: ");
                // Genre genre = Genre.valueOf(sc.nextLine().toUpperCase());
                // user.addFavoriteGenre(genre);
                // notifier.subscribe(user);
            } else if (command.equalsIgnoreCase("movie")) {
                System.out.print("Enter movie name: ");
                String movieName = sc.nextLine();
                System.out.print("Enter genre: ");
                String genreStr = sc.nextLine();
                String genres = Arrays.toString(Genre.values());
                if (!genres.contains(genreStr.toUpperCase())) {
                    System.out.println("Invalid genre. Available genres are: " + genres);
                    continue;
                }
                Genre genre = Genre.valueOf(genreStr.toUpperCase());
                notifier.uploadMovie(movieName, genre);
                movieLibrary.computeIfAbsent(genre, g -> new MovieGenres(g)).addMovie(movieName);

            } else if (command.equalsIgnoreCase("showlibrary")) {
                printGenres();
                printUserNames(users);
                printMovies(movieLibrary);

            } else if (command.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid command");
            }

        }
        sc.close();

        // Shutdown executor after use
        notifier.shutdown();
    }
}
