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
    public GameStarter(SaveSystemInterface saveSystem) {
        this.saveSystem = saveSystem;
    }
    public void printInstructies () {
        if (SpelerSession.getSpeler() == null) {
            Speler speler = saveSystem.loadGame();
            if (speler.getStatus() != null) {
                speler.getStatus().setSaveSystem(saveSystem);
            }
            SpelerSession.setSpeler(speler);
        }
        // Zorg dat de speler geen jokers heeft voordat er een gekozen wordt
        SpelerSession.getSpeler().getItems().removeIf(item -> item instanceof Joker.HintJoker || item instanceof Joker.KeyJoker);
        System.out.println("Welkom bij de scrum escape room game!");
        System.out.println("In deze game moet je door verschillende kamers heen gaan om te ontsnappen.");
        System.out.println("In elk van deze kamers moeten een aantal vragen beantwoordt worden.");
        System.out.println("Elke kamer gaat over een ander onderwerp binnen scrum.");
        System.out.println("Als je een vraag fout beantwoordt krijg je een nieuwe uitdaging om de vraag te corrigeren.");
        System.out.println("Kies aan het begin van het spel één joker:");
        System.out.println("1. HintJoker (in alle kamers een hint)");
        System.out.println("2. KeyJoker (alleen inzetbaar in Daily Scrum en Review)");
        System.out.print("Typ 1 of 2 en druk op enter: ");
        String keuze = SpelerInputHandler.spelerAntwoord();
        if (keuze.trim().equals("1")) {
            SpelerSession.getSpeler().addItem(new Joker.HintJoker());
            System.out.println("Je hebt gekozen voor de HintJoker!");
        } else if (keuze.trim().equals("2")) {
            SpelerSession.getSpeler().addItem(new Joker.KeyJoker());
            System.out.println("Je hebt gekozen voor de KeyJoker!");
        } else {
            System.out.println("Ongeldige keuze. Je krijgt standaard de HintJoker.");
            SpelerSession.getSpeler().addItem(new Joker.HintJoker());
        }
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

