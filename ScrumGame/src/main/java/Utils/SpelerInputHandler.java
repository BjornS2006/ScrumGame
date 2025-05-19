package Utils;

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
}
