public class SingletonTest {
    public static void main(String[] args) {
       
        Logger logger1 = Logger.getInstance(); // Getting the first instance of Logger....................
        logger1.log("This is the first log message.");

        
        Logger logger2 = Logger.getInstance(); // Getting the second instance of Logger...................
        logger2.log("This is the second log message.");

        // We are checking if both instances are the same....................
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}
