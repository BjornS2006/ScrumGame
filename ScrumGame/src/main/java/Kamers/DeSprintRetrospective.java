package Kamers;

import GameLogic.Game;

import java.util.Scanner;

public class DeSprintRetrospective extends Kamer {

    public DeSprintRetrospective() {
        super("De Sprint Retrospective");
    }



    @Override
    public void enter() {
        System.out.println("Welkom in de 5de kamer.");
        System.out.println("Deze kamer gaat over de Sprint Retrospective");
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
        Game.maakLaatsteKamerAan().speelKamer(scanner);
    }
}
