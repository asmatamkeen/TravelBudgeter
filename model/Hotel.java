package model;

public class Hotel {

    private String name;

    private double basic;
    private String basicFeatures;

    private double standard;
    private String standardFeatures;

    private double premium;
    private String premiumFeatures;

    public Hotel(String name,
                 double basic, String basicFeatures,
                 double standard, String standardFeatures,
                 double premium, String premiumFeatures) {

        this.name = name;

        this.basic = basic;
        this.basicFeatures = basicFeatures;

        this.standard = standard;
        this.standardFeatures = standardFeatures;

        this.premium = premium;
        this.premiumFeatures = premiumFeatures;
    }

    public String getName() {
        return name;
    }

    public double getBasic() {
        return basic;
    }

    public String getBasicFeatures() {
        return basicFeatures;
    }

    public double getStandard() {
        return standard;
    }

    public String getStandardFeatures() {
        return standardFeatures;
    }

    public double getPremium() {
        return premium;
    }

    public String getPremiumFeatures() {
        return premiumFeatures;
    }
}