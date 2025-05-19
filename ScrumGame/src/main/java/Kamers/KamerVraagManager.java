package Kamers;

import GameLogic.Game;
import Vragen.Vraag;
import java.util.ArrayList;

public class KamerVraagManager {
    private ArrayList<Vraag> vragen;

    public KamerVraagManager() {
        vragen = new ArrayList<>();
    }

    public void addVraag(Vraag vraag) {
        vragen.add(vraag);
    }

    public ArrayList<Vraag> getVragen() {
        return vragen;
    }
}

