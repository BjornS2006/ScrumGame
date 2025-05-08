package Kamers;

import java.util.Scanner;

public class DeSprintReview extends Kamer {

    public DeSprintReview() {
        super("De Sprint Review");
    }
    public void enter (Scanner scanner) {
        System.out.println("Welkom in de 4de kamer.");
        System.out.println("Deze kamer gaat over de Sprint Review");
        System.out.println("Beantwoord de volgende vraag:");
    }
}
