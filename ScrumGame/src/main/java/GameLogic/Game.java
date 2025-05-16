package GameLogic;

import Kamers.*;
import Monster.Monster;
import Vragen.MeerkeuzeVraag;

import java.util.ArrayList;

public class Game {
    public static Kamer maakEersteKamerAan () {
        DeSprintPlanning kamer1 = new DeSprintPlanning();
        Monster monster = new Monster("Jon");
        ArrayList <String> antwoordmogelijkheden = new  ArrayList <String>();
        antwoordmogelijkheden.add("A: 5");
        antwoordmogelijkheden.add("B: 38");
        antwoordmogelijkheden.add("C: 93");
        MeerkeuzeVraag meerkeuzeVraag = new MeerkeuzeVraag(monster,antwoordmogelijkheden, 2, "Wat is 90 plus 3?" );
        kamer1.addVraag(meerkeuzeVraag);
        return kamer1;
    }
    public static Kamer maakTweedeKamerAan() {
        DeDailyScrum kamer2 = new DeDailyScrum();
        Monster monster = new Monster("Mohammed");
        ArrayList <String> antwoordmogelijkheden = new  ArrayList <String>();
        antwoordmogelijkheden.add("A: 1");
        antwoordmogelijkheden.add("B: 8");
        antwoordmogelijkheden.add("C: 36");
        MeerkeuzeVraag meerkeuzeVraag = new MeerkeuzeVraag(monster,antwoordmogelijkheden, 1, "Wat is 4 plus 4?" );
        kamer2.addVraag(meerkeuzeVraag);
        return kamer2;
    }
    public static Kamer maakDerdeKamerAan() {
        HetScrumBoard kamer3 = new HetScrumBoard();
        Monster monster = new Monster("Ahmad");
        ArrayList <String> antwoordmogelijkheden = new  ArrayList <String>();
        antwoordmogelijkheden.add("A: 1");
        antwoordmogelijkheden.add("B: 10");
        antwoordmogelijkheden.add("C: 36");
        MeerkeuzeVraag meerkeuzeVraag = new MeerkeuzeVraag(monster,antwoordmogelijkheden, 1, "Wat is 5 plus 5?" );
        kamer3.addVraag(meerkeuzeVraag);
        return kamer3;
    }
    public static Kamer maakVierdeKamerAan() {
        DeSprintReview kamer4 = new DeSprintReview();
        Monster monster = new Monster("Marcel");
        ArrayList <String> antwoordmogelijkheden = new  ArrayList <String>();
        antwoordmogelijkheden.add("A: 1");
        antwoordmogelijkheden.add("B: 20");
        antwoordmogelijkheden.add("C: 36");
        MeerkeuzeVraag meerkeuzeVraag = new MeerkeuzeVraag(monster,antwoordmogelijkheden, 1, "Wat is 20 plus helemaal niks?" );
        kamer4.addVraag(meerkeuzeVraag);
        return kamer4;
    }
    public static Kamer maakVijfdeKamerAan() {
        DeSprintRetrospective kamer5 = new DeSprintRetrospective();
        return kamer5;
    }
    public static Kamer maakLaatsteKamerAan() {
        Finale kamer6 = new Finale();
        return kamer6;
    }
}
