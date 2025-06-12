package vragen;

import gamelogic.Subject;
import gamelogic.Update;
import hintsysteem.HelpHintProvider;
import monster.Monster;
import utils.SpelerSession;

import java.util.ArrayList;

public class Vraag implements Subject {
    private VraagControleStrategie controleStrategie;
    private VraagWeergaveStrategie weergaveStrategie;
    private ArrayList<Update> observers;
    private HelpHintProvider hint;

    public Vraag (VraagWeergaveStrategie weergaveStrategie, VraagControleStrategie controleStrategie, Monster monster, HelpHintProvider hint) {
        this.controleStrategie = controleStrategie;
        this.weergaveStrategie = weergaveStrategie;
        observers = new ArrayList<>();
        this.hint = hint;
    }
    public void stelVraag () {
        weergaveStrategie.toonVraag();
    }

    public boolean controleerAntwoord() {
        boolean foutOfGoed = controleStrategie.checkGoedAntwoord();
        if (!foutOfGoed) {
            SpelerSession.getSpeler().addFout();
        }
        return foutOfGoed;
    }

    // Overload for answer checking with input
    public boolean controleerAntwoord(String antwoord) {
        if (antwoord == null) return false;
        String gegeven = antwoord.trim().toLowerCase();
        String correct = controleStrategie.getCorrectAntwoord().trim().toLowerCase();
        return gegeven.equals(correct);
    }

    public String getCorrecteAntwoord() {
        return controleStrategie.getCorrectAntwoord();
    }

    public HelpHintProvider getHint() {
        return hint;
    }

    public void stuurUpdateVoorAntwoord(boolean goedOfFout) {
        stuurUpdate(goedOfFout);
    }


    @Override
    public void stuurUpdate(Boolean goedOfFout) {
        for (Update update : observers) {
            update.update(goedOfFout);
        }
    }
    public void addObserver(Update observer) {
        observers.add(observer);
    }
}
