package com.dsa.forecast;

public class Forecast {

    public static double forecastRevenue(double currentRevenue, double growthRate, int years) {
        if (years == 0) return currentRevenue;
        return forecastRevenue(currentRevenue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialRevenue = 1000000; // Rs. 10 lakhs
        double growthRate = 0.1; // 10% growth
        int years = 3;

        double forecastedRevenue = forecastRevenue(initialRevenue, growthRate, years);
        System.out.printf("Forecasted revenue after %d years: Rs. %.2f\n", years, forecastedRevenue);
    }
}
