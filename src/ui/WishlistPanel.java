package ui;
import javax.swing.*;
import java.awt.*;

public class WishlistPanel extends UIState {
    private static Client activeClient;
    private Warehouse warehouse;

    public WishlistPanel(UIContext ctx) {
        super(ctx);
        warehouse = Warehouse.instance();
        setLayout(new GridLayout(0,1,5,5));

        add(new JLabel("Wishlist Operations", SwingConstants.CENTER));

        JButton addItem = new JButton("Add Item");
        JButton viewWishlist = new JButton("View Wishlist");
        JButton placeOrder = new JButton("Place Order");
        JButton back = new JButton("Back to Client Menu");

        addItem.addActionListener(e -> {
            String pid = JOptionPane.showInputDialog(this, "Enter Product ID:");
            String qtyStr = JOptionPane.showInputDialog(this, "Enter Quantity:");
            try {
                int qty = Integer.parseInt(qtyStr);
                if (warehouse.getProduct(pid) == null) {
                    JOptionPane.showMessageDialog(this, "Invalid product ID!");
                } else {
                    activeClient.addToWishlist(pid, qty);
                    JOptionPane.showMessageDialog(this, "Added " + qty + " of " + pid);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input.");
            }
        });

        viewWishlist.addActionListener(e -> {
            var wl = activeClient.getWishlist();
            if (wl.isEmpty()) JOptionPane.showMessageDialog(this, "Wishlist empty.");
            else {
                var sb = new StringBuilder();
                wl.forEach((k,v)-> sb.append(k).append(" x").append(v).append("\n"));
                JOptionPane.showMessageDialog(this, sb.toString());
            }
        });

        placeOrder.addActionListener(e -> {
            double total = 0;
            for (var entry : activeClient.getWishlist().entrySet()) {
                Product p = warehouse.getProduct(entry.getKey());
                if (p != null) {
                    int q = Math.min(entry.getValue(), p.getQuantity());
                    total += q * p.getPrice();
                    p.reduceQuantity(q);
                }
            }
            activeClient.addBalance(total);
            activeClient.clearWishlist();
            JOptionPane.showMessageDialog(this, "Order placed! Total = $" + total);
        });

        back.addActionListener(e -> goTo("CLIENT"));

        add(addItem);
        add(viewWishlist);
        add(placeOrder);
        add(back);
    }

    public static void setActiveClient(Client c) {
        activeClient = c;
    }
}
