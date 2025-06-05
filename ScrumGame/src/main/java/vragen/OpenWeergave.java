package vragen;

public class OpenWeergave implements VraagWeergaveStrategie {
    private String vraag;

    public OpenWeergave (String vraag) {
        this.vraag = vraag;
    }

    @Override
    public void toonVraag() {
        System.out.println(vraag);
    }
}
