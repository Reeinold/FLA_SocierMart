package commands;

import io.ConsoleIO;
import facade.ShoppingFacade;
import facade.OperationResult;

public class CheckoutCommand implements Command {
    private final ConsoleIO io;
    private final ShoppingFacade facade;

    public CheckoutCommand(ConsoleIO io, ShoppingFacade facade) {
        this.io = io;
        this.facade = facade;
    }

    @Override
    public void execute() {
        OperationResult res = facade.checkout();
        io.println(res.getMessage());
    }
}
