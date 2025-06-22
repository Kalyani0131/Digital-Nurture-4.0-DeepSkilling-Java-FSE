package com.dsa.forecast;

public class FinancialForecast {

    public static double predictFutureValueRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        double prevValue = predictFutureValueRecursive(presentValue, growthRate, years - 1);
        double futureValue = prevValue * (1 + growthRate);
        System.out.printf("Year %d -> Rs. %.2f\n", years, futureValue);
        return futureValue;
    }

    public static double predictFutureValueIterative(double presentValue, double growthRate, int years) {
        double amount = presentValue;
        for (int i = 1; i <= years; i++) {
            amount *= (1 + growthRate);
            System.out.printf("Year %d -> Rs. %.2f\n", i, amount);
        }
        return amount;
    }

    public static void main(String[] args) {
        double presentValue = 15000.00;
        double growthRate = 0.07;
        int years = 6;

        System.out.println("===== Financial Forecast using Recursive Method =====");
        double futureRecursive = predictFutureValueRecursive(presentValue, growthRate, years);
        System.out.printf("Final Predicted Value (Recursive): Rs. %.2f\n", futureRecursive);

        System.out.println("\n===== Financial Forecast using Iterative Method =====");
        double futureIterative = predictFutureValueIterative(presentValue, growthRate, years);
        System.out.printf("Final Predicted Value (Iterative): Rs. %.2f\n", futureIterative);
    }
}
