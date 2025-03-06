package CreationalPatterns.HandsOnExample;

interface AbstractFactoryDog {
    void speak();

    void preferredAction();
}

interface AbstractFactoryTiger {
    void speak();

    void preferredAction();
}

class AbstractFactoryWildDog implements AbstractFactoryDog {
    @Override
    public void speak() {
        System.out.println("Wild Dog says: Bow-Wow.");
    }

    @Override
    public void preferredAction() {
        System.out.println("Wild Dogs prefer barking...");
    }
}

class AbstractFactoryPetDog implements AbstractFactoryDog {
    @Override
    public void speak() {
        System.out.println("Pet Dog says: Bow-Wow.");
    }

    @Override
    public void preferredAction() {
        System.out.println("Pet Dogs prefer barking...");
    }
}

class AbstractFactoryWildTiger implements AbstractFactoryTiger {
    @Override
    public void speak() {
        System.out.println("Wild Tiger says: Halum.");
    }

    @Override
    public void preferredAction() {
        System.out.println("Wild Tigers prefer hunting...");
    }
}

class AbstractFactoryPetTiger implements AbstractFactoryTiger {
    @Override
    public void speak() {
        System.out.println("Pet Tiger says: Halum.");
    }

    @Override
    public void preferredAction() {
        System.out.println("Pet Tigers prefer playing...");
    }
}

interface AbstractFactoryFactory {
    AbstractFactoryDog createDog();

    AbstractFactoryTiger createTiger();
}

class AbstractFactoryWildAnimal implements AbstractFactoryFactory {
    @Override
    public AbstractFactoryDog createDog() {
        return new AbstractFactoryWildDog();
    }

    @Override
    public AbstractFactoryTiger createTiger() {
        return new AbstractFactoryWildTiger();
    }
}

class AbstractFactoryPetAnimal implements AbstractFactoryFactory {
    @Override
    public AbstractFactoryDog createDog() {
        return new AbstractFactoryPetDog();
    }

    @Override
    public AbstractFactoryTiger createTiger() {
        return new AbstractFactoryPetTiger();
    }
}


public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactoryFactory wildAnimalFactory = new AbstractFactoryWildAnimal();
        AbstractFactoryDog wildDog = wildAnimalFactory.createDog();
        wildDog.speak();
        wildDog.preferredAction();

        AbstractFactoryTiger wildTiger = wildAnimalFactory.createTiger();
        wildTiger.speak();
        wildTiger.preferredAction();

        AbstractFactoryFactory petAnimalFactory = new AbstractFactoryPetAnimal();
        AbstractFactoryDog petDog = petAnimalFactory.createDog();
        petDog.speak();
        petDog.preferredAction();

        AbstractFactoryTiger petTiger = petAnimalFactory.createTiger();
        petTiger.speak();
        petTiger.preferredAction();
    }
}
