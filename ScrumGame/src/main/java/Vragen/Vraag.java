package Vragen;

import GameLogic.Subject;
import GameLogic.Update;
import HintSysteem.FunnyHintProvider;
import HintSysteem.HelpHintProvider;
import HintSysteem.HintProvider;
import Monster.Monster;

import java.util.ArrayList;

public class Vraag implements Subject {
    private VraagControleStrategie controleStrategie;
    private VraagWeergaveStrategie weergaveStrategie;
    private ArrayList<Update> observers;
    private HelpHintProvider hint;
    private Monster monster;

    public Vraag (VraagWeergaveStrategie weergaveStrategie, VraagControleStrategie controleStrategie, Monster monster, HelpHintProvider hint) {
        this.controleStrategie = controleStrategie;
        this.weergaveStrategie = weergaveStrategie;
        observers = new ArrayList<>();
        this.monster = monster;
        this.hint = hint;
    }
    public void stelVraag () {
        weergaveStrategie.toonVraag();
    }

    public boolean controleerAntwoord () {
        boolean goedOfFout = controleStrategie.checkGoedAntwoord();
        stuurUpdate(goedOfFout);
        return goedOfFout;
    }

    public String getCorrecteAntwoord() {
        return controleStrategie.getCorrectAntwoord();
    }

    public HelpHintProvider getHint() {
        return hint;
    }

    @Override
    public void stuurUpdate(Boolean goedOfFout) {
        for (Update update : observers) {
            update.update(goedOfFout);
        }
    }
}
