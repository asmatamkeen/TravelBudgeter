package gui;

import logic.ExpenseManager;

import javax.swing.*;
import java.awt.*;

public class BudgetPanel extends JPanel {

    private JLabel totalLabel;
    private JLabel remainingLabel;
    private JTextField budgetField;

    public BudgetPanel() {

        setBackground(new Color(40, 45, 70));
        setLayout(new GridLayout(6, 1, 15, 15));
        setBorder(BorderFactory.createEmptyBorder(60, 200, 60, 200));

        JLabel title = new JLabel("Budget Planner", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));

        budgetField = new JTextField();
        budgetField.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JButton calculateButton = new JButton("Calculate");
        styleButton(calculateButton);

        totalLabel = createLabel("Total Expenses: 0.0");
        remainingLabel = createLabel("Remaining Budget: 0.0");

        add(title);
        add(createLabel("Enter Budget Amount:"));
        add(budgetField);
        add(calculateButton);
        add(totalLabel);
        add(remainingLabel);

        calculateButton.addActionListener(e -> {
            try {
                double budget = Double.parseDouble(budgetField.getText());
                double total = ExpenseManager.getTotal();
                double remaining = budget - total;

                totalLabel.setText("Total Expenses: " + total);
                remainingLabel.setText("Remaining Budget: " + remaining);

                if (remaining < 0) {
                    remainingLabel.setForeground(Color.RED);
                } else {
                    remainingLabel.setForeground(Color.GREEN);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Budget Input!");
            }
        });
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        return label;
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(59, 130, 246));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
    }
}