package Kamers;

import GameLogic.Game;

import java.util.Scanner;

public class DeSprintReview extends Kamer {

    public DeSprintReview() {
        super("De Sprint Review");
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 4de kamer.");
        System.out.println("Deze kamer gaat over de Sprint Review");
        System.out.println("Beantwoord de volgende vraag:");
    }

    @Override
    public void stelVraag() {

    }

    @Override
    public void vraagAntwoord(Scanner scanner) {

    }

    @Override
    public void naarVolgendeKamer(Scanner scanner) {
        Game.maakVijfdeKamerAan().speelKamer(scanner);
    }
}
