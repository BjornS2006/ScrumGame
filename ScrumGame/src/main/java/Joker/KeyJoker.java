package Joker;

import Kamers.DeDailyScrum;
import Kamers.DeSprintReview;
import Kamers.Kamer;
import UsableItems.I_UsebleItem;

public class KeyJoker extends JokerBase implements I_UsebleItem {
    @Override
    public String getName() {
        return "KeyJoker";
    }

    @Override
    public String getDescription() {
        return "Gebruik deze joker om een kamer over te slaan in de Daily Scrum of Sprint Review kamer. Slechts één keer te gebruiken.";
    }

    @Override
    public void gebruik() {
        // Gebruik zonder kamercontext doet niets
    }

    /**
     * Kan alleen gebruikt worden in KeyJokerUsable kamers (DeDailyScrum, DeSprintReview).
     * Skipt de kamer en markeert zichzelf als gebruikt.
     */
    public void useIn(Kamer kamer) {
        if (isUsed()) {
            System.out.println("Je hebt de KeyJoker al gebruikt.");
            return;
        }
        if (kamer instanceof KeyJokerUsable usableRoom) {
            usableRoom.skipRoom();
            markUsed();
        } else {
            System.out.println("De KeyJoker kan alleen gebruikt worden in de Daily Scrum of Sprint Review kamer.");
        }
    }
}
