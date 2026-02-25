package model;

public class Plan {

    private String name;
    private double price;
    private String features;

    public Plan(String name, double price, String features) {
        this.name = name;
        this.price = price;
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " (" + features + ")";
    }
}