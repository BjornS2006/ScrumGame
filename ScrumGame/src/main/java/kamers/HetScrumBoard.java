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
        super("Het Scrum Board",  "Scrum Board", monster);
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 3de kamer.");
        System.out.println("Deze kamer gaat over het Scrum Board");
        if (!SpelerSession.getSpeler().isThirdItemReceived()) {
            IUsableItem item = ItemGiver.giveRandomItem();
            System.out.println("Gefeliciteerd!!! Je hebt een: " + item.getName() + " gekregen.");
            System.out.println(item.getDescription());
            SpelerSession.getSpeler().getItems().add(item);
            SpelerSession.getSpeler().setThirdItemReceived(true);
        }
        System.out.println("Beantwoord de volgende vraag:");
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

