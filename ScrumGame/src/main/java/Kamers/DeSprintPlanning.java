package Kamers;

import GameLogic.Game;
import Vragen.Vraag;

import java.util.ArrayList;
import java.util.Scanner;

public class DeSprintPlanning extends Kamer {
    private KamerVraagManager vraagManager;
    private KamerVraagPresenter vraagPresenter;

    public DeSprintPlanning() {
        super("De Sprint Planning");
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de eerste kamer.");
        System.out.println("Deze kamer gaat over De Sprint Planning");
        System.out.println("Beantwoord de volgende vraag:");
    }

    @Override
    public void stelVraag(Scanner scanner) {
        vraagPresenter.stelVragen(vraagManager, scanner);
    }
    public void addVraag (Vraag vraag) {
        vraagManager.addVraag(vraag);
    }


    @Override
    public void naarVolgendeKamer(Scanner scanner) {
        Game.maakTweedeKamerAan().speelKamer(scanner);
    }
}
