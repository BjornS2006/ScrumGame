package vragen;

import utils.SpelerInputHandler;

public class MeerkeuzeControle implements VraagControleStrategie {
    private String correcteLetter;

    public MeerkeuzeControle (String correcteLetter) {
        this.correcteLetter = correcteLetter;
    }

    @Override
    public boolean checkGoedAntwoord() {
        return SpelerInputHandler.spelerAntwoord().trim().equalsIgnoreCase(correcteLetter);
    }

    @Override
    public String getCorrectAntwoord() {
        return correcteLetter;
    }
}

