package Monster;

import GameLogic.Update;
import Vragen.Vraag;

public class Monster implements Update {
    private String naam;
    private Vraag huidigeVraag;
    private MonsterChallenge challenge;

    public Monster(String naam, MonsterChallenge challenge) {
        this.naam = naam;
        this.challenge = challenge;
    }

    public void setHuidigeVraag(Vraag vraag) {
        this.huidigeVraag = vraag;
    }

    public String getNaam() {
        return naam;
    }

    public Vraag getHuidigeVraag() {
        return huidigeVraag;
    }

    @Override
    public void update(boolean goedOfFout) {
        if (goedOfFout) {
            challenge.startChallenge();
        }
    }

}
