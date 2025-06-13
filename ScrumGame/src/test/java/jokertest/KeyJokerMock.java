package jokertest;

import joker.KeyJoker;
import kamers.Kamer;

public class KeyJokerMock extends KeyJoker {
    public boolean usedInCalled = false;

    @Override
    protected void doUseIn(Kamer kamer) {
        usedInCalled = true;
        super.doUseIn(kamer);
    }
}