package gui;

import model.Trip;

import javax.swing.*;
import java.awt.*;

public class BudgetPanel extends JPanel {

    private JLabel totalBudgetLabel;
    private JLabel totalExpenseLabel;
    private JLabel remainingLabel;

    private DashboardFrame frame;
    private Trip trip;

    public BudgetPanel(DashboardFrame frame, Trip trip) {

        this.frame = frame;
        this.trip = trip;

        setLayout(new GridLayout(6, 1, 15, 15));
        setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JLabel title = new JLabel("Budget Overview", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        totalBudgetLabel = new JLabel();
        totalExpenseLabel = new JLabel();
        remainingLabel = new JLabel();

        JButton refreshBtn = new JButton("Refresh");
        JButton backBtn = new JButton("Back");

        updateBudget();

        refreshBtn.addActionListener(e -> updateBudget());

        // ✅ FIXED BACK BUTTON
        backBtn.addActionListener(e -> frame.setVisible(true));

        add(title);
        add(totalBudgetLabel);
        add(totalExpenseLabel);
        add(remainingLabel);
        add(refreshBtn);
        add(backBtn);
    }

    private void updateBudget() {

        double totalBudget = trip.getBudget();
        double totalExpenseINR = trip.getTotalExpenseINR();
        double totalExpenseConverted = trip.getTotalExpenseInDestination();
        double remaining = trip.getRemainingBudget();

        totalBudgetLabel.setText("Total Budget (INR): ₹" + totalBudget);

        totalExpenseLabel.setText(
                "Total Expenses: ₹" + String.format("%.2f", totalExpenseINR)
                        + " | "
                        + trip.getDestinationCurrency()
                        + " " + String.format("%.2f", totalExpenseConverted)
        );

        remainingLabel.setText("Remaining Budget (INR): ₹" + String.format("%.2f", remaining));

        if (remaining < 0) {

            remainingLabel.setForeground(Color.RED);

            JOptionPane.showMessageDialog(
                    this,
                    "⚠ Budget Exceeded!\nYou have overspent your trip budget.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );

        } else if (remaining <= totalBudget * 0.2) {

            remainingLabel.setForeground(Color.ORANGE);

        } else {

            remainingLabel.setForeground(new Color(0, 128, 0));
        }
    }
}