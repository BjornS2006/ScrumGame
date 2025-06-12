package kamers;

import gamelogic.Game;
import gamelogic.GameRoute;
import joker.IKeyJoker;
import monster.Monster;
import test.checkAantalFouten;
import usableitems.IUsableItem;
import utils.ItemGiver;
import utils.SpelerSession;
import vragen.Vraag;

public class DeDailyScrum extends Kamer implements IKeyJoker {

    public DeDailyScrum(Monster monster) {
        super("De Daily Scrum",  "Daily Scrum", monster);
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 2de kamer.");
        System.out.println("Deze kamer gaat over De Daily Scrum");
        checkAantalFouten foutenChecker = new checkAantalFouten();
        if (foutenChecker.check(SpelerSession.getSpeler().getAantalFoutenTest())) {
            System.out.println("Je hebt al veel fouten dus pas op!");
        }

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
       monster.checkStartChallenge();
    }

    public void addVraag (Vraag vraag) {
        vraagManager.addVraag(vraag);
    }

    @Override
    public void naarVolgendeKamer() {
        SpelerSession.getSpeler().getStatus().setPositie("Het Scrum Board");
        GameRoute.locatie();
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
