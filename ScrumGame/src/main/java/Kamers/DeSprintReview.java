package Kamers;

import GameLogic.Game;
import UsableItems.Komkommer;
import Vragen.Vraag;

public class DeSprintReview extends Kamer {

    public DeSprintReview() {
        super("De Sprint Review",  new Komkommer());
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
    public void stelVraag() {
        vraagPresenter.stelVragen(vraagManager);
    }
    public void addVraag (Vraag vraag) {
        vraagManager.addVraag(vraag);
    }


    @Override
    public void naarVolgendeKamer() {
        Game.maakVijfdeKamerAan().speelKamer();
    }
}
