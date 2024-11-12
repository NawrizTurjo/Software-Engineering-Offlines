package res;

// enum for log levels
enum LogLevel {
    INFO, DEBUG, ERROR, SHOVON
}

// Step 1: Define the Handler interface
interface Logger {
    void setNextLogger(Logger nextLogger);

    void handleRequest(Requestt request);
}

// Step 2: Create Concrete Handlers
class InfoLogger implements Logger {
    private LogLevel level;
    private Logger nextLogger;

    public InfoLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void handleRequest(Requestt request) {
        if (this.level == request.level) {
            System.out.println(request.level.name() + ": " + request.message);
        } else {
            if (nextLogger != null)
                nextLogger.handleRequest(request);
            else
                System.out.println(request.level.name() + ": No handler found for this request.");
        }
    }
}

class DebugLogger implements Logger {
    private LogLevel level;
    private Logger nextLogger;

    public DebugLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void handleRequest(Requestt request) {
        if (this.level == request.level) {
            System.out.println(request.level.name() + ": " + request.message);
        } else {
            if (nextLogger != null)
                nextLogger.handleRequest(request);
            else
                System.out.println(request.level.name() + ": No handler found for this request.");
        }
    }
}

class ErrorLogger implements Logger {
    private LogLevel level;
    private Logger nextLogger;

    public ErrorLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void handleRequest(Requestt request) {
        if (this.level == request.level) {
            System.out.println(request.level.name() + ": " + request.message);
        } else {
            if (nextLogger != null)
                nextLogger.handleRequest(request);
            else
                System.out.println(request.level.name() + ": No handler found for this request.");
        }
    }
}

// Request Class
class Requestt {
    public LogLevel level;
    public String message;

    public Requestt(LogLevel level, String message) {
        this.level = level;
        this.message = message;
    }
}

// Step 3: Set up the Chain of Responsibility
public class COR {
    private static Logger createChain() {
        Logger errorLogger = new ErrorLogger(LogLevel.ERROR);
        Logger debugLogger = new DebugLogger(LogLevel.DEBUG);
        Logger infoLogger = new InfoLogger(LogLevel.INFO);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = createChain();

        loggerChain.handleRequest(new Requestt(LogLevel.INFO, "This is an info message."));
        loggerChain.handleRequest(new Requestt(LogLevel.DEBUG, "This is a debug message."));
        loggerChain.handleRequest(new Requestt(LogLevel.ERROR, "This is an error message."));
        loggerChain.handleRequest(new Requestt(LogLevel.SHOVON, "This is a shovon message."));
    }
}

// TLDR:
// 1. Handler Interface (setNextMethod, handleRequest)
// 2. Concrete Handlers
// 3. Client Code : create chain of handlers and pass the request