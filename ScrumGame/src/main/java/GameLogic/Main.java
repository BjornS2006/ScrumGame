package GameLogic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Speler speler = new Speler();
        Game.maakEersteKamerAan().speelKamer(scanner);
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("status")) {
                speler.getStatus();
            }
        }
    }
}

