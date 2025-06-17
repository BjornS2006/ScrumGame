package kamers;

import monster.Monster;
import usableitems.IUsableItem;
import vragen.Vraag;
import utils.*;
import usableitems.JeffDeAssistent;

public class Finale extends Kamer {
    SaveSystemInterface saveSystem;

    public Finale(Monster monster) {
        super("Finale", "Finale: In deze kamer ontdek je waarom Scrum belangrijk is. Scrum helpt teams om flexibel te werken, snel in te spelen op veranderingen en samen te werken aan waardevolle resultaten.", monster);
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
        this.saveSystem = new SaveSystem();
    }


    @Override
    public void enter() {
        System.out.println("Welkom in la grande finale.\uD83D\uDC12");
        System.out.println("Deze kamer gaat over waarom hebben we scrum nodig?");
        if (!SpelerSession.getSpeler().isSixthItemReceived()) {
            beginSpel();
            SpelerSession.getSpeler().setSixthItemReceived(true);
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
        saveSystem.reset();
        System.out.println("Je hebt het spel uitgespeeld!");
        System.out.println("Bedankt voor het spelen van het spel! 🎂");
        System.out.println("typ restart om opnieuw te spelen of exit om het spel te verlaten.");
        SpelerInputHandler.eindeSpel();

    }
    @Override
    public void showJokerHint(){
        System.out.println("Joker hint: Scrum is een framework dat teams helpt om beter samen te werken en sneller waarde te leveren.");
    }
}
