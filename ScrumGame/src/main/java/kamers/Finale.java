package kamers;

import usableitems.Komkommer;
import vragen.Vraag;
import utils.*;
import UsableItems.JeffDeAssistent;

public class Finale extends Kamer {
    SaveSystemInterface saveSystem = new SaveSystem();

    public Finale() {
        super("Finale",  new JeffDeAssistent("Hint: Het is de laatste vraag, ik zou gewoon gokken. \n Educatief hulpmiddel: Hier is een stappenplan: \n Lees de som: 12 × 2\nBegrijp dat het betekent: 12 keer 2\nTel 2 twaalf keer op: 2 + 2 + ... = ?\nOf reken: 10 × 2 + 2 × 2 = 20 + 4 = ?\nControleer je antwoord\nAntwoord: ??\n En je weet wat ze zeggen: \n Yesterday was history... Tomorrow is a mystery... But today is gift, that's why it's called the presend \n ~Master Oogway"));
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
        this.saveSystem = new SaveSystem();
    }


    @Override
    public void enter() {
        SpelerSession.getSpeler().addItem(item);

        System.out.println("Welkom in la grande finale.\uD83D\uDC12");
        System.out.println("Deze kamer gaat over waarom hebben we scrum nodig?");
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
