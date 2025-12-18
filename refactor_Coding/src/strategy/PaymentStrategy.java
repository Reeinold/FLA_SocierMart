package strategy;

import facade.OperationResult;
import model.Order;

public interface PaymentStrategy {
    OperationResult pay(Order order);
}
