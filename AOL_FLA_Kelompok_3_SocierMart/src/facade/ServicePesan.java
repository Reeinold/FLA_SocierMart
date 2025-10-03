package facade;
import java.util.Map;
import Model.Product;
public class ServicePesan {
	private Map<Integer, Product> cart;

    public ServicePesan(Map<Integer, Product> cart) {
        this.cart = cart;
    }

    public void placeOrder() {
        if (cart.isEmpty()) {
            System.out.println("Keranjang kosong, tidak ada pesanan.");
        } else {
            System.out.println("Pesanan berhasil dibuat untuk produk:");
            for (Product p : cart.values()) {
                System.out.println("- " + p.getName());
            }
        }
    }

    public double getTotal() {
        return cart.values().stream().mapToDouble(Product::getPrice).sum();
    }

}
