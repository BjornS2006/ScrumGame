package Kamers;

import GameLogic.Game;
import Vragen.VraagType;
import java.util.ArrayList;

public class KamerVraagManager {
    private ArrayList<VraagType> vragen;

    public KamerVraagManager() {
        vragen = new ArrayList<>();
    }

    public void addVraag(VraagType vraag) {
        vragen.add(vraag);
    }

    public ArrayList<VraagType> getVragen() {
        return vragen;
    }
}

