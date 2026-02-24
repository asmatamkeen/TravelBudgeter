package logic;

import java.util.HashMap;

public class CurrencyConverter {

    private static HashMap<String, Double> rates = new HashMap<>();

    static {
        rates.put("INR", 1.0);
        rates.put("USD", 83.0);
        rates.put("EUR", 90.0);
        rates.put("GBP", 105.0);
    }

    public static double convert(double amount, String from, String to) {

        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            return amount;
        }

        double amountInINR = amount * rates.get(from);
        return amountInINR / rates.get(to);
    }
}