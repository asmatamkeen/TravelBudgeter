package gui;

import javax.swing.*;
import java.awt.*;

public class BudgetPanel extends JPanel {

    public BudgetPanel() {

        setLayout(new GridLayout(3,2,10,10));

        JTextField budgetField = new JTextField();
        JButton setBtn = new JButton("Set Budget");
        JLabel resultLabel = new JLabel("Budget not set");

        add(new JLabel("Enter Budget:"));
        add(budgetField);
        add(new JLabel());
        add(setBtn);
        add(new JLabel());
        add(resultLabel);

        setBtn.addActionListener(e -> {
            try {
                double budget = Double.parseDouble(budgetField.getText());
                resultLabel.setText("Budget Set: " + budget);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Invalid Input");
            }
        });
    }
}