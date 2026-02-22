package gui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel contentPanel;

    public DashboardFrame() {

        setTitle("Travel Budgeter Dashboard");
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // TITLE
        JLabel title = new JLabel("Travel Budgeter Dashboard",JLabel.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,22));
        add(title,BorderLayout.NORTH);

        // MENU PANEL
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3,1,10,10));

        JButton converterBtn = new JButton("Currency Converter");
        JButton expenseBtn = new JButton("Add Expense");
        JButton budgetBtn = new JButton("Budget Planner");

        menuPanel.add(converterBtn);
        menuPanel.add(expenseBtn);
        menuPanel.add(budgetBtn);

        add(menuPanel,BorderLayout.WEST);

        // CONTENT PANEL (CENTER)
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.add(new ConverterPanel(), "converter");
        contentPanel.add(new ExpensePanel(), "expense");
        contentPanel.add(new BudgetPanel(), "budget");

        add(contentPanel, BorderLayout.CENTER);

        // BUTTON ACTIONS
        converterBtn.addActionListener(e -> cardLayout.show(contentPanel, "converter"));
        expenseBtn.addActionListener(e -> cardLayout.show(contentPanel, "expense"));
        budgetBtn.addActionListener(e -> cardLayout.show(contentPanel, "budget"));

        setVisible(true);
    }
}