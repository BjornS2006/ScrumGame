package joker;

import kamers.Kamer;
import usableitems.IUsableItem;

public class KeyJoker extends JokerBase implements IUsableItem {
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
    }

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
