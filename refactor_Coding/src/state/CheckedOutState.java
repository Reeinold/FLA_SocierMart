package state;

import model.Order;

public class CheckedOutState implements OrderState {
    private final Order order;
    public CheckedOutState(Order order) { this.order = order; }

    @Override
    public void addItem(String productId, String name, int qty, double price) {
        throw new IllegalStateException("Tidak bisa menambahkan item setelah checkout.");
    }

    @Override
    public boolean removeItem(String productId) {
        throw new IllegalStateException("Tidak bisa menghapus item setelah checkout.");
    }

    @Override
    public void checkout() {
        throw new IllegalStateException("Sudah melakukan checkout.");
    }

    @Override
    public void pay() {
        order.setState(new PaidState(order));
    }

    @Override
    public void cancel() {
        order.setState(new CancelledState(order));
    }
}
