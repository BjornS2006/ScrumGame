package joker;

import kamers.Kamer;
import usableitems.IUsebleItem;

public class KeyJoker extends JokerBase implements IUsebleItem {
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
        if (kamer instanceof IKeyJoker usableRoom) {
            usableRoom.skipRoom();
            markUsed();
        } else {
            System.out.println("De KeyJoker kan alleen gebruikt worden in de Daily Scrum of Sprint Review kamer.");
        }
    }
}
