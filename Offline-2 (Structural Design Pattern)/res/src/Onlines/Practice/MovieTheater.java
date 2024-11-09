package Onlines.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface MovieTicket {
    String getFeatures();

    int getCost();
}

class BasicMovieTicket implements MovieTicket {
    @Override
    public String getFeatures() {
        return "Basic Movie Ticket";
    }

    @Override
    public int getCost() {
        return 200;
    }
}

class TicketOrder {
    private List<MovieTicket> tickets = new ArrayList<>();

    public void addTicket(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public void printOrderDetails() {
        int totalCost = 0;
        int ticketCount = 1;

        for (MovieTicket ticket : tickets) {
            System.out.println("Ticket " + ticketCount + ":");
            System.out.println("Features: " + ticket.getFeatures());
            System.out.println("Cost: " + ticket.getCost() + " taka");
            System.out.println();
            totalCost += ticket.getCost();
            ticketCount++;
        }

        System.out.println("Total Cost for Order: " + totalCost + " taka");
    }
}

class TicketDecorator implements MovieTicket {
    protected MovieTicket ticket;

    public TicketDecorator(MovieTicket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String getFeatures() {
        return ticket.getFeatures();
    }

    @Override
    public int getCost() {
        return ticket.getCost();
    }
}

class VIPAccess extends TicketDecorator {
    public VIPAccess(MovieTicket ticket) {
        super(ticket);
    }

    @Override
    public String getFeatures() {
        return super.getFeatures() + ", VIP Lounge Access";
    }

    @Override
    public int getCost() {
        return super.getCost() + 100;
    }
}

class ThreeDGlasses extends TicketDecorator {
    public ThreeDGlasses(MovieTicket ticket) {
        super(ticket);
    }

    @Override
    public String getFeatures() {
        return super.getFeatures() + ", 3D Glasses";
    }

    @Override
    public int getCost() {
        return super.getCost() + 50;
    }
}

class Snacks extends TicketDecorator {
    public Snacks(MovieTicket ticket) {
        super(ticket);
    }

    @Override
    public String getFeatures() {
        return ticket.getFeatures() + ", Snacks";
    }

    @Override
    public int getCost() {
        return ticket.getCost() + 80;
    }
}

// Main Class
public class MovieTheater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketOrder order = new TicketOrder();

        while (true) {
            System.out.println("Select ticket (1: Basic Ticket, 2: VIP Access, 3: 3D Glasses, 4: Snacks, 0: Finish): ");
            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            MovieTicket ticket = new BasicMovieTicket();
            switch (choice) {
                case 1:
                    ticket = new BasicMovieTicket();
                    break;
                case 2:
                    ticket = new VIPAccess(ticket);
                    break;
                case 3:
                    ticket = new ThreeDGlasses(ticket);
                    break;
                case 4:
                    ticket = new Snacks(ticket);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
            order.addTicket(ticket);
        }

        order.printOrderDetails();
        scanner.close();
    }
}