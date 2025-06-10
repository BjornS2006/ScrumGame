package monster;
import vragen.Vraag;

import java.util.ArrayList;

public class MonsterVraagBeheer {
    private ArrayList<Vraag> vragen;

    public MonsterVraagBeheer() {
        this.vragen = new ArrayList<>();
    }
    public void voegVraagToe(Vraag vraag) {
        vragen.add(vraag);
    }

    public ArrayList<Vraag> getVragen() {
         return vragen;
    }

}
