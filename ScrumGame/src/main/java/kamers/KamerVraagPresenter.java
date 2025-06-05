package kamers;

import hintsysteem.HintPresenter;
import utils.SpelerInputHandler;
import vragen.Vraag;

public class KamerVraagPresenter {


    public void stelVragen(KamerVraagManager vraagManager) {
        for (Vraag vraag : vraagManager.getVragen()) {
            vraag.stelVraag();
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

