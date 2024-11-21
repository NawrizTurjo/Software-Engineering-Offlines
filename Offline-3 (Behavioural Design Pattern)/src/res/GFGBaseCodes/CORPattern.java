package res.GFGBaseCodes;

// Handler Interface
interface SupportHandler {
    void handleRequest(Damage request);

    void setNextHandler(SupportHandler nextHandler);
}

// Concrete Handlers
class Level1SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Damage request) {
        if (request == Damage.BASIC) {
            System.out.println("Level 1 Support handled the damage.--> Damage Category " + request.name());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class Level2SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Damage request) {
        if (request == Damage.INTERMEDIATE) {
            System.out.println("Level 2 Support handled the damage.--> Damage Category " + request.name());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class Level3SupportHandler implements SupportHandler {
    public void handleRequest(Damage request) {
        if (request == Damage.CRITICAL) {
            System.out.println("Level 3 Support handled the damage.--> Damage Category " + request.name());
        } else {
            System.out.println("Damage cannot be handled. --> " + request.name());
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        // No next handler for Level 3 as it is the last in the chain
    }
}

// Damage Enum
enum Damage {
    BASIC, INTERMEDIATE, CRITICAL, SHOVON
}

// Main Class
public class CORPattern {
    public static SupportHandler getChainOfSupportHandlers() {
        SupportHandler level1Handler = new Level1SupportHandler();
        SupportHandler level2Handler = new Level2SupportHandler();
        SupportHandler level3Handler = new Level3SupportHandler();

        level1Handler.setNextHandler(level2Handler);
        level2Handler.setNextHandler(level3Handler);

        return level1Handler;
    }
    public static void main(String[] args) {
        SupportHandler handlerChains = getChainOfSupportHandlers();

        handlerChains.handleRequest(Damage.BASIC);
        handlerChains.handleRequest(Damage.INTERMEDIATE);
        handlerChains.handleRequest(Damage.CRITICAL);
        handlerChains.handleRequest(Damage.SHOVON);
    }
}
