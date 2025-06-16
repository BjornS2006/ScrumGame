package test;

class SaveSystemStub implements utils.SaveSystemInterface {
    public boolean saveCalled = false;
    @Override
    public void saveGame(gamelogic.Speler speler) {
        saveCalled = true;
        System.out.println("[Stub] SaveGame aangeroepen.");
    }
    @Override
    public gamelogic.Speler loadGame() { return null; }
    @Override
    public void reset() {}
}

public class StatusStubTest {
    public static void main(String[] args) {
        SaveSystemStub stub = new SaveSystemStub();
        gamelogic.Status status = new gamelogic.Status(0, "Start", stub);
        status.update(true); // zou saveGame moeten aanroepen
        if (stub.saveCalled) {
            System.out.println("✅ StubTest geslaagd: saveGame werd aangeroepen.");
        } else {
            System.out.println("❌ StubTest gefaald: saveGame werd niet aangeroepen.");
        }
    }
}

