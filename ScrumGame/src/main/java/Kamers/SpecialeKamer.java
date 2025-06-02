package Kamers;
import Joker.Joker;

public class SpecialeKamer extends Kamer {
    public SpecialeKamer(String naam, Joker joker) {
        super(naam, joker);
    }

    @Override
    public void enter() {
        System.out.println("Je betreedt een **speciale kamer**: " + naam);
    }

    @Override
    public void stelVraag() {
        System.out.println("Dit is een moeilijke kamer! Gebruik je KeyJoker?");
    }

    @Override
    public void naarVolgendeKamer() {
        System.out.println("De kamer vereist een sleutel om door te gaan.");
    }

    @Override
    public void geefSleutel() {
        System.out.println("Je hebt een sleutel gekregen in kamer: " + naam);
    }
}
