package GameLogic;
import java.util.List;

public class Speler {
    private int score;
    private String positie;
    private List<String> vragenGeschiedenis; //naam kan beter vertel me wel als je het verandert

    public void getStatus() {
        System.out.println("Speler status:");
        System.out.println("Score: " + score);
        System.out.println("Positie: " + score);
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public String getPositie() {
        return positie;
    }
    public void setPositie(String positie) {
        this.positie = positie;
    }

    public List<String> getVragenGeschiedenis(){
        return vragenGeschiedenis;
    }
    public void setVragenGeschiedenis(java.util.List<String> vragenGeschiedenis) {
        this.vragenGeschiedenis = vragenGeschiedenis;
    }
}
