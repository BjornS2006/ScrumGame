package Monster;

import Vragen.Vraag;

public class Monster {
    private String naam;
    private Vraag huidigeVraag;

    public Monster(String naam) {
        this.naam = naam;
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
}
