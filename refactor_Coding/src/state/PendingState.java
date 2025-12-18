package state;

import model.Order;
import model.OrderLine;

public class PendingState implements OrderState {
    private final Order order;
    public PendingState(Order order) { this.order = order; }

    @Override
    public void addItem(String productId, String name, int qty, double price) {
        order.addLineInternal(new OrderLine(productId, name, qty, price));
    }

    @Override
    public boolean removeItem(String productId) {
        return order.removeLineInternal(productId);
    }

    @Override
    public void checkout() {
        order.setState(new CheckedOutState(order));
    }

    @Override
    public void pay() {
        throw new IllegalStateException("Pembayaran belum dilakukan setelah checkout.");
    }

    @Override
    public void cancel() {
        order.setState(new CancelledState(order));
    }
}
