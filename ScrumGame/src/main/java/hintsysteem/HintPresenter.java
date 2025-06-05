package hintsysteem;

import vragen.Vraag;

public class HintPresenter {
    private Vraag vraag;
    private FunnyHintProvider funnyHintProvider = new FunnyHintProvider();

    public HintPresenter (Vraag vraag) {
        this.vraag = vraag;
    }
    public void presentHint(){

        int randomNum = (int) (Math.random() * 2);
        if (randomNum == 0) {
            vraag.getHint().geefHint();
        } else {
            funnyHintProvider.geefHint();
        }
    }
}
