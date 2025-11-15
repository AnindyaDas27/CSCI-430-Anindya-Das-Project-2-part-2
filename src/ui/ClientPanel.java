package ui;
import javax.swing.*;
import java.awt.*;

public class ClientPanel extends UIState {
    private Warehouse warehouse;
    private Client currentClient;

    public ClientPanel(UIContext ctx) {
        super(ctx);
        warehouse = Warehouse.instance();
        setLayout(new GridLayout(0,1,5,5));

        add(new JLabel("Client Menu", SwingConstants.CENTER));

        JButton loginClient = new JButton("Enter Client ID");
        JButton showProducts = new JButton("Show Products");
        JButton wishlistOps = new JButton("Wishlist Operations");
        JButton logout = new JButton("Logout");

        loginClient.addActionListener(e -> {
            String id = JOptionPane.showInputDialog(this, "Enter your Client ID:");
            Client c = warehouse.getClient(id);
            if (c != null) {
                currentClient = c;
                JOptionPane.showMessageDialog(this, "Logged in as: " + id);
            } else {
                JOptionPane.showMessageDialog(this, "Client not found!");
            }
        });

        showProducts.addActionListener(e -> {
            var sb = new StringBuilder();
            for (Product p : warehouse.getProducts()) sb.append(p).append("\n");
            JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No products yet.");
        });

        wishlistOps.addActionListener(e -> {
            if (currentClient == null) {
                JOptionPane.showMessageDialog(this, "Please log in as a client first!");
            } else {
                WishlistPanel.setActiveClient(currentClient);
                goTo("WISHLIST");
            }
        });

        logout.addActionListener(e -> goTo("LOGIN"));

        add(loginClient);
        add(showProducts);
        add(wishlistOps);
        add(logout);
    }
}
