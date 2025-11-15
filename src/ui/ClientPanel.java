package ui;

import javax.swing.*;
import java.awt.*;

public class ClientPanel extends UIState {
    public ClientPanel(UIContext ctx) {
        super(ctx);
        setLayout(new GridLayout(0,1,5,5));

        add(new JLabel("Client Menu", SwingConstants.CENTER));

        JButton showProducts = new JButton("Show Products");
        JButton wishlistOps = new JButton("Wishlist Operations");
        JButton logout = new JButton("Logout");

        wishlistOps.addActionListener(e -> goTo("WISHLIST"));
        logout.addActionListener(e -> goTo("LOGIN"));

        add(showProducts);
        add(wishlistOps);
        add(logout);
    }
}
