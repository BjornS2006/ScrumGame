package Kamers;

import GameLogic.Vraag;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Kamer {
    protected String naam;
    protected ArrayList<Vraag> vragen;

    public Kamer(String name) {
        this.naam = name;
    }

    public abstract void enter (Scanner scanner);




}
