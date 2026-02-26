package model;

import java.util.HashMap;
import java.util.Map;

public class Hotel {

    private String name;

    private double basic;
    private String basicFeatures;

    private double standard;
    private String standardFeatures;

    private double premium;
    private String premiumFeatures;

    private Map<String, Double> customFeatures;

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

        customFeatures = new HashMap<>();

        // Default Custom Features
        customFeatures.put("Extra Bed", 1000.0);
        customFeatures.put("Breakfast", 800.0);
        customFeatures.put("Airport Pickup", 1500.0);
        customFeatures.put("Swimming Pool Access", 700.0);
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

    public Map<String, Double> getCustomFeatures() {
        return customFeatures;
    }

    @Override
    public String toString() {
        return name;
    }
}