package GameLogic;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Monster implements Update {
    private String naam;
    private VraagType huidigeVraag;
    private ArrayList<String> extraVragen;
    private ArrayList<String> antwoorden;



    public Monster(String naam) {
        this.naam = naam;

        extraVragen = new ArrayList<>(Arrays.asList(
                "Hoe heet het wanneer teamleden bij elkaar komen om kort uit te leggen wat ze hebben gedaan?",
                "Wie bepaald de prioriteit van backlog items?",
                "Wie is verantwoordlijk voor het verwijderen van opstakels binnen een team?",
                "Wat is het verschil tussen een user-story en epic?",
                "Welk soort meeting help het team continu te verbeteren?", "Retrospective"
        ));
        antwoorden = new ArrayList<>(Arrays.asList(
                "Stand Up",
                "Product owner",
                "Scrum Master",
                "grootte",
                "Retrospective"
        ));
    }

    public void setHuidigeVraag(VraagType vraag) {
        this.huidigeVraag = vraag;
    }
        //Als de vraag fout is dan komt de monster te voorschijn.
        //Dit moet in de andere klasssen aangeroepen worden.


        public void monsterVerschijnt () {
            System.out.println("KIJK UIT, DE " + naam + " VERSCHIJNT!!");
        }
        public void monsterChallenge() {
            Random random = new Random();
            int keuze = random.nextInt(2) + 1;
            System.out.println("De monster heeft zijn dobbelsteen gerold...");

            if (keuze == 1) {

                if (huidigeVraag == null) {
                    System.out.println(naam + " De correcte antwoord voor jouw vraag was" + huidigeVraag.getCorrecteAntwoord());
                } else {
                    System.out.println("Kan het correcte antwoord niet vinden.");
                }
            }

                //hiermee corrigeert de monster de gebruiker(Code is nog niet af)
            else {
                int secondChanceVragen = random.nextInt(extraVragen.size());
                Scanner scanner = new Scanner(System.in);
                String vraag = extraVragen.get(secondChanceVragen);
                String correcteAntwoord = antwoorden.get(secondChanceVragen);

                System.out.println(naam + ": Hier is een nieuwe vraag " + vraag);
                String Antwoord = scanner.nextLine();
                if(Antwoord.equalsIgnoreCase(correcteAntwoord)) {
                    System.out.println(naam + ": Dat is de goede antwoord je kan verder gaan");
                }
                else {
                    System.out.println(naam + ": Je hebt de vraag helaas fout, je zult nog een vraag van mij moeten beantworden");
                    monsterChallenge();
                }
                scanner.close();
            }
        }

    @Override
    public void Update() {
    }
}
