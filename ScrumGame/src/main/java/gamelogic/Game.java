package gamelogic;

import hintsysteem.HelpHintProvider;
import kamers.*;
import monster.Monster;
import monster.MonsterChallenge;
import utils.SpelerSession;
import vragen.*;

public class Game {

    public static Kamer maakEersteKamerAan() {
        DeSprintPlanning kamer1 = new DeSprintPlanning();
        MonsterChallenge challenge = new MonsterChallenge("Jon");
        Monster monster = new Monster("Jon", challenge);

        OpenWeergave openWeergave = new OpenWeergave("Wat voor soort spel spelen scrum teams bij de sprint planning?");
        OpenControle openControle = new OpenControle("Planning Poker");
        HelpHintProvider openHelpHintProvider = new HelpHintProvider("Het is een spel dat helpt bij het inschatten van werk.");
        Vraag openVraag = new Vraag(openWeergave, openControle, monster, openHelpHintProvider);

        MeerkeuzeWeergave weergave = new MeerkeuzeWeergave("Wat is 90 plus 3?");
        weergave.addAntwoord("A: 5");
        weergave.addAntwoord("B: 38");
        weergave.addAntwoord("C: 93");

        MeerkeuzeControle controle = new MeerkeuzeControle("C");
        HelpHintProvider helpHintProvider = new HelpHintProvider("s;kdmf");
        Vraag vraag = new Vraag(weergave, controle, monster, helpHintProvider);


        // Nieuwe random meerkeuzevraag 1
        MeerkeuzeWeergave weergave2 = new MeerkeuzeWeergave("Wat is de hoofdstad van Frankrijk?");
        weergave2.addAntwoord("A: Parijs");
        weergave2.addAntwoord("B: Londen");
        weergave2.addAntwoord("C: Berlijn");
        MeerkeuzeControle controle2 = new MeerkeuzeControle("A");
        HelpHintProvider helpHintProvider2 = new HelpHintProvider("Het is bekend om de Eiffeltoren.");
        Vraag monsterVraag1 = new Vraag(weergave2, controle2, monster, helpHintProvider2);
        monster.getChallenge().getVraagBeheer().voegVraagToe(monsterVraag1);

        // Nieuwe random meerkeuzevraag 2
        MeerkeuzeWeergave weergave3 = new MeerkeuzeWeergave("Welke planeet staat het dichtst bij de zon?");
        weergave3.addAntwoord("A: Venus");
        weergave3.addAntwoord("B: Mercurius");
        weergave3.addAntwoord("C: Mars");
        MeerkeuzeControle controle3 = new MeerkeuzeControle("B");
        HelpHintProvider helpHintProvider3 = new HelpHintProvider("Het is de kleinste planeet in ons zonnestelsel.");
        Vraag monsterVraag2 = new Vraag(weergave3, controle3, monster, helpHintProvider3);
        monster.getChallenge().getVraagBeheer().voegVraagToe(monsterVraag2);


        vraag.addObserver(monster);
        vraag.addObserver(SpelerSession.getSpeler().getStatus());
        openVraag.addObserver(monster);
        openVraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer1.addVraag(openVraag);
        kamer1.addVraag(vraag);
        SpelerSession.getSpeler().getStatus().setPositie("De Sprint Planning");

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
        HelpHintProvider helpHintProvider = new HelpHintProvider("a;oksmd");
        Vraag vraag = new Vraag(weergave, controle, monster, helpHintProvider);

        vraag.addObserver(monster);
        vraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer2.addVraag(vraag);
        SpelerSession.getSpeler().getStatus().setPositie("De Daily Scrum");

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
        HelpHintProvider helpHintProvider = new HelpHintProvider("gfdhjgkhj");
        Vraag vraag = new Vraag(weergave, controle, monster, helpHintProvider);


        vraag.addObserver(monster);
        vraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer3.addVraag(vraag);
        SpelerSession.getSpeler().getStatus().setPositie("Het Scrum Board");

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
        HelpHintProvider helpHintProvider = new HelpHintProvider("dgkh");
        Vraag vraag = new Vraag(weergave, controle, monster, helpHintProvider);


        vraag.addObserver(monster);
        vraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer4.addVraag(vraag);
        SpelerSession.getSpeler().getStatus().setPositie("De Sprint Review");

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
        HelpHintProvider helpHintProvider = new HelpHintProvider("ertoj");
        Vraag vraag = new Vraag(weergave, controle, monster, helpHintProvider);


        vraag.addObserver(monster);
        vraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer5.addVraag(vraag);
        SpelerSession.getSpeler().getStatus().setPositie("De Sprint Retrospective");

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
        HelpHintProvider helpHintProvider = new HelpHintProvider("qwtuop[");
        Vraag vraag = new Vraag(weergave, controle, monster, helpHintProvider);


        vraag.addObserver(monster);
        vraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer6.addVraag(vraag);
        SpelerSession.getSpeler().getStatus().setPositie("De Finale");

        return kamer6;
    }
    
}
