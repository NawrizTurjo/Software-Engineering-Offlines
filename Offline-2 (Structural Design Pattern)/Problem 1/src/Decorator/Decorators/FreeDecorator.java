package Decorator.Decorators;

import Composite.Composites.ComboItem;
import Composite.Interfaces.MenuItem;
import Composite.Leaf.Item;
import Decorator.BaseDecorator.ComboDecorator;

public class FreeDecorator extends ComboDecorator {
    public FreeDecorator(ComboItem comboItem, MenuItem freeItem) {
        super(comboItem);
        comboItem.add(new Item(freeItem.getName(), 0));
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }


    // @Override
    // public void setFree() {
    // // this.setFree();
    // }

}
