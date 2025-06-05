<<<<<<< HEAD:ScrumGame/src/main/java/Utils/SpelerInputHandler.java
package Utils;

import UsableItems.I_UsableItem;
=======
package utils;
>>>>>>> Jokertest:ScrumGame/src/main/java/utils/SpelerInputHandler.java

import usableitems.IUsebleItem;
import java.util.Scanner;

public class SpelerInputHandler {

    private static final Scanner scanner = new Scanner(System.in);
    public static String spelerAntwoord () {
        String spelerAntwoord = scanner.nextLine();
        while (spelerAntwoord.equalsIgnoreCase("status")) {
            System.out.println(SpelerSession.getSpeler().getStatus());
            spelerAntwoord = scanner.nextLine();
        }
<<<<<<< HEAD:ScrumGame/src/main/java/Utils/SpelerInputHandler.java
        for (I_UsableItem item : SpelerSession.getSpeler().getItems()) {
=======
        for (IUsebleItem item : SpelerSession.getSpeler().getItems()) {
>>>>>>> Jokertest:ScrumGame/src/main/java/utils/SpelerInputHandler.java
            if (spelerAntwoord.equalsIgnoreCase(item.getName())) {
                item.gebruik();
                SpelerSession.getSpeler().removeItem(item.getName());
                break;
            }
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
