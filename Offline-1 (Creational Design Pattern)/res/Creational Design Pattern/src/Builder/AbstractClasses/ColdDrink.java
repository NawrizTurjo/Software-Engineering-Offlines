package Builder.AbstractClasses;

import Builder.CommonConcrete.Bottle;
import Builder.Interfaces.Item;
import Builder.Interfaces.Packing;

public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
       return new Bottle();
	}

	@Override
	public abstract float price();
}