package CreationalPatterns;

interface HondaFactory {
    Engine createEngine();

    Body createBody();
}

class CivicFactory implements HondaFactory {
    public Engine createEngine() {
        return new CivicEngine();
    }

    public Body createBody() {
        return new CivicBody();
    }
}

class AccordFactory implements HondaFactory {
    public Engine createEngine() {
        return new AccordEngine();
    }

    public Body createBody() {
        return new AccordBody();
    }
}

interface Engine {
    void createEngine();
}

class CivicEngine implements Engine {
    public void createEngine() {
        System.out.println("Creating Civic Engine");
    }
}

class AccordEngine implements Engine {
    public void createEngine() {
        System.out.println("Creating Accord Engine");
    }
}

interface Body {
    void createBody();
}

class CivicBody implements Body {
    public void createBody() {
        System.out.println("Creating Civic Body");
    }
}

class AccordBody implements Body {
    public void createBody() {
        System.out.println("Creating Accord Body");
    }
}

abstract class Car {
    Engine engine;
    Body body;

    public abstract void createCar();
}

class Civic extends Car {

    public Civic() {
        engine = new CivicEngine();
        body = new CivicBody();
    }

    public void createCar() {
        System.out.println("Creating Civic Car");
    }
}

class Accord extends Car {

    public Accord() {
        engine = new AccordEngine();
        body = new AccordBody();
    }

    public void createCar() {
        System.out.println("Creating Accord Car");
    }
}

class CarFactoryProducer {
    public static Car getCar(String factoryType) {
        if (factoryType.equalsIgnoreCase("Civic")) {
            return new Civic();
        } else if (factoryType.equalsIgnoreCase("Accord")) {
            return new Accord();
        }
        return null;
    }
}

public class CarFactory {
    public static void main(String[] args) {
        Car car = CarFactoryProducer.getCar("Civic");
        car.createCar();

    }
}
