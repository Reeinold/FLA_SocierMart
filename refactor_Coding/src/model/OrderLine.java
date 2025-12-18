package model;

public class OrderLine {
    private final String productId;
    private final String name;
    private final int quantity;
    private final double pricePerUnit;

    public OrderLine(String productId, String name, int quantity, double pricePerUnit) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPricePerUnit() { return pricePerUnit; }

    public double getLineTotal() { return quantity * pricePerUnit; }

    @Override
    public String toString() {
        return String.format("%s - %s x%d = Rp %.0f", productId, name, quantity, getLineTotal());
    }
}
