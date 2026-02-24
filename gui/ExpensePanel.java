package gui;

import logic.CurrencyConverter;
import logic.ExpenseManager;
import model.Expense;
import model.Trip;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ExpensePanel extends JPanel {

    private DefaultTableModel tableModel;

    public ExpensePanel(DashboardFrame frame, Trip trip) {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // ===== FORM PANEL =====
        JPanel formPanel = new JPanel(new GridLayout(2, 3, 10, 10));

        JTextField categoryField = new JTextField();
        JTextField amountField = new JTextField();
        JButton addButton = new JButton("Add Expense");

        formPanel.add(new JLabel("Category:"));
        formPanel.add(new JLabel("Amount (INR):"));
        formPanel.add(new JLabel());

        formPanel.add(categoryField);
        formPanel.add(amountField);
        formPanel.add(addButton);

        add(formPanel, BorderLayout.NORTH);

        // ===== TABLE =====
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Category");
        tableModel.addColumn("Amount (INR)");
        tableModel.addColumn("Amount (" + trip.getCurrency() + ")");

        JTable table = new JTable(tableModel);
        table.setRowHeight(25);

        add(new JScrollPane(table), BorderLayout.CENTER);

        // 🔥 LOAD PREVIOUSLY ADDED EXPENSES
        loadExistingExpenses();

        // ===== BACK BUTTON =====
        JButton backBtn = new JButton("Back");
        add(backBtn, BorderLayout.SOUTH);

        backBtn.addActionListener(e -> frame.showDashboardPanel());

        // ===== ADD BUTTON LOGIC =====
        addButton.addActionListener(e -> {
            try {

                String category = categoryField.getText();

                if (category.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Enter category!");
                    return;
                }

                double nativeAmount = Double.parseDouble(amountField.getText());

                double convertedAmount = CurrencyConverter.convert(
                        nativeAmount,
                        "INR",
                        trip.getCurrency()
                );

                Expense expense = new Expense(category, nativeAmount, convertedAmount);
                ExpenseManager.addExpense(expense);

                tableModel.addRow(new Object[]{
                        category,
                        nativeAmount,
                        convertedAmount
                });

                categoryField.setText("");
                amountField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        });
    }

    // 🔥 THIS METHOD LOADS EXISTING EXPENSES WHEN PANEL OPENS
    private void loadExistingExpenses() {

        tableModel.setRowCount(0); // clear table before loading

        for (Expense e : ExpenseManager.getExpenses()) {
            tableModel.addRow(new Object[]{
                    e.getCategory(),
                    e.getNativeAmount(),
                    e.getConvertedAmount()
            });
        }
    }
}