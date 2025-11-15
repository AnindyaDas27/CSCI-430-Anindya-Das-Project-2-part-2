package ui;

import java.util.*;

public class Warehouse {
    private static Warehouse instance;
    private List<String> clients = new ArrayList<>();
    private List<String> products = new ArrayList<>();

    private Warehouse() {}

    public static Warehouse instance() {
        if (instance == null) instance = new Warehouse();
        return instance;
    }

    // CLIENT METHODS
    public void addClient(String id) {
        clients.add(id + " (Balance: $0)");
    }

    public List<String> getClients() {
        return clients;
    }

    // PRODUCT METHODS
    public void addProduct(String name, int qty, double price) {
        products.add(name + " - Qty: " + qty + " @ $" + price);
    }

    public List<String> getProducts() {
        return products;
    }
}
