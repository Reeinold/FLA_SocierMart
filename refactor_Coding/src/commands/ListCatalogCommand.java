package commands;

import io.ConsoleIO;
import facade.ShoppingFacade;
import model.Product;

import java.util.Map;

public class ListCatalogCommand implements Command {
    private final ConsoleIO io;
    private final ShoppingFacade facade;

    public ListCatalogCommand(ConsoleIO io, ShoppingFacade facade) {
        this.io = io;
        this.facade = facade;
    }

    @Override
    public void execute() {
        Map<String, Product> catalog = facade.listCatalog();
        if (catalog.isEmpty()) {
            io.println("Katalog kosong.");
            return;
        }
        io.println("Katalog produk:");
        for (Product p : catalog.values()) {
            io.println("  " + p.toString());
        }
    }
}
