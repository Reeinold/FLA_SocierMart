package state;

import model.Order;

public class CancelledState implements OrderState {
    private final Order order;
    public CancelledState(Order order) { this.order = order; }

    @Override
    public void addItem(String productId, String name, int qty, double price) {
        throw new IllegalStateException("Pesanan dibatalkan, tidak bisa tambah item.");
    }

    @Override
    public boolean removeItem(String productId) {
        throw new IllegalStateException("Pesanan dibatalkan.");
    }

    @Override
    public void checkout() {
        throw new IllegalStateException("Pesanan dibatalkan.");
    }

    @Override
    public void pay() {
        throw new IllegalStateException("Pesanan dibatalkan.");
    }

    @Override
    public void cancel() {
        // already cancelled
    }
}
