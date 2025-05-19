package Monster;
import java.util.ArrayList;

public class MonsterVraagBeheer {
    private ArrayList<String> vragen = new ArrayList<>();
    private ArrayList<String> antwoorden = new ArrayList<>();

    public MonsterVraagBeheer(ArrayList<String> vragen, ArrayList<String> antwoorden) {
        this.vragen = vragen;
        this.antwoorden = antwoorden;
    }
    public void VoegVraagToe(String vraag, String antwoord) {
        vragen.add(vraag);
        antwoorden.add(antwoord);
        System.out.println("Voeg een vraag toe: " + vraag);
        System.out.println("Antwoord: " + antwoord);
    }

    public ArrayList<String> getVragen() {
        this.vragen = new ArrayList<>();
         return vragen;
    }
    public void setVragen(ArrayList<String> vragen) {
        this.vragen = vragen;
    }
    public ArrayList<String> getAntwoorden() {
        this.antwoorden = new ArrayList<>();
        return antwoorden;
    }
    public void setAntwoorden(ArrayList<String> vragen) {
        this.antwoorden = antwoorden;
    }
}
