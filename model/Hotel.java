package model;

public class Hotel {

    private String name;
    private double pricePerDay;

    public Hotel(String name, double pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
    }

    public String getName() {
        return name;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }
}