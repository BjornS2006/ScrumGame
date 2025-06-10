package utils;

import hintsysteem.HintPresenter;
import usableitems.IUsableItem;

import java.util.Scanner;

import static joker.JokerHandler.handleJokerUsage;

public class SpelerInputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static String spelerAntwoord() {
        String spelerAntwoord = "";
        do {
            spelerAntwoord = scanner.nextLine();
            IUsableItem itemToRemove = null;
            for (IUsableItem item : SpelerSession.getSpeler().getItems()) {
                if (spelerAntwoord.equalsIgnoreCase(item.getName())) {
                    itemToRemove = item;
                    if (spelerAntwoord.equalsIgnoreCase("zwaard")) {
                        System.out.println("Je kan het zwaard alleen gebruiken als je een monster bent tegengekomen.");
                        break;
                    } else {
                        item.gebruik();
                        continue;
                    }
                }
            }
            if (itemToRemove != null) {
                SpelerSession.getSpeler().getItems().remove(itemToRemove);
            }

            if (spelerAntwoord.equalsIgnoreCase("hint")) {
                HintPresenter hintPresenter = new HintPresenter(SpelerSession.getSpeler().getStatus().getHuidigeVraag());
                hintPresenter.presentHint();
            }
            if (spelerAntwoord.equalsIgnoreCase("status")) {
                System.out.println(SpelerSession.getSpeler().toString());
                spelerAntwoord = scanner.nextLine();
            }
        } while (
                spelerAntwoord.equalsIgnoreCase("status") ||
                        spelerAntwoord.equalsIgnoreCase("hint") ||
                        spelerAntwoord.equalsIgnoreCase("infoboek") ||
                        spelerAntwoord.equalsIgnoreCase("zwaard") ||
                        spelerAntwoord.equalsIgnoreCase("assistent") ||
                        spelerAntwoord.equalsIgnoreCase("komkommer") ||
                        spelerAntwoord.equalsIgnoreCase("hintjoker") ||
                        spelerAntwoord.equalsIgnoreCase("keyjoker") ||
                        isUsableItemInput(spelerAntwoord)
        );

        return spelerAntwoord;
    }

    private static boolean isUsableItemInput(String input) {
        for (IUsableItem item : SpelerSession.getSpeler().getItems()) {
            if (input.equalsIgnoreCase(item.getName())) {
                return true;
            }
        }
        return false;
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
