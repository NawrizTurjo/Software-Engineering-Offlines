package Decorator.Decorators;

import Composite.Composites.ComboItem;
import Decorator.BaseDecorator.ComboDecorator;

public class DiscountDecorator extends ComboDecorator {
    private double discount;

    public DiscountDecorator(ComboItem comboItem, double discount) {
        super(comboItem);
        // super.setDiscount(discount);
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return super.getPrice() - (int) Math.ceil(super.getPrice() * discount / 100);
    }

    public double getDiscount() {
        return discount;
    }

    // public String toString() {
    // StringBuilder sb = new StringBuilder();
    // sb.append(comboItem.getName());
    // sb.append(" ");
    // sb.append(this.getPrice());
    // sb.append("(" + discount + "% off)");
    // return sb.toString();
    // }
}
