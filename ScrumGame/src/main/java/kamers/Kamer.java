package kamers;

import usableitems.UsableItem;
import utils.SpelerSession;


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
        SpelerSession.getSpeler().getStatus().setActieveKamer(this);
        SpelerSession.getSpeler().setHintUsed(false);
        enter();
        stelVraag();
        naarVolgendeKamer();
    }

    public abstract void enter ();
    public abstract void stelVraag();
    public abstract void naarVolgendeKamer();
    public abstract void showJokerHint();
}
