package kamers;

import gamelogic.Game;
import gamelogic.GameRoute;
import joker.IKeyJoker;
import monster.Monster;
import usableitems.IUsableItem;
import utils.ItemGiver;
import utils.SpelerSession;
import vragen.Vraag;
import usableitems.JeffDeAssistent;

public class DeSprintReview extends Kamer implements IKeyJoker {

    public DeSprintReview(Monster monster) {
        super("De Sprint Review",  "Review", monster);
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 4de kamer.");
        System.out.println("Deze kamer gaat over de Sprint Review");
        if (!SpelerSession.getSpeler().isFourthItemReceived()) {
            IUsableItem item = ItemGiver.giveRandomItem();
            System.out.println("Gefeliciteerd!!! Je hebt een: " + item.getName() + " gekregen.");
            System.out.println(item.getDescription());
            SpelerSession.getSpeler().getItems().add(item);
            SpelerSession.getSpeler().setFourthItemReceived(true);
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
        SpelerSession.getSpeler().getStatus().setPositie("De Sprint Retrospective");
        GameRoute.locatie();
    }

    @Override
    public void showJokerHint() {
        System.out.println("Hint: De Sprint Review is een bijeenkomst waar het team de resultaten van de sprint presenteert en feedback verzamelt.");
    }

    @Override
    public void skipRoom() {
        System.out.println("Je gebruikt de KeyJoker! Je slaat deze kamer over.");
        naarVolgendeKamer();
    }
}
