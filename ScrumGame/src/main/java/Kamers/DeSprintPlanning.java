package Kamers;

import GameLogic.Game;
import Vragen.Vraag;

public class DeSprintPlanning extends Kamer {

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
    public void stelVraag() {
        vraagPresenter.stelVragen(vraagManager);
    }
    public void addVraag (Vraag vraag) {
        vraagManager.addVraag(vraag);
    }


    @Override
    public void naarVolgendeKamer() {
        Game.maakTweedeKamerAan().speelKamer();
    }
}
