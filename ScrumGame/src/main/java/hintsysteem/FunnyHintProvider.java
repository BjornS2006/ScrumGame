package hintsysteem;

import java.util.ArrayList;
import java.util.Random;

public class FunnyHintProvider implements HintProvider {
    private ArrayList <String> mogelijkeFunnyHints;
    private Random random = new Random();

    public FunnyHintProvider() {
        mogelijkeFunnyHints = new ArrayList<>();
        mogelijkeFunnyHints.add("Doe anders een gokje");
        mogelijkeFunnyHints.add("Zelfs met een hint gaat het je toch niet lukken");
        mogelijkeFunnyHints.add("Kies gewoon het eerste antwoord wat naar boven komt");
        mogelijkeFunnyHints.add("Zoek het uit");
    }

    @Override
    public void geefHint() {
        int randomNum = random.nextInt(mogelijkeFunnyHints.size());
        System.out.println(mogelijkeFunnyHints.get(randomNum));
    }
}