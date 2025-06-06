package kamers;

import usableitems.Komkommer;
import gamelogic.Game;
import vragen.Vraag;

public class HetScrumBoard extends Kamer {

    public HetScrumBoard() {
        super("Het Scrum Board",  new Komkommer());
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        SpelerSession.getSpeler().addItem(item);

        System.out.println("Welkom in de 3de kamer.");
        System.out.println("Deze kamer gaat over het Scrum Board");
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
        Game.maakVierdeKamerAan().speelKamer();
    }

    @Override
    public void showJokerHint() {
        System.out.println("Hint: Het Scrum Board is een hulpmiddel voor teams om hun werk te organiseren en te visualiseren.");}
}

