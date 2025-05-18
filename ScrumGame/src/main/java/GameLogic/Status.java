package GameLogic;

public class Status implements Update {
    private int score;
    private String positie;

    public Status(int score, String positie) {
        this.score = score;
        this.positie = positie;
    }
    @Override
    public void update() {

    }
}
