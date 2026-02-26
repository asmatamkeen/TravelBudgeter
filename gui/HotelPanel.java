package gui;

import model.Hotel;
import model.Trip;

import javax.swing.*;
import java.awt.*;

public class HotelPanel extends JPanel {

    private Trip trip;
    private JLabel totalLabel;

    public HotelPanel(Trip trip) {

        this.trip = trip;

        setLayout(new BorderLayout());

        Hotel hotel = new Hotel(
                "Grand Palace",

                3000,
                "AC Room, Free WiFi",

                5000,
                "AC Room, Free WiFi, Breakfast",

                8000,
                "AC Room, Free WiFi, Breakfast, Pool Access"
        );

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        JButton basicBtn = new JButton("Basic Plan - ₹" + hotel.getBasic());
        JButton standardBtn = new JButton("Standard Plan - ₹" + hotel.getStandard());
        JButton premiumBtn = new JButton("Premium Plan - ₹" + hotel.getPremium());
        JButton customBtn = new JButton("Customization Plan");
        JButton otherExpenseBtn = new JButton("Add Other Expense");

        totalLabel = new JLabel();
        updateTotal();

        panel.add(basicBtn);
        panel.add(standardBtn);
        panel.add(premiumBtn);
        panel.add(customBtn);
        panel.add(otherExpenseBtn);

        add(panel, BorderLayout.CENTER);
        add(totalLabel, BorderLayout.SOUTH);

        // Plan Buttons
        basicBtn.addActionListener(e -> addExpense(hotel.getBasic()));
        standardBtn.addActionListener(e -> addExpense(hotel.getStandard()));
        premiumBtn.addActionListener(e -> addExpense(hotel.getPremium()));

        // Custom Plan
        customBtn.addActionListener(e -> handleCustomPlan());

        // Other Expense
        otherExpenseBtn.addActionListener(e -> handleOtherExpense());
    }

    private void addExpense(double amount) {
        trip.addExpense(amount);
        updateTotal();
        JOptionPane.showMessageDialog(this, "Added ₹" + amount);
    }

    private void handleCustomPlan() {

        double total = 0;

        int wifi = JOptionPane.showConfirmDialog(this, "Add WiFi (₹500)?");
        if (wifi == JOptionPane.YES_OPTION) total += 500;

        int food = JOptionPane.showConfirmDialog(this, "Add Food (₹1000)?");
        if (food == JOptionPane.YES_OPTION) total += 1000;

        int pool = JOptionPane.showConfirmDialog(this, "Add Pool (₹800)?");
        if (pool == JOptionPane.YES_OPTION) total += 800;

        trip.addExpense(total);
        updateTotal();

        JOptionPane.showMessageDialog(this,
                "Customization Added: ₹" + total);
    }

    private void handleOtherExpense() {

        String input = JOptionPane.showInputDialog(this,
                "Enter Other Expense (₹)");

        if (input != null && !input.isEmpty()) {
            double amount = Double.parseDouble(input);
            trip.addExpense(amount);
            updateTotal();
        }
    }

    private void updateTotal() {

        double inr = trip.getTotalExpenseINR();
        double dest = trip.getTotalExpenseInDestination();

        totalLabel.setText(
                "Total Expense: ₹" + String.format("%.2f", inr)
                        + " | "
                        + trip.getDestinationCurrency() + " "
                        + String.format("%.2f", dest)
        );
    }
}