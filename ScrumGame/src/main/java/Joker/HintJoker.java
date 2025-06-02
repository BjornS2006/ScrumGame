package Joker;

import Kamers.Kamer;

public class HintJoker extends Joker {
    public HintJoker() {
        super("HintJoker");
    }
    @Override
    public void gebruikJoker(Kamer kamer) {
        System.out.println("Je hebt een hint ontvangen in kamer: " + kamer.getNaam());
    }
}
