package CreationalPatterns.Onlines.B2;

// Step 1: Create the `Meal` class representing the final product
class Meal {
    private String starter;
    private String mainDish;
    private String dessert;

    public void setStarter(String starter) {
        this.starter = starter;
    }

    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    @Override
    public String toString() {
        return "Meal:\nStarter: " + starter + "\nMain Dish: " + mainDish + "\nDessert: " + dessert;
    }
}

// Step 2: Create the `MealBuilder` abstract class
abstract class MealBuilder {
    protected Meal meal;

    public MealBuilder() {
        meal = new Meal();
    }

    public abstract void buildStarter();

    public abstract void buildMainDish();

    public abstract void buildDessert();

    public Meal getMeal() {
        return meal;
    }
}

// Step 3: Implement concrete builders for Bengali and Chinese meals
class BengaliMealBuilder extends MealBuilder {
    @Override
    public void buildStarter() {
        meal.setStarter("Vegetable");
    }

    @Override
    public void buildMainDish() {
        meal.setMainDish("Chicken Curry");
    }

    @Override
    public void buildDessert() {
        meal.setDessert("Sweet Curd");
    }
}

class ChineseMealBuilder extends MealBuilder {
    @Override
    public void buildStarter() {
        meal.setStarter("Soup");
    }

    @Override
    public void buildMainDish() {
        meal.setMainDish("Peking Duck");
    }

    @Override
    public void buildDessert() {
        meal.setDessert("Pudding");
    }
}

// Step 4: Create the `MealDirector` class
class MealDirector {
    private MealBuilder mealBuilder;

    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal createMeal() {
        mealBuilder.buildStarter();
        mealBuilder.buildMainDish();
        mealBuilder.buildDessert();
        return mealBuilder.getMeal();
    }
}

// Step 5: Main class to demonstrate the system
public class B2Online {
    public static void main(String[] args) {
        // Creating a Bengali meal
        MealBuilder bengaliMealBuilder = new BengaliMealBuilder();
        MealDirector bengaliDirector = new MealDirector(bengaliMealBuilder);
        Meal bengaliMeal = bengaliDirector.createMeal();
        System.out.println("Bengali Meal:");
        System.out.println(bengaliMeal);

        System.out.println();

        // Creating a Chinese meal
        MealBuilder chineseMealBuilder = new ChineseMealBuilder();
        MealDirector chineseDirector = new MealDirector(chineseMealBuilder);
        Meal chineseMeal = chineseDirector.createMeal();
        System.out.println("Chinese Meal:");
        System.out.println(chineseMeal);
    }
}
