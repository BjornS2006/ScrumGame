package GameLogic;

import Utils.SaveSystem;
import Utils.SpelerSession;
import GameLogic.GameRoute;


public class GameStarter {
    public void printInstructies () {
        System.out.println("Welkom bij de scrum escape room game!");
        System.out.println("In deze game moet je door verschillende kamers heen gaan om te ontsnappen.");
        System.out.println("In elk van deze kamers moeten een aantal vragen beantwoordt worden.");
        System.out.println("Elke kamer gaat over een ander onderwerp binnen scrum.");
        System.out.println("Als je een vraag fout beantwoordt krijg je een nieuwe uitdaging om de vraag te corrigeren.");
        System.out.println("Druk op enter om het spel te beginnen.");
        startGame();
    }
    public void startGame() {
        Speler speler = SaveSystem.loadGame();
        SpelerSession.setSpeler(speler);
        GameRoute gameRoute = new GameRoute();
        gameRoute.locatie();
    }
}


