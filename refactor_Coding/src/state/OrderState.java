package state;

import facade.OperationResult;

public interface OrderState {
    void addItem(String productId, String name, int qty, double price);
    boolean removeItem(String productId);
    void checkout();
    void pay();
    void cancel();
}
