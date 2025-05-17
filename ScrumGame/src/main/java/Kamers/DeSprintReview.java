package Kamers;

import GameLogic.Game;
import Vragen.VraagType;

import java.util.ArrayList;
import java.util.Scanner;

public class DeSprintReview extends Kamer {
    private KamerVraagManager vraagManager;
    private KamerVraagPresenter vraagPresenter;

    public DeSprintReview() {
        super("De Sprint Review");
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 4de kamer.");
        System.out.println("Deze kamer gaat over de Sprint Review");
        System.out.println("Beantwoord de volgende vraag:");
    }

    @Override
    public void stelVraag(Scanner scanner) {
        vraagPresenter.stelVragen(vraagManager, scanner);
    }
    public void addVraag (VraagType vraag) {
        vraagManager.addVraag(vraag);
    }


    @Override
    public void naarVolgendeKamer(Scanner scanner) {
        Game.maakVijfdeKamerAan().speelKamer(scanner);
    }
}
