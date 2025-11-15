package ui;

import javax.swing.*;
import java.awt.*;

public class UIContext extends JFrame {
    private static UIContext instance;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private UIContext() {
        setTitle("Warehouse FSM GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel);

        // Initialize states
        mainPanel.add(new LoginPanel(this), "LOGIN");
        mainPanel.add(new ClerkPanel(this), "CLERK");
        mainPanel.add(new ClientPanel(this), "CLIENT");
        mainPanel.add(new ManagerPanel(this), "MANAGER");
        mainPanel.add(new WishlistPanel(this), "WISHLIST");

        showState("LOGIN");
    }

    public static UIContext instance() {
        if (instance == null) instance = new UIContext();
        return instance;
    }

    public void showState(String name) {
        cardLayout.show(mainPanel, name);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> UIContext.instance().setVisible(true));
    }
}
