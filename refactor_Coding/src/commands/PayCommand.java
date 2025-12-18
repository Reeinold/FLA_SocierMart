package commands;

import io.ConsoleIO;
import facade.ShoppingFacade;
import facade.OperationResult;
import strategy.CashPaymentStrategy;
import strategy.PaymentStrategy;

public class PayCommand implements Command {
    private final ConsoleIO io;
    private final ShoppingFacade facade;

    public PayCommand(ConsoleIO io, ShoppingFacade facade) {
        this.io = io;
        this.facade = facade;
    }

    @Override
    public void execute() {
        io.println("Pilih metode pembayaran:");
        io.println("  1) Tunai");
        String choice = io.readLine("Pilihan: ");
        PaymentStrategy strategy;
        if ("1".equals(choice)) {
            strategy = new CashPaymentStrategy();
        } else {
            io.println("Metode tidak dikenal. Gunakan tunai sebagai default.");
            strategy = new CashPaymentStrategy();
        }
        OperationResult res = facade.pay(strategy);
        io.println(res.getMessage());
    }
}
