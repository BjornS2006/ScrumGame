package Kamers;

import Joker.Joker;

public class GewoneKamer extends Kamer {
    public GewoneKamer(String naam, Joker joker) {
        super(naam, joker);
    }

    @Override
    public void enter() {
        System.out.println("Je betreedt de kamer: " + naam);
    }

    @Override
    public void stelVraag() {
        vraagPresenter.stelVragen(vraagManager);
    }

    @Override
    public void naarVolgendeKamer() {
        System.out.println("Je verlaat de kamer en gaat verder.");
    }

    @Override
    public void geefSleutel() {
        throw new UnsupportedOperationException("Geen sleutel beschikbaar in deze kamer!");
    }
}
