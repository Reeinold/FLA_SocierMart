package strategy;

import facade.OperationResult;
import model.Order;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public OperationResult pay(Order order) {
        // For demo, always succeed
        return OperationResult.success("Pembayaran tunai berhasil.");
    }
}
