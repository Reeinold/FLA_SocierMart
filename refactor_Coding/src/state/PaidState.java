package state;

import model.Order;

public class PaidState implements OrderState {
    private final Order order;
    public PaidState(Order order) { this.order = order; }

    @Override
    public void addItem(String productId, String name, int qty, double price) {
        throw new IllegalStateException("Tidak bisa menambahkan item setelah dibayar.");
    }

    @Override
    public boolean removeItem(String productId) {
        throw new IllegalStateException("Tidak bisa menghapus item setelah dibayar.");
    }

    @Override
    public void checkout() {
        throw new IllegalStateException("Sudah dibayar.");
    }

    @Override
    public void pay() {
        throw new IllegalStateException("Sudah dibayar.");
    }

    @Override
    public void cancel() {
        throw new IllegalStateException("Tidak bisa membatalkan setelah dibayar.");
    }
}
