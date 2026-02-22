package gui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    public DashboardFrame() {

        setTitle("Travel Budgeter");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== SIDEBAR =====
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(3, 1, 20, 20));
        sidePanel.setBackground(new Color(24, 30, 54));
        sidePanel.setPreferredSize(new Dimension(220, getHeight()));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));

        JButton converterBtn = createSidebarButton("Currency Converter");
        JButton expenseBtn = createSidebarButton("Add Expense");
        JButton budgetBtn = createSidebarButton("Budget Planner");

        sidePanel.add(converterBtn);
        sidePanel.add(expenseBtn);
        sidePanel.add(budgetBtn);

        add(sidePanel, BorderLayout.WEST);

        // ===== CONTENT AREA =====
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(new Color(40, 45, 70));

        contentPanel.add(new ConverterPanel(), "converter");
        contentPanel.add(new ExpensePanel(), "expense");
        contentPanel.add(new BudgetPanel(), "budget");

        add(contentPanel, BorderLayout.CENTER);

        // ===== BUTTON ACTIONS =====
        converterBtn.addActionListener(e -> cardLayout.show(contentPanel, "converter"));
        expenseBtn.addActionListener(e -> cardLayout.show(contentPanel, "expense"));
        budgetBtn.addActionListener(e -> cardLayout.show(contentPanel, "budget"));

        setVisible(true);
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(59, 130, 246));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        return button;
    }
}