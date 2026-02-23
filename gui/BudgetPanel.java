package gui;

import logic.ExpenseManager;
import model.Trip;

import javax.swing.*;
import java.awt.*;

public class BudgetPanel extends JPanel {

    private JLabel totalLabel;
    private JLabel remainingLabel;

    public BudgetPanel() {

        setBackground(new Color(40, 45, 70));
        setLayout(new GridLayout(5, 1, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(80, 200, 80, 200));

        totalLabel = createLabel("Total Expenses: 0");
        remainingLabel = createLabel("Remaining Budget: 0");

        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBackground(new Color(59, 130, 246));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setFocusPainted(false);

        refreshButton.addActionListener(e -> updateBudget());

        add(createLabel("Trip Budget: " + Trip.budget));
        add(totalLabel);
        add(remainingLabel);
        add(refreshButton);
    }

    private void updateBudget() {
        double total = ExpenseManager.getTotal();
        double remaining = Trip.budget - total;

        totalLabel.setText("Total Expenses: " + total);
        remainingLabel.setText("Remaining Budget: " + remaining);

        if (remaining < 0) {
            remainingLabel.setForeground(Color.RED);
        } else {
            remainingLabel.setForeground(Color.GREEN);
        }
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        return label;
    }
}