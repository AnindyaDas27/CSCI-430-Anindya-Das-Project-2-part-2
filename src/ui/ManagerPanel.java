package ui;

import javax.swing.*;
import java.awt.*;

public class ManagerPanel extends UIState {
    public ManagerPanel(UIContext ctx) {
        super(ctx);
        setLayout(new GridLayout(0,1,5,5));

        add(new JLabel("Manager Menu", SwingConstants.CENTER));

        JButton addProduct = new JButton("Add Product");
        JButton receiveShipment = new JButton("Receive Shipment");
        JButton viewWaitlist = new JButton("View Waitlist");
        JButton logout = new JButton("Logout");

        logout.addActionListener(e -> goTo("LOGIN"));

        add(addProduct);
        add(receiveShipment);
        add(viewWaitlist);
        add(logout);
    }
}
