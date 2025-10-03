package Command;
import Singleton.ShoppingCart;
import Model.Product;
public class AddItem implements command{
	 private ShoppingCart cart;
	    private Product product;

	    public AddItem(ShoppingCart cart, Product product) {
	        this.cart = cart;
	        this.product = product;
	    }

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		cart.addItem(product);
		
	}

}
