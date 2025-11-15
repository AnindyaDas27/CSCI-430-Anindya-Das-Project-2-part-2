package ui;
import java.util.*;

public class Warehouse {
    private static Warehouse instance;
    private Map<String, Client> clients = new HashMap<>();
    private Map<String, Product> products = new HashMap<>();

    private Warehouse() {}

    public static Warehouse instance() {
        if (instance == null) instance = new Warehouse();
        return instance;
    }

    // CLIENTS
    public void addClient(String id) {
        if (!clients.containsKey(id)) {
            clients.put(id, new Client(id));
        }
    }

    public Collection<Client> getClients() {
        return clients.values();
    }

    public Client getClient(String id) {
        return clients.get(id);
    }

    // PRODUCTS
    public void addProduct(String id, int qty, double price) {
        if (!products.containsKey(id)) {
            products.put(id, new Product(id, qty, price));
        }
    }

    public Collection<Product> getProducts() {
        return products.values();
    }

    public Product getProduct(String id) {
        return products.get(id);
    }
}
