package GameLogic;

import static Utils.SaveSystem.saveGame;
import Utils.SpelerSession;

public class Status implements Update {
    private int score;
    private String positie;

    public Status(int score, String positie) {
        this.score = score;
        this.positie = positie;
    }
    @Override
    public void update(boolean goedOfFout) {
        if (goedOfFout) {
            score++; //hoe we dit precies gaan doen moeten we nog ff beslissen
            saveGame(SpelerSession.getSpeler());
        }
    }
    public int getScore() {
        return score;
    }
    public String getPositie() {
        return positie;
    }
}
