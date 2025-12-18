package io;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleIO {
    private final Scanner scanner = new Scanner(System.in);

    public String readLine(String prompt) {
        System.out.print(prompt);
        System.out.flush();
        return scanner.nextLine().trim();
    }

    public Optional<Integer> readInt(String prompt) {
        String line = readLine(prompt);
        try {
            return Optional.of(Integer.parseInt(line));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public Optional<Double> readDouble(String prompt) {
        String line = readLine(prompt);
        try {
            return Optional.of(Double.parseDouble(line));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public void println(String s) { System.out.println(s); System.out.flush(); }
}