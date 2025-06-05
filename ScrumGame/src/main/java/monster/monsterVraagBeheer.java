package monster;
import java.util.ArrayList;

public class monsterVraagBeheer {
    private ArrayList<String> vragen;
    private ArrayList<String> antwoorden;

    public monsterVraagBeheer() {
        this.vragen = new ArrayList<>();
        this.antwoorden = new ArrayList<>();
    }
    public void voegVraagToe(String vraag, String antwoord) {
        vragen.add(vraag);
        antwoorden.add(antwoord);
    }

    public ArrayList<String> getVragen() {
         return vragen;
    }
    public ArrayList<String> getAntwoorden() {
        return antwoorden;
    }

}
