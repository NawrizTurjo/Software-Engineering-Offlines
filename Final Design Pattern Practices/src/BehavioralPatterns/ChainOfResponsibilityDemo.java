package BehavioralPatterns;

// enum for log levels
enum LogLevel {
    ERROR, DEBUG, INFO, SHOVON
}

// Step 1: Define the Handler interface
interface Logger {
    Boolean handleRequest(Requestt request);
}

// Step 2: Create Concrete Handlers
class InfoLogger implements Logger {
    private LogLevel level;
    private Logger nextLogger;

    public InfoLogger(Logger nextLogger) {
        this.level = LogLevel.INFO;
        this.nextLogger = nextLogger;
    }

    @Override
    public Boolean handleRequest(Requestt request) {
        if (this.level == request.level) {
            System.out.println(request.level.name() + ": " + request.message);
            return true;
        } else {
            if (nextLogger != null)
                return nextLogger.handleRequest(request);
            else {
                System.out.println(request.level.name() + ": No handler found for this request.");
                return false;
            }
        }
    }
}

class DebugLogger implements Logger {
    private LogLevel level;
    private Logger nextLogger;

    public DebugLogger(Logger nextLogger) {
        this.level = LogLevel.DEBUG;
        this.nextLogger = nextLogger;
    }

    @Override
    public Boolean handleRequest(Requestt request) {
        if (this.level == request.level) {
            System.out.println(request.level.name() + ": " + request.message);
            return true;
        } else {
            if (nextLogger != null)
                return nextLogger.handleRequest(request);
            else {
                System.out.println(request.level.name() + ": No handler found for this request.");
                return false;
            }
        }
    }
}

class ErrorLogger implements Logger { //# Handles all other requests
    private LogLevel level;
    private Logger nextLogger;

    public ErrorLogger(Logger nextLogger) {
        this.level = LogLevel.ERROR;
        this.nextLogger = nextLogger;
    }

    @Override
    public Boolean handleRequest(Requestt request) {
        if (this.level.compareTo(request.level) <= 0) {
            System.out.println(request.level.name() + ": " + request.message);
            return true;
        } else {
            if (nextLogger != null)
                return nextLogger.handleRequest(request);
            else {
                System.out.println(request.level.name() + ": No handler found for this request.");
                return false;
            }
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
public class ChainOfResponsibilityDemo {
    private static Logger createChain() {
        Logger infoLogger = new InfoLogger(null);
        Logger debugLogger = new DebugLogger(infoLogger);
        Logger errorLogger = new ErrorLogger(debugLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = createChain();

        loggerChain.handleRequest(new Requestt(LogLevel.INFO, "This is an info message."));
        loggerChain.handleRequest(new Requestt(LogLevel.DEBUG, "This is a debug message."));
        loggerChain.handleRequest(new Requestt(LogLevel.ERROR, "This is an error message."));
        loggerChain.handleRequest(new Requestt(LogLevel.SHOVON, "This is a NOTFOUND message."));
    }
}

// TLDR:
// 1. Handler Interface (handleRequest)
// 2. Concrete Handlers
// 3. Client Code : create chain of handlers and pass the request