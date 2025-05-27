package GameLogic;

import Utils.SaveSystemInterface;
import Utils.SaveSystem;
import Utils.SpelerInputHandler;
import Utils.SpelerSession;
import GameLogic.GameRoute;

public class GameStarter {
    private final SaveSystemInterface saveSystem;

    public GameStarter() {
        this.saveSystem = new SaveSystem();
    }
    // Optionally, allow injection for testing
    public GameStarter(SaveSystemInterface saveSystem) {
        this.saveSystem = saveSystem;
    }
    public void printInstructies () {
        System.out.println("Welkom bij de scrum escape room game!");
        System.out.println("In deze game moet je door verschillende kamers heen gaan om te ontsnappen.");
        System.out.println("In elk van deze kamers moeten een aantal vragen beantwoordt worden.");
        System.out.println("Elke kamer gaat over een ander onderwerp binnen scrum.");
        System.out.println("Als je een vraag fout beantwoordt krijg je een nieuwe uitdaging om de vraag te corrigeren.");
        System.out.println("Druk op enter om het spel te beginnen.");
        SpelerInputHandler.spelerAntwoord();
    }
    public void startGame() {
        Speler speler = saveSystem.loadGame();
        if (speler != null && speler.getStatus() != null) {
            speler.getStatus().setSaveSystem(saveSystem);
        }
        SpelerSession.setSpeler(speler);
        GameRoute gameRoute = new GameRoute();
        gameRoute.locatie();
    }
}

