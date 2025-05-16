package Monster;

import Vragen.VraagType;

public class Monster {
    private String naam;
    private VraagType huidigeVraag;

    public Monster(String naam) {
        this.naam = naam;
    }

    public void setHuidigeVraag(VraagType vraag) {
        this.huidigeVraag = vraag;
    }

    public String getNaam() {
        return naam;
    }

    public VraagType getHuidigeVraag() {
        return huidigeVraag;
    }
}
