package GameLogic;

import Utils.SaveSystem;
import Utils.SpelerInputHandler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Speler speler = SaveSystem.loadGame();
        System.out.println("Welkom bij de scrum escape room game!");
        System.out.println("In deze game moet je door verschillende kamers heen gaan om te ontsnappen.");
        System.out.println("In elk van deze kamers moeten een aantal vragen beantwoordt worden.");
        System.out.println("Elke kamer gaat over een ander onderwerp binnen scrum.");
        System.out.println("Als je een vraag fout beantwoordt krijg je een nieuwe uitdaging om de vraag te corrigeren.");
        System.out.println("Druk op enter om het spel te beginnen.");

        while (true) {
            String input = SpelerInputHandler.spelerAntwoord();
            if (input.isEmpty()) {
                Game.maakEersteKamerAan().speelKamer(scanner);
            }
        }
    }
}

