package GameLogic;
import java.util.Scanner;
import java.util.Random;

public class Monster {
    private String naam;
    private String[][] extraVragen = {

    {"Hoe heet het wanneer teamleden bij elkaar komen om kort uit te leggen wat ze hebben gedaan?", "Stand Up"},
            {"Wie bepaald de prioriteit van backlog items?", "Product owner"},
            {"Wie is verantwoordlijk voor het verwijderen van opstakels binnen een team?", "Scrum Master"},
            {"Wat is het verschil tussen een user-story en epic?", "grootte"},
            {"Welk soort meeting help het team continu te verbeteren?", "Retrospective"}
    };

    public Monster(String naam) {
        this.naam = naam;
    }
        //Als de vraag fout is dan komt de monster te voorschijn
        public void monsterVerschijnt () {
            System.out.println("KIJK UIT, DE"  + naam + " VERSCHIJNT!!");
        }
        public void monsterChallenge() {
            Random random = new Random();
            int keuze = random.nextInt(2) + 1;
            System.out.println("De monster heeft zijn dobbelsteen gerold...");

            if (keuze == 1) {
                System.out.println(naam + " De correcte antwoord voor jouw vraag was...");
                //hiermee corrigeert de monster de gebruiker(Code is nog niet af)
            }
            else {
                System.out.println(naam + "Hier is een nieuwe vraag: Wie leid scrum-meetings binnen een sprint");
                Scanner scanner = new Scanner(System.in);
                String Antwoord = scanner.nextLine();
                if(Antwoord.equalsIgnoreCase("ScrumMaster")) {
                    System.out.println(naam + ": Dat is de goede antwoord je kan verder gaan");
                }
                else {
                    System.out.println(naam + ": Je hebt de vraag helaas fout, we zullen wat langer met elkaar opgesch je zul nog een vraag van mij moeten beantworden");
                    //zoalng de monster in de weg staat kan de gebruiker niet verder(Dit stuk code moet toegevoegd worden)
                }
                scanner.close();
            }
        }
}
