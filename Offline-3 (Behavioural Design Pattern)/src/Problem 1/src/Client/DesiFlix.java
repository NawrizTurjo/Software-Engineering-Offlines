package Client;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ObserverPattern.*;

public class DesiFlix {
    public static void printNotifierNames(Map<String, MovieGenreNotifier> notifiers) {
        System.out.print("Notifiers: ");
        for (String notifierName : notifiers.keySet()) {
            System.out.print(notifierName + " ");
        }
        System.out.println();
    }

    public static void printUserNames(Map<String, User> users) {
        System.out.print("Users: ");
        for (String userName : users.keySet()) {
            System.out.println(users.get(userName));
        }
    }

    public static void printGenres() {
        System.out.print("Genres: ");
        for (Genre genre : Genre.values()) {
            System.out.print(genre + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create movie genre notifier
        MovieGenreNotifier notifier = new MovieGenreNotifier();
        MovieGenreNotifier notifier2 = new MovieGenreNotifier();

        Map<String, User> users = new HashMap<>();
        Map<String, MovieGenreNotifier> notifiers = new HashMap<>();
        notifiers.put("netflix", notifier);
        notifiers.put("youtube", notifier2);
        // Create users
        // User user1 = new User("Alice");
        // User user2 = new User("Bob");
        // User user3 = new User("Charlie");
        // users.put(user1.getName(), user1);
        // users.put(user2.getName(), user2);
        // users.put(user3.getName(), user3);

        // Users set their favorite genres
        // user1.addFavoriteGenre(Genre.THRILLER);

        // user2.addFavoriteGenre(Genre.HORROR);
        // user2.addFavoriteGenre(Genre.COMEDY);

        // user3.addFavoriteGenre(Genre.THRILLER);

        // Subscribe users to their preferred genres
        // notifier.subscribe(user1);
        // user1.addFavoriteGenre(Genre.COMEDY);
        // notifier.subscribe(user1);

        // notifier.subscribe(user2);
        // notifier.subscribe(user2);

        // notifier.subscribe(user3);

        // System.out.println(user1);
        // System.out.println(user2);
        // System.out.println(user3);
        // Upload movies
        // notifier.uploadMovie("Haunted House", Genre.HORROR);
        // notifier.uploadMovie("Laugh Out Loud", Genre.COMEDY);
        // notifier.uploadMovie("The Detective", Genre.THRILLER);

        Scanner sc = new Scanner(System.in);
        while (true) {
            printNotifierNames(notifiers);
            System.out.print("Enter command (notifier, user, movie, exit): ");
            String command = sc.nextLine();
            if (command.equalsIgnoreCase("notifier")) {
                System.out.print("Enter notifier name: ");
                String notifierName = sc.nextLine();
                MovieGenreNotifier newNotifier = new MovieGenreNotifier();
                notifiers.put(notifierName.toLowerCase(), newNotifier);
            } else if (command.equalsIgnoreCase("user")) {
                System.out.println("Updating User information...");
                System.out.print("Enter user name: ");
                String userName = sc.nextLine();
                User user = users.get(userName);
                if (user == null) {
                    user = new User(userName);
                    users.put(userName, user);
                }
                System.out.print("Enter genre: ");
                Genre genre = Genre.valueOf(sc.nextLine().toUpperCase());
                user.addFavoriteGenre(genre);
                System.out.print("Enter notifier name: ");
                String notifierName = sc.nextLine();
                MovieGenreNotifier noti = notifiers.get(notifierName.toLowerCase());
                if (noti == null) {
                    System.out.println("Invalid notifier");
                    continue;
                }
                noti.subscribe(user);
            } else if (command.equalsIgnoreCase("movie")) {
                System.out.print("Enter movie name: ");
                String movieName = sc.nextLine();
                System.out.print("Enter genre: ");
                Genre genre = Genre.valueOf(sc.nextLine().toUpperCase());
                if (genre == null) {
                    System.out.print("Invalid genre available genres are: Thriller, Comedy, Horror");
                    continue;
                }
                System.out.print("Enter notifier name: ");
                String notifierName = sc.nextLine();
                MovieGenreNotifier noti = notifiers.get(notifierName.toLowerCase());
                if (noti == null) {
                    System.out.println("Invalid notifier");
                    continue;
                }
                noti.uploadMovie(movieName, genre);

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
