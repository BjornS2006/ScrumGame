package Kamers;

import HintSysteem.FunnyHintProvider;

import java.util.Scanner;
import java.util.ArrayList;

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
