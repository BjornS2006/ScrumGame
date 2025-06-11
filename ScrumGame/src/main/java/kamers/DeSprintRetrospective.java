package kamers;

import gamelogic.Game;
import usableitems.IUsableItem;
import usableitems.Komkommer;
import utils.ItemGiver;
import utils.SpelerSession;
import vragen.Vraag;

public class DeSprintRetrospective extends Kamer {

    public DeSprintRetrospective() {
        super("De Sprint Retrospective",  "Retrospective");
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }



    @Override
    public void enter() {
        System.out.println("Welkom in de 5de kamer.");
        System.out.println("Deze kamer gaat over de Sprint Retrospective");
        if (!SpelerSession.getSpeler().isFifthItemReceived()) {
            IUsableItem item = ItemGiver.giveRandomItem();
            System.out.println("Gefeliciteerd!!! Je hebt een: " + item.getName() + " gekregen.");
            System.out.println(item.getDescription());
            SpelerSession.getSpeler().getItems().add(item);
            SpelerSession.getSpeler().setFifthItemReceived(true);
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
        Game.maakLaatsteKamerAan().speelKamer();
    }

    @Override
    public void showJokerHint() {
        System.out.println("Hint: Reflecteer op de afgelopen sprint en bespreek wat er goed ging en wat beter kan.");
    }
}
