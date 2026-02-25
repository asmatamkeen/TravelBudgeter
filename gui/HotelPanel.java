package gui;

import model.Hotel;

import javax.swing.*;
import java.awt.*;

public class HotelPanel extends JPanel {

    public HotelPanel(Hotel hotel) {

        setLayout(new GridLayout(4, 1));
        setBorder(BorderFactory.createTitledBorder(hotel.getName()));

        add(new JLabel("Basic: ₹" + hotel.getBasic()));
        add(new JLabel("Standard: ₹" + hotel.getStandard()));
        add(new JLabel("Premium: ₹" + hotel.getPremium()));

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
                            "Custom plan price: ₹" + custom);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Invalid amount");
                }
            }
        });

        add(customize);
    }
}