package Kamers;

import GameLogic.Game;
import Vragen.Vraag;

public class DeDailyScrum extends Kamer {

    public DeDailyScrum() {
        super("De Daily Scrum");
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 2de kamer.");
        System.out.println("Deze kamer gaat over De Daily Scrum");
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
        Game.maakDerdeKamerAan().speelKamer();
    }
}
