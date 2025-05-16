package Vragen;

import Monster.Monster;

import java.util.Scanner;
import java.util.ArrayList;

public class MeerkeuzeVraag implements VraagType {
    private String vraagNaam;
    private int antwoord;
    private ArrayList <String> antwoordMogelijkheden;
    private Monster monster;
    private boolean Meerkeuze = true;

    public MeerkeuzeVraag(Monster monster, ArrayList<String> antwoordMogelijkheden, int antwoord, String vraagNaam) {
        this.monster = monster;
        this.antwoordMogelijkheden = antwoordMogelijkheden;
        this.antwoord = antwoord;
        this.vraagNaam = vraagNaam;
    }



    public ArrayList<String> getAntwoordMogelijkheden() {
        return antwoordMogelijkheden;
    }

    public String getCorrecteAntwoordLetter () {
        String goedAntwoord = antwoordMogelijkheden.get(antwoord);
        return goedAntwoord.split (":") [0];
    }

    public Monster getMonster () {
        return monster;
    }

    @Override
    public void stelVraag () {
        VraagWeergave.toonMeerVraag(this);
    }

    @Override
    public void checkGoedAntwoord (Scanner scanner) {
        CheckGoedAntwoord.controleerMeerkeuze(this, scanner);
    }


//    @Override
//    public void stelVraag() {
//        System.out.println("Dit is:  " + vraagNaam + "?");
//        for (int i = 0; i < antwoordMogelijkheden.size (); i++) {
//            System.out.println(antwoordMogelijkheden.get(i));
//        }
//
//    }

//    @Override
//    public void checkGoedAntwoord(Scanner scanner) {
//        String goedAntwoord = antwoordMogelijkheden.get(antwoord);
//        String[] delen = goedAntwoord.split(":");
//        String goedeLetter = delen[0];
//        String input = scanner.nextLine();
//        if (input.toUpperCase().equals(goedeLetter)){
//            System.out.println("goed");
//        }else {
//            monster.monsterVerschijnt();
//            monster.monsterChallenge();
//        }
//    }

    @Override
    public String getVraagNaam() {
        return "";
    }

    @Override
    public String getCorrecteAntwoord() {
        return "";
    }
}