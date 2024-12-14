package BehavioralPatterns;

// Strategy Interface
interface Strategy {
    void execute();
}

// Concrete Strategy A
class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing Strategy A");
    }
}

// Concrete Strategy B
class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing Strategy B");
    }
}

// Context Class
class Context {
    private Strategy strategy;

    // Constructor
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // Set a new strategy at runtime
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // Execute the current strategy
    public void executeStrategy() {
        strategy.execute();
    }
}

// Client Code
public class StrategyPatternDemo {
    public static void main(String[] args) {
        // Use Strategy A
        Strategy strategyA = new ConcreteStrategyA();
        Context context = new Context(strategyA);
        context.executeStrategy(); // Output: Executing Strategy A

        // Switch to Strategy B
        Strategy strategyB = new ConcreteStrategyB();
        context.setStrategy(strategyB);
        context.executeStrategy(); // Output: Executing Strategy B
    }
}
