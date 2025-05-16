package Vragen;

public class VraagWeergave {
    public static void toonMeerVraag(MeerkeuzeVraag vraag) {
        System.out.println("Dit is: " + vraag.getVraagNaam() + "?");
        for (String mogelijkheid : vraag.getAntwoordMogelijkheden()) {
            System.out.println(mogelijkheid);
        }
    }

    static void toonOpenVraag(OpenVraag vraag) {
        System.out.println("Dit is: " + vraag.getVraagNaam() + "?");
    }
}
