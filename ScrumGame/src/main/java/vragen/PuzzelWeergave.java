package vragen;

import java.util.*;

public class PuzzelWeergave implements VraagWeergaveStrategie{
    private List<String> matchItems;
    private List<String> tweedeMatchItems;

    public PuzzelWeergave() {
        matchItems = new ArrayList<>();
        tweedeMatchItems = new ArrayList<>();
    }
    @Override
    public void toonVraag() {
        System.out.println("Match de begrippen met de juiste betekenis:");


        // Print opties
        for (int i = 0; i < matchItems.size(); i++) {
            System.out.println((i + 1) + ". " + matchItems.get(i));
        }
        System.out.println();
        for (int i = 0; i < tweedeMatchItems.size(); i++) {
            System.out.println((i + 1) + ". " + tweedeMatchItems.get(i));
        }
        System.out.println("typ je antwoord op deze manier: '1-x,2-x,3-x,4-x,5-x'");
    }
    public void addMatchItem (String item) {
        matchItems.add(item);
    }
    public void addTweedeMatchItem (String item) {
        tweedeMatchItems.add(item);
    }
}

