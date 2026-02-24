package gui;

import model.Trip;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private Trip trip;

    public DashboardFrame(Trip trip) {

        this.trip = trip;

        setTitle("Dashboard - " + trip.getDestination());
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        showDashboardPanel();

        setVisible(true);
    }

    public void showDashboardPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));

        JLabel welcomeLabel = new JLabel(
                "Welcome to " + trip.getDestination() +
                        " (" + trip.getCurrency() + ")",
                SwingConstants.CENTER
        );
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        JButton budgetBtn = new JButton("Budget Overview");
        JButton expenseBtn = new JButton("Expense Planner");
        JButton converterBtn = new JButton("Currency Converter");
        JButton exitBtn = new JButton("Exit");

        // Navigation
        budgetBtn.addActionListener(e ->
                switchPanel(new BudgetPanel(this, trip)));

        expenseBtn.addActionListener(e ->
                switchPanel(new ExpensePanel(this, trip)));

        converterBtn.addActionListener(e ->
                switchPanel(new ConverterPanel(this)));

        exitBtn.addActionListener(e -> dispose());

        panel.add(welcomeLabel);
        panel.add(budgetBtn);
        panel.add(expenseBtn);
        panel.add(converterBtn);
        panel.add(exitBtn);

        setContentPane(panel);
        revalidate();
        repaint();
    }

    public void switchPanel(JPanel panel) {
        setContentPane(panel);
        revalidate();
        repaint();
    }
}