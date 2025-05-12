package GameLogic;

import java.util.Scanner;
import java.util.ArrayList;

public class MeerkeuzeVraag implements VraagType {
    private String vraagNaam;
    private int antwoord;
    private ArrayList <String> antwoordMogelijkheden;
    private Monster monster;

    public MeerkeuzeVraag(Monster monster, ArrayList<String> antwoordMogelijkheden, int antwoord, String vraagNaam) {
        this.monster = monster;
        this.antwoordMogelijkheden = antwoordMogelijkheden;
        this.antwoord = antwoord;
        this.vraagNaam = vraagNaam;
    }



    @Override
    public void stelVraag() {
        System.out.println("Dit is:  " + vraagNaam + "?");
        for (int i = 0; i < antwoordMogelijkheden.size (); i++) {
            System.out.println(antwoordMogelijkheden.get(i));
        }

    }

    @Override
    public void checkGoedAntwoord(Scanner scanner) {
        String goedAntwoord = antwoordMogelijkheden.get(antwoord);
        String[] delen = goedAntwoord.split(":");
        String goedeLetter = delen[0];
        String input = scanner.nextLine();
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
