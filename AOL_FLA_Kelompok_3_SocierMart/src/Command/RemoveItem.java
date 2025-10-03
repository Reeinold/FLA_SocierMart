package Command;
import Model.Product;
import Singleton.ShoppingCart;
public class RemoveItem implements command{
	private ShoppingCart cart;
    private Product product;

    public RemoveItem(ShoppingCart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		cart.removeItem(product);
		
	}

}
