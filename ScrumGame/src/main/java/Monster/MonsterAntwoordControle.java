package Monster;
import java.util.Scanner;

    public class MonsterAntwoordControle implements MonsterActie {
        private String correcteAntwoord;

        public MonsterAntwoordControle(String correcteAntwoord) {
            this.correcteAntwoord = correcteAntwoord;
        }
        @Override
        public void uitvoeren() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Geef je antwoord:");
            String antwoord = scanner.nextLine();

            if (antwoord.equalsIgnoreCase(correcteAntwoord)) {
                System.out.println("Correct! Je mag verder gaan.");
            } else {
                System.out.println("Fout! De monster geeft je een nieuwe vraag...");
                new MonsterNieuweVraag().uitvoeren();
            }
        }
    }
