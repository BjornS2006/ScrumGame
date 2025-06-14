package jokertest;

import kamers.Kamer;
import joker.IKeyJoker;
import monster.Monster;
import vragen.Vraag;

public class KamerStub extends Kamer implements IKeyJoker {
    public boolean skipRoomCalled = false;
    private String type;

    public KamerStub() {
        super("StubKamer", "StubInfo", null);
    }

    @Override
    public void enter() {}

    @Override
    public void stelVraag() {}

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public void naarVolgendeKamer() {}

    @Override
    public void showJokerHint() {}

    @Override
    public void skipRoom() {
        skipRoomCalled = true;
    }
}