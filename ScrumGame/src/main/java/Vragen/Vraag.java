package Vragen;

import GameLogic.Update;
import Monster.Monster;

import java.util.ArrayList;
import java.util.Scanner;

public class Vraag {
    private VraagControleStrategie controleStrategie;
    private VraagWeergaveStrategie weergaveStrategie;
    private ArrayList<Update> observers;
    private Monster monster;

    public Vraag (VraagWeergaveStrategie weergaveStrategie, VraagControleStrategie controleStrategie, Monster monster) {
        this.controleStrategie = controleStrategie;
        this.weergaveStrategie = weergaveStrategie;
        observers = new ArrayList<>();
        this.monster = monster;
    }
    public void stelVraag () {
        weergaveStrategie.toonVraag();
    }
    public void controleerAntwoord () {
        boolean goedOfFout = controleStrategie.checkGoedAntwoord();
        for (Update update : observers) {
            update.update(goedOfFout);
        }
    }

    public String getCorrecteAntwoord() {
        return controleStrategie.getCorrectAntwoord();
    }
}
