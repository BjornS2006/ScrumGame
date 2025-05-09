package Kamers;

import GameLogic.VraagType;


import java.util.ArrayList;
import java.util.Scanner;

public abstract class Kamer {
    protected String naam;
    protected ArrayList<VraagType> vragen;

    public Kamer(String name) {
        this.naam = name;
    }

    public void speelKamer(Scanner scanner) {
        enter();
        stelVraag();
        vraagAntwoord(scanner);
        naarVolgendeKamer();
    }

    public abstract void enter ();
    public abstract void stelVraag();
    public abstract void vraagAntwoord(Scanner scanner);
    public abstract void naarVolgendeKamer();
}
