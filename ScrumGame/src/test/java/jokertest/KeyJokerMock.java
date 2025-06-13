package jokertest;

import kamers.Kamer;
import usableitems.IUsableItem;

public class KeyJokerMock implements IUsableItem {
    public boolean usedInCalled = false;

    public boolean isUsed() {
        return false;
    }

    public void useIn(Kamer kamer) {
        usedInCalled = true;
    }

    @Override
    public String getName() {
        return "KeyJoker";
    }

    @Override
    public String getDescription() {
        return "Stub KeyJoker";
    }

    @Override
    public void gebruik() {
    }
}