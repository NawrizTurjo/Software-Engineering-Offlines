package CreationalPatterns.HandsOnExample;

interface FactoryMethodAnimal {
    void speak();

    void action();
}

class FactoryMethodDog implements FactoryMethodAnimal {
    @Override
    public void speak() {
        System.out.println("Dog says: Bow-Wow.");
    }

    @Override
    public void action() {
        System.out.println("Dogs prefer barking...");
    }
}

class FactoryMethodCat implements FactoryMethodAnimal {
    @Override
    public void speak() {
        System.out.println("Cat says: Meow.");
    }

    @Override
    public void action() {
        System.out.println("Cats prefer meowing...");
    }
}

abstract class FactoryMethodAnimalFactory {
    public FactoryMethodAnimal makeAnimal() {
        FactoryMethodAnimal animal = getAnimal();
        animal.speak();
        animal.action();
        return animal;
    }

    public abstract FactoryMethodAnimal getAnimal();
}

class FactoryMethodDogFactory extends FactoryMethodAnimalFactory {
    @Override
    public FactoryMethodAnimal getAnimal() {
        return new FactoryMethodDog();
    }
}

class FactoryMethodCatFactory extends FactoryMethodAnimalFactory {
    @Override
    public FactoryMethodAnimal getAnimal() {
        return new FactoryMethodCat();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        FactoryMethodAnimalFactory dogFactory = new FactoryMethodDogFactory();
        dogFactory.makeAnimal();

        FactoryMethodAnimalFactory catFactory = new FactoryMethodCatFactory();
        catFactory.makeAnimal();
    }
}
