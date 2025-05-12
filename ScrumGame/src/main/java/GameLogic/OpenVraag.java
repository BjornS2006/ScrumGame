package GameLogic;

import java.util.Scanner;

public class OpenVraag implements VraagType {
    private String vraagNaam;
    private String antwoord;
    Scanner scanner = new Scanner(System.in);
    private Monster monster;

    public OpenVraag(GameLogic.Monster monster, String antwoord, String vraagNaam) {
        this.monster = monster;
        this.antwoord = antwoord;
        this.vraagNaam = vraagNaam;
    }

    @Override
    public String getVraagNaam() {
        return vraagNaam;
    }

    @Override
    public void stelVraag() {
        System.out.println(vraagNaam);
        String input = scanner.nextLine();
        checkGoedAntwoord(input);
    }

    @Override
    public void checkGoedAntwoord(String input) {
        if (input.equals(antwoord)) {
            System.out.println("Vraag goed!");
        } else {
            monster.monsterVerschijnt();
        }
    }
}
