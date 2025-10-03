package State;

public interface CartStatus {
	void proceed(ShoppingCartContext context);
    String getStateName();

}
