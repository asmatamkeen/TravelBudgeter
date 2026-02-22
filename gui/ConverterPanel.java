package gui;

import logic.CurrencyConverter;

import javax.swing.*;
import java.awt.*;

public class ConverterPanel extends JPanel {

    public ConverterPanel() {

        setLayout(new GridLayout(5,2,10,10));

        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();

        JLabel rateLabel = new JLabel("Rate:");
        JTextField rateField = new JTextField();

        JButton convertBtn = new JButton("Convert");

        JLabel resultLabel = new JLabel("Result: ");

        add(amountLabel);
        add(amountField);
        add(rateLabel);
        add(rateField);
        add(new JLabel());
        add(convertBtn);
        add(new JLabel());
        add(resultLabel);

        convertBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                double rate = Double.parseDouble(rateField.getText());

                double result = CurrencyConverter.convert(amount, rate);
                resultLabel.setText("Result: " + result);
            } catch (Exception ex) {
                resultLabel.setText("Invalid Input!");
            }
        });
    }
}