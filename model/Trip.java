package model;

public class Trip {

    private String destination;
    private double budget;
    private int days;
    private int travelers;
    private String currency;

    public Trip(String destination, double budget, int days, int travelers, String currency) {
        this.destination = destination;
        this.budget = budget;
        this.days = days;
        this.travelers = travelers;
        this.currency = currency;
    }

    public String getDestination() {
        return destination;
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

    public String getCurrency() {
        return currency;
    }
}