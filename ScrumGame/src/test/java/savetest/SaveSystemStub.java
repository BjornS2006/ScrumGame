package savetest;

import gamelogic.Speler;
import gamelogic.Status;
import utils.SaveSystemInterface;


public class SaveSystemStub implements SaveSystemInterface {
    private Speler speler;


    @Override
    public void saveGame(Speler speler) {
        this.speler = speler;
    }
    @Override
    public Speler loadGame() {
        Status status = new Status(5, "Start", this);
        return new Speler(status);
    }
    @Override
    public void reset() {
        speler = null;
    }
}
