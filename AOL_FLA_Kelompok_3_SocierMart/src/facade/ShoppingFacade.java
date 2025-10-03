package facade;
import Model.Product;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class ShoppingFacade {
	private Service service;
	private ServicePesan pesanan;
	private ServicePembayaran bayar;
	private Map<Integer, Product> productCatalog;
    private Map<Integer, Product> cart;

    public ShoppingFacade() {
        productCatalog = new HashMap<>();
        cart = new HashMap<>();

        service = new Service(cart, productCatalog);
        pesanan = new ServicePesan(cart);
        bayar = new ServicePembayaran();
    }
    public Map<Integer, Product> getProductCatalog() {
        return productCatalog;
    }
    public void addProductToCatalog(Product product) {
        int newId = Integer.parseInt(product.getId());
        productCatalog.put(newId, product);
        addToCart(newId);
    }
    public void addProductToCatalogAndCart(Product product) {
        try {
            int idKey = Integer.parseInt(product.getId());
            productCatalog.put(idKey, product);
            addToCart(idKey);
            System.out.println("Produk " + product.getName() + " berhasil ditambahkan ke katalog dan keranjang.");
        } catch (NumberFormatException e) {
            System.out.println("ID produk harus berupa angka.");
        }
    }


    // Method untuk mendapatkan koleksi produk di keranjang
    public Collection<Product> getCart() {
        return service.getCart().values();
    }

    public void addToCart(int productId) {
        service.addToCart(productId);
    }

    public void removeFromCart(int productId) {
        service.removeFromCart(productId);
    }

    public void placeOrder() {
        pesanan.placeOrder();
    }

    public void selectPaymentMethod(String method) {
        bayar.selectPaymentMethod(method);
    }

    public void pay() {
        double total = pesanan.getTotal();
        if (total > 0) {
            bayar.processPayment(total);
        } else {
            System.out.println("Tidak ada pembayaran karena keranjang kosong.");
        }
    }
}
