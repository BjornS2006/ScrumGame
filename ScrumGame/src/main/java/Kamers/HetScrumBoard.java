package Kamers;

import GameLogic.Game;

import java.util.Scanner;

public class HetScrumBoard extends Kamer {

    public HetScrumBoard() {
        super("Het Scrum Board");
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 3de kamer.");
        System.out.println("Deze kamer gaat over het Scrum Board");
        System.out.println("Beantwoord de volgende vraag:");
    }

    @Override
    public void stelVraag(Scanner scanner) {

    }



    @Override
    public void naarVolgendeKamer(Scanner scanner) {
        Game.maakVierdeKamerAan().speelKamer(scanner);
    }
}
