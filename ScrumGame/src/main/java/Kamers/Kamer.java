package Kamers;

import HintSysteem.FunnyHintProvider;
import UsableItems.UsableItem;

import java.util.Scanner;
import java.util.ArrayList;

public abstract class Kamer {
    protected String naam;
    protected KamerVraagManager vraagManager;
    protected KamerVraagPresenter vraagPresenter;
    protected UsableItem item;

    public Kamer(String name, UsableItem item) {
        this.naam = name;
        this.item = item;
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
