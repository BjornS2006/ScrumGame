package Kamers;

import GameLogic.Game;
import Vragen.Vraag;

import java.util.ArrayList;
import java.util.Scanner;

public class DeSprintRetrospective extends Kamer {

    public DeSprintRetrospective() {
        super("De Sprint Retrospective");
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }



    @Override
    public void enter() {
        System.out.println("Welkom in de 5de kamer.");
        System.out.println("Deze kamer gaat over de Sprint Retrospective");
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
        Game.maakLaatsteKamerAan().speelKamer(scanner);
    }
}
