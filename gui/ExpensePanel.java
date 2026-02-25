package gui;

import model.Trip;

import javax.swing.*;
import java.awt.*;

public class ExpensePanel extends JFrame {

    public ExpensePanel(Trip trip) {

        setTitle("Expense Summary");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        area.setText(
                "Trip Expense Summary\n\n" +
                        "Destination: " + trip.getDestination() + "\n" +
                        "Budget: " + trip.getCurrency() + " " + trip.getBudget() + "\n" +
                        "Days: " + trip.getDays() + "\n" +
                        "Travelers: " + trip.getTravelers()
        );

        add(area);
        setVisible(true);
    }
}