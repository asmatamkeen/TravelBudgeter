import gui.HomePanel;

import javax.swing.*;

public class MainApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Travel Budget Planner");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.add(new HomePanel(frame));

        frame.setVisible(true);
    }
}