package ui;
import javax.swing.*;
import java.awt.*;

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

        addClient.addActionListener(e -> {
            String id = JOptionPane.showInputDialog(this, "Enter new Client ID:");
            if (id != null && !id.trim().isEmpty()) {
                warehouse.addClient(id.trim());
                JOptionPane.showMessageDialog(this, "Client added: " + id);
            }
        });

        showClients.addActionListener(e -> {
            var sb = new StringBuilder();
            for (Client c : warehouse.getClients()) sb.append(c).append("\n");
            JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No clients yet.");
        });

        showProducts.addActionListener(e -> {
            var sb = new StringBuilder();
            for (Product p : warehouse.getProducts()) sb.append(p).append("\n");
            JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No products yet.");
        });

        logout.addActionListener(e -> goTo("LOGIN"));

        add(addClient);
        add(showClients);
        add(showProducts);
        add(logout);
    }
}
