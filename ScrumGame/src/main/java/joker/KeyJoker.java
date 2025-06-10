// src/main/java/joker/KeyJoker.java
package joker;

import kamers.Kamer;

public class KeyJoker extends JokerBase {
    @Override
    public String getName() {
        return "KeyJoker";
    }

    @Override
    public String getDescription() {
        return "Gebruik deze joker om een kamer over te slaan in de Daily Scrum of Sprint Review kamer. Slechts één keer te gebruiken.";
    }

    @Override
    protected boolean canUseIn(Kamer kamer) {
        return kamer instanceof IKeyJoker;
    }

    @Override
    protected String getUsageRestrictionMessage() {
        return "De KeyJoker kan alleen gebruikt worden in de Daily Scrum of Sprint Review kamer.";
    }

    @Override
    protected void doUseIn(Kamer kamer) {
        ((IKeyJoker) kamer).skipRoom();
    }
}