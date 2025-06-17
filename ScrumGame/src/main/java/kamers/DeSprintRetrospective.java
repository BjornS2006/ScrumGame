package kamers;

import gamelogic.Game;
import gamelogic.GameRoute;
import monster.Monster;
import usableitems.IUsableItem;
import usableitems.Komkommer;
import utils.ItemGiver;
import utils.SpelerSession;
import vragen.Vraag;

public class DeSprintRetrospective extends Kamer {

    public DeSprintRetrospective(Monster monster) {
        super("De Sprint Retrospective",  "Retrospective", monster);
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }



    @Override
    public void enter() {
        System.out.println("Welkom in de 5de kamer.");
        System.out.println("Deze kamer gaat over de Sprint Retrospective");
        if (!SpelerSession.getSpeler().isFifthItemReceived()) {
            beginSpel();
            SpelerSession.getSpeler().setFifthItemReceived(true);
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
        SpelerSession.getSpeler().getStatus().setPositie("De Finale");
        GameRoute.locatie();
    }

    @Override
    public void showJokerHint() {
        System.out.println("Hint: Reflecteer op de afgelopen sprint en bespreek wat er goed ging en wat beter kan.");
    }
}
