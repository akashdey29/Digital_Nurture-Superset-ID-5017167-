
public class FinancialForecast {

    public static double predictFutureValueIterative(double initialValue, double growthRate, int periods) {
        double futureValue = initialValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {

        double initialValue = 1000.0; // Initial value..............
        double growthRate = 0.05; // 5% growth rate............
        int periods = 10; // Number of periods (years)........

        // Predict future value using the iterative method.........
        double futureValue = predictFutureValueIterative(initialValue, growthRate, periods);
        System.out.println("Predicted Future Value: " + futureValue);
    }
}
