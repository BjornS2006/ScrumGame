package monster;

import gamelogic.Update;
import vragen.Vraag;

public class Monster implements Update {
    private String naam;
    private Vraag huidigeVraag;
    private MonsterChallenge challenge;
    private boolean isActief;

    public Monster(String naam, MonsterChallenge challenge) {
        this.naam = naam;
        this.challenge = challenge;
        this.isActief = false;
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
        if (!goedOfFout) {
            isActief = true;
        }
    }

    public MonsterChallenge getChallenge() {
        return challenge;
    }
    public void checkStartChallenge() {
        if (isActief) {
            challenge.startChallenge();
        }
    }
}
