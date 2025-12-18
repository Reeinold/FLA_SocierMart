package commands;

import io.ConsoleIO;
import facade.ShoppingFacade;
import facade.OperationResult;

public class AddToCartCommand implements Command {
    private final ConsoleIO io;
    private final ShoppingFacade facade;

    public AddToCartCommand(ConsoleIO io, ShoppingFacade facade) {
        this.io = io;
        this.facade = facade;
    }

    @Override
    public void execute() {
        String id = io.readLine("Masukkan ID produk: ");
        var qtyOpt = io.readInt("Jumlah: ");
        if (qtyOpt.isEmpty()) {
            io.println("Input jumlah tidak valid.");
            return;
        }
        int qty = qtyOpt.get();
        OperationResult res = facade.addToCart(id, qty);
        io.println(res.getMessage());
    }
}
