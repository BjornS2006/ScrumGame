package Kamers;

import HintSysteem.FunnyHintProvider;
import Joker.Joker;

import java.util.Scanner;
import java.util.ArrayList;

public abstract class Kamer {
    protected String naam;
    protected KamerVraagManager vraagManager;
    protected KamerVraagPresenter vraagPresenter;
    protected Joker joker;

    public Kamer(String name, Joker joker) {
        this.naam = name;
        this.joker = joker;
    }

    public void speelKamer() {
        enter();
        stelVraag();
        gebruikJoker();
        naarVolgendeKamer();
    }

    public void gebruikJoker() {
        joker.gebruikJoker(this);
    }

    public String getNaam() {
        return naam;
    }

    public abstract void enter ();
    public abstract void stelVraag();
    public abstract void naarVolgendeKamer();
    public abstract void geefSleutel();
}
