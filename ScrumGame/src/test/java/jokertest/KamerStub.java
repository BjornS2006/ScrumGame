package jokertest;

import kamers.Kamer;

public class KamerStub extends Kamer {
    private String type;
    public KamerStub() {
        super("StubKamer", "StubInfo");
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    @Override
    public void enter() {}
    @Override
    public void stelVraag() {}
    @Override
    public void naarVolgendeKamer() {}
    @Override
    public void showJokerHint() {}
}
