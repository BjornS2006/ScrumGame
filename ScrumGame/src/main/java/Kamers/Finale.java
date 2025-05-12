package Kamers;

import java.util.Scanner;

public class Finale extends Kamer {

    public Finale() {
        super("Finale");
    }


    @Override
    public void enter() {
        System.out.println("Welkom in la grande finale.\uD83D\uDC12");
        System.out.println("Deze kamer gaat over waarom hebben we scrum nodig?");
        System.out.println("Beantwoord de volgende vraag:");
    }

    @Override
    public void stelVraag(Scanner scanner) {

    }



    @Override
    public void naarVolgendeKamer(Scanner scanner) {
        System.out.println("Je hebt het spel uitgespeeld!");
    }
}
