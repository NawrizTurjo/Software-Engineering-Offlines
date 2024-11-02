package Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Composite.Composites.ComboItem;
import Composite.Interfaces.MenuItem;
import Composite.Leaf.Item;
// import Decorator.Decorators.DiscountDecorator;
// import Decorator.Decorators.FreeDecorator;

public class KhaidaiBistro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuItem burger = new Item("Burger", 300);
        MenuItem fries = new Item("Fries", 100);
        MenuItem wedges = new Item("Wedges", 150);
        MenuItem shawarma = new Item("Shawarma", 200);
        MenuItem drink = new Item("Drink", 25);

        ComboItem combo1 = new ComboItem("Combo1");
        combo1.add(burger);
        combo1.add(fries);
        combo1.add(new Item("Drink", 0));

        ComboItem combo2 = new ComboItem("Combo2");
        combo2.add(shawarma);
        combo2.add(drink);
        combo2.setDiscount(40.0 / 9.0);

        class Pair {
            private String x;
            private MenuItem y;

            public Pair(String x, MenuItem y) {
                this.x = x;
                this.y = y;
            }

            public String getString() {
                return x;
            }

            public MenuItem getValue() {
                return y;
            }
        }
        List<Pair> menu = new ArrayList<>();
        menu.add(new Pair("Burger", burger));
        menu.add(new Pair("Fries", fries));
        menu.add(new Pair("Wedges", wedges));
        menu.add(new Pair("Shawarma", shawarma));
        menu.add(new Pair("Drink", drink));
        menu.add(new Pair("Combo1", combo1));
        menu.add(new Pair("Combo2", combo2));

        System.out.println("Menu:");
        for (Pair entry : menu) {
            System.out.println(entry.getValue());
        }

        System.out.println("Press 1 to create a combo, 2 to view menu and 0 to exit");
        int num;
        while ((num = sc.nextInt()) != 0) {
            sc.nextLine();
            if (num == 1) {
                System.out.println("Enter the name of the combo:");
                String comboName = sc.nextLine();

                ComboItem newCombo = new ComboItem(comboName);
                System.out.println("Available commands:\r\n" + //
                        "Add [item]\r\n" + //
                        "Remove [item]\r\n" + //
                        "Free [item]\r\n" + //
                        "Discount [percentage]\r\n" + //
                        "Done\r\n");
                while (true) {
                    String command = sc.nextLine();
                    if (command.equalsIgnoreCase("Done")) {
                        break;
                    }
                    String[] tokens = command.split(" ");
                    if (tokens[0].equalsIgnoreCase("Add")) {
                        for (Pair entry : menu) {
                            if (entry.getString().equalsIgnoreCase(tokens[1])) {
                                newCombo.add(entry.getValue());
                            }
                        }
                    } else if (tokens[0].equalsIgnoreCase("Remove")) {
                        for (Pair entry : menu) {
                            if (entry.getString().equalsIgnoreCase(tokens[1])) {
                                newCombo.remove(entry.getValue());
                            }
                        }
                    } else if (tokens[0].equalsIgnoreCase("Free")) {
                        for (Pair entry : menu) {
                            if (entry.getString().equalsIgnoreCase(tokens[1])) {
                                // newCombo = new FreeDecorator(newCombo, entry.getValue());
                                newCombo.add(new Item(entry.getValue().getName(),0));
                            }
                        }
                    } else if (tokens[0].equalsIgnoreCase("Discount")) {
                        // newCombo = new DiscountDecorator(newCombo, Double.parseDouble(tokens[1]));
                        newCombo.setDiscount(Double.parseDouble(tokens[1]));
                    }
                }
                // System.out.println(newCombo.getComboItem());
                System.out.println("Your Combo:");
                System.out.println(newCombo.getName());
                for (MenuItem item : newCombo.getItems()) {
                    System.out.println("\t- " + item);
                }
                System.out.println("Total - " + newCombo.getTotalPrice() + "tk");
                System.out.println("Discount - " + newCombo.getDiscount() + "%");
                System.out.println("Discounted Total - " + newCombo.getPrice() + "tk");

                menu.add(new Pair(comboName, newCombo));
            } else if (num == 2) {
                System.out.println("Menu:");
                for (Pair entry : menu) {
                    System.out.println(entry.getValue());
                }
            } else {
                System.out.println("Invalid input");
            }

            System.out.println("Press 1 to create a combo, 2 to view menu and 0 to exit");
            // num = sc.nextInt();
        }
        sc.close();
    }

}
