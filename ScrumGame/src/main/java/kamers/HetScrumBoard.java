package kamers;

import gamelogic.GameRoute;
import monster.Monster;
import usableitems.IUsableItem;
import usableitems.Komkommer;
import gamelogic.Game;
import utils.ItemGiver;
import utils.SpelerSession;
import vragen.Vraag;

public class HetScrumBoard extends Kamer {

    public HetScrumBoard(Monster monster) {
        super("Het Scrum Board",  "Scrum Board: Het Scrum Board is een visueel hulpmiddel waarop het team taken bijhoudt. Het toont de status van werkitems, zoals 'To Do', 'In Progress' en 'Done', en bevordert transparantie en samenwerking.", monster);
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 3de kamer.");
        System.out.println("Deze kamer gaat over het Scrum Board");
        if (!SpelerSession.getSpeler().isThirdItemReceived()) {
            beginSpel();
            SpelerSession.getSpeler().setThirdItemReceived(true);
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
        SpelerSession.getSpeler().getStatus().setPositie("De Sprint Review");
        GameRoute.locatie();
    }

    @Override
    public void showJokerHint() {
        System.out.println("Hint: Het Scrum Board is een hulpmiddel voor teams om hun werk te organiseren en te visualiseren.");}
}
