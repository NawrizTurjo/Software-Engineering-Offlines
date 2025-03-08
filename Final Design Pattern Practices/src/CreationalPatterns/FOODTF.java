package CreationalPatterns;

interface RiceStation {
    void createRice();
}

class MushroomRice implements RiceStation {
    public void createRice() {
        System.out.println("Creating Mushroom Rice");
    }
}

class ChickenRice implements RiceStation {
    public void createRice() {
        System.out.println("Creating Chicken Rice");
    }
}

class BeefRice implements RiceStation {
    public void createRice() {
        System.out.println("Creating Beef Rice");
    }
}

class ShrimpRice implements RiceStation {
    public void createRice() {
        System.out.println("Creating Shrimp Rice");
    }
}

interface MainMania {
    void createMain();
}

class PaneerMasala implements MainMania {
    public void createMain() {
        System.out.println("Creating Paneer Masala");
    }
}

class ButterChicken implements MainMania {
    public void createMain() {
        System.out.println("Creating Butter Chicken");
    }
}

class BeefChilli implements MainMania {
    public void createMain() {
        System.out.println("Creating Beef Chilli");
    }
}

class CrabMasala implements MainMania {
    public void createMain() {
        System.out.println("Creating Crab Masala");
    }
}

interface FryMore {
    void createFry();
}

class FriedVegPakora implements FryMore {
    public void createFry() {
        System.out.println("Creating Fried Veg Pakora");
    }
}

class FriedChicken implements FryMore {
    public void createFry() {
        System.out.println("Creating Fried Chicken");
    }
}

class FriedBeef implements FryMore {
    public void createFry() {
        System.out.println("Creating Fried Beef");
    }
}

class FriedCalamari implements FryMore {
    public void createFry() {
        System.out.println("Creating Fried Calamari");
    }
}

interface FoodFactory {
    RiceStation createRice();
    MainMania createMain();
    FryMore createFry();
}

class VeggieFactory implements FoodFactory {
    public RiceStation createRice() {
        return new MushroomRice();
    }

    public MainMania createMain() {
        return new PaneerMasala();
    }

    public FryMore createFry() {
        return new FriedVegPakora();
    }
}

class ChickenFactory implements FoodFactory {
    public RiceStation createRice() {
        return new ChickenRice();
    }

    public MainMania createMain() {
        return new ButterChicken();
    }

    public FryMore createFry() {
        return new FriedChicken();
    }
}

class BeefFactory implements FoodFactory {
    public RiceStation createRice() {
        return new BeefRice();
    }

    public MainMania createMain() {
        return new BeefChilli();
    }

    public FryMore createFry() {
        return new FriedBeef();
    }
}

class SeafoodFactory implements FoodFactory {
    public RiceStation createRice() {
        return new ShrimpRice();
    }

    public MainMania createMain() {
        return new CrabMasala();
    }

    public FryMore createFry() {
        return new FriedCalamari();
    }
}

class FoodDish{
    private RiceStation rice;
    private MainMania main;
    private FryMore fry;

    public FoodDish(FoodFactory factory) {
        rice = factory.createRice();
        main = factory.createMain();
        fry = factory.createFry();
    }

    public void createFood() {
        rice.createRice();
        main.createMain();
        fry.createFry();
    }
}


public class FOODTF {
    public static void main(String[] args) {
        FoodFactory veggieFactory = new VeggieFactory();
        FoodDish veggieDish = new FoodDish(veggieFactory);
        veggieDish.createFood();

        FoodFactory chickenFactory = new ChickenFactory();
        FoodDish chickenDish = new FoodDish(chickenFactory);
        chickenDish.createFood();

        FoodFactory beefFactory = new BeefFactory();
        FoodDish beefDish = new FoodDish(beefFactory);
        beefDish.createFood();

        FoodFactory seafoodFactory = new SeafoodFactory();
        FoodDish seafoodDish = new FoodDish(seafoodFactory);
        seafoodDish.createFood();   
    }

}
