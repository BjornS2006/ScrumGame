package Vragen;

import Monster.Monster;

import java.util.Scanner;

public class OpenVraag implements VraagType {
    private String vraagNaam;
    private String antwoord;
    private Monster monster;

    public OpenVraag(Monster monster, String antwoord, String vraagNaam) {
        this.monster = monster;
        this.antwoord = antwoord;
        this.vraagNaam = vraagNaam;
    }

    @Override
    public String getVraagNaam() {
        return vraagNaam;
    }

    @Override
    public String getCorrecteAntwoord() {
        return "";
    }

    @Override
    public void stelVraag() {
        System.out.println(vraagNaam);
    }

    @Override
    public void checkGoedAntwoord(Scanner scanner) {
        String input = scanner.nextLine();
        if (input.equals(antwoord)) {
            System.out.println("Vraag goed!");
        } else {
            monster.monsterVerschijnt();
            monster.monsterChallenge();
        }
    }
}
