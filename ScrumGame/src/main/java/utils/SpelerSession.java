package utils;

import gamelogic.Speler;

public class SpelerSession {
    private static Speler speler;

    public static Speler getSpeler () {
        return speler;
    }
    public static void setSpeler (Speler speler) {
        SpelerSession.speler = speler;
    }
    public static void clear () {
        speler = null;
    }
}
