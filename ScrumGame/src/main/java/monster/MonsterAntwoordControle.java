package monster;
import utils.SpelerInputHandler;


public class MonsterAntwoordControle implements MonsterActie {
    private String correcteAntwoord;
    private monsterVraagBeheer vraagBeheer;

    public MonsterAntwoordControle(String correcteAntwoord, monsterVraagBeheer vraagBeheer) {
        this.correcteAntwoord = correcteAntwoord;
        this.vraagBeheer = vraagBeheer;
    }

    @Override
    public void uitvoeren() {
            System.out.println("Geef je antwoord:");
            String antwoord = SpelerInputHandler.spelerAntwoord();
            if (antwoord.equalsIgnoreCase(correcteAntwoord)) {
                System.out.println("Correct! Je mag verder gaan.");
            } else {
                System.out.println("Fout! De monster geeft je een nieuwe vraag...");
                new MonsterNieuweVraag(vraagBeheer).uitvoeren(); // Gebruik het bestaande vraagbeheer
            }
        }
    }
