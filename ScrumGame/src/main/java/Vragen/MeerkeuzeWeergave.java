package Vragen;

import java.util.ArrayList;

public class MeerkeuzeWeergave implements VraagWeergaveStrategie {
    private String vraag;
    private ArrayList<String> antwoordMogelijkheden;

    public MeerkeuzeWeergave (String vraag) {
        this.vraag = vraag;
        antwoordMogelijkheden = new ArrayList<>();
    }
    @Override
    public void toonVraag() {
        for (String mogelijkheid : antwoordMogelijkheden) {
            System.out.println(mogelijkheid);
        }
    }
    public void addAntwoord (String antwoord) {
        antwoordMogelijkheden.add(antwoord);
    }
}
