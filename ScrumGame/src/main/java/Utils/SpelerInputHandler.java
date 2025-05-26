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
    public static void eindeSpel () {
        if (scanner.nextLine().equalsIgnoreCase("exit")) {
            System.exit(0);
        }
//        } else if (scanner.nextLine().equalsIgnoreCase("restart")) {
//            Main.main(new String[0]);
//        }
    }
}
