package Joker;

import Kamers.Kamer;

public abstract class Joker {
    protected String naam;

    public Joker(String naam) {
        this.naam = naam;
    }
    public abstract void gebruikJoker(Kamer kamer);
}
