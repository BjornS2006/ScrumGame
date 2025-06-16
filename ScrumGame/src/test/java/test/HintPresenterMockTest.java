package test;

class HintProviderMock extends hintsysteem.HelpHintProvider {
    public boolean hintCalled = false;
    public HintProviderMock() { super("Mock hint"); }
    @Override
    public void geefHint() {
        hintCalled = true;
        System.out.println("[Mock] Hint is opgevraagd!");
    }
}

public class HintPresenterMockTest {
    public static void main(String[] args) {
        HintProviderMock mock = new HintProviderMock();
        vragen.Vraag vraag = new vragen.Vraag(
            new vragen.OpenWeergave("Testvraag?"),
            new vragen.OpenControle("antwoord"),
            null,
            mock
        );
        hintsysteem.HintPresenter presenter = new hintsysteem.HintPresenter(vraag);
        vraag.getHint().geefHint();
        if (mock.hintCalled) {
            System.out.println("✅ MockTest geslaagd: Hint werd opgevraagd.");
        } else {
            System.out.println("❌ MockTest gefaald: Hint werd niet opgevraagd.");
        }
    }
}
