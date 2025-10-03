package State;

public class EmptyCart implements CartStatus{

	@Override
	public void proceed(ShoppingCartContext context) {
		// TODO Auto-generated method stub
		System.out.println("Keranjang Kosong. Tolong tambahkan barang untuk melanjutkan Transaksi.");
		
	}

	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "Kosong!";
	}

}
