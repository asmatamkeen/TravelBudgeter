package model;

public class Hotel {

    private String name;
    private double basic;
    private double standard;
    private double premium;

    public Hotel(String name, double basic, double standard, double premium) {
        this.name = name;
        this.basic = basic;
        this.standard = standard;
        this.premium = premium;
    }

    public String getName() {
        return name;
    }

    public double getBasic() {
        return basic;
    }

    public double getStandard() {
        return standard;
    }

    public double getPremium() {
        return premium;
    }
}