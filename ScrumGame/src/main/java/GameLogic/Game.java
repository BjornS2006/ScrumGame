package GameLogic;

import Kamers.*;
import Monster.Monster;
import Monster.MonsterChallenge;
import Vragen.*;

import java.util.ArrayList;

public class Game {

    public static Kamer maakEersteKamerAan() {
        DeSprintPlanning kamer1 = new DeSprintPlanning();
        MonsterChallenge challenge = new MonsterChallenge("Jon");
        Monster monster = new Monster("Jon", challenge);

        MeerkeuzeWeergave weergave = new MeerkeuzeWeergave("Wat is 90 plus 3?");
        weergave.addAntwoord("A: 5");
        weergave.addAntwoord("B: 38");
        weergave.addAntwoord("C: 93");

        MeerkeuzeControle controle = new MeerkeuzeControle("C");

        Vraag vraag = new Vraag(weergave, controle, monster);
        kamer1.addVraag(vraag);

        return kamer1;
    }

    public static Kamer maakTweedeKamerAan() {
        DeDailyScrum kamer2 = new DeDailyScrum();
        MonsterChallenge challenge = new MonsterChallenge("Mohammed");
        Monster monster = new Monster("Mohammed", challenge);

        MeerkeuzeWeergave weergave = new MeerkeuzeWeergave("Wat is 4 plus 4?");
        weergave.addAntwoord("A: 1");
        weergave.addAntwoord("B: 8");
        weergave.addAntwoord("C: 36");

        MeerkeuzeControle controle = new MeerkeuzeControle("B");

        Vraag vraag = new Vraag(weergave, controle, monster);
        kamer2.addVraag(vraag);

        return kamer2;
    }

    public static Kamer maakDerdeKamerAan() {
        HetScrumBoard kamer3 = new HetScrumBoard();
        MonsterChallenge challenge = new MonsterChallenge("Ahmad");
        Monster monster = new Monster("Ahmad", challenge);

        MeerkeuzeWeergave weergave = new MeerkeuzeWeergave("Wat is 5 plus 5?");
        weergave.addAntwoord("A: 1");
        weergave.addAntwoord("B: 10");
        weergave.addAntwoord("C: 36");

        MeerkeuzeControle controle = new MeerkeuzeControle("B");

        Vraag vraag = new Vraag(weergave, controle, monster);
        kamer3.addVraag(vraag);

        return kamer3;
    }

    public static Kamer maakVierdeKamerAan() {
        DeSprintReview kamer4 = new DeSprintReview();
        MonsterChallenge challenge = new MonsterChallenge("Marcel");
        Monster monster = new Monster("Marcel", challenge);

        MeerkeuzeWeergave weergave = new MeerkeuzeWeergave("Wat is 20 plus helemaal niks?");
        weergave.addAntwoord("A: 1");
        weergave.addAntwoord("B: 20");
        weergave.addAntwoord("C: 36");

        MeerkeuzeControle controle = new MeerkeuzeControle("B");

        Vraag vraag = new Vraag(weergave, controle, monster);
        kamer4.addVraag(vraag);

        return kamer4;
    }

    public static Kamer maakVijfdeKamerAan() {
        DeSprintRetrospective kamer5 = new DeSprintRetrospective();
        MonsterChallenge challenge = new MonsterChallenge("Fatima");
        Monster monster = new Monster("Fatima", challenge);

        MeerkeuzeWeergave weergave = new MeerkeuzeWeergave("Wat is 7 plus 3?");
        weergave.addAntwoord("A: 10");
        weergave.addAntwoord("B: 13");
        weergave.addAntwoord("C: 9");

        MeerkeuzeControle controle = new MeerkeuzeControle("A");

        Vraag vraag = new Vraag(weergave, controle, monster);
        kamer5.addVraag(vraag);

        return kamer5;
    }

    public static Kamer maakLaatsteKamerAan() {
        Finale kamer6 = new Finale();
        MonsterChallenge challenge = new MonsterChallenge("Eindbaas");
        Monster monster = new Monster("Eindbaas", challenge);

        MeerkeuzeWeergave weergave = new MeerkeuzeWeergave("Wat is 12 keer 2?");
        weergave.addAntwoord("A: 22");
        weergave.addAntwoord("B: 24");
        weergave.addAntwoord("C: 26");

        MeerkeuzeControle controle = new MeerkeuzeControle("B");

        Vraag vraag = new Vraag(weergave, controle, monster);
        kamer6.addVraag(vraag);

        return kamer6;
    }
    
}
