
package vragen;

import utils.SpelerInputHandler;

public abstract class AbstracteVraagControle implements VraagControleStrategie {
    protected String correctAntwoord;

    public AbstracteVraagControle(String correctAntwoord) {
        this.correctAntwoord = correctAntwoord;
    }

    @Override
    public boolean checkGoedAntwoord() {
        return SpelerInputHandler.spelerAntwoord().trim().equalsIgnoreCase(correctAntwoord);
    }

    @Override
    public String getCorrectAntwoord() {
        return correctAntwoord;
    }
}