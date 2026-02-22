package gui;

import model.Expense;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ExpensePanel extends JPanel {

    private DefaultTableModel tableModel;

    public ExpensePanel() {

        setLayout(new BorderLayout());

        // TOP FORM
        JPanel formPanel = new JPanel(new GridLayout(3,2,10,10));

        JTextField categoryField = new JTextField();
        JTextField amountField = new JTextField();
        JButton addBtn = new JButton("Add Expense");

        formPanel.add(new JLabel("Category:"));
        formPanel.add(categoryField);
        formPanel.add(new JLabel("Amount:"));
        formPanel.add(amountField);
        formPanel.add(new JLabel());
        formPanel.add(addBtn);

        add(formPanel, BorderLayout.NORTH);

        // TABLE
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Category");
        tableModel.addColumn("Amount");

        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // BUTTON ACTION
        addBtn.addActionListener(e -> {
            try {
                String category = categoryField.getText();
                double amount = Double.parseDouble(amountField.getText());

                Expense expense = new Expense(category, amount);

                tableModel.addRow(new Object[]{
                        expense.getCategory(),
                        expense.getAmount()
                });

                categoryField.setText("");
                amountField.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Invalid Input");
            }
        });
    }
}