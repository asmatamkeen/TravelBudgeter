package gui;

import logic.CurrencyConverter;

import javax.swing.*;
import java.awt.*;

public class ConverterPanel extends JPanel {

    public ConverterPanel(DashboardFrame frame) {

        setLayout(new GridLayout(5, 2, 10, 10));

        String[] currencies = {"INR", "USD", "EUR", "GBP"};

        JComboBox<String> fromBox = new JComboBox<>(currencies);
        JComboBox<String> toBox = new JComboBox<>(currencies);

        JTextField amountField = new JTextField();
        JLabel resultLabel = new JLabel("Result: ");

        JButton convertBtn = new JButton("Convert");
        JButton backBtn = new JButton("Back");

        add(new JLabel("From:"));
        add(fromBox);

        add(new JLabel("To:"));
        add(toBox);

        add(new JLabel("Amount:"));
        add(amountField);

        add(convertBtn);
        add(backBtn);

        add(resultLabel);

        convertBtn.addActionListener(e -> {
            try {

                double amount = Double.parseDouble(amountField.getText());

                double result = CurrencyConverter.convert(
                        amount,
                        (String) fromBox.getSelectedItem(),
                        (String) toBox.getSelectedItem()
                );

                resultLabel.setText("Result: " + result);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });

        backBtn.addActionListener(e -> frame.showDashboardPanel());
    }
}