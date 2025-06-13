package jokertest;

import kamers.Kamer;
import joker.IKeyJoker;

public class DeDailyScrumStub extends Kamer implements IKeyJoker {
    public boolean skipRoomCalled = false;

    public DeDailyScrumStub() {
        super("De Daily Scrum", "Daily Scrum", null);
    }

    @Override
    public void enter() {}

    @Override
    public void stelVraag() {}

    @Override
    public void naarVolgendeKamer() {}

    @Override
    public void showJokerHint() {}

    @Override
    public void skipRoom() {
        skipRoomCalled = true;
    }
}