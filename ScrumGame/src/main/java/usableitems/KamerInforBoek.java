package usableitems;

import utils.SpelerSession;

public class KamerInforBoek extends UsableItem implements IInformatie, IUsableItem {


    public void showInfo() {
        System.out.println("Dit is de informatie die we gaan geven over deze kamer:");
        System.out.println(SpelerSession.getSpeler().getStatus().getActieveKamer().getKamerInfo());
    }


    public KamerInforBoek() {
        super("Infoboek", "Dit is een informatie boekje om info te krijgen over de huidige kamer.");;
    }

    public void gebruik() {
        showInfo();
    }

}
