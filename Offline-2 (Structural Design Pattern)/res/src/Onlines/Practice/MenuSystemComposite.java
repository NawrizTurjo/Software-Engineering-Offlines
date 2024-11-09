package Onlines.Practice;

import java.util.ArrayList;
import java.util.List;

interface Dish {
    void showDetails();

    int getPrice();
}

class SimpleDish implements Dish {
    private String name;
    private int price;

    public SimpleDish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showDetails() {
        System.out.println("Simple Dish: " + this.name + " " + this.price);
    }

    @Override
    public int getPrice() {
        return this.price;
    }

}

class Menu implements Dish {
    private String name;
    private List<Dish> dishes = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("Menu: " + this.name);
        for (Dish dish : dishes) {
            dish.showDetails();
        }
    }

    @Override
    public int getPrice() {
        int total = 0;
        for (Dish dish : dishes) {
            total += dish.getPrice();
        }
        return total;
    }

    public void addComponent(Dish dish) {
        dishes.add(dish);
    }

    public void removeComponent(Dish dish)
    {
        dishes.remove(dish);
    }

}

public class MenuSystemComposite {
    public static void main(String[] args) {
        Dish dish1 = new SimpleDish("Pasta", 150);
        Dish dish2 = new SimpleDish("Pizza", 200);
        Dish dish3 = new SimpleDish("Burger", 120);

        Menu mainMenu = new Menu("Main Menu");
        mainMenu.addComponent(dish1);
        mainMenu.addComponent(dish2);

        Menu subMenu = new Menu("Side Menu");
        subMenu.addComponent(dish3);

        mainMenu.addComponent(subMenu);

        mainMenu.showDetails();
        System.out.println("Total Price of Main Menu: " + mainMenu.getPrice() + " taka");

    }
}
