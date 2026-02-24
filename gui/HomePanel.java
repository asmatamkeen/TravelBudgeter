package gui;

import model.Trip;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    public HomePanel(JFrame parentFrame) {

        setLayout(new GridLayout(5, 2, 10, 10));

        String[] cities = {
                "Paris",
                "London",
                "Madrid",
                "New York",
                "Los Angeles"
        };

        JComboBox<String> destinationBox = new JComboBox<>(cities);
        JTextField budgetField = new JTextField();
        JTextField daysField = new JTextField();
        JTextField travelersField = new JTextField();
        JButton startButton = new JButton("Start Trip");

        add(new JLabel("Destination:"));
        add(destinationBox);

        add(new JLabel("Total Budget (INR):"));
        add(budgetField);

        add(new JLabel("Days:"));
        add(daysField);

        add(new JLabel("Travelers:"));
        add(travelersField);

        add(new JLabel());
        add(startButton);

        startButton.addActionListener(e -> {
            try {

                Trip trip = new Trip(
                        (String) destinationBox.getSelectedItem(),
                        Double.parseDouble(budgetField.getText()),
                        Integer.parseInt(daysField.getText()),
                        Integer.parseInt(travelersField.getText())
                );

                parentFrame.dispose();
                new DashboardFrame(trip);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Enter valid details!");
            }
        });
    }
}