package Vragen;

import java.util.Scanner;

public class OpenControle implements VraagControleStrategie {
    private String goedAntwoord;

    public OpenControle (String goedAntwoord) {
        this.goedAntwoord = goedAntwoord;
    }

    @Override
    public boolean checkGoedAntwoord(Scanner scanner) {
        return AnswerHandler.spelerAntwoord(scanner).trim().equalsIgnoreCase(goedAntwoord);
    }

    @Override
    public String getCorrectAntwoord() {
        return goedAntwoord;
    }
}
