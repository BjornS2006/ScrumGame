package jokertest;

import kamers.Kamer;
import usableitems.IUsableItem;

public class HintJokerStub implements IUsableItem {
    private final boolean used;
    public boolean usedInCalled = false;

    public HintJokerStub(boolean used) {
        this.used = used;
    }

    public boolean isUsed() {
        return used;
    }

    public void useIn(Kamer kamer) {
        usedInCalled = true;
    }

    @Override
    public String getName() {
        return "HintJoker";
    }

    @Override
    public String getDescription() {
        return "Stub HintJoker";
    }

    @Override
    public void gebruik() {
    }
}