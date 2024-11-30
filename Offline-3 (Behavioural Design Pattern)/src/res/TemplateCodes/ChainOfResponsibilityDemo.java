// Handler Interface
interface Handler {
    void setNextHandler(Handler handler);

    void handleRequest(String request);
}

// Abstract Handler (Optional: for default behavior)
abstract class AbstractHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler handler) {
        this.nextHandler = handler;
    }

    protected void forwardToNext(String request) {
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler found for request: " + request);
        }
    }
}

// Concrete Handler A
class ConcreteHandlerA extends AbstractHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("A")) {
            System.out.println("ConcreteHandlerA handled the request.");
        } else {
            System.out.println("ConcreteHandlerA passing request to next handler.");
            forwardToNext(request);
        }
    }
}

// Concrete Handler B
class ConcreteHandlerB extends AbstractHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equalsIgnoreCase("B")) {
            System.out.println("ConcreteHandlerB handled the request.");
        } else {
            System.out.println("ConcreteHandlerB passing request to next handler.");
            forwardToNext(request);
        }
    }
}

// Client Code
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // Create Handlers
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();

        // Build the Chain
        handlerA.setNextHandler(handlerB);

        // Send Requests
        handlerA.handleRequest("A");
        // Output: ConcreteHandlerA handled the request.

        handlerA.handleRequest("B");
        // Output:
        // ConcreteHandlerA passing request to next handler.
        // ConcreteHandlerB handled the request.

        handlerA.handleRequest("C");
        // Output:
        // ConcreteHandlerA passing request to next handler.
        // ConcreteHandlerB passing request to next handler.
        // No handler found for request: C
    }
}
