//public class test {
//    // --- MOCK TEST 1: HintProviderMock for HintPresenter ---
//    static class HintProviderMock implements hintsysteem.HintProvider {
//        public boolean hintCalled = false;
//        @Override
//        public void geefHint() {
//            hintCalled = true;
//            System.out.println("[Mock] Hint is opgevraagd!");
//        }
//    }
//
//    static class HintPresenterMockTest {
//        public static void main(String[] args) {
//            HintProviderMock mock = new HintProviderMock();
//            // Simuleer een Vraag met een mock HintProvider
//            vragen.Vraag vraag = new vragen.Vraag(
//                new vragen.OpenWeergave("Testvraag?"),
//                new vragen.OpenControle("antwoord"),
//                null,
//                (hintsysteem.HelpHintProvider) mock // cast for test
//            );
//            hintsysteem.HintPresenter presenter = new hintsysteem.HintPresenter(vraag);
//            // Forceer dat altijd de echte hint wordt gekozen
//            vraag.getHint().geefHint();
//            if (mock.hintCalled) {
//                System.out.println("✅ MockTest geslaagd: Hint werd opgevraagd.");
//            } else {
//                System.out.println("❌ MockTest gefaald: Hint werd niet opgevraagd.");
//            }
//        }
//    }
//
//    // --- MOCK TEST 2: MonsterMock for Vraag observer ---
//    static class MonsterMock implements gamelogic.Update {
//        public boolean updateCalled = false;
//        public boolean laatsteResultaat;
//        @Override
//        public void update(boolean goedOfFout) {
//            updateCalled = true;
//            laatsteResultaat = goedOfFout;
//            System.out.println("[Mock] Monster update aangeroepen met: " + goedOfFout);
//        }
//    }
//
//    static class VraagObserverMockTest {
//        public static void main(String[] args) {
//            MonsterMock mock = new MonsterMock();
//            vragen.Vraag vraag = new vragen.Vraag(
//                new vragen.OpenWeergave("Testvraag?"),
//                new vragen.OpenControle("antwoord"),
//                null,
//                new hintsysteem.HelpHintProvider("hint")
//            );
//            vraag.addObserver(mock);
//            vraag.stuurUpdateVoorAntwoord(true);
//            if (mock.updateCalled && mock.laatsteResultaat) {
//                System.out.println("✅ MockTest geslaagd: Observer update correct aangeroepen.");
//            } else {
//                System.out.println("❌ MockTest gefaald: Observer update niet correct aangeroepen.");
//            }
//        }
//    }
//
//    // --- STUB TEST 1: HelpHintProviderStub for predictable hint ---
//    static class HelpHintProviderStub extends hintsysteem.HelpHintProvider {
//        public boolean hintGevraagd = false;
//        public HelpHintProviderStub() { super("Dit is een stub hint."); }
//        @Override
//        public void geefHint() {
//            hintGevraagd = true;
//            System.out.println("[Stub] Stub hint gegeven.");
//        }
//    }
//
//    static class HintStubTest {
//        public static void main(String[] args) {
//            HelpHintProviderStub stub = new HelpHintProviderStub();
//            vragen.Vraag vraag = new vragen.Vraag(
//                new vragen.OpenWeergave("Stubvraag?"),
//                new vragen.OpenControle("antwoord"),
//                null,
//                stub
//            );
//            vraag.getHint().geefHint();
//            if (stub.hintGevraagd) {
//                System.out.println("✅ StubTest geslaagd: Stub hint werd gegeven.");
//            } else {
//                System.out.println("❌ StubTest gefaald: Stub hint werd niet gegeven.");
//            }
//        }
//    }
//
//    // --- STUB TEST 2: ScoreManagerStub for Status ---
//    static class SaveSystemStub implements utils.SaveSystemInterface {
//        public boolean saveCalled = false;
//        @Override
//        public void saveGame(gamelogic.Speler speler) {
//            saveCalled = true;
//            System.out.println("[Stub] SaveGame aangeroepen.");
//        }
//        @Override
//        public gamelogic.Speler loadGame() { return null; }
//        @Override
//        public void reset() {}
//    }
//
//    static class StatusStubTest {
//        public static void main(String[] args) {
//            SaveSystemStub stub = new SaveSystemStub();
//            gamelogic.Status status = new gamelogic.Status(0, "Start", stub);
//            status.update(true); // zou saveGame moeten aanroepen
//            if (stub.saveCalled) {
//                System.out.println("✅ StubTest geslaagd: saveGame werd aangeroepen.");
//            } else {
//                System.out.println("❌ StubTest gefaald: saveGame werd niet aangeroepen.");
//            }
//        }
//    }
//}
