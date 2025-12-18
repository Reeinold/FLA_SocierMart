package app;

import controller.MenuController;
import facade.ShoppingFacade;
import io.ConsoleIO;

public class Main {
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        ShoppingFacade facade = ShoppingFacade.getInstance();

        // Seed some products
        facade.refillProduct("P1", "Pensil", 2000.0, 10);
        facade.refillProduct("P2", "Buku Tulis", 5000.0, 5);
        facade.refillProduct("P3", "Penghapus", 1500.0, 20);

        MenuController controller = new MenuController(io, facade);
        controller.loop();
    }
}
