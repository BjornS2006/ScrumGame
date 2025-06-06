package kamers;

import hintsysteem.HintPresenter;
import usableitems.IUsableItem;
import utils.SpelerInputHandler;
import utils.SpelerSession;
import vragen.Vraag;

public class KamerVraagPresenter {


    public void stelVragen(KamerVraagManager vraagManager) {
        for (Vraag vraag : vraagManager.getVragen()) {
            vraag.stelVraag();
            System.out.println("Als je een item wilt gebruiken, nu is je moment!");
            for (IUsableItem item : SpelerSession.getSpeler().getItems()) {
                if (SpelerInputHandler.spelerAntwoord().equalsIgnoreCase(item.getName())) {
                    break;
                } else {
                    break;
                }
            }

            boolean goedOfFout = vraag.controleerAntwoord();

            if (goedOfFout) {
                vraag.stuurUpdateVoorAntwoord(true);
                System.out.println("Volgende vraag!");
            } else {
                System.out.println("Wil je een hint?");
                String aapje = SpelerInputHandler.spelerAntwoord();
                if (aapje.equalsIgnoreCase("Ja")) {
                    HintPresenter hintPresenter = new HintPresenter(vraag);
                    hintPresenter.presentHint();
                }
                vraag.stuurUpdateVoorAntwoord(false); // Monster challenge pas na hint
            }
        }
    }

}

