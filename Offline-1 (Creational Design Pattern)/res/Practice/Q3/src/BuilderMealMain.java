import java.util.Scanner;

class Meal {
    private String MainCourse;
    private String SideDish;
    private String Drink;
    private String Dessert;

    public void setMainCourse(String MainCourse) {
        this.MainCourse = MainCourse;
    }

    public void setSideDish(String SideDish) {
        this.SideDish = SideDish;
    }

    public void setDrink(String Drink) {
        this.Drink = Drink;
    }

    public void setDessert(String Dessert) {
        this.Dessert = Dessert;
    }

    public void showMeal() {
        System.out.println("Main Course: " + MainCourse);
        System.out.println("Side Dish: " + SideDish);
        System.out.println("Drink: " + Drink);
        System.out.println("Dessert: " + Dessert);
    }
}

interface MealBuilder {
    public void setMainCourse();

    public void setSideDish();

    public void setDrink();

    public void setDessert();

    public Meal getMeal();
}

class VegMealBuilder implements MealBuilder {
    private Meal meal = new Meal();

    @Override
    public void setMainCourse() {
        meal.setMainCourse("Vegetarian Burger");
    }

    @Override
    public void setSideDish() {
        meal.setSideDish("French Fries");
    }

    @Override
    public void setDrink() {
        meal.setDrink("Orange Juice");
    }

    @Override
    public void setDessert() {
        meal.setDessert("Fruit Salad");
    }

    @Override
    public Meal getMeal() {
        return this.meal;
    }

}

class NonvegMealBuilder implements MealBuilder {
    private Meal meal = new Meal();

    public void setMainCourse() {
        meal.setMainCourse("Chicken Sandwich");
    }

    public void setSideDish() {
        meal.setSideDish("Coleslaw");
    }

    public void setDrink() {
        meal.setDrink("Coke");
    }

    public void setDessert() {
        meal.setDessert("No dessert");
    }

    public Meal getMeal() {
        return this.meal;
    }
}

class Director {
    public static Meal BuildMeal(MealBuilder mealBuilder) {
        mealBuilder.setMainCourse();
        mealBuilder.setSideDish();
        mealBuilder.setDrink();
        mealBuilder.setDessert();
        return mealBuilder.getMeal();
    }
}

public class BuilderMealMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an option: 1.Veg Meal, 2.Non-veg Meal");
        String choice = sc.nextLine();
        MealBuilder mealBuilder;
        if (choice.equalsIgnoreCase("Veg")) {
            mealBuilder = new VegMealBuilder();
            Meal meal = Director.BuildMeal(mealBuilder);
            meal.showMeal();
        } else if (choice.equalsIgnoreCase("Nonveg")) {
            mealBuilder = new NonvegMealBuilder();
            Meal meal = Director.BuildMeal(mealBuilder);
            meal.showMeal();
        }
        sc.close();
    }
}
