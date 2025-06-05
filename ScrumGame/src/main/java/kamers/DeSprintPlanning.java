package kamers;

import gamelogic.Game;
import usableitems.Komkommer;
import utils.SpelerSession;
import vragen.Vraag;

public class DeSprintPlanning extends Kamer {

    public DeSprintPlanning() {
        super( "De Sprint Planning",  new Komkommer());
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        SpelerSession.getSpeler().addItem(item);

        System.out.println("Welkom in de eerste kamer.");
        System.out.println("Deze kamer gaat over De Sprint Planning");
        System.out.println("Gefeliciteerd!!! Je hebt een: " + item.getName() + " gekregen.");
        System.out.println("Eetsmakelijk");
        System.out.println(item.getDescription());
        System.out.println("Beanwoord de volgende vraag:");
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

    @Override
    public void showJokerHint() {
        System.out.println("Deze kamer heeft geen specifieke hint, maar je kunt de komkommer gebruiken voor een magische ervaring.");
    }
}
