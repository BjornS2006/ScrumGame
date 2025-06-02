package Joker;

import Kamers.Kamer;

public class KeyJoker extends Joker {
    public KeyJoker() {
        super("KeyJoker");
    }
    @Override
    public void gebruikJoker(Kamer kamer) {
        kamer.geefSleutel();
    }
}
