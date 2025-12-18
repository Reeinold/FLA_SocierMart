package model;

import state.OrderState;
import state.PendingState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Order {
    private OrderState state;
    private final List<OrderLine> lines = new ArrayList<>();

    public Order() {
        this.state = new PendingState(this);
    }

    public void setState(OrderState s) { this.state = s; }
    public OrderState getState() { return state; }

    public void addItem(String productId, String name, int qty, double price) {
        state.addItem(productId, name, qty, price);
    }

    public boolean removeItem(String productId) {
        return state.removeItem(productId);
    }

    public List<OrderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    // package-private helpers used by states
    public void addLineInternal(OrderLine line) { lines.add(line); }

    public boolean removeLineInternal(String productId) {
        Iterator<OrderLine> it = lines.iterator();
        boolean removed = false;
        while (it.hasNext()) {
            OrderLine l = it.next();
            if (l.getProductId().equals(productId)) {
                it.remove();
                removed = true;
            }
        }
        return removed;
    }

    public void checkout() { state.checkout(); }
    public void pay() { state.pay(); }
}