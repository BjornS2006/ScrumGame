package Vragen;

import GameLogic.Subject;
import GameLogic.Update;

import java.util.ArrayList;
import java.util.Scanner;

public class Vraag {
    private VraagControleStrategie controleStrategie;
    private VraagWeergaveStrategie weergaveStrategie;
    private ArrayList<Update> observers;

    public Vraag (VraagWeergaveStrategie weergaveStrategie, VraagControleStrategie controleStrategie) {
        this.controleStrategie = controleStrategie;
        this.weergaveStrategie = weergaveStrategie;
    }
    public void stelVraag () {
        weergaveStrategie.toonVraag();
    }
    public void controleerAntwoord (Scanner scanner) {
        if (controleStrategie.checkGoedAntwoord(scanner)) {
            //code voor score ophogen
        }
        else {
            //code voor monster challenge starten
        }
    }

    public String getCorrecteAntwoord() {
        return controleStrategie.getCorrectAntwoord();
    }
}
