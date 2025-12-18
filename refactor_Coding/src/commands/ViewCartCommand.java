package commands;

import io.ConsoleIO;
import facade.ShoppingFacade;
import model.OrderLine;

import java.util.List;

public class ViewCartCommand implements Command {
    private final ConsoleIO io;
    private final ShoppingFacade facade;

    public ViewCartCommand(ConsoleIO io, ShoppingFacade facade) {
        this.io = io;
        this.facade = facade;
    }

    @Override
    public void execute() {
        List<OrderLine> lines = facade.listCart();
        if (lines.isEmpty()) {
            io.println("Keranjang kosong.");
            return;
        }
        io.println("Isi keranjang:");
        for (OrderLine l : lines) {
            io.println("  " + l.toString());
        }
    }
}
