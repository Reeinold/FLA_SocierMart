package State;

public class FilledCart implements CartStatus{

	@Override
	public void proceed(ShoppingCartContext context) {
		// TODO Auto-generated method stub
		System.out.println("Keranjang Terdapat Barang. Siap untuk melanjutkan Transaksi");
		
	}

	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "Terisi";
	}

}
