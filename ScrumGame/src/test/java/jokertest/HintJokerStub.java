package jokertest;

import joker.HintJoker;
import kamers.Kamer;

public class HintJokerStub extends HintJoker {
    public boolean usedInCalled = false;

    @Override
    protected void doUseIn(Kamer kamer) {
        usedInCalled = true;
        super.doUseIn(kamer);
    }
}