package HintSysteem;

import java.util.ArrayList;

public class FunnyHintProvider implements HintProvider {
    private ArrayList <String> mogelijkeFunnyHints;

    public FunnyHintProvider() {
        mogelijkeFunnyHints = new ArrayList<>();
        mogelijkeFunnyHints.add("");
        mogelijkeFunnyHints.add("gfgposifgois");
        mogelijkeFunnyHints.add("hhhh");
        mogelijkeFunnyHints.add("zoek");
    }

    @Override
    public void geefHint() {
        int randomNum = (int)(Math.random() * mogelijkeFunnyHints.size());
        System.out.println(randomNum);
        System.out.println(mogelijkeFunnyHints.get(randomNum));
    }
}