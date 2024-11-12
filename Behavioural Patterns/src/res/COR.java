package res;

// enum for log levels
enum LogLevel {
    INFO, DEBUG, ERROR
}

// Step 1: Define the Handler interface
interface Logger {
    void write(String message);

    void setNextLogger(Logger nextLogger);

    void logMessage(LogLevel level, String message);
}

// Step 2: Create Concrete Handlers
class InfoLogger implements Logger {
    private LogLevel level;
    private Logger nextLogger;

    public InfoLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("INFO: " + message);
    }

    @Override
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void logMessage(LogLevel level, String message) {
        if (this.level == level) {
            write(message);
        } else {
            nextLogger.logMessage(level, message);
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
    public void write(String message) {
        System.out.println("DEBUG: " + message);
    }

    @Override
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void logMessage(LogLevel level, String message) {
        if (this.level == level) {
            write(message);
        } else {
            nextLogger.logMessage(level, message);
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
    public void write(String message) {
        System.out.println("ERROR: " + message);
    }

    @Override
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void logMessage(LogLevel level, String message) {
        if (this.level == level) {
            write(message);
        } else {
            nextLogger.logMessage(level, message);
        }
    }
}

// Step 3: Set up the Chain of Responsibility
public class COR {
    private static Logger getChainOfLoggers() {
        Logger errorLogger = new ErrorLogger(LogLevel.ERROR);
        Logger debugLogger = new DebugLogger(LogLevel.DEBUG);
        Logger infoLogger = new InfoLogger(LogLevel.INFO);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(LogLevel.INFO, "This is an informational message.");
        loggerChain.logMessage(LogLevel.DEBUG, "This is a debug message.");
        loggerChain.logMessage(LogLevel.ERROR, "This is an error message.");
    }
}


// TLDR:
// 1. Handler Interface
// 2. Concrete Handlers
// 3. Client Code : create chain of handlers and pass the request