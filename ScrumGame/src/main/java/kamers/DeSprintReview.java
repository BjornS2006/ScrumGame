package kamers;

import gamelogic.Game;
import joker.IKeyJoker;
import usableitems.Komkommer;
import vragen.Vraag;
import UsableItems.JeffDeAssistent;

public class DeSprintReview extends Kamer implements IKeyJoker {

    public DeSprintReview() {
        super("De Sprint Review",  new JeffDeAssistent("De hint: het is niet a\nStappenplan:\n1. Lees de som: 20 + 0\n2. Herken het getal 0: 0 betekent dat je niets toevoegt\n3. Voeg 0 toe aan 20: 20 blijft hetzelfde\n4. Schrijf het antwoord op: 20 gebruik je rekenmachine!\nMotivatie quote: To be, or not to be: that is the question. -William Shakespear"));
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        SpelerSession.getSpeler().addItem(item);

        System.out.println("Welkom in de 4de kamer.");
        System.out.println("Deze kamer gaat over de Sprint Review");
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
        Game.maakVijfdeKamerAan().speelKamer();
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
