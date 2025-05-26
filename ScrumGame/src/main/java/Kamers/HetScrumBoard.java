package Kamers;

import UsableItems.Komkommer;
import GameLogic.Game;
import Vragen.Vraag;

public class HetScrumBoard extends Kamer {

    public HetScrumBoard() {
        super("Het Scrum Board",  new Komkommer());
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
    public void stelVraag() {
        vraagPresenter.stelVragen(vraagManager);
    }

    public void addVraag (Vraag vraag) {
        vraagManager.addVraag(vraag);
    }

    @Override
    public void naarVolgendeKamer() {
        Game.maakVierdeKamerAan().speelKamer();
    }
}
