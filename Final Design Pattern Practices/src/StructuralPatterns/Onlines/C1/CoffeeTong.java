package StructuralPatterns.Onlines.C1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Coffee {
    String getIngredients();

    int getCost();
}

class BasicBlackCoffee implements Coffee {

    @Override
    public String getIngredients() {
        return "Ingridients: Water, grinded coffee beans";
    }

    @Override
    public int getCost() {
        return 100 + 30;
    }

}

class BasicMilkCoffee implements Coffee {

    @Override
    public String getIngredients() {
        return "Ingridients: Milk, grinded coffee beans";
    }

    @Override
    public int getCost() {
        return 100 + 30 + 50;
    }

}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients();
    }

    @Override
    public int getCost() {
        return coffee.getCost();
    }
}

class Americano extends CoffeeDecorator {

    public Americano(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients() + " ,Additional grinded coffee beans";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 30;
    }

}

class Cappuccino extends CoffeeDecorator {

    public Cappuccino(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getIngredients() {
        return coffee.getIngredients() + " ,Cinnamon powder";
    }

    @Override
    public int getCost() {
        return coffee.getCost() + 50;
    }

}

// Order class to handle multiple coffee orders
class Order {
    private List<Coffee> coffees = new ArrayList<>();

    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
    }

    public void printOrderDetails() {
        int totalCost = 0;
        int coffeeCount = 1;

        for (Coffee coffee : coffees) {
            System.out.println("Coffee " + coffeeCount + ":");
            System.out.println("Ingredients: " + coffee.getIngredients());
            System.out.println("Cost: " + coffee.getCost() + " taka");
            System.out.println();
            totalCost += coffee.getCost();
            coffeeCount++;
        }

        System.out.println("Total Cost for Order: " + totalCost + " taka");
    }
}

// Main Class

public class CoffeeTong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        while (true) {
            System.out.println("Select coffee type (1: Americano, 2: Espresso, 3: Cappuccino, 4: Mocha, 0: Finish): ");
            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            Coffee coffee;
            switch (choice) {
                case 1:
                    coffee = new Americano(new BasicBlackCoffee());
                    break;
                case 3:
                    coffee = new Cappuccino(new BasicMilkCoffee());
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
            order.addCoffee(coffee);
        }

        order.printOrderDetails();
        scanner.close();
    }
}
