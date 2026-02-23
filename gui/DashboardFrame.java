package gui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel container;

    public DashboardFrame() {

        setTitle("Travel Budgeter");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        HomePanel homePanel = new HomePanel(() -> cardLayout.show(container, "MAIN"));
        container.add(homePanel, "HOME");

        container.add(createMainPanel(), "MAIN");

        add(container);

        cardLayout.show(container, "HOME");
    }

    private JPanel createMainPanel() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(30, 35, 60));

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(3, 1, 10, 10));
        sidePanel.setBackground(new Color(30, 41, 59));
        sidePanel.setPreferredSize(new Dimension(200, 600));

        JButton expenseBtn = createSidebarButton("Expenses");
        JButton budgetBtn = createSidebarButton("Budget");
        JButton converterBtn = createSidebarButton("Currency");

        JPanel contentPanel = new JPanel(new CardLayout());
        CardLayout contentLayout = (CardLayout) contentPanel.getLayout();

        contentPanel.add(new ExpensePanel(), "EXPENSE");
        contentPanel.add(new BudgetPanel(), "BUDGET");
        contentPanel.add(new ConverterPanel(), "CONVERTER");

        expenseBtn.addActionListener(e -> contentLayout.show(contentPanel, "EXPENSE"));
        budgetBtn.addActionListener(e -> contentLayout.show(contentPanel, "BUDGET"));
        converterBtn.addActionListener(e -> contentLayout.show(contentPanel, "CONVERTER"));

        sidePanel.add(expenseBtn);
        sidePanel.add(budgetBtn);
        sidePanel.add(converterBtn);

        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(new Color(59, 130, 246));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return button;
    }
}