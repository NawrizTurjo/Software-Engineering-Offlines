package Composite.Composites;

import java.util.ArrayList;
import java.util.List;

import Composite.Interfaces.MenuItem;

public class ComboItem implements MenuItem {
    private String name;
    private double price;
    private double discount;

    private List<MenuItem> items = new ArrayList<MenuItem>();

    public ComboItem(String name) {
        this.name = name;
        this.discount = 0;
        this.price = 0;
    }

    public ComboItem(ComboItem comboItem) {
        this.name = comboItem.getName();
        this.price = comboItem.getPrice();
        this.items = comboItem.getItems();
        this.discount = comboItem.getDiscount();
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getDiscount() {
        return discount;
    }

    public void add(MenuItem item) {
        for (MenuItem i : items) {
            if (i.getName().equals(item.getName())) {
                this.price -= i.getPrice();
                this.price += item.getPrice();
                items.remove(i);
                items.add(item);
                return;
            }
        }
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
        this.price = getTotalPrice();
        double totalPrice = Math.max(0, this.price - this.price * this.discount / 100);
        return (int) Math.ceil(totalPrice);
    }

    public int getTotalPrice() {
        double totalPrice = 0;
        for (MenuItem item : items) {
            totalPrice += item.getPrice();
        }
        return (int) Math.ceil(totalPrice);
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
        // if (discount != 0) {
        // sb.append(" (");
        // sb.append(discount);
        // sb.append("% off)");
        // }
        return sb.toString();
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public void setPrice(int i) {
        this.price = i;
    }

}
