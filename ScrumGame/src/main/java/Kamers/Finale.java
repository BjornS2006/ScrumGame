package Kamers;

import GameLogic.Speler;
import UsableItems.Komkommer;
import Vragen.Vraag;
import Utils.*;

public class Finale extends Kamer {
    SaveSystemInterface saveSystem = new SaveSystem();

    public Finale() {
        super("Finale",  new Komkommer());
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
        this.saveSystem = new SaveSystem();
    }


    @Override
    public void enter() {
        System.out.println("Welkom in la grande finale.\uD83D\uDC12");
        System.out.println("Deze kamer gaat over waarom hebben we scrum nodig?");
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
        saveSystem.Reset();
        System.out.println("Je hebt het spel uitgespeeld!");
        System.out.println("Bedankt voor het spelen van het spel! 🎂");
        System.out.println("typ restart om opnieuw te spelen of exit om het spel te verlaten.");
//        System.out.println("Typ 'exit' om het spel te verlaten.");
        SpelerInputHandler.eindeSpel();

    }
    @Override
    public void showJokerHint(){
        System.out.println("Joker hint: Scrum is een framework dat teams helpt om beter samen te werken en sneller waarde te leveren.");
    }
}
