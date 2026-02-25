package gui;

import logic.HotelManager;
import model.Hotel;
import model.Trip;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DashboardFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel container;
    private Trip trip;

    public DashboardFrame(Trip trip) {

        this.trip = trip;

        setTitle("Travel Dashboard");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        // Panels
        container.add(createDashboardPanel(), "DASHBOARD");
        container.add(new BudgetPanel(this, trip), "BUDGET");
        container.add(new ConverterPanel(this), "CONVERTER");

        add(container);
        setVisible(true);
    }

    // 🔹 Main dashboard screen
    private JPanel createDashboardPanel() {

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel hotelListPanel = new JPanel();
        hotelListPanel.setLayout(new BoxLayout(hotelListPanel, BoxLayout.Y_AXIS));

        HotelManager manager = new HotelManager();
        List<Hotel> hotels = manager.getHotelsByCity(trip.getDestination());

        JLabel tripInfo = new JLabel(
                "Destination: " + trip.getDestination() +
                        " | Budget: " + trip.getCurrency() + " " + trip.getBudget()
        );

        hotelListPanel.add(tripInfo);

        for (Hotel hotel : hotels) {

            JPanel hotelPanel = new JPanel(new GridLayout(4, 1));
            hotelPanel.setBorder(BorderFactory.createTitledBorder(hotel.getName()));

            hotelPanel.add(new JLabel(
                    "<html><b>Basic:</b> " + trip.getCurrency() + " " + hotel.getBasic() +
                            "<br>Features: " + hotel.getBasicFeatures() +
                            "</html>"
            ));

            hotelPanel.add(new JLabel(
                    "<html><b>Standard:</b> " + trip.getCurrency() + " " + hotel.getStandard() +
                            "<br>Features: " + hotel.getStandardFeatures() +
                            "</html>"
            ));

            hotelPanel.add(new JLabel(
                    "<html><b>Premium:</b> " + trip.getCurrency() + " " + hotel.getPremium() +
                            "<br>Features: " + hotel.getPremiumFeatures() +
                            "</html>"
            ));

            JButton customize = new JButton("Customize Plan");

            customize.addActionListener(e -> {
                String input = JOptionPane.showInputDialog(
                        this,
                        "Enter custom price per day:"
                );

                if (input != null) {
                    try {
                        double custom = Double.parseDouble(input);
                        JOptionPane.showMessageDialog(this,
                                "Custom plan price: " + trip.getCurrency() + " " + custom);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Invalid amount");
                    }
                }
            });

            hotelPanel.add(customize);
            hotelListPanel.add(hotelPanel);
        }

        JScrollPane scrollPane = new JScrollPane(hotelListPanel);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        JButton expenseButton = new JButton("Expense Summary");
        JButton budgetButton = new JButton("Budget Overview");
        JButton converterButton = new JButton("Currency Converter");

        expenseButton.addActionListener(e -> new ExpensePanel(trip));
        budgetButton.addActionListener(e -> showBudgetPanel());
        converterButton.addActionListener(e -> showConverterPanel());

        bottomPanel.add(expenseButton);
        bottomPanel.add(budgetButton);
        bottomPanel.add(converterButton);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

    public void showDashboardPanel() {
        cardLayout.show(container, "DASHBOARD");
    }

    public void showBudgetPanel() {
        cardLayout.show(container, "BUDGET");
    }

    public void showConverterPanel() {
        cardLayout.show(container, "CONVERTER");
    }
}