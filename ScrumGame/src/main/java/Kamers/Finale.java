package Kamers;

import UsableItems.Komkommer;
import Vragen.Vraag;

public class Finale extends Kamer {

    public Finale() {
        super("Finale",  new Komkommer());
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }


    @Override
    public void enter() {
        System.out.println("Welkom in la grande finale.\uD83D\uDC12");
        System.out.println("Deze kamer gaat over waarom hebben we scrum nodig?");
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
        System.out.println("Je hebt het spel uitgespeeld!");
    }
}
