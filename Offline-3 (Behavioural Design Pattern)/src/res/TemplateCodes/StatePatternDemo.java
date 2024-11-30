// State Interface
interface State {
    void handle(Context context);
}

// Concrete State A
class ConcreteStateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Handling State A");
        context.setState(new ConcreteStateB()); // Transition to State B
    }
}

// Concrete State B
class ConcreteStateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Handling State B");
        context.setState(new ConcreteStateA()); // Transition to State A
    }
}

// Context Class
class Context {
    private State state;

    // Constructor
    public Context(State initialState) {
        this.state = initialState;
    }

    // Sets the current state
    public void setState(State state) {
        this.state = state;
    }

    // Invokes the behavior of the current state
    public void request() {
        state.handle(this);
    }
}

// Client Code
public class StatePatternDemo {
    public static void main(String[] args) {
        // Initial State
        State initialState = new ConcreteStateA();

        // Context with Initial State
        Context context = new Context(initialState);

        // Trigger state transitions
        context.request(); // Output: Handling State A
        context.request(); // Output: Handling State B
        context.request(); // Output: Handling State A
    }
}
