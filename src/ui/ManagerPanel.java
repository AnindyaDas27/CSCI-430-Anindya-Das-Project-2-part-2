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
        JButton viewProducts = new JButton("View Products");
        JButton logout = new JButton("Logout");

        addProduct.addActionListener(e -> addProductAction());
        viewProducts.addActionListener(e -> viewProductsAction());
        logout.addActionListener(e -> goTo("LOGIN"));

        add(addProduct);
        add(viewProducts);
        add(logout);
    }

    private void addProductAction() {
        String name = JOptionPane.showInputDialog(this, "Enter Product Name:");
        String qtyStr = JOptionPane.showInputDialog(this, "Enter Quantity:");
        String priceStr = JOptionPane.showInputDialog(this, "Enter Price:");

        try {
            int qty = Integer.parseInt(qtyStr);
            double price = Double.parseDouble(priceStr);
            warehouse.addProduct(name, qty, price);
            JOptionPane.showMessageDialog(this, "Product added: " + name);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }

    private void viewProductsAction() {
        java.util.List<String> list = warehouse.getProducts();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No products found!");
        } else {
            JOptionPane.showMessageDialog(this, String.join("\n", list));
        }
    }
}
