package Vragen;

import java.util.Scanner;

public class PuzzelControle implements VraagControleStrategie{
    private String goedAntwoord;

    public PuzzelControle (String goedAntwoord) {
        this.goedAntwoord = goedAntwoord;
    }

    @Override
    public boolean checkGoedAntwoord(Scanner scanner) {
        return AnswerHandler.spelerAntwoord(scanner).trim().equalsIgnoreCase(goedAntwoord);
    }
    public String getCorrectAntwoord () {
        return goedAntwoord;
    }
}
