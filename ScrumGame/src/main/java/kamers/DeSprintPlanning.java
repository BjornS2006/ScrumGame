package kamers;

import gamelogic.Game;
import gamelogic.GameRoute;
import monster.Monster;
import usableitems.IUsableItem;
import usableitems.Zwaard;
import utils.ItemGiver;
import utils.SpelerSession;
import vragen.Vraag;

public class DeSprintPlanning extends Kamer {

    public DeSprintPlanning(Monster monster) {
        super( "De Sprint Planning",  "Sprint Planning", monster);
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de eerste kamer.");
        System.out.println("Deze kamer gaat over De Sprint Planning");
        if (!SpelerSession.getSpeler().isFirstItemReceived()) {
            beginSpel();
            SpelerSession.getSpeler().setFirstItemReceived(true);
        }
    }

    @Override
    public void stelVraag() {
        vraagPresenter.stelVragen(vraagManager);
        monster.checkStartChallenge();
    }
    public void addVraag (Vraag vraag) {
        vraagManager.addVraag(vraag);
    }


    @Override
    public void naarVolgendeKamer() {
        SpelerSession.getSpeler().getStatus().setPositie("De Daily Scrum");
        GameRoute.locatie();
    }

    @Override
    public void showJokerHint() {
        System.out.println("Deze kamer heeft geen specifieke hint, maar je kunt de komkommer gebruiken voor een magische ervaring.");
    }
}
