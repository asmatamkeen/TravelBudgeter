package model;

public class Trip {

    private String currency;              // Native currency (INR)
    private String destinationCurrency;   // USD, EUR, etc.
    private double exchangeRate;          // INR per 1 destination currency

    private double budget;
    private int days;
    private int travelers;

    private double totalExpenseINR;

    public Trip(String currency,
                String destinationCurrency,
                double exchangeRate,
                double budget,
                int days,
                int travelers) {

        this.currency = currency;
        this.destinationCurrency = destinationCurrency;
        this.exchangeRate = exchangeRate;
        this.budget = budget;
        this.days = days;
        this.travelers = travelers;
        this.totalExpenseINR = 0;
    }

    // ===== Add Expense =====
    public void addExpense(double amountINR) {
        totalExpenseINR += amountINR;
    }

    // ===== Getters =====

    public String getCurrency() {
        return currency;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public double getBudget() {
        return budget;
    }

    public int getDays() {
        return days;
    }

    public int getTravelers() {
        return travelers;
    }

    public double getTotalExpenseINR() {
        return totalExpenseINR;
    }

    public double getTotalExpenseInDestination() {
        return totalExpenseINR / exchangeRate;
    }

    public double getRemainingBudget() {
        return budget - totalExpenseINR;
    }
}