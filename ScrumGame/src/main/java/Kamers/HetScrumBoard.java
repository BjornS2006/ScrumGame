package Kamers;

import GameLogic.Game;
import GameLogic.VraagType;

import java.util.ArrayList;
import java.util.Scanner;

public class HetScrumBoard extends Kamer {

    public HetScrumBoard() {
        super("Het Scrum Board");
        vragen = new ArrayList<>();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 3de kamer.");
        System.out.println("Deze kamer gaat over het Scrum Board");
        System.out.println("Beantwoord de volgende vraag:");
    }

    @Override
    public void stelVraag(Scanner scanner) {
        for (VraagType vraag : vragen) {
            vraag.stelVraag();
        }
    }
    public void addVraag (VraagType vraag) {
        vragen.add(vraag);
    }


    @Override
    public void naarVolgendeKamer(Scanner scanner) {
        Game.maakVierdeKamerAan().speelKamer(scanner);
    }
}
