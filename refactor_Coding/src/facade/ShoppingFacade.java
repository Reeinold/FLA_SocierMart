package facade;

import model.Product;
import model.Order;
import model.OrderLine;
import strategy.PaymentStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ShoppingFacade {
    private static final ShoppingFacade INSTANCE = new ShoppingFacade();

    private final Map<String, Product> catalog = new HashMap<>();
    private Order currentOrder = new Order();

    private ShoppingFacade() {}

    public static ShoppingFacade getInstance() {
        return INSTANCE;
    }

    public synchronized void refillProduct(String id, String name, double price, int qty) {
        Product p = catalog.get(id);
        if (p == null) {
            catalog.put(id, new Product(id, name, price, qty));
        } else {
            p.increaseQuantity(qty);
        }
    }

    public synchronized OperationResult addToCart(String productId, int qty) {
        if (qty <= 0) return OperationResult.failure("Jumlah harus lebih dari 0");
        Product p = catalog.get(productId);
        if (p == null) return OperationResult.failure("Produk tidak ditemukan");
        if (p.getQuantity() < qty) return OperationResult.failure("Stok tidak mencukupi");
        currentOrder.addItem(productId, p.getName(), qty, p.getPrice());
        p.decreaseQuantity(qty);
        return OperationResult.success("Berhasil ditambahkan ke keranjang");
    }

    public synchronized OperationResult removeFromCart(String productId) {
        boolean removed = currentOrder.removeItem(productId);
        if (!removed) return OperationResult.failure("Produk tidak ada di keranjang");
        // Optionally return stock to catalog
        return OperationResult.success("Produk dihapus dari keranjang");
    }

    public synchronized Map<String, Product> listCatalog() {
        return Collections.unmodifiableMap(new HashMap<>(catalog));
    }

    public synchronized List<OrderLine> listCart() {
        return Collections.unmodifiableList(currentOrder.getLines());
    }

    public synchronized OperationResult checkout() {
        if (currentOrder.getLines().isEmpty()) return OperationResult.failure("Keranjang kosong, tidak bisa checkout");
        currentOrder.checkout();
        return OperationResult.success("Checkout berhasil. Silakan pilih metode pembayaran.");
    }

    public synchronized OperationResult pay(PaymentStrategy strategy) {
        if (currentOrder.getLines().isEmpty()) return OperationResult.failure("Tidak ada pesanan untuk dibayar");
        OperationResult res = strategy.pay(currentOrder);
        if (res.isSuccess()) {
            currentOrder.pay();
            // reset order after payment to simulate new shopping session
            currentOrder = new Order();
        }
        return res;
    }
}