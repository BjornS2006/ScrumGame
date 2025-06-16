package test;

class MonsterMock implements gamelogic.Update {
    public boolean updateCalled = false;
    public boolean laatsteResultaat;
    @Override
    public void update(boolean goedOfFout) {
        updateCalled = true;
        laatsteResultaat = goedOfFout;
        System.out.println("Mock Monster update aangeroepen met: " + goedOfFout);
    }
}

public class VraagObserverMockTest {
    public static void main(String[] args) {
        MonsterMock mock = new MonsterMock();
        vragen.Vraag vraag = new vragen.Vraag(
            new vragen.OpenWeergave("Testvraag?"),
            new vragen.OpenControle("antwoord"),
            null,
            new hintsysteem.HelpHintProvider("hint")
        );
        vraag.addObserver(mock);
        vraag.stuurUpdateVoorAntwoord(true);
        if (mock.updateCalled && mock.laatsteResultaat) {
            System.out.println("✅ MockTest geslaagd: Observer update correct aangeroepen.");
        } else {
            System.out.println("❌ MockTest gefaald: Observer update niet correct aangeroepen.");
        }
    }
}

