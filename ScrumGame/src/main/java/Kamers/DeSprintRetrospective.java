package Kamers;

import GameLogic.Game;
import GameLogic.VraagType;

import java.util.ArrayList;
import java.util.Scanner;

public class DeSprintRetrospective extends Kamer {

    public DeSprintRetrospective() {
        super("De Sprint Retrospective");
        vragen = new ArrayList<>();
    }



    @Override
    public void enter() {
        System.out.println("Welkom in de 5de kamer.");
        System.out.println("Deze kamer gaat over de Sprint Retrospective");
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
        Game.maakLaatsteKamerAan().speelKamer(scanner);
    }
}
