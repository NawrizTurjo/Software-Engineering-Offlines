import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface MenuItem {
    String getName();

    int getPrice();

    // void setFree();
}

class item implements MenuItem {
    private String name;
    protected double price;

    item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        return (int) Math.ceil(this.price);
    }

    // @Override
    // public void setFree() {
    // this.price = 0;
    // }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        // sb.append("Item: ");
        sb.append(this.name);
        sb.append("-");
        sb.append((int) Math.ceil(this.price));
        sb.append("tk");
        return sb.toString();
    }

}

class ComboItem implements MenuItem {
    private String name;
    private double price;
    private double discount;

    private List<MenuItem> items = new ArrayList<MenuItem>();

    ComboItem(String name) {
        this.name = name;
        this.discount = 0;
        this.price = 0;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getDiscount() {
        return discount;
    }

    public void add(MenuItem item) {
        items.add(item);
        this.price += item.getPrice();
    }

    public void remove(MenuItem item) {
        if (!items.contains(item)) {
            return;
        }
        items.remove(item);
        this.price -= item.getPrice();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        double totalPrice = this.price - this.price * this.discount / 100;
        return (int) Math.ceil(totalPrice);
    }

    public int getTotalPrice() {
        return (int) Math.ceil(this.price);
    }

    // @Override
    // public void setFree() {
    // // this.price = price;
    // }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        // sb.append("Combo: ");
        sb.append(this.name);
        sb.append(" ( ");
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i).getName());
            if (i != items.size() - 1) {
                sb.append("+");
            }
        }
        sb.append(" )-");
        sb.append(this.getPrice());
        sb.append("tk");
        return sb.toString();
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

}

abstract class MenuItemDecorator implements MenuItem {
    protected MenuItem menuItem;

    public MenuItemDecorator(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public String getName() {
        return menuItem.getName();
    }

    @Override
    public int getPrice() {
        return menuItem.getPrice();
    }
}

class FreeDecorator extends MenuItemDecorator {
    public FreeDecorator(MenuItem menuItem) {
        super(menuItem);
        // this.setFree();
    }

    @Override
    public int getPrice() {
        return 0;
    }

    public String toString() {
        return menuItem.getName() + " (Free!!!)";
    }

    // @Override
    // public void setFree() {
    // // this.setFree();
    // }

}

class ComboFacade {
    private ComboItem comboItem;

    public ComboFacade(String name) {
        comboItem = new ComboItem(name);
    }

    public void add(MenuItem item) {
        comboItem.add(item);
    }

    public void remove(MenuItem item) {
        comboItem.remove(item);
    }

    public void makeFree(MenuItem menuItem) {
        menuItem = new FreeDecorator(menuItem);
        comboItem.add(menuItem);
    }

    public void setDiscount(double discount) {
        comboItem.setDiscount(discount);
    }

    public ComboItem getComboItem() {
        return comboItem;
    }
}

public class KhaidaiBostro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        item burger = new item("Burger", 300);
        item fries = new item("Fries", 100);
        item wedges = new item("Wedges", 150);
        item shwarma = new item("Shwarma", 200);
        item drink = new item("Drink", 25);
        ComboFacade combo1 = new ComboFacade("Combo1");
        combo1.add(burger);
        combo1.add(fries);
        combo1.makeFree(drink);

        ComboFacade combo2 = new ComboFacade("Combo2");
        combo2.add(shwarma);
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
        menu.add(new Pair("Shwarma", shwarma));
        menu.add(new Pair("Drink", drink));
        menu.add(new Pair("Combo1", combo1.getComboItem()));
        menu.add(new Pair("Combo2", combo2.getComboItem()));

        System.out.println("Menu:");
        for (Pair entry : menu) {
            System.out.println(entry.getValue());
        }

        System.out.println("Press 1 to create a combo, 2 to view menu and 0 to exit");
        int num = sc.nextInt();
        while (num != 0) {
            sc.nextLine();
            if (num == 1) {
                System.out.println("Enter the name of the combo:");
                String comboName = sc.nextLine();

                ComboFacade newCombo = new ComboFacade(comboName);
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
                                newCombo.makeFree(entry.getValue());
                            }
                        }
                    } else if (tokens[0].equalsIgnoreCase("Discount")) {
                        newCombo.setDiscount(Double.parseDouble(tokens[1]));
                    }
                }
                // System.out.println(newCombo.getComboItem());
                System.out.println("Your Combo:");
                System.out.println(newCombo.getComboItem().getName());
                for (MenuItem item : newCombo.getComboItem().getItems()) {
                    System.out.println("\t- " + item);
                }
                System.out.println("Total - " + newCombo.getComboItem().getTotalPrice());
                System.out.println("Discount - " + newCombo.getComboItem().getDiscount() + "%");
                System.out.println("Discounted Total - " + newCombo.getComboItem().getPrice());

                menu.add(new Pair(comboName, newCombo.getComboItem()));
            } else if (num == 2) {
                System.out.println("Menu:");
                for (Pair entry : menu) {
                    System.out.println(entry.getValue());
                }
            }

            System.out.println("Press 1 to create a combo, 2 to view menu and 0 to exit");
            num = sc.nextInt();
        }
        sc.close();
    }

}
