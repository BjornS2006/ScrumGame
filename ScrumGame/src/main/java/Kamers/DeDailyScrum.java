package Kamers;

import GameLogic.Game;
import Vragen.VraagType;

import java.util.ArrayList;
import java.util.Scanner;

public class DeDailyScrum extends Kamer {

    public DeDailyScrum() {
        super("De Daily Scrum");
        vragen = new ArrayList<>();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 2de kamer.");
        System.out.println("Deze kamer gaat over De Daily Scrum");
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
        Game.maakDerdeKamerAan().speelKamer(scanner);
    }
}
