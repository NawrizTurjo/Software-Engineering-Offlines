package Composite.Leaf;

import Composite.Interfaces.MenuItem;

public class Item implements MenuItem {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        // sb.append("Item: ");
        sb.append(this.name);
        if (this.price == 0) {
            sb.append("(Free!!!)");
            return sb.toString();
        }
        sb.append("-");
        sb.append((int) Math.ceil(this.price));
        sb.append("tk");
        return sb.toString();
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

}
