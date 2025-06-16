package gamelogic;

import utils.SaveSystemInterface;
import utils.SaveSystem;
import utils.SpelerInputHandler;
import utils.SpelerSession;

public class GameStarter {
    private SaveSystemInterface saveSystem;

    public GameStarter() {
        this.saveSystem = new SaveSystem();
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
        SpelerSession.getSpeler().getItems().removeIf(item -> item instanceof joker.HintJoker || item instanceof joker.KeyJoker);
        System.out.println("Welkom bij de scrum escape room game!");
        System.out.println("In deze game moet je door verschillende kamers heen gaan om te ontsnappen.");
        System.out.println("In elk van deze kamers moeten een aantal vragen beantwoordt worden.");
        System.out.println("Elke kamer gaat over een ander onderwerp binnen scrum.");
        System.out.println("Als je een vraag fout beantwoordt krijg je aan het einde van de kamer een nieuwe uitdaging om de vraag te corrigeren.");
        System.out.println("Elke kamer krijg je een item dat je kan gebruiken om je te helpen in het spel.");
        System.out.println("Typ om een item te gebruiken de naam van die item. Hoofdletters maken niet uit, spelling wel.");
        System.out.println("Om te zien welke items je hebt, in welke kamer je bent en wat je score is, typ 'status'.");
        if (!SpelerSession.getSpeler().isJokerReceived()) {
            System.out.println("Kies aan het begin van het spel één joker:");
            System.out.println("1. HintJoker (in alle kamers een hint)");
            System.out.println("2. KeyJoker (alleen inzetbaar in Daily Scrum en Review)");
            System.out.print("Typ 1 of 2 en druk op enter: ");
            String keuze = SpelerInputHandler.spelerAntwoord();
            if (keuze.trim().equals("1")) {
                SpelerSession.getSpeler().addItem(new joker.HintJoker());
                System.out.println("Je hebt gekozen voor de HintJoker!");
                SpelerSession.getSpeler().setJokerReceived(true);
            } else if (keuze.trim().equals("2")) {
                SpelerSession.getSpeler().addItem(new joker.KeyJoker());
                System.out.println("Je hebt gekozen voor de KeyJoker!");
                SpelerSession.getSpeler().setJokerReceived(true);
            } else {
                System.out.println("Ongeldige keuze. Je krijgt standaard de HintJoker.");
                SpelerSession.getSpeler().addItem(new joker.HintJoker());
                SpelerSession.getSpeler().setJokerReceived(true);
            }
        }
        System.out.println("Druk op enter om het spel te beginnen.");
        SpelerInputHandler.spelerAntwoord();
    }
    public void startGame() {
        GameRoute.locatie();
    }
}

