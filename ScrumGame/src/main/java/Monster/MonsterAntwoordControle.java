package Monster;
import java.util.Scanner;

public class MonsterAntwoordControle implements MonsterActie {
    private String correcteAntwoord;
    private MonsterVraagBeheer vraagBeheer;

    public MonsterAntwoordControle(String correcteAntwoord, MonsterVraagBeheer vraagBeheer) {
        this.correcteAntwoord = correcteAntwoord;
        this.vraagBeheer = vraagBeheer;
    }

    @Override
    public void uitvoeren() {
        try (Scanner scanner = new Scanner(System.in)) { // Zorgt ervoor dat Scanner correct sluit
            System.out.println("Geef je antwoord:");
            String antwoord = scanner.nextLine();

            if (antwoord.equalsIgnoreCase(correcteAntwoord)) {
                System.out.println("Correct! Je mag verder gaan.");
            } else {
                System.out.println("Fout! De monster geeft je een nieuwe vraag...");
                new MonsterNieuweVraag(vraagBeheer).uitvoeren(); // Gebruik het bestaande vraagbeheer
            }
        }
    }
}