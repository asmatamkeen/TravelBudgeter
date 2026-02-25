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

                Trip trip = new Trip(
                        (String) destinationBox.getSelectedItem(),
                        Double.parseDouble(budgetField.getText()),
                        Integer.parseInt(daysField.getText()),
                        Integer.parseInt(travelersField.getText()),
                        (String) currencyBox.getSelectedItem()
                );

                parentFrame.dispose();
                new DashboardFrame(trip);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid details!");
            }
        });
    }
}