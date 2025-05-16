package Kamers;

import Vragen.VraagType;

import java.util.ArrayList;
import java.util.Scanner;

public class Finale extends Kamer {
    private KamerVraagPresenter vraagPresenter;
    private KamerVraagManager vraagManager;

    public Finale() {
        super("Finale");
        vraagManager = new KamerVraagManager();
        vraagPresenter = new KamerVraagPresenter();
    }


    @Override
    public void enter() {
        System.out.println("Welkom in la grande finale.\uD83D\uDC12");
        System.out.println("Deze kamer gaat over waarom hebben we scrum nodig?");
        System.out.println("Beantwoord de volgende vraag:");
    }

    @Override
    public void stelVraag(Scanner scanner) {
        vraagPresenter.stelVragen(vraagManager, scanner);
    }
    public void addVraag (VraagType vraag) {
        vraagManager.addVraag(vraag);
    }

    @Override
    public void naarVolgendeKamer(Scanner scanner) {
        System.out.println("Je hebt het spel uitgespeeld!");
    }
}
