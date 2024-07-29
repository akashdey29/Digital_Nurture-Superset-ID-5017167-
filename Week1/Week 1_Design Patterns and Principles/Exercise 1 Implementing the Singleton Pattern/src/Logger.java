//Exercise 1: Implementing the Singleton Pattern

public class Logger {
    
    private static Logger instance;   // this is private static instance of Logger............

    // It is the private constructor to prevent instantiation..............
    private Logger() {
    }

    // Public method to provide access to the instance....................
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages........................
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
