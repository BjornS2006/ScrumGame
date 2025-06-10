package kamers;

import hintsysteem.HintPresenter;
import usableitems.IUsableItem;
import utils.SpelerInputHandler;
import utils.SpelerSession;
import vragen.Vraag;

public class KamerVraagPresenter {


    public void stelVragen(KamerVraagManager vraagManager) {
        for (Vraag vraag : vraagManager.getVragen()) {
            SpelerSession.getSpeler().getStatus().setHuidigeVraag(vraag);
            vraag.stelVraag();
            System.out.println("Typ je antwoord of de naam van een item dat je wilt gebruiken:");


            boolean goedOfFout = vraag.controleerAntwoord();

            if (goedOfFout) {
                vraag.stuurUpdateVoorAntwoord(true);
            } else {
                vraag.stuurUpdateVoorAntwoord(false);
            }
        }
    }

}

