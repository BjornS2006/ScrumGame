package jokertest;

import gamelogic.Status;
import kamers.Kamer;
import utils.SaveSystemInterface;

public class StatusStub extends Status {
    private Kamer kamer;

    public StatusStub(Kamer kamer) {
        super(0, "Stub", null);
        this.kamer = kamer;
    }

    @Override
    public Kamer getActieveKamer() {
        return kamer;
    }
}