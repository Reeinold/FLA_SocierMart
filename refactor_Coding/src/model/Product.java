package model;

public class Product {
    private final String id;
    private final String name;
    private final double price;
    private int quantity;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void decreaseQuantity(int delta) { this.quantity -= delta; }
    public void increaseQuantity(int delta) { this.quantity += delta; }

    @Override
    public String toString() {
        return String.format("%s - %s (Rp %.0f) [stok: %d]", id, name, price, quantity);
    }
}
