package Joker;

import Kamers.Kamer;
import UsableItems.I_UsebleItem;

public class HintJoker extends JokerBase implements I_UsebleItem {
    @Override
    public String getName() {
        return "HintJoker";
    }

    @Override
    public String getDescription() {
        return "Gebruik deze joker om een hint te krijgen in elke kamer.";
    }

    @Override
    public void gebruik() {
        // Gebruik zonder kamercontext doet niets
    }

    public void useIn(Kamer kamer) {
        if (!isUsed()) {
            kamer.showJokerHint();
            markUsed();
        } else {
            System.out.println("Je hebt de HintJoker al gebruikt.");
        }
    }
}
