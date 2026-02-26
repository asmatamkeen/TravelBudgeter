package gui;

import logic.HotelManager;
import model.Trip;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    public HomePanel(JFrame parentFrame) {

        setLayout(new GridLayout(6, 2, 10, 10));

        HotelManager manager = new HotelManager();
        String[] cities = manager.getCities();

        JComboBox<String> destinationBox = new JComboBox<>(cities);
        JTextField budgetField = new JTextField();
        JTextField daysField = new JTextField();
        JTextField travelersField = new JTextField();

        String[] currencies = {"INR", "USD", "EUR"};
        JComboBox<String> currencyBox = new JComboBox<>(currencies);

        JButton startButton = new JButton("Start Planning");

        add(new JLabel("Destination:"));
        add(destinationBox);

        add(new JLabel("Total Budget:"));
        add(budgetField);

        add(new JLabel("Days:"));
        add(daysField);

        add(new JLabel("Travelers:"));
        add(travelersField);

        add(new JLabel("Currency:"));
        add(currencyBox);

        add(new JLabel());
        add(startButton);

        startButton.addActionListener(e -> {
            try {

                String currency = (String) currencyBox.getSelectedItem();
                String destination = (String) destinationBox.getSelectedItem();

                double budget = Double.parseDouble(budgetField.getText());
                int days = Integer.parseInt(daysField.getText());
                int travelers = Integer.parseInt(travelersField.getText());

                // 🔹 Example exchange rates (you can improve later)
                double exchangeRate = 83.0; // default USD

                if (destination.equals("USA")) {
                    exchangeRate = 83.0;
                } else if (destination.equals("UK")) {
                    exchangeRate = 105.0;
                } else if (destination.equals("Singapore")) {
                    exchangeRate = 61.0;
                } else if (destination.equals("France")) {
                    exchangeRate = 90.0;
                }

                Trip trip = new Trip(
                        currency,          // native currency
                        destination,       // destination currency name
                        exchangeRate,      // exchange rate
                        budget,            // budget
                        days,              // days
                        travelers          // travelers
                );

                parentFrame.dispose();
                new DashboardFrame(trip);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid details!");
            }
        });
    }
}