package GameLogic;


import Utils.SaveSystem;
import Utils.SpelerInputHandler;
import Utils.SpelerSession;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Speler speler = SaveSystem.loadGame();
        SpelerSession.setSpeler(speler);
        System.out.println("Welkom bij de scrum escape room game!");
        System.out.println("In deze game moet je door verschillende kamers heen gaan om te ontsnappen.");
        System.out.println("In elk van deze kamers moeten een aantal vragen beantwoordt worden.");
        System.out.println("Elke kamer gaat over een ander onderwerp binnen scrum.");
        System.out.println("Als je een vraag fout beantwoordt krijg je een nieuwe uitdaging om de vraag te corrigeren.");
        System.out.println("Druk op enter om het spel te beginnen.");

        while (true) {
            String input = SpelerInputHandler.spelerAntwoord();

            switch (SpelerSession.getSpeler().getStatus().getPositie()) {
                case "Start", "De Sprint Planning":
                    Game.maakEersteKamerAan().speelKamer();
                    break;
                case "De Daily Scrum":
                    Game.maakTweedeKamerAan().speelKamer();
                    break;
                case "Het Scrum Board":
                    Game.maakDerdeKamerAan().speelKamer();
                    break;
                case "De Sprint Review":
                    Game.maakVierdeKamerAan().speelKamer();
                    break;
                case "De Finale":
                    Game.maakVijfdeKamerAan().speelKamer();
                    break;
                default:
                    // Optioneel: afhandeling voor onbekende posities
                    System.out.println("Onbekende positie.");
                    break;
            }


//                alles hier na wordt pass aan het einde van het spel laten zien
            }
        }
    }


