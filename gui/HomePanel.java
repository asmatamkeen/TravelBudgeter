package gui;

import model.Trip;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    public HomePanel(Runnable onStartTrip) {

        setBackground(new Color(40, 45, 70));
        setLayout(new GridLayout(6, 2, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(80, 200, 80, 200));

        JTextField destinationField = new JTextField();
        JTextField budgetField = new JTextField();
        JTextField daysField = new JTextField();
        JTextField travelersField = new JTextField();

        JButton startButton = new JButton("Start Trip");
        styleButton(startButton);

        add(createLabel("Destination:"));
        add(destinationField);

        add(createLabel("Total Budget:"));
        add(budgetField);

        add(createLabel("Duration (Days):"));
        add(daysField);

        add(createLabel("Number of Travelers:"));
        add(travelersField);

        add(new JLabel());
        add(startButton);

        startButton.addActionListener(e -> {
            try {
                Trip.destination = destinationField.getText();
                Trip.budget = Double.parseDouble(budgetField.getText());
                Trip.days = Integer.parseInt(daysField.getText());
                Trip.travelers = Integer.parseInt(travelersField.getText());

                onStartTrip.run();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid details!");
            }
        });
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
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
    }
}