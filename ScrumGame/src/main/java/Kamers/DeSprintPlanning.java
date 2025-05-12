package Kamers;

import GameLogic.Game;

import java.util.Scanner;

public class DeSprintPlanning extends Kamer {

    public DeSprintPlanning() {
        super("De Sprint Planning");
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de eerste kamer.");
        System.out.println("Deze kamer gaat over De Sprint Planning");
        System.out.println("Beantwoord de volgende vraag:");
    }

    @Override
    public void stelVraag(Scanner scanner) {

    }


    @Override
    public void naarVolgendeKamer(Scanner scanner) {
        Game.maakTweedeKamerAan().speelKamer(scanner);
    }
}
