package controller;

import io.ConsoleIO;
import facade.ShoppingFacade;
import commands.*;

import java.util.HashMap;
import java.util.Map;

public class MenuController {
    private final ConsoleIO io;
    private final ShoppingFacade facade;
    private final Map<String, Command> commands = new HashMap<>();

    public MenuController(ConsoleIO io, ShoppingFacade facade) {
        this.io = io;
        this.facade = facade;
        registerCommands();
    }

    private void registerCommands() {
        commands.put("1", new AddToCartCommand(io, facade));
        commands.put("2", new RemoveFromCartCommand(io, facade));
        commands.put("3", new ListCatalogCommand(io, facade));
        commands.put("4", new ViewCartCommand(io, facade));
        commands.put("5", new CheckoutCommand(io, facade));
        commands.put("6", new PayCommand(io, facade));
    }

    public void loop() {
        boolean running = true;
        while (running) {
            io.println("\n=== SocierMart (Refactor) ===");
            io.println("1) Tambah ke keranjang");
            io.println("2) Hapus dari keranjang");
            io.println("3) List katalog");
            io.println("4) Lihat keranjang");
            io.println("5) Checkout");
            io.println("6) Bayar");
            io.println("9) Keluar");
            String choice = io.readLine("Pilih: ");
            if ("9".equals(choice)) {
                running = false;
                io.println("Terima kasih. Keluar...");
            } else {
                Command cmd = commands.get(choice);
                if (cmd != null) {
                    try {
                        cmd.execute();
                    } catch (Exception e) {
                        io.println("Terjadi error: " + e.getMessage());
                    }
                } else {
                    io.println("Pilihan tidak valid.");
                }
            }
        }
    }
}
