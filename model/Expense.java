package model;

public class Expense {

    private String category;
    private double nativeAmount;
    private double convertedAmount;

    public Expense(String category, double nativeAmount, double convertedAmount) {
        this.category = category;
        this.nativeAmount = nativeAmount;
        this.convertedAmount = convertedAmount;
    }

    public String getCategory() {
        return category;
    }

    public double getNativeAmount() {
        return nativeAmount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }
}