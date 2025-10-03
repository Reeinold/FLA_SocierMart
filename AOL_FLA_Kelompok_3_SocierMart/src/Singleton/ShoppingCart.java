package Singleton;
import Model.Product;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private static volatile ShoppingCart instance;
    private List<Product> items;

    private ShoppingCart() {
        items = new ArrayList<>();
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            synchronized (ShoppingCart.class) {
                if (instance == null) {
                    instance = new ShoppingCart();
                }
            }
        }
        return instance;
    }

    public void addItem(Product product) {
        for (Product p : items) {
            if (p.equals(product)) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                return;
            }
        }
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public double calculateTotal() {
    	System.out.println("Total:");
        return items.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
    }
}
