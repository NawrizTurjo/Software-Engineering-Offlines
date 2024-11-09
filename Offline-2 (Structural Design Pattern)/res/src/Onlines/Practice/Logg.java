package Onlines.Practice;

// Legacy Custom Logger, which we cannot modify
class CustomLogger {
    public void logMessage(String message) {
        System.out.println("Custom Log: " + message);
    }
}

// Client Interface expected by the application
interface Logger {
    void log(String message);
}

// Application class that depends on the Logger interface
class Application {
    private Logger logger;

    public Application(Logger logger) {
        this.logger = logger;
    }

    public void run(String message) {
        logger.log(message);
    }
}

class CustomLoggerAdapter implements Logger {
    CustomLogger customLogger;

    public CustomLoggerAdapter(CustomLogger customLogger) {
        this.customLogger = customLogger;
    }

    @Override
    public void log(String message) {
        customLogger.logMessage(message);
    }

}

// Main Class
public class Logg {
    public static void main(String[] args) {
        // Legacy service instance
        CustomLogger customLogger = new CustomLogger();

        // Adapter to make CustomLogger compatible with Logger interface
        Logger logger = new CustomLoggerAdapter(customLogger);

        Application app = new Application(logger);
        app.run("Application started"); // Output: Custom Log: Application started
    }
}
