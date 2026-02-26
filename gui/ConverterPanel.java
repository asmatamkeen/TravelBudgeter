package gui;

import logic.CurrencyConverter;
import model.Trip;

import javax.swing.*;
import java.awt.*;

public class ConverterPanel extends JPanel {

    private DashboardFrame frame;
    private Trip trip;

    public ConverterPanel(DashboardFrame frame, Trip trip) {

        this.frame = frame;
        this.trip = trip;

        setLayout(new GridLayout(6, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

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

        // ================= CONVERT =================
        convertBtn.addActionListener(e -> {
            try {

                double amount = Double.parseDouble(amountField.getText());

                double result = CurrencyConverter.convert(
                        amount,
                        (String) fromBox.getSelectedItem(),
                        (String) toBox.getSelectedItem()
                );

                resultLabel.setText("Result: " + String.format("%.2f", result));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });

        // ================= BACK BUTTON =================
        backBtn.addActionListener(e -> {
            frame.setVisible(true);
            ((JFrame) SwingUtilities.getWindowAncestor(this)).dispose();
        });
    }
}