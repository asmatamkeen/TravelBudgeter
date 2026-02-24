import gui.HomePanel;

import javax.swing.*;

public class MainApp extends JFrame {

    public MainApp() {

        setTitle("Travel Budgeter");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(new HomePanel(this));

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainApp();
    }
}