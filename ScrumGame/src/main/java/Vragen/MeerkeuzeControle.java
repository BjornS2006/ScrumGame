package Vragen;

import java.util.Scanner;

public class MeerkeuzeControle implements VraagControleStrategie {
    private String correcteLetter;

    public MeerkeuzeControle (String correcteLetter) {
        this.correcteLetter = correcteLetter;
    }

    @Override
    public boolean checkGoedAntwoord(Scanner scanner) {
        return AnswerHandler.spelerAntwoord(scanner).trim().equalsIgnoreCase(correcteLetter);
    }

    @Override
    public String getCorrectAntwoord() {
        return correcteLetter;
    }
}
