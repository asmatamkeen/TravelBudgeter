package gui;

import logic.ExpenseManager;
import model.Trip;

import javax.swing.*;
import java.awt.*;

public class BudgetPanel extends JPanel {

    private JLabel totalBudgetLabel;
    private JLabel totalExpenseLabel;
    private JLabel remainingLabel;

    public BudgetPanel(DashboardFrame frame, Trip trip) {

        setLayout(new GridLayout(5, 1, 15, 15));
        setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JLabel title = new JLabel("Budget Overview", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        totalBudgetLabel = new JLabel();
        totalExpenseLabel = new JLabel();
        remainingLabel = new JLabel();

        JButton refreshBtn = new JButton("Refresh");
        JButton backBtn = new JButton("Back");

        updateBudget(trip);

        refreshBtn.addActionListener(e -> updateBudget(trip));
        backBtn.addActionListener(e -> frame.showDashboardPanel());

        add(title);
        add(totalBudgetLabel);
        add(totalExpenseLabel);
        add(remainingLabel);
        add(refreshBtn);
        add(backBtn);
    }

    private void updateBudget(Trip trip) {

        double totalBudget = trip.getBudget();

        double totalExpensesNative = ExpenseManager.getTotalNative();
        double totalExpensesConverted = ExpenseManager.getTotalConverted();

        double remaining = totalBudget - totalExpensesNative;

        totalBudgetLabel.setText("Total Budget (INR): " + totalBudget);
        totalExpenseLabel.setText("Total Expenses: " +
                totalExpensesNative + " INR | " +
                totalExpensesConverted + " " + trip.getCurrency());

        remainingLabel.setText("Remaining Budget (INR): " + remaining);
    }
}