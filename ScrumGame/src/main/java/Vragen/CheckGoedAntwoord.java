package Vragen;

import java.util.Scanner;

public class CheckGoedAntwoord {


    public static void controleerMeerkeuze(MeerkeuzeVraag vraag, Scanner scanner) {
        String correcteLetter = vraag.getCorrecteAntwoordLetter();
        String input = scanner.nextLine().toUpperCase();

        if (input.equals(correcteLetter)) {
            System.out.println("Goed!");
        } else {
            vraag.getMonster().monsterVerschijnt();
            vraag.getMonster().monsterChallenge();
        }
    }

    static void controleerOpen(OpenVraag vraag, Scanner scanner) {
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase(vraag.getAntwoord())) {
            System.out.println("Vraag goed!");
        } else {
            vraag.getMonster().monsterVerschijnt();
            vraag.getMonster().monsterChallenge();
        }
    }

}
