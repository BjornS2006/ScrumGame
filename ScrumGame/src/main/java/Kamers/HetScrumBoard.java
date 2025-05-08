package Kamers;

import java.util.Scanner;

public class HetScrumBoard extends Kamer {

    public HetScrumBoard() {
        super("Het Scrum Board");
    }
    public void enter (Scanner scanner) {
        System.out.println("Welkom in de 3de kamer.");
        System.out.println("Deze kamer gaat over het Scrum Board");
        System.out.println("Beantwoord de volgende vraag:");
    }
}
