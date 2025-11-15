package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClerkPanel extends UIState {
    private Warehouse warehouse;

    public ClerkPanel(UIContext ctx) {
        super(ctx);
        warehouse = Warehouse.instance();
        setLayout(new GridLayout(0,1,5,5));

        add(new JLabel("Clerk Menu", SwingConstants.CENTER));

        JButton addClient = new JButton("Add Client");
        JButton showClients = new JButton("Show Clients");
        JButton showProducts = new JButton("Show Products");
        JButton logout = new JButton("Logout");

        addClient.addActionListener(e -> addClientAction());
        showClients.addActionListener(e -> showClientsAction());
        showProducts.addActionListener(e -> showProductsAction());
        logout.addActionListener(e -> goTo("LOGIN"));

        add(addClient);
        add(showClients);
        add(showProducts);
        add(logout);
    }

    private void addClientAction() {
        String id = JOptionPane.showInputDialog(this, "Enter new Client ID:");
        if (id != null && !id.trim().isEmpty()) {
            warehouse.addClient(id.trim());
            JOptionPane.showMessageDialog(this, "Client added: " + id);
        }
    }

    private void showClientsAction() {
        java.util.List<String> list = warehouse.getClients();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No clients found!");
        } else {
            JOptionPane.showMessageDialog(this, String.join("\n", list));
        }
    }

    private void showProductsAction() {
        java.util.List<String> list = warehouse.getProducts();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No products found!");
        } else {
            JOptionPane.showMessageDialog(this, String.join("\n", list));
        }
    }
}
