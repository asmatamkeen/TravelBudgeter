package gui;

import logic.ExpenseManager;
import model.Expense;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ExpensePanel extends JPanel {

    private DefaultTableModel tableModel;

    public ExpensePanel() {

        setBackground(new Color(40, 45, 70));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JPanel formPanel = new JPanel(new GridLayout(2, 3, 15, 15));
        formPanel.setBackground(new Color(40, 45, 70));

        JTextField categoryField = new JTextField();
        JTextField amountField = new JTextField();
        JButton addButton = new JButton("Add Expense");

        styleButton(addButton);

        formPanel.add(createLabel("Category:"));
        formPanel.add(createLabel("Amount:"));
        formPanel.add(new JLabel());

        formPanel.add(categoryField);
        formPanel.add(amountField);
        formPanel.add(addButton);

        add(formPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Category");
        tableModel.addColumn("Amount");

        JTable table = new JTable(tableModel);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);

        add(new JScrollPane(table), BorderLayout.CENTER);

        addButton.addActionListener(e -> {
            try {
                String category = categoryField.getText();
                double amount = Double.parseDouble(amountField.getText());

                Expense expense = new Expense(category, amount);
                ExpenseManager.addExpense(expense);

                tableModel.addRow(new Object[]{category, amount});

                categoryField.setText("");
                amountField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        });
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return label;
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(59, 130, 246));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }
}