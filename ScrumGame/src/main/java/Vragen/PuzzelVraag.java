package Vragen;

import Monster.Monster;

import java.util.*;

public class PuzzelVraag implements VraagType {
    private Map<String, String> juisteMatches;
    private List<String> matchItems;
    private List<String> tweedeMatchItems;
    private Monster monster;

    public PuzzelVraag(Monster monster) {
        juisteMatches = new HashMap<>();
        matchItems = new ArrayList<>(juisteMatches.keySet());
        tweedeMatchItems = new ArrayList<>(juisteMatches.values());
    }

    @Override
    public void stelVraag() {
        System.out.println("Match de begrippen met de juiste betekenis:");


        // Randomize de betekenissen om het lastiger te maken
        Collections.shuffle(tweedeMatchItems);

        // Print opties
        for (int i = 0; i < matchItems.size(); i++) {
            System.out.println((i + 1) + ". " + matchItems.get(i));
        }
        System.out.println();
        for (int i = 0; i < tweedeMatchItems.size(); i++) {
            System.out.println((i + 1) + ". " + tweedeMatchItems.get(i));
        }
    }

    @Override
    public void checkGoedAntwoord(Scanner scanner) {

        System.out.println("Voer de juiste matches in (bijv. '1-3' voor eerste begrip en derde betekenis):");

        // Lees invoer en controleer
        for (Map.Entry<String, String> entry : juisteMatches.entrySet()) {
            String begrip = entry.getKey();
            String juisteBetekenis = entry.getValue();
            System.out.print("Match voor '" + begrip + "': ");
            String antwoord = scanner.nextLine();

            if (juisteMatches.get(begrip).equals(juisteBetekenis)) {
                System.out.println("Correct!");
            }
            else {
                monster.monsterVerschijnt();
                monster.monsterChallenge();

            }
        }
    }

    @Override
    public String getVraagNaam() {
        return "";
    }

    @Override
    public String getCorrecteAntwoord() {
        return "";
    }

    public void addItem (String item) {
        matchItems.add(item);
    }
    public void addTweedeItem (String item) {
        tweedeMatchItems.add(item);
    }
 }

