package gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ConverterPanel extends JPanel {

    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JTextField amountField;
    private JLabel resultLabel;

    private HashMap<String, Double> rates;

    public ConverterPanel() {

        setBackground(new Color(40, 45, 70));
        setLayout(new GridLayout(6, 2, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(60, 150, 60, 150));

        initializeRates();

        fromCurrency = new JComboBox<>(rates.keySet().toArray(new String[0]));
        toCurrency = new JComboBox<>(rates.keySet().toArray(new String[0]));

        amountField = new JTextField();
        amountField.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        JButton convertButton = new JButton("Convert");
        styleButton(convertButton);

        resultLabel = createLabel("Result: ");

        add(createLabel("From Currency:"));
        add(fromCurrency);

        add(createLabel("To Currency:"));
        add(toCurrency);

        add(createLabel("Amount:"));
        add(amountField);

        add(new JLabel());
        add(convertButton);

        add(new JLabel());
        add(resultLabel);

        convertButton.addActionListener(e -> convertCurrency());
    }

    private void initializeRates() {
        rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("EUR", 0.92);
        rates.put("INR", 83.0);
        rates.put("GBP", 0.78);
        rates.put("JPY", 150.0);
    }

    private void convertCurrency() {
        try {
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();
            double amount = Double.parseDouble(amountField.getText());

            double amountInUSD = amount / rates.get(from);
            double converted = amountInUSD * rates.get(to);

            resultLabel.setText("Result: " + String.format("%.2f", converted) + " " + to);

        } catch (Exception ex) {
            resultLabel.setText("Invalid Input!");
        }
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 16));
        return label;
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(59, 130, 246));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
    }
}