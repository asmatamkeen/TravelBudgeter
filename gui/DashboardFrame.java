package gui;

import logic.HotelManager;
import model.Hotel;
import model.Trip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

public class DashboardFrame extends JFrame {

    private JComboBox<String> cityCombo;
    private JComboBox<Hotel> hotelCombo;
    private JTextArea detailsArea;

    private JPanel customPanel;
    private JLabel totalLabel;

    private HotelManager hotelManager;
    private Trip trip;   // ✅ use this trip

    // ================= CONSTRUCTOR =================
    public DashboardFrame(Trip trip) {

        this.trip = trip;   // ✅ IMPORTANT FIX
        hotelManager = new HotelManager();

        setTitle("Travel Budget Planner - Dashboard");
        setSize(750, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ================= TOP PANEL =================
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        cityCombo = new JComboBox<>(hotelManager.getCities());
        hotelCombo = new JComboBox<>();

        topPanel.add(new JLabel("Select City:"));
        topPanel.add(cityCombo);
        topPanel.add(new JLabel("Select Hotel:"));
        topPanel.add(hotelCombo);

        add(topPanel, BorderLayout.NORTH);

        // ================= CENTER =================
        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        add(new JScrollPane(detailsArea), BorderLayout.CENTER);

        // ================= BOTTOM =================
        JPanel bottomPanel = new JPanel(new BorderLayout());

        JButton showButton = new JButton("Show Plans");
        bottomPanel.add(showButton, BorderLayout.NORTH);

        customPanel = new JPanel(new GridLayout(0, 1));
        bottomPanel.add(new JScrollPane(customPanel), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton basicBtn = new JButton("Select Basic");
        JButton standardBtn = new JButton("Select Standard");
        JButton premiumBtn = new JButton("Select Premium");
        JButton customBtn = new JButton("Add Custom Plan");

        buttonPanel.add(basicBtn);
        buttonPanel.add(standardBtn);
        buttonPanel.add(premiumBtn);
        buttonPanel.add(customBtn);

        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // ================= RIGHT SIDE TOTAL =================
        totalLabel = new JLabel();
        totalLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        add(totalLabel, BorderLayout.EAST);

        updateTotalLabel();

        // ================= LISTENERS =================
        cityCombo.addActionListener(this::loadHotels);
        showButton.addActionListener(this::showPlans);

        basicBtn.addActionListener(e -> addPlanPrice("basic"));
        standardBtn.addActionListener(e -> addPlanPrice("standard"));
        premiumBtn.addActionListener(e -> addPlanPrice("premium"));
        customBtn.addActionListener(this::calculateCustom);

        loadHotels(null);

        setVisible(true);
    }

    // ================= LOAD HOTELS =================
    private void loadHotels(ActionEvent e) {

        hotelCombo.removeAllItems();

        String city = (String) cityCombo.getSelectedItem();
        List<Hotel> hotels = hotelManager.getHotelsByCity(city);

        for (Hotel h : hotels) {
            hotelCombo.addItem(h);
        }
    }

    // ================= SHOW PLANS =================
    private void showPlans(ActionEvent e) {

        Hotel hotel = (Hotel) hotelCombo.getSelectedItem();
        if (hotel == null) return;

        detailsArea.setText("");

        detailsArea.append("Hotel: " + hotel.getName() + "\n\n");

        detailsArea.append("BASIC PLAN - ₹" + hotel.getBasic() + "\n");
        detailsArea.append("Features: " + hotel.getBasicFeatures() + "\n\n");

        detailsArea.append("STANDARD PLAN - ₹" + hotel.getStandard() + "\n");
        detailsArea.append("Features: " + hotel.getStandardFeatures() + "\n\n");

        detailsArea.append("PREMIUM PLAN - ₹" + hotel.getPremium() + "\n");
        detailsArea.append("Features: " + hotel.getPremiumFeatures() + "\n\n");

        // Load Custom Features
        customPanel.removeAll();
        Map<String, Double> features = hotel.getCustomFeatures();

        for (String feature : features.keySet()) {

            JCheckBox checkBox =
                    new JCheckBox(feature + " (₹" + features.get(feature) + ")");

            checkBox.setActionCommand(feature);
            customPanel.add(checkBox);
        }

        customPanel.revalidate();
        customPanel.repaint();
    }

    // ================= ADD PLAN PRICE =================
    private void addPlanPrice(String type) {

        Hotel hotel = (Hotel) hotelCombo.getSelectedItem();
        if (hotel == null) return;

        double price = 0;

        switch (type) {
            case "basic":
                price = hotel.getBasic();
                break;
            case "standard":
                price = hotel.getStandard();
                break;
            case "premium":
                price = hotel.getPremium();
                break;
        }

        trip.addExpense(price);   // ✅ add directly to trip
        updateTotalLabel();

        JOptionPane.showMessageDialog(this,
                "Added ₹" + price + " to Expense.");
    }

    // ================= CUSTOM PLAN =================
    private void calculateCustom(ActionEvent e) {

        Hotel hotel = (Hotel) hotelCombo.getSelectedItem();
        if (hotel == null) return;

        Component[] components = customPanel.getComponents();
        double total = 0;

        for (Component c : components) {
            if (c instanceof JCheckBox) {
                JCheckBox cb = (JCheckBox) c;
                if (cb.isSelected()) {
                    String feature = cb.getActionCommand();
                    total += hotel.getCustomFeatures().get(feature);
                }
            }
        }

        trip.addExpense(total);   // ✅ add custom to expense
        updateTotalLabel();

        JOptionPane.showMessageDialog(this,
                "Custom Plan Added: ₹" + total);
    }


    // ================= UPDATE TOTAL =================
    private void updateTotalLabel() {

        double inr = trip.getTotalExpenseINR();
        double dest = trip.getTotalExpenseInDestination();

        totalLabel.setText(
                "<html><b>Total Expense:</b><br><br>" +
                        "INR: ₹" + String.format("%.2f", inr) + "<br>" +
                        trip.getDestinationCurrency() + ": "
                        + String.format("%.2f", dest) +
                        "</html>"
        );
    }
}