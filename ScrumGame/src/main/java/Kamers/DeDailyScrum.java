package Kamers;

import GameLogic.Game;
import UsableItems.Komkommer;
import Vragen.Vraag;

public class DeDailyScrum extends Kamer implements Joker.KeyJokerUsable {

    public DeDailyScrum() {
        super("De Daily Scrum",  new Komkommer());
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }

    @Override
    public void enter() {
        System.out.println("Welkom in de 2de kamer.");
        System.out.println("Deze kamer gaat over De Daily Scrum");
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
