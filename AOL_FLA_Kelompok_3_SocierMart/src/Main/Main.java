package Main;
import java.util.Scanner;

import Model.Product;
import facade.ShoppingFacade;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	        ShoppingFacade facade = new ShoppingFacade();

	        boolean running = true;
	        while (running) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Tambah barang ke keranjang");
	            System.out.println("2. Hapus barang dari keranjang");
	            System.out.println("3. Refill stok barang");
	            System.out.println("4. Daftar katalog");
	            System.out.println("5. Tampilkan isi keranjang");
	            System.out.println("6. Buat pesanan");
	            System.out.println("7. Pilih metode pembayaran");
	            System.out.println("8. Bayar");
	            System.out.println("9. Keluar");
	            System.out.print("Pilih menu: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Masukkan ID produk yang ingin ditambahkan: ");
	                    int addId = scanner.nextInt();
	                    scanner.nextLine();

	                    // Cek apakah produk ada di katalog
	                    if (facade.getProductCatalog().containsKey(addId)) {
	                        facade.addToCart(addId);
	                    } else {
	                        System.out.println("Stok kosong! Produk dengan ID " + addId + " tidak tersedia.");
	                    }
	                    break;

	                case 2:
	                	System.out.print("Masukkan ID produk yang ingin dihapus: ");
	                    int removeId = scanner.nextInt();
	                    scanner.nextLine();

	                    // Cek apakah produk ada di keranjang
	                    boolean isInCart = facade.getCart().stream()
	                        .anyMatch(product -> product.getId().equals(String.valueOf(removeId)));

	                    if (isInCart) {
	                        facade.removeFromCart(removeId);
	                    } else {
	                        System.out.println("Stok kosong! Produk dengan ID " + removeId + " tidak ada di keranjang.");
	                    }
	                    break;
	                case 3: // 
	                	System.out.print("Masukkan ID produk (angka): ");
	                    String newId = scanner.nextLine();
	                    System.out.print("Masukkan nama produk: ");
	                    String newName = scanner.nextLine();
	                    System.out.print("Masukkan harga produk: ");
	                    double newPrice = scanner.nextDouble();
	                    System.out.print("Masukkan jumlah produk: ");
	                    int newQuantity = scanner.nextInt();
	                    scanner.nextLine(); // consume newline

	                    Product newProduct = new Product(newId, newName, newPrice, newQuantity);
	                    facade.addProductToCatalogAndCart(newProduct);
	                    break;
	                case 4:
	                    System.out.println("Daftar produk tersedia:");
	                    facade.getProductCatalog().forEach((id, product) -> {
	                        System.out.println("ID: " + id + ", Nama: " + product.getName() + ", Harga: Rp" + product.getPrice());
	                    });
	                    break;

	                case 5:
	                    System.out.println("Isi keranjang:");
	                    facade.getCart().forEach(product -> product.displayProduct());
	                    break;

	                case 6:
	                    facade.placeOrder();
	                    break;

	                case 7:
	                    System.out.print("Masukkan metode pembayaran (misal: Transfer Bank, Cash): ");
	                    String method = scanner.nextLine();
	                    facade.selectPaymentMethod(method);
	                    break;

	                case 8:
	                    facade.pay();
	                    break;

	                case 9:
	                    running = false;
	                    System.out.println("Terima kasih telah menggunakan aplikasi.");
	                    break;

	                default:
	                    System.out.println("Pilihan tidak valid.");
	            }
	        }

	        scanner.close();
	    }
	}
