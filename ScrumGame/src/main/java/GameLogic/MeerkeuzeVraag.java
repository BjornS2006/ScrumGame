package GameLogic;

import java.util.Scanner;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class MeerkeuzeVraag implements VraagType {
    private String vraagNaam;
    private int antwoord;
    Scanner scanner = new Scanner(System.in);
    private ArrayList <String> antwoordMogelijkheden;
    private Monster monster;

    public MeerkeuzeVraag(Monster monster, ArrayList<String> antwoordMogelijkheden, int antwoord, String vraagNaam) {
        this.monster = monster;
        this.antwoordMogelijkheden = antwoordMogelijkheden;
        this.antwoord = antwoord;
        this.vraagNaam = vraagNaam;
    }

    @Override
    public String getVraagNnaam() {
        return vraagNaam;
    }


    @Override
    public void stelVraag() {
        System.out.println("Dit is:  " + vraagNaam + "?");
        for (int i = 0; i < antwoordMogelijkheden.size (); i++) {
            System.out.println(antwoordMogelijkheden.get(i));
        }
        String input = scanner.nextLine();
        checkGoedAntwoord(input);
    }

    @Override
    public void checkGoedAntwoord() {

        if (input.toUpperCase().equals(goedeLetter)){
            System.out.println("goed");
        }else {
            monster.monsterVerschijnt();
        }
    }

    @Override
    public String getVraagNaam() {
        return "";
    }
}
