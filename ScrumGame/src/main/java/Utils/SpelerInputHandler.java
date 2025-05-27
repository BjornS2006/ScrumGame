package Utils;

import GameLogic.GameStarter;
import GameLogic.Main;

import java.util.Scanner;

public class SpelerInputHandler {
    private static final Scanner scanner = new Scanner(System.in);
    public static String spelerAntwoord () {
        String spelerAntwoord = scanner.nextLine();
        while (spelerAntwoord.equalsIgnoreCase("status")) {
            System.out.println(SpelerSession.getSpeler().getStatus());
            spelerAntwoord = scanner.nextLine();
        }
        return spelerAntwoord;
    }
    public static void eindeSpel() {
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("exit")) {
            System.exit(0);
        } else if (input.equalsIgnoreCase("restart")) {
            return;
        } else {
            System.out.println("Ongeldige invoer. Typ 'exit' om het spel te beëindigen of 'restart' om opnieuw te beginnen.");
            eindeSpel();
        }
    }
}
