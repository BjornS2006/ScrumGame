package HintSysteem;

public class HelpHintProvider implements HintProvider {
    String hint;
    public HelpHintProvider(String hint) {
        this.hint = hint;
    }

    @Override
    public void geefHint() {
        System.out.println(hint);
    }
}
