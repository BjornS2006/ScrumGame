package Kamers;

import GameLogic.Game;
import UsableItems.KamerInforBoek;
import UsableItems.Komkommer;
import Vragen.Vraag;

public class DeDailyScrum extends Kamer {

    public DeDailyScrum() {
        super("De Daily Scrum",  new Komkommer());
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 2de kamer.");
        System.out.println("Deze kamer gaat over De Daily Scrum");
        System.out.println("Gefeliciteerd!!! Je hebt een: " + item.getName() + " gekregen.");
        System.out.println(item.getDescription());
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
