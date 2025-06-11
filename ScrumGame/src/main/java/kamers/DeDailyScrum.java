package kamers;

import gamelogic.Game;
import joker.IKeyJoker;
import usableitems.IUsableItem;
import utils.ItemGiver;
import utils.SpelerSession;
import vragen.Vraag;

public class DeDailyScrum extends Kamer implements IKeyJoker {

    public DeDailyScrum() {
        super("De Daily Scrum",  "Daily Scrum");
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 2de kamer.");
        System.out.println("Deze kamer gaat over De Daily Scrum");
        if (!SpelerSession.getSpeler().isSecondItemReceived()) {
            IUsableItem item = ItemGiver.giveRandomItem();
            System.out.println("Gefeliciteerd!!! Je hebt een: " + item.getName() + " gekregen.");
            System.out.println(item.getDescription());
            SpelerSession.getSpeler().getItems().add(item);
            SpelerSession.getSpeler().setSecondItemReceived(true);
        }
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

    @Override
    public void showJokerHint() {
        System.out.println("Hint: De Daily Scrum is een korte dagelijkse bijeenkomst waar teamleden elkaar bijpraten over hun voortgang.");
    }

    @Override
    public void skipRoom() {
        System.out.println("Je gebruikt de KeyJoker! Je slaat deze kamer over.");
        naarVolgendeKamer();
    }
}
