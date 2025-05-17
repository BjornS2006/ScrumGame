package Kamers;

import GameLogic.Game;
import Vragen.VraagType;

import java.util.ArrayList;
import java.util.Scanner;

public class HetScrumBoard extends Kamer {
    private KamerVraagManager vraagManager;
    private KamerVraagPresenter vraagPresenter;

    public HetScrumBoard() {
        super("Het Scrum Board");
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 3de kamer.");
        System.out.println("Deze kamer gaat over het Scrum Board");
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
        Game.maakVierdeKamerAan().speelKamer(scanner);
    }
}
