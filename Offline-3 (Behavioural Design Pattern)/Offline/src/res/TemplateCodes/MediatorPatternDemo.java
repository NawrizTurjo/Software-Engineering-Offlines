import java.util.ArrayList;
import java.util.List;

// Mediator Interface
interface Mediator {
    void sendMessage(String message, Colleague colleague);

    void addColleague(Colleague colleague);
}

// Concrete Mediator
class ConcreteMediator implements Mediator {
    private final List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            if (colleague != sender) {
                colleague.receiveMessage(message);
            }
        }
    }
}

// Colleague Interface
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receiveMessage(String message);

    public abstract void sendMessage(String message);
}

// Concrete Colleague A
class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Colleague A received: " + message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Colleague A sending: " + message);
        mediator.sendMessage(message, this);
    }
}

// Concrete Colleague B
class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Colleague B received: " + message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Colleague B sending: " + message);
        mediator.sendMessage(message, this);
    }
}

// Client Code
public class MediatorPatternDemo {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        Colleague colleagueA = new ConcreteColleagueA(mediator);
        Colleague colleagueB = new ConcreteColleagueB(mediator);

        mediator.addColleague(colleagueA);
        mediator.addColleague(colleagueB);

        colleagueA.sendMessage("Hello from A!");
        // Output:
        // Colleague A sending: Hello from A!
        // Colleague B received: Hello from A!

        colleagueB.sendMessage("Hi there, A!");
        // Output:
        // Colleague B sending: Hi there, A!
        // Colleague A received: Hi there, A!
    }
}
