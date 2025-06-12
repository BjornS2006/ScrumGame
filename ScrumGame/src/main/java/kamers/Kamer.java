package kamers;

import monster.Monster;
import usableitems.UsableItem;
import utils.SaveSystem;
import utils.SpelerSession;


public abstract class Kamer {
    protected String naam;
    protected KamerVraagManager vraagManager;
    protected KamerVraagPresenter vraagPresenter;
    protected String kamerInfo;
    protected Monster monster;

    protected Kamer(String name, String kamerInfo, Monster monster) {
        this.naam = name;
        this.kamerInfo = kamerInfo;
        this.monster = monster;
    }

    public void speelKamer() {
        SpelerSession.getSpeler().getStatus().setActieveKamer(this);
        SpelerSession.getSpeler().setHintUsed(false);
        SpelerSession.getSpeler().getStatus().save();
        enter();
        SpelerSession.getSpeler().getStatus().save();
        stelVraag();
        naarVolgendeKamer();
    }

    public abstract void enter ();
    public abstract void stelVraag();
    public abstract void naarVolgendeKamer();
    public abstract void showJokerHint();

    public String getKamerInfo() {
        return kamerInfo;
    }
}
