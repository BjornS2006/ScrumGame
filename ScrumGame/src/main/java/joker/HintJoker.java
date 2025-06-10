// src/main/java/joker/HintJoker.java
package joker;

import kamers.Kamer;

public class HintJoker extends JokerBase {
    @Override
    public String getName() {
        return "HintJoker";
    }

    @Override
    public String getDescription() {
        return "Gebruik deze joker om een hint te krijgen in elke kamer.";
    }

    @Override
    protected void doUseIn(Kamer kamer) {
        kamer.showJokerHint();
    }
}