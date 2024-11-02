package Decorator.BaseDecorator;

import Composite.Composites.ComboItem;

public abstract class ComboDecorator extends ComboItem {
    protected ComboItem comboItem;

    public ComboDecorator(ComboItem comboItem) {
        super(comboItem);
        this.comboItem = comboItem;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }
}
