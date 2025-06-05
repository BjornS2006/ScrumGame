package hintsysteem;

import java.util.ArrayList;
import java.util.Random;

public class FunnyHintProvider implements HintProvider {
    private ArrayList <String> mogelijkeFunnyHints;
    private Random random = new Random();

    public FunnyHintProvider() {
        mogelijkeFunnyHints = new ArrayList<>();
        mogelijkeFunnyHints.add("");
        mogelijkeFunnyHints.add("gfgposifgois");
        mogelijkeFunnyHints.add("hhhh");
        mogelijkeFunnyHints.add("zoek");
    }

    @Override
    public void geefHint() {
        int randomNum = random.nextInt(mogelijkeFunnyHints.size());
        System.out.println(mogelijkeFunnyHints.get(randomNum));
    }
}