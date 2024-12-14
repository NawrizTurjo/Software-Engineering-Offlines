package BehavioralPatterns.Onlines.C2;

// Step 1: Define the State Interface
interface OrderState {
    void next(Order order); // Move to the next state

    void cancel(Order order); // Cancel the order

    String getStatus(); // Get the current state status
}

// Step 2: Implement Concrete States
class PlacedState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new ConfirmedState());
        System.out.println("Order confirmed.");
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CancelledState());
        System.out.println("Order cancelled.");
    }

    @Override
    public String getStatus() {
        return "Placed";
    }
}

class ConfirmedState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new ShippedState());
        System.out.println("Order shipped.");
    }

    @Override
    public void cancel(Order order) {
        order.setState(new CancelledState());
        System.out.println("Order cancelled.");
    }

    @Override
    public String getStatus() {
        return "Confirmed";
    }
}

class ShippedState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new DeliveredState());
        System.out.println("Order delivered.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cannot cancel an order that has been shipped.");
    }

    @Override
    public String getStatus() {
        return "Shipped";
    }
}

class DeliveredState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order is already delivered. No further transitions.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cannot cancel an order that has been delivered.");
    }

    @Override
    public String getStatus() {
        return "Delivered";
    }
}

class CancelledState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order is cancelled. No further transitions.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Order is already cancelled.");
    }

    @Override
    public String getStatus() {
        return "Cancelled";
    }
}

// Step 3: Define the Context (Order)
class Order {
    private OrderState state;

    public Order() {
        // Initial state is Placed
        this.state = new PlacedState();
        System.out.println("Order placed.");
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void nextState() {
        state.next(this);
    }

    public void cancelOrder() {
        state.cancel(this);
    }

    public String getStatus() {
        return state.getStatus();
    }
}

// Step 4: Main Class to Demonstrate the Workflow
public class C2Online {
    public static void main(String[] args) {
        // Create a new order
        Order order = new Order();

        // Transition through various states
        System.out.println("Current status: " + order.getStatus());
        order.nextState(); // Confirmed
        System.out.println("Current status: " + order.getStatus());
        order.nextState(); // Shipped
        System.out.println("Current status: " + order.getStatus());
        order.nextState(); // Delivered
        System.out.println("Current status: " + order.getStatus());

        // Try cancelling after delivery
        order.cancelOrder();

        // Create another order and cancel it early
        Order anotherOrder = new Order();
        anotherOrder.cancelOrder();
        System.out.println("Current status: " + anotherOrder.getStatus());
    }
}
