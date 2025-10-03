package State;

public class ShoppingCartContext {
	 private CartStatus state;

	    public ShoppingCartContext() {
	        state = new EmptyCart();
	    }

	    public void setState(CartStatus state) {
	        this.state = state;
	    }

	    public void proceed() {
	        state.proceed(this);
	    }

	    public String getStateName() {
	        return state.getStateName();
	    }

}
