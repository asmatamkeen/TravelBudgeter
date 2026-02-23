package gui;

import model.Trip;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ConverterPanel extends JPanel {

    private JLabel resultLabel;
    private HashMap<String, Double> rates;

    public ConverterPanel() {

        setBackground(new Color(40, 45, 70));
        setLayout(new GridLayout(4, 2, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(80, 200, 80, 200));

        initializeRates();

        JTextField amountField = new JTextField();
        amountField.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        JButton convertButton = new JButton("Convert");
        convertButton.setBackground(new Color(59, 130, 246));
        convertButton.setForeground(Color.WHITE);
        convertButton.setFocusPainted(false);

        resultLabel = new JLabel("Result: ");
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        add(createLabel("Amount (INR):"));
        add(amountField);
        add(new JLabel());
        add(convertButton);
        add(new JLabel());
        add(resultLabel);

        convertButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());

                String destinationCurrency = getCurrencyForDestination(Trip.destination);

                double amountInUSD = amount / rates.get("INR");
                double converted = amountInUSD * rates.get(destinationCurrency);

                resultLabel.setText("Result: " + String.format("%.2f", converted) + " " + destinationCurrency);

            } catch (Exception ex) {
                resultLabel.setText("Invalid Input!");
            }
        });
    }

    private void initializeRates() {
        rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("EUR", 0.92);
        rates.put("INR", 83.0);
        rates.put("GBP", 0.78);
        rates.put("JPY", 150.0);
    }

    private String getCurrencyForDestination(String destination) {
        if (destination == null) return "USD";

        switch (destination.toLowerCase()) {
            case "usa": return "USD";
            case "uk": return "GBP";
            case "japan": return "JPY";
            case "india": return "INR";
            case "europe": return "EUR";
            default: return "USD";
        }
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        return label;
    }
}