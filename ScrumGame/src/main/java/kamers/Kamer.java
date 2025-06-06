package kamers;

import usableitems.UsableItem;
import joker.HintJoker;
import joker.KeyJoker;
import usableitems.IUsableItem;
import utils.SpelerInputHandler;
import vragen.Vraag;

public abstract class Kamer {
    protected String naam;
    protected KamerVraagManager vraagManager;
    protected KamerVraagPresenter vraagPresenter;
    protected UsableItem item;

    protected Kamer(String name, UsableItem item) {
        this.naam = name;
        this.item = item;
    }

    public void speelKamer() {
        enter();
        for (Vraag vraag : vraagManager.getVragen()) {
            boolean vraagBeantwoord = false;
            while (!vraagBeantwoord) {
                vraag.stelVraag();
                String input = "";
                do {
                    System.out.println("Typ je antwoord of typ 'joker' om je joker te gebruiken:");
                    input = SpelerInputHandler.spelerAntwoord();
                    IUsableItem joker = utils.SpelerSession.getSpeler().getItems().stream()
                        .filter(item -> item instanceof joker.HintJoker || item instanceof joker.KeyJoker)
                        .findFirst().orElse(null);
                    if (input.equalsIgnoreCase("joker")) {
                        if (joker == null) {
                            System.out.println("Je hebt geen joker om te gebruiken.");
                        } else if (joker instanceof HintJoker hintJoker) {
                            if (!hintJoker.isUsed()) {
                                hintJoker.useIn(this);
                            } else {
                                System.out.println("Je hebt de HintJoker al gebruikt.");
                            }
                        } else if (joker instanceof KeyJoker keyJoker) {
                            if (!keyJoker.isUsed()) {
                                keyJoker.useIn(this);
                                if (keyJoker.isUsed()) {
                                    // Als de kamer is geskipt, stop direct met deze kamer
                                    return;
                                }
                            } else {
                                System.out.println("Je hebt de KeyJoker al gebruikt.");
                            }
                        }
                    }
                } while (input.equalsIgnoreCase("joker"));
                // Nu is input geen 'joker', dus behandelen als antwoord
                boolean goed = vraag.controleerAntwoord(input);
                if (goed) {
                    vraag.stuurUpdateVoorAntwoord(true);
                    System.out.println("Goed gedaan! Volgende vraag.");
                    vraagBeantwoord = true;
                } else {
                    System.out.println("Helaas, dat is niet correct. Het juiste antwoord is: " + vraag.getCorrecteAntwoord());
                    vraag.stuurUpdateVoorAntwoord(false);
                    vraagBeantwoord = true;
                }
            }
        }
        naarVolgendeKamer();
    }

    public abstract void enter ();
    public abstract void stelVraag();
    public abstract void naarVolgendeKamer();
    public abstract void showJokerHint();
}
