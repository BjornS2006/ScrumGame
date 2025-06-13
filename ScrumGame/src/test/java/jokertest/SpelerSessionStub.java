package jokertest;

import gamelogic.Speler;
import utils.SpelerSession;

public class SpelerSessionStub extends SpelerSession {
    private static Speler speler;

    public static void setSpeler(Speler s) {
        speler = s;
    }

    public static Speler getSpeler() {
        return speler;
    }
}