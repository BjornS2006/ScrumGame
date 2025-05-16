package Monster;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MonsterNieuweVraag implements MonsterActie {
    private ArrayList<String> vragen = new ArrayList<>(Arrays.asList(
            "Hoe heet het wanneer teamleden bij elkaar komen om kort uit te leggen wat ze hebben gedaan?",
            "Wie bepaalt de prioriteit van backlog items?",
            "Wie is verantwoordelijk voor het verwijderen van obstakels binnen een team?",
            "Wat is het verschil tussen een user-story en epic?",
            "Welk soort meeting helpt het team continu te verbeteren?"
    ));

    private ArrayList<String> antwoorden = new ArrayList<>(Arrays.asList(
            "Stand Up", "Product owner", "Scrum Master", "grootte", "Retrospective"
    ));

    public void uitvoeren() {
        Random random = new Random();
        int index = random.nextInt(vragen.size());

        System.out.println("Nieuwe vraag: " + vragen.get(index));
        new MonsterAntwoordControle(antwoorden.get(index)).uitvoeren();
    }
}
