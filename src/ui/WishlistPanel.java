package ui;

import javax.swing.*;
import java.awt.*;

public class WishlistPanel extends UIState {
    public WishlistPanel(UIContext ctx) {
        super(ctx);
        setLayout(new GridLayout(0,1,5,5));

        add(new JLabel("Wishlist Operations", SwingConstants.CENTER));

        JButton viewWishlist = new JButton("View Wishlist");
        JButton addItem = new JButton("Add Item");
        JButton deleteItem = new JButton("Delete Item");
        JButton modifyItem = new JButton("Modify Quantity");
        JButton placeOrder = new JButton("Place Order");
        JButton back = new JButton("Back to Client Menu");

        back.addActionListener(e -> goTo("CLIENT"));

        add(viewWishlist);
        add(addItem);
        add(deleteItem);
        add(modifyItem);
        add(placeOrder);
        add(back);
    }
}
