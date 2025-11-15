package ui;
import javax.swing.*;
import java.awt.*;

public class ManagerPanel extends UIState {
    private Warehouse warehouse;

    public ManagerPanel(UIContext ctx) {
        super(ctx);
        warehouse = Warehouse.instance();
        setLayout(new GridLayout(0,1,5,5));

        add(new JLabel("Manager Menu", SwingConstants.CENTER));

        JButton addProduct = new JButton("Add Product");
        JButton showProducts = new JButton("Show Products");
        JButton logout = new JButton("Logout");

        addProduct.addActionListener(e -> {
            String id = JOptionPane.showInputDialog(this, "Enter Product ID:");
            String qtyStr = JOptionPane.showInputDialog(this, "Enter Quantity:");
            String priceStr = JOptionPane.showInputDialog(this, "Enter Price:");

            try {
                int qty = Integer.parseInt(qtyStr);
                double price = Double.parseDouble(priceStr);
                warehouse.addProduct(id.trim(), qty, price);
                JOptionPane.showMessageDialog(this, "Product added: " + id);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input.");
            }
        });

        showProducts.addActionListener(e -> {
            var sb = new StringBuilder();
            for (Product p : warehouse.getProducts()) sb.append(p).append("\n");
            JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No products yet.");
        });

        logout.addActionListener(e -> goTo("LOGIN"));

        add(addProduct);
        add(showProducts);
        add(logout);
    }
}
