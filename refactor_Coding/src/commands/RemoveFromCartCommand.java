package commands;

import io.ConsoleIO;
import facade.ShoppingFacade;
import facade.OperationResult;

public class RemoveFromCartCommand implements Command {
    private final ConsoleIO io;
    private final ShoppingFacade facade;

    public RemoveFromCartCommand(ConsoleIO io, ShoppingFacade facade) {
        this.io = io;
        this.facade = facade;
    }

    @Override
    public void execute() {
        String id = io.readLine("Masukkan ID produk yang akan dihapus dari keranjang: ");
        OperationResult res = facade.removeFromCart(id);
        io.println(res.getMessage());
    }
}
