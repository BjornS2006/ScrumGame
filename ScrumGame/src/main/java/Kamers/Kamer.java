package Kamers;

import java.util.Scanner;

public abstract class Kamer {
    protected String naam;
    protected KamerVraagManager vraagManager;
    protected KamerVraagPresenter vraagPresenter;

    public Kamer(String name) {
        this.naam = name;
    }

    public void speelKamer() {
        enter();
        stelVraag();
        naarVolgendeKamer();
    }

    public abstract void enter ();
    public abstract void stelVraag();
    public abstract void naarVolgendeKamer();
}
