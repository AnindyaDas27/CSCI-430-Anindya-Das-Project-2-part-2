package ui;
import java.util.*;

public class Client {
    private String id;
    private double balance;
    private Map<String, Integer> wishlist = new HashMap<>();

    public Client(String id) {
        this.id = id;
        this.balance = 0;
    }

    public String getId() { return id; }
    public double getBalance() { return balance; }

    public void addToWishlist(String product, int qty) {
        wishlist.put(product, wishlist.getOrDefault(product, 0) + qty);
    }

    public Map<String, Integer> getWishlist() {
        return wishlist;
    }

    public void clearWishlist() {
        wishlist.clear();
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return id + " | Balance: $" + balance;
    }
}
