package ui;

import javax.swing.*;
import java.awt.*;

public class ClerkPanel extends UIState {
    public ClerkPanel(UIContext ctx) {
        super(ctx);
        setLayout(new GridLayout(0,1,5,5));

        add(new JLabel("Clerk Menu", SwingConstants.CENTER));

        JButton addClient = new JButton("Add Client");
        JButton showClients = new JButton("Show Clients");
        JButton recordPayment = new JButton("Record Payment");
        JButton logout = new JButton("Logout");

        logout.addActionListener(e -> goTo("LOGIN"));

        add(addClient);
        add(showClients);
        add(recordPayment);
        add(logout);
    }
}

