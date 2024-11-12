package res;

// enum for log levels
enum LogLevel {
    INFO, DEBUG, ERROR
}

// Step 1: Define the Handler interface
interface Logger {
    void setNextLogger(Logger nextLogger);

    void handleRequest(LogLevel level, String message);
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
    public void handleRequest(LogLevel level, String message) {
        if (this.level == level) {
            System.out.println("INFO: " + message);
        } else {
            nextLogger.handleRequest(level, message);
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
    public void handleRequest(LogLevel level, String message) {
        if (this.level == level) {
            System.out.println("DEBUG: " + message);
        } else {
            nextLogger.handleRequest(level, message);
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
    public void handleRequest(LogLevel level, String message) {
        if (this.level == level) {
            System.out.println("ERROR: " + message);
        } else {
            nextLogger.handleRequest(level, message);
        }
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

        loggerChain.handleRequest(LogLevel.INFO, "This is an informational message.");
        loggerChain.handleRequest(LogLevel.DEBUG, "This is a debug message.");
        loggerChain.handleRequest(LogLevel.ERROR, "This is an error message.");
    }
}

// TLDR:
// 1. Handler Interface (setNextMethod, handleRequest)
// 2. Concrete Handlers
// 3. Client Code : create chain of handlers and pass the request