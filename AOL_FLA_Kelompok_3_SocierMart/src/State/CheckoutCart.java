package State;

public class CheckoutCart implements CartStatus{

	@Override
	public void proceed(ShoppingCartContext context) {
		// TODO Auto-generated method stub
		System.out.println("Checkout Berhasil");
		
	}

	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "CheckedOut";
	}

}
