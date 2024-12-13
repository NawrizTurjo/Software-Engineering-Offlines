package GFGBaseCodes;

interface VendingMachineState { // State interface
    void handleRequest();
}
// These are the different states of the vending machine
class ReadyState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Ready state: Please select a product.");
    }
}

class ProductSelectedState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Product selected state: Processing payment.");
    }
}

class PaymentPendingState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Payment pending state: Dispensing product.");
    }
}

class OutOfStockState implements VendingMachineState {
    @Override
    public void handleRequest() {
        System.out.println("Out of stock state: Product unavailable. Please select another product.");
    }
}
// Context class : it will have a state object to delegate the request to the state object
class VendingMachineContext {
    private VendingMachineState state;

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest();
    }
}

public class StatePattern {
    public static void main(String[] args) {
        // Create context
        VendingMachineContext vendingMachine = new VendingMachineContext();

        // Set initial state
        vendingMachine.setState(new ReadyState());

        // Request state change
        vendingMachine.request();

        // Change state
        vendingMachine.setState(new ProductSelectedState());

        // Request state change
        vendingMachine.request();

        // Change state
        vendingMachine.setState(new PaymentPendingState());

        // Request state change
        vendingMachine.request();

        // Change state
        vendingMachine.setState(new OutOfStockState());

        // Request state change
        vendingMachine.request();
    }
}
