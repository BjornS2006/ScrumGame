package test;

import gamelogic.Game;
import utils.SpelerSession;

public class TestKamerNummer {

    public static void main(String[] args) {
        // Randwaarde 1
        Game.setHuidigKamerNummer(0);
        checkAantalKamers kamerchecker1 = new checkAantalKamers();
        int huidig1 = Game.getHuidigKamerNummer();
        boolean isInBereik1 = kamerchecker1.check(huidig1);
        if (isInBereik1) {
            System.out.println("TEST: " + huidig1 + " GELUKT, HOEREYYY!!!");
        } else {
            System.out.println("TEST: " + huidig1 + " Nope, compleet mislukt, het zit er of boven of onder de randwaarde.");
        }
        // Randwaarde 2
        Game.setHuidigKamerNummer(1);
        checkAantalKamers kamerchecker2 = new checkAantalKamers();
        int huidig2 = Game.getHuidigKamerNummer();
        boolean isInBereik2 = kamerchecker2.check(huidig2);
        if (isInBereik2) {
            System.out.println("TEST: " + huidig2 + " GELUKT, HOEREYYY!!!");
        } else {
            System.out.println("TEST: " + huidig2 + " Nope, compleet mislukt, het zit er of boven of onder de randwaarde.");
        }
        // Randwaarde 3
        Game.setHuidigKamerNummer(4);
        checkAantalKamers kamerchecker3 = new checkAantalKamers();
        int huidig3 = Game.getHuidigKamerNummer();
        boolean isInBereik3 = kamerchecker3.check(huidig3);
        if (isInBereik3) {
            System.out.println("TEST: " + huidig3 + " GELUKT, HOEREYYY!!!");
        } else {
            System.out.println("TEST: " + huidig3 + " Nope, compleet mislukt, het zit er of boven of onder de randwaarde.");
        }
        // Randwaarde 4
        Game.setHuidigKamerNummer(6);
        checkAantalKamers kamerchecker4 = new checkAantalKamers();
        int huidig4 = Game.getHuidigKamerNummer();
        boolean isInBereik4 = kamerchecker4.check(huidig4);
        if (isInBereik4) {
            System.out.println("TEST: " + huidig4 + " GELUKT, HOEREYYY!!!");
        } else {
            System.out.println("TEST: " + huidig4 + " Nope, compleet mislukt, het zit er of boven of onder de randwaarde.");
        }
        // Randwaarde 5
        Game.setHuidigKamerNummer(7);
        checkAantalKamers kamerchecker5 = new checkAantalKamers();
        int huidig5 = Game.getHuidigKamerNummer();
        boolean isInBereik5 = kamerchecker5.check(huidig5);
        if (isInBereik5) {
            System.out.println("TEST: " + huidig5 + " GELUKT, HOEREYYY!!!");
        } else {
            System.out.println("TEST: " + huidig5 + " Nope, compleet mislukt, het zit er of boven of onder de randwaarde.");
        }
    }
}
