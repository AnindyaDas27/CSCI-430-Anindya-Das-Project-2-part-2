package ui;

public class Product {
    private String id;
    private int quantity;
    private double price;

    public Product(String id, int quantity, double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() { return id; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void reduceQuantity(int q) {
        quantity = Math.max(0, quantity - q);
    }

    @Override
    public String toString() {
        return id + " | Qty: " + quantity + " | Price: $" + price;
    }
}
