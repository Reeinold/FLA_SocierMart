package facade;

import java.util.Map;
import Model.Product;

public class Service {
    private Map<Integer, Product> cart;
    private Map<Integer, Product> productCatalog;

    public Service(Map<Integer, Product> cart, Map<Integer, Product> productCatalog) {
        this.cart = cart;
        this.productCatalog = productCatalog;
    }

    public void addToCart(int productId) {
        Product product = productCatalog.get(productId);
        if (product != null) {
            // Jika produk sudah ada di keranjang, update quantity
            if (cart.containsKey(productId)) {
                Product existing = cart.get(productId);
                existing.setQuantity(existing.getQuantity() + product.getQuantity());
            } else {
                // Buat salinan produk agar quantity bisa diubah tanpa mengubah katalog
                cart.put(productId, new Product(product.getId(), product.getName(), product.getPrice(), product.getQuantity()));
            }
            System.out.println(product.getName() + " ditambahkan ke keranjang.");
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    public void removeFromCart(int productId) {
        Product removed = cart.remove(productId);
        if (removed != null) {
            System.out.println(removed.getName() + " dihapus dari keranjang.");
        } else {
            System.out.println("Produk tidak ada di keranjang.");
        }
    }

    public Map<Integer, Product> getCart() {
        return cart;
    }
}
