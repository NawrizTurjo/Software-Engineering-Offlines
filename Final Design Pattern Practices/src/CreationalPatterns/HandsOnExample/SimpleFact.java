package CreationalPatterns.HandsOnExample;

interface SimpleAnimal{
    void speak();
    void action();
}

class SimpleDog implements SimpleAnimal{
    @Override
    public void speak() {
        System.out.println("Dog says: Bow-Wow.");
    }

    @Override
    public void action() {
        System.out.println("Dogs prefer barking...");
    }
}

class SimpleCat implements SimpleAnimal{
    @Override
    public void speak() {
        System.out.println("Cat says: Meow.");
    }

    @Override
    public void action() {
        System.out.println("Cats prefer meowing...");
    }
}

class SimpleAnimalFactory{
    public SimpleAnimal getAnimal(String animalType){
        if(animalType == null){
            return null;
        }
        if(animalType.equalsIgnoreCase("DOG")){
            return new SimpleDog();
        } else if(animalType.equalsIgnoreCase("CAT")){
            return new SimpleCat();
        }
        return null;
    }
}

public class SimpleFact {
    public static void main(String[] args) {
        SimpleAnimalFactory animalFactory = new SimpleAnimalFactory();
        SimpleAnimal animal1 = animalFactory.getAnimal("DOG");
        animal1.speak();
        animal1.action();

        SimpleAnimal animal2 = animalFactory.getAnimal("CAT");
        animal2.speak();
        animal2.action();
    }
}
