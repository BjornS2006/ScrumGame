package Kamers;

import GameLogic.Update;
import Monster.Monster;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Kamer {
    protected String naam;
    protected Monster monster;
    protected KamerVraagManager vraagManager;
    protected KamerVraagPresenter vraagPresenter;

    public Kamer(String name) {
        this.naam = name;
    }

    public void speelKamer(Scanner scanner) {
        enter();
        stelVraag(scanner);
        naarVolgendeKamer(scanner);
    }

    public abstract void enter ();
    public abstract void stelVraag(Scanner scanner);
    public abstract void naarVolgendeKamer(Scanner scanner);
}
