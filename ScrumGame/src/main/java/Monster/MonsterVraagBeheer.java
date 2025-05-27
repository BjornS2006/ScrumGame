package Monster;
import java.util.ArrayList;

public class MonsterVraagBeheer {
    private ArrayList<String> vragen;
    private ArrayList<String> antwoorden;

    public MonsterVraagBeheer(ArrayList<String> vragen, ArrayList<String> antwoorden) {
        this.vragen = new ArrayList<>();
        this.antwoorden = new ArrayList<>();
    }
    public void VoegVraagToe(String vraag, String antwoord) {
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
