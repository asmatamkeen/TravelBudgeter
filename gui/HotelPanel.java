package gui;

import logic.CurrencyConverter;
import logic.ExpenseManager;
import logic.HotelManager;
import model.Expense;
import model.Hotel;
import model.Trip;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HotelPanel extends JPanel {

    public HotelPanel(DashboardFrame frame, Trip trip) {

        setLayout(new GridLayout(6, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));

        ArrayList<Hotel> hotels = HotelManager.getHotels(trip.getDestination());

        JComboBox<String> hotelBox = new JComboBox<>();
        for (Hotel h : hotels) {
            hotelBox.addItem(h.getName() + " (Per Day: " + h.getPricePerDay() + " " + trip.getCurrency() + ")");
        }

        JLabel totalCostLabel = new JLabel("Total Cost: ");

        JButton calculateBtn = new JButton("Calculate");
        JButton bookBtn = new JButton("Add to Expenses");
        JButton backBtn = new JButton("Back");

        add(new JLabel("Select Hotel:"));
        add(hotelBox);

        add(new JLabel("Days:"));
        add(new JLabel(String.valueOf(trip.getDays())));

        add(new JLabel("Travelers:"));
        add(new JLabel(String.valueOf(trip.getTravelers())));

        add(calculateBtn);
        add(totalCostLabel);

        add(bookBtn);
        add(backBtn);

        calculateBtn.addActionListener(e -> {
            int index = hotelBox.getSelectedIndex();
            Hotel selected = hotels.get(index);

            double totalCost = selected.getPricePerDay()
                    * trip.getDays()
                    * trip.getTravelers();

            totalCostLabel.setText("Total Cost: " + totalCost + " " + trip.getCurrency());
        });

        bookBtn.addActionListener(e -> {
            int index = hotelBox.getSelectedIndex();
            Hotel selected = hotels.get(index);

            double totalCost = selected.getPricePerDay()
                    * trip.getDays()
                    * trip.getTravelers();

            double convertedToINR = CurrencyConverter.convert(
                    totalCost,
                    trip.getCurrency(),
                    "INR"
            );

            Expense expense = new Expense(
                    "Hotel - " + selected.getName(),
                    convertedToINR,
                    totalCost
            );

            ExpenseManager.addExpense(expense);

            JOptionPane.showMessageDialog(this,
                    "Hotel added to expenses successfully!");
        });

        backBtn.addActionListener(e -> frame.showDashboardPanel());
    }
}