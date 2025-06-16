package test;

class HelpHintProviderStub extends hintsysteem.HelpHintProvider {
    public boolean hintGevraagd = false;
    public HelpHintProviderStub() { super("Dit is een stub hint."); }
    @Override
    public void geefHint() {
        hintGevraagd = true;
        System.out.println("[Stub] Stub hint gegeven.");
    }
}

public class HintStubTest {
    public static void main(String[] args) {
        HelpHintProviderStub stub = new HelpHintProviderStub();
        vragen.Vraag vraag = new vragen.Vraag(
            new vragen.OpenWeergave("Stubvraag?"),
            new vragen.OpenControle("antwoord"),
            null,
            stub
        );
        vraag.getHint().geefHint();
        if (stub.hintGevraagd) {
            System.out.println("✅ StubTest geslaagd: Stub hint werd gegeven.");
        } else {
            System.out.println("❌ StubTest gefaald: Stub hint werd niet gegeven.");
        }
    }
}

