package vragen;

import utils.SpelerInputHandler;

public class OpenControle implements VraagControleStrategie {
    private String goedAntwoord;

    public OpenControle (String goedAntwoord) {
        this.goedAntwoord = goedAntwoord;
    }

    @Override
    public boolean checkGoedAntwoord() {
        return SpelerInputHandler.spelerAntwoord().trim().equalsIgnoreCase(goedAntwoord);
    }

    @Override
    public String getCorrectAntwoord() {
        return goedAntwoord;
    }
}
