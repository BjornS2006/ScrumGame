package gamelogic;

import hintsysteem.HelpHintProvider;
import kamers.*;
import monster.Monster;
import monster.MonsterChallenge;
import utils.SpelerSession;
import vragen.*;

import java.util.*;

public class Game {

    private static int huidigKamerNummer = 0;

    public static int getHuidigKamerNummer() {
        return huidigKamerNummer;
    }
    public static void setHuidigKamerNummer(int nummer) {
        huidigKamerNummer = nummer;
    }

    private static void verhoogKamerNummer() {
        huidigKamerNummer++;
    }

    public static Kamer maakEersteKamerAan() {
        verhoogKamerNummer();
        MonsterChallenge challenge = new MonsterChallenge("Jon");
        Monster monster = new Monster("Jon", challenge);
        DeSprintPlanning kamer1 = new DeSprintPlanning(monster);
        // Open vraag - Sprint Planning
        OpenWeergave openWeergave = new OpenWeergave("Hoe heet het spel dat teamleden helpt bij het plannen van hun werk in een sprint?");
        OpenControle openControle = new OpenControle("Planning poker");
        HelpHintProvider openHelpHintProvider = new HelpHintProvider("Het wordt gespeeld met kaarten");
        Vraag openVraag = new Vraag(openWeergave, openControle, monster, openHelpHintProvider);

        // Meerkeuzevraag - Sprint Planning
        MeerkeuzeWeergave meerkeuzeWeergave = new MeerkeuzeWeergave("Wie is verantwoordelijk voor het uitleggen van de product backlog tijdens de Sprint Planning?");
        meerkeuzeWeergave.addAntwoord("A: Scrum Master");
        meerkeuzeWeergave.addAntwoord("B: Product Owner");
        meerkeuzeWeergave.addAntwoord("C: Ontwikkelteam");
        MeerkeuzeControle meerkeuzeControle = new MeerkeuzeControle("B");
        HelpHintProvider meerkeuzeHint = new HelpHintProvider("Deze persoon beheert de product backlog.");
        Vraag meerkeuzeVraag = new Vraag(meerkeuzeWeergave, meerkeuzeControle, monster, meerkeuzeHint);

        // Puzzelvraag - Sprint Planning
        List<String> begrippen = Arrays.asList(
            "Product Owner",
            "Sprint Goal",
            "Backlog",
            "Team",
            "Definition of Done"
        );
        List<String> betekenissen = Arrays.asList(
            "Bepaalt prioriteiten",
            "Doel van de sprint",
            "Lijst met taken",
            "Voert het werk uit",
            "Wanneer werk als af wordt beschouwd"
        );
        Map<String, String> mapping = new LinkedHashMap<>();
        for (int i = 0; i < begrippen.size(); i++) {
            mapping.put(begrippen.get(i), betekenissen.get(i));
        }
        List<String> shuffledBetekenissen = new ArrayList<>(betekenissen);
        Collections.shuffle(shuffledBetekenissen);
        StringBuilder correctAntwoord = new StringBuilder();
        for (int i = 0; i < begrippen.size(); i++) {
            String begrip = begrippen.get(i);
            int betekenisIndex = shuffledBetekenissen.indexOf(mapping.get(begrip));
            correctAntwoord.append((i+1)).append("-").append(betekenisIndex+1);
            if (i < begrippen.size() - 1) correctAntwoord.append(",");
        }
        PuzzelWeergave puzzelWeergave = new PuzzelWeergave();
        for (String begrip : begrippen) puzzelWeergave.addMatchItem(begrip);
        for (String betekenis : shuffledBetekenissen) puzzelWeergave.addTweedeMatchItem(betekenis);
        PuzzelControle puzzelControle = new PuzzelControle(correctAntwoord.toString());
        HelpHintProvider puzzelHint = new HelpHintProvider("Denk aan de rollen en doelen binnen de sprint planning.");
        Vraag puzzelVraag = new Vraag(puzzelWeergave, puzzelControle, monster, puzzelHint);

        // Observers en toevoegen aan kamer
        openVraag.addObserver(monster);
        openVraag.addObserver(SpelerSession.getSpeler().getStatus());
        meerkeuzeVraag.addObserver(monster);
        meerkeuzeVraag.addObserver(SpelerSession.getSpeler().getStatus());
        puzzelVraag.addObserver(monster);
        puzzelVraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer1.addVraag(openVraag);
        kamer1.addVraag(meerkeuzeVraag);
        kamer1.addVraag(puzzelVraag);

        // Monster meerkeuzevragen voor kamer 1
        MeerkeuzeWeergave m1 = new MeerkeuzeWeergave("Wat is een belangrijk resultaat van de Sprint Planning?");
        m1.addAntwoord("A: Een lijst met bugs");
        m1.addAntwoord("B: Een sprint backlog");
        m1.addAntwoord("C: Een release plan");
        MeerkeuzeControle c1 = new MeerkeuzeControle("B");
        HelpHintProvider h1 = new HelpHintProvider("Het team kiest werk uit de product backlog.");
        Vraag v1 = new Vraag(m1, c1, monster, h1);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v1);

        MeerkeuzeWeergave m2 = new MeerkeuzeWeergave("Wie bepaalt hoeveel werk het team oppakt in de sprint?");
        m2.addAntwoord("A: De Product Owner");
        m2.addAntwoord("B: Het team zelf");
        m2.addAntwoord("C: De Scrum Master");
        MeerkeuzeControle c2 = new MeerkeuzeControle("B");
        HelpHintProvider h2 = new HelpHintProvider("Het team is zelforganiserend.");
        Vraag v2 = new Vraag(m2, c2, monster, h2);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v2);

        return kamer1;
    }

    public static Kamer maakTweedeKamerAan() {
        verhoogKamerNummer();
        MonsterChallenge challenge = new MonsterChallenge("Mohammed");
        Monster monster = new Monster("Mohammed", challenge);
        DeDailyScrum kamer2 = new DeDailyScrum(monster);

        // Open vraag - Daily Scrum
        OpenWeergave openWeergave = new OpenWeergave("Wat geeft elk teamlid bij de daily scrum");
        OpenControle openControle = new OpenControle("Stand Up");
        HelpHintProvider openHelpHintProvider = new HelpHintProvider("Het teamlid staat hierbij even op.");
        Vraag openVraag = new Vraag(openWeergave, openControle, monster, openHelpHintProvider);

        // Meerkeuzevraag - Daily Scrum
        MeerkeuzeWeergave meerkeuzeWeergave = new MeerkeuzeWeergave("Hoe lang duurt een Daily Scrum over het algemeen ongeveer?");
        meerkeuzeWeergave.addAntwoord("A: 15 minuten");
        meerkeuzeWeergave.addAntwoord("B: 30 minuten");
        meerkeuzeWeergave.addAntwoord("C: 1 uur");
        MeerkeuzeControle meerkeuzeControle = new MeerkeuzeControle("A");
        HelpHintProvider meerkeuzeHint = new HelpHintProvider("Het is een kort, staand overleg.");
        Vraag meerkeuzeVraag = new Vraag(meerkeuzeWeergave, meerkeuzeControle, monster, meerkeuzeHint);

        // Puzzelvraag - Daily Scrum
        List<String> begrippen = Arrays.asList(
            "Daily Scrum",
            "Scrum Master",
            "Impediment",
            "Teamleden",
            "Sprint Backlog"
        );
        List<String> betekenissen = Arrays.asList(
            "Dagelijkse meeting",
            "Faciliteert het proces",
            "Belemmering voor voortgang",
            "Bespreken hun voortgang",
            "Taken voor de huidige sprint"
        );
        Map<String, String> mapping = new LinkedHashMap<>();
        for (int i = 0; i < begrippen.size(); i++) {
            mapping.put(begrippen.get(i), betekenissen.get(i));
        }
        List<String> shuffledBetekenissen = new ArrayList<>(betekenissen);
        Collections.shuffle(shuffledBetekenissen);
        StringBuilder correctAntwoord = new StringBuilder();
        for (int i = 0; i < begrippen.size(); i++) {
            String begrip = begrippen.get(i);
            int betekenisIndex = shuffledBetekenissen.indexOf(mapping.get(begrip));
            correctAntwoord.append((i+1)).append("-").append(betekenisIndex+1);
            if (i < begrippen.size() - 1) correctAntwoord.append(",");
        }
        PuzzelWeergave puzzelWeergave = new PuzzelWeergave();
        for (String begrip : begrippen) puzzelWeergave.addMatchItem(begrip);
        for (String betekenis : shuffledBetekenissen) puzzelWeergave.addTweedeMatchItem(betekenis);
        PuzzelControle puzzelControle = new PuzzelControle(correctAntwoord.toString());
        HelpHintProvider puzzelHint = new HelpHintProvider("Denk aan de dagelijkse afstemming en obstakels.");
        Vraag puzzelVraag = new Vraag(puzzelWeergave, puzzelControle, monster, puzzelHint);

        // Observers en toevoegen aan kamer
        openVraag.addObserver(monster);
        openVraag.addObserver(SpelerSession.getSpeler().getStatus());
        meerkeuzeVraag.addObserver(monster);
        meerkeuzeVraag.addObserver(SpelerSession.getSpeler().getStatus());
        puzzelVraag.addObserver(monster);
        puzzelVraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer2.addVraag(openVraag);
        kamer2.addVraag(meerkeuzeVraag);
        kamer2.addVraag(puzzelVraag);

        // Monster meerkeuzevragen voor kamer 2
        MeerkeuzeWeergave m3 = new MeerkeuzeWeergave("Wat wordt NIET besproken tijdens de Daily Scrum?");
        m3.addAntwoord("A: Wat je gisteren hebt gedaan");
        m3.addAntwoord("B: Wat je vandaag gaat doen");
        m3.addAntwoord("C: Lange termijn planning");
        MeerkeuzeControle c3 = new MeerkeuzeControle("C");
        HelpHintProvider h3 = new HelpHintProvider("De Daily Scrum is gericht op de komende 24 uur.");
        Vraag v3 = new Vraag(m3, c3, monster, h3);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v3);

        MeerkeuzeWeergave m4 = new MeerkeuzeWeergave("Wie mag de Daily Scrum faciliteren?");
        m4.addAntwoord("A: Iedereen in het team");
        m4.addAntwoord("B: Alleen de Scrum Master");
        m4.addAntwoord("C: Alleen de Product Owner");
        MeerkeuzeControle c4 = new MeerkeuzeControle("A");
        HelpHintProvider h4 = new HelpHintProvider("Het team is zelforganiserend, de Scrum Master faciliteert indien nodig.");
        Vraag v4 = new Vraag(m4, c4, monster, h4);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v4);

        return kamer2;
    }

    public static Kamer maakDerdeKamerAan() {
        verhoogKamerNummer();
        MonsterChallenge challenge = new MonsterChallenge("Ahmad");
        Monster monster = new Monster("Ahmad", challenge);
        HetScrumBoard kamer3 = new HetScrumBoard(monster);

        // Open vraag - Scrum Board
        OpenWeergave openWeergave = new OpenWeergave("Hoe heten de taken op op het scrum board?");
        OpenControle openControle = new OpenControle("User Stories");
        HelpHintProvider openHelpHintProvider = new HelpHintProvider("Ze beschrijven functionaliteit vanuit gebruikersperspectief.");
        Vraag openVraag = new Vraag(openWeergave, openControle, monster, openHelpHintProvider);

        // Meerkeuzevraag - Scrum Board
        MeerkeuzeWeergave meerkeuzeWeergave = new MeerkeuzeWeergave("Welke kolom op het Scrum Board geeft aan dat een taak nog niet gestart is?");
        meerkeuzeWeergave.addAntwoord("A: Done");
        meerkeuzeWeergave.addAntwoord("B: In Progress");
        meerkeuzeWeergave.addAntwoord("C: To Do");
        MeerkeuzeControle meerkeuzeControle = new MeerkeuzeControle("C");
        HelpHintProvider meerkeuzeHint = new HelpHintProvider("Het is de eerste stap op het bord.");
        Vraag meerkeuzeVraag = new Vraag(meerkeuzeWeergave, meerkeuzeControle, monster, meerkeuzeHint);

        // Puzzelvraag - Scrum Board
        List<String> begrippen = Arrays.asList(
            "To Do",
            "In Progress",
            "Done",
            "Peer review",
            "Task Card"
        );
        List<String> betekenissen = Arrays.asList(
            "Nog te doen",
            "Wordt aan gewerkt",
            "Afgerond",
            "Onderzoek door een collega",
            "Bevat een taakomschrijving"
        );
        Map<String, String> mapping = new LinkedHashMap<>();
        for (int i = 0; i < begrippen.size(); i++) {
            mapping.put(begrippen.get(i), betekenissen.get(i));
        }
        List<String> shuffledBetekenissen = new ArrayList<>(betekenissen);
        Collections.shuffle(shuffledBetekenissen);
        StringBuilder correctAntwoord = new StringBuilder();
        for (int i = 0; i < begrippen.size(); i++) {
            String begrip = begrippen.get(i);
            int betekenisIndex = shuffledBetekenissen.indexOf(mapping.get(begrip));
            correctAntwoord.append((i+1)).append("-").append(betekenisIndex+1);
            if (i < begrippen.size() - 1) correctAntwoord.append(",");
        }
        PuzzelWeergave puzzelWeergave = new PuzzelWeergave();
        for (String begrip : begrippen) puzzelWeergave.addMatchItem(begrip);
        for (String betekenis : shuffledBetekenissen) puzzelWeergave.addTweedeMatchItem(betekenis);
        PuzzelControle puzzelControle = new PuzzelControle(correctAntwoord.toString());
        HelpHintProvider puzzelHint = new HelpHintProvider("Denk aan de kolommen en elementen van het Scrum Board.");
        Vraag puzzelVraag = new Vraag(puzzelWeergave, puzzelControle, monster, puzzelHint);

        // Observers en toevoegen aan kamer
        openVraag.addObserver(monster);
        openVraag.addObserver(SpelerSession.getSpeler().getStatus());
        meerkeuzeVraag.addObserver(monster);
        meerkeuzeVraag.addObserver(SpelerSession.getSpeler().getStatus());
        puzzelVraag.addObserver(monster);
        puzzelVraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer3.addVraag(openVraag);
        kamer3.addVraag(meerkeuzeVraag);
        kamer3.addVraag(puzzelVraag);

        // Monster meerkeuzevragen voor kamer 3
        MeerkeuzeWeergave m5 = new MeerkeuzeWeergave("Waarom is het belangrijk dat het Scrum Board voor iedereen zichtbaar is?");
        m5.addAntwoord("A: Zodat iedereen weet wat de status van het werk is");
        m5.addAntwoord("B: Alleen de Scrum Master moet het zien");
        m5.addAntwoord("C: Het is alleen voor de Product Owner bedoeld");
        MeerkeuzeControle c5 = new MeerkeuzeControle("A");
        HelpHintProvider h5 = new HelpHintProvider("Transparantie is een kernwaarde van Scrum.");
        Vraag v5 = new Vraag(m5, c5, monster, h5);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v5);

        MeerkeuzeWeergave m6 = new MeerkeuzeWeergave("Wat is GEEN onderdeel van een Scrum Board?");
        m6.addAntwoord("A: To Do");
        m6.addAntwoord("B: In Progress");
        m6.addAntwoord("C: Sprint Review");
        MeerkeuzeControle c6 = new MeerkeuzeControle("C");
        HelpHintProvider h6 = new HelpHintProvider("Sprint Review is een event, geen kolom.");
        Vraag v6 = new Vraag(m6, c6, monster, h6);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v6);

        return kamer3;
    }

    public static Kamer maakVierdeKamerAan() {
        verhoogKamerNummer();
        MonsterChallenge challenge = new MonsterChallenge("Marcel");
        Monster monster = new Monster("Marcel", challenge);
        DeSprintReview kamer4 = new DeSprintReview(monster);

        // Open vraag - Sprint Review
        OpenWeergave openWeergave = new OpenWeergave("Welk begrip hoort bij het tonen van het opgeleverde werk aan stakeholders?");
        OpenControle openControle = new OpenControle("Demo");
        HelpHintProvider openHelpHintProvider = new HelpHintProvider("Het team laat het increment zien tijdens deze sessie.");
        Vraag openVraag = new Vraag(openWeergave, openControle, monster, openHelpHintProvider);

        // Meerkeuzevraag - Sprint Review
        MeerkeuzeWeergave meerkeuzeWeergave = new MeerkeuzeWeergave("Wie zijn aanwezig bij de Sprint Review?");
        meerkeuzeWeergave.addAntwoord("A: Alleen het ontwikkelteam");
        meerkeuzeWeergave.addAntwoord("B: Het team en stakeholders");
        meerkeuzeWeergave.addAntwoord("C: Alleen de Scrum Master");
        MeerkeuzeControle meerkeuzeControle = new MeerkeuzeControle("B");
        HelpHintProvider meerkeuzeHint = new HelpHintProvider("Ook belanghebbenden mogen feedback geven.");
        Vraag meerkeuzeVraag = new Vraag(meerkeuzeWeergave, meerkeuzeControle, monster, meerkeuzeHint);

        // Puzzelvraag - Sprint Review
        List<String> begrippen = Arrays.asList(
            "Sprint Review",
            "Stakeholder",
            "Increment",
            "Feedback",
            "Demo"
        );
        List<String> betekenissen = Arrays.asList(
            "Terugblik op de sprint",
            "Belanghebbende",
            "Opgeleverd product",
            "Terugkoppeling",
            "Presentatie van werk"
        );
        Map<String, String> mapping = new LinkedHashMap<>();
        for (int i = 0; i < begrippen.size(); i++) {
            mapping.put(begrippen.get(i), betekenissen.get(i));
        }
        List<String> shuffledBetekenissen = new ArrayList<>(betekenissen);
        Collections.shuffle(shuffledBetekenissen);
        StringBuilder correctAntwoord = new StringBuilder();
        for (int i = 0; i < begrippen.size(); i++) {
            String begrip = begrippen.get(i);
            int betekenisIndex = shuffledBetekenissen.indexOf(mapping.get(begrip));
            correctAntwoord.append((i+1)).append("-").append(betekenisIndex+1);
            if (i < begrippen.size() - 1) correctAntwoord.append(",");
        }
        PuzzelWeergave puzzelWeergave = new PuzzelWeergave();
        for (String begrip : begrippen) puzzelWeergave.addMatchItem(begrip);
        for (String betekenis : shuffledBetekenissen) puzzelWeergave.addTweedeMatchItem(betekenis);
        PuzzelControle puzzelControle = new PuzzelControle(correctAntwoord.toString());
        HelpHintProvider puzzelHint = new HelpHintProvider("Denk aan de onderdelen van de Sprint Review.");
        Vraag puzzelVraag = new Vraag(puzzelWeergave, puzzelControle, monster, puzzelHint);

        // Observers en toevoegen aan kamer
        openVraag.addObserver(monster);
        openVraag.addObserver(SpelerSession.getSpeler().getStatus());
        meerkeuzeVraag.addObserver(monster);
        meerkeuzeVraag.addObserver(SpelerSession.getSpeler().getStatus());
        puzzelVraag.addObserver(monster);
        puzzelVraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer4.addVraag(openVraag);
        kamer4.addVraag(meerkeuzeVraag);
        kamer4.addVraag(puzzelVraag);

        // Monster meerkeuzevragen voor kamer 4
        MeerkeuzeWeergave m7 = new MeerkeuzeWeergave("Wat is een belangrijk doel van de Sprint Review?");
        m7.addAntwoord("A: Feedback verzamelen");
        m7.addAntwoord("B: Nieuwe sprint plannen");
        m7.addAntwoord("C: Teamleden beoordelen");
        MeerkeuzeControle c7 = new MeerkeuzeControle("A");
        HelpHintProvider h7 = new HelpHintProvider("De Sprint Review draait om feedback op het increment.");
        Vraag v7 = new Vraag(m7, c7, monster, h7);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v7);

        MeerkeuzeWeergave m8 = new MeerkeuzeWeergave("Wie mogen feedback geven tijdens de Sprint Review?");
        m8.addAntwoord("A: Alleen het team");
        m8.addAntwoord("B: Alleen de Scrum Master");
        m8.addAntwoord("C: Ook stakeholders");
        MeerkeuzeControle c8 = new MeerkeuzeControle("C");
        HelpHintProvider h8 = new HelpHintProvider("Stakeholders zijn welkom om feedback te geven.");
        Vraag v8 = new Vraag(m8, c8, monster, h8);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v8);

        return kamer4;
    }

    public static Kamer maakVijfdeKamerAan() {
        verhoogKamerNummer();
        MonsterChallenge challenge = new MonsterChallenge("Fatima");
        Monster monster = new Monster("Fatima", challenge);
        DeSprintRetrospective kamer5 = new DeSprintRetrospective(monster);

        // Open vraag - Sprint Retrospective
        OpenWeergave openWeergave = new OpenWeergave("Welk Scrum-event draait om teamverbetering?");
        OpenControle openControle = new OpenControle("Retrospective");
        HelpHintProvider openHelpHintProvider = new HelpHintProvider("Het is het laatste event van de sprint.");
        Vraag openVraag = new Vraag(openWeergave, openControle, monster, openHelpHintProvider);

        // Meerkeuzevraag - Sprint Retrospective
        MeerkeuzeWeergave meerkeuzeWeergave = new MeerkeuzeWeergave("Wat wordt vaak besproken tijdens de Sprint Retrospective?");
        meerkeuzeWeergave.addAntwoord("A: Nieuwe features voor de volgende sprint");
        meerkeuzeWeergave.addAntwoord("B: Wat goed ging en wat beter kan");
        meerkeuzeWeergave.addAntwoord("C: Alleen technische problemen");
        MeerkeuzeControle meerkeuzeControle = new MeerkeuzeControle("B");
        HelpHintProvider meerkeuzeHint = new HelpHintProvider("Het gaat om reflectie.");
        Vraag meerkeuzeVraag = new Vraag(meerkeuzeWeergave, meerkeuzeControle, monster, meerkeuzeHint);

        // Puzzelvraag - Sprint Retrospective
        List<String> begrippen = Arrays.asList(
            "Retrospective",
            "Action Point",
            "Facilitator",
            "Teamleden",
            "Verbetering"
        );
        List<String> betekenissen = Arrays.asList(
            "Terugblik op proces",
            "Concrete afspraak",
            "Leidt de sessie",
            "Delen ervaringen",
            "Aanpassing voor volgende sprint"
        );
        Map<String, String> mapping = new LinkedHashMap<>();
        for (int i = 0; i < begrippen.size(); i++) {
            mapping.put(begrippen.get(i), betekenissen.get(i));
        }
        List<String> shuffledBetekenissen = new ArrayList<>(betekenissen);
        Collections.shuffle(shuffledBetekenissen);
        StringBuilder correctAntwoord = new StringBuilder();
        for (int i = 0; i < begrippen.size(); i++) {
            String begrip = begrippen.get(i);
            int betekenisIndex = shuffledBetekenissen.indexOf(mapping.get(begrip));
            correctAntwoord.append((i+1)).append("-").append(betekenisIndex+1);
            if (i < begrippen.size() - 1) correctAntwoord.append(",");
        }
        PuzzelWeergave puzzelWeergave = new PuzzelWeergave();
        for (String begrip : begrippen) puzzelWeergave.addMatchItem(begrip);
        for (String betekenis : shuffledBetekenissen) puzzelWeergave.addTweedeMatchItem(betekenis);
        PuzzelControle puzzelControle = new PuzzelControle(correctAntwoord.toString());
        HelpHintProvider puzzelHint = new HelpHintProvider("Denk aan reflectie en acties voor verbetering.");
        Vraag puzzelVraag = new Vraag(puzzelWeergave, puzzelControle, monster, puzzelHint);

        // Observers en toevoegen aan kamer
        openVraag.addObserver(monster);
        openVraag.addObserver(SpelerSession.getSpeler().getStatus());
        meerkeuzeVraag.addObserver(monster);
        meerkeuzeVraag.addObserver(SpelerSession.getSpeler().getStatus());
        puzzelVraag.addObserver(monster);
        puzzelVraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer5.addVraag(openVraag);
        kamer5.addVraag(meerkeuzeVraag);
        kamer5.addVraag(puzzelVraag);

        // Monster meerkeuzevragen voor kamer 5
        MeerkeuzeWeergave m9 = new MeerkeuzeWeergave("Wat is een actiepunt uit de Sprint Retrospective?");
        m9.addAntwoord("A: Een nieuwe user story");
        m9.addAntwoord("B: Een concrete verbetering voor het team");
        m9.addAntwoord("C: Een bugfix");
        MeerkeuzeControle c9 = new MeerkeuzeControle("B");
        HelpHintProvider h9 = new HelpHintProvider("Actiepunten zijn gericht op teamverbetering.");
        Vraag v9 = new Vraag(m9, c9, monster, h9);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v9);

        MeerkeuzeWeergave m10 = new MeerkeuzeWeergave("Wie nemen deel aan de Sprint Retrospective?");
        m10.addAntwoord("A: Alleen de Scrum Master");
        m10.addAntwoord("B: Het hele team");
        m10.addAntwoord("C: Alleen de Product Owner");
        MeerkeuzeControle c10 = new MeerkeuzeControle("B");
        HelpHintProvider h10 = new HelpHintProvider("De hele Scrum Team reflecteert samen.");
        Vraag v10 = new Vraag(m10, c10, monster, h10);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v10);

        return kamer5;
    }

    public static Kamer maakLaatsteKamerAan() {
        verhoogKamerNummer();
        MonsterChallenge challenge = new MonsterChallenge("Eindbaas");
        Monster monster = new Monster("Eindbaas", challenge);
        Finale kamer6 = new Finale(monster);

        // Open vraag - Waarom Scrum?
        OpenWeergave openWeergave = new OpenWeergave("Welk begrip dat te maken heeft met wendbaar zijn wordt vaak gebruikt in Scrum? (is een engels woord)");
        OpenControle openControle = new OpenControle("agile");
        HelpHintProvider openHelpHintProvider = new HelpHintProvider("Het is een term die vaak wordt gebruikt in softwareontwikkeling.");
        Vraag openVraag = new Vraag(openWeergave, openControle, monster, openHelpHintProvider);

        // Meerkeuzevraag - Waarom Scrum?
        MeerkeuzeWeergave meerkeuzeWeergave = new MeerkeuzeWeergave("Wat is een belangrijk voordeel van Scrum?");
        meerkeuzeWeergave.addAntwoord("A: Alles wordt vooraf vastgelegd en verandert nooit");
        meerkeuzeWeergave.addAntwoord("B: Snel kunnen inspelen op veranderingen");
        meerkeuzeWeergave.addAntwoord("C: Er is geen samenwerking nodig");
        MeerkeuzeControle meerkeuzeControle = new MeerkeuzeControle("B");
        HelpHintProvider meerkeuzeHint = new HelpHintProvider("Scrum is wendbaar en iteratief.");
        Vraag meerkeuzeVraag = new Vraag(meerkeuzeWeergave, meerkeuzeControle, monster, meerkeuzeHint);

        // Puzzelvraag - Waarom Scrum?
        List<String> begrippen = Arrays.asList(
            "Transparantie",
            "Aanpassingsvermogen",
            "Iteratie",
            "Samenwerking",
            "Feedback"
        );
        List<String> betekenissen = Arrays.asList(
            "Inzicht voor iedereen",
            "Snel reageren op verandering",
            "Korte cycli van verbetering",
            "Werken als team",
            "Leren van resultaten"
        );
        Map<String, String> mapping = new LinkedHashMap<>();
        for (int i = 0; i < begrippen.size(); i++) {
            mapping.put(begrippen.get(i), betekenissen.get(i));
        }
        List<String> shuffledBetekenissen = new ArrayList<>(betekenissen);
        Collections.shuffle(shuffledBetekenissen);
        StringBuilder correctAntwoord = new StringBuilder();
        for (int i = 0; i < begrippen.size(); i++) {
            String begrip = begrippen.get(i);
            int betekenisIndex = shuffledBetekenissen.indexOf(mapping.get(begrip));
            correctAntwoord.append((i+1)).append("-").append(betekenisIndex+1);
            if (i < begrippen.size() - 1) correctAntwoord.append(",");
        }
        PuzzelWeergave puzzelWeergave = new PuzzelWeergave();
        for (String begrip : begrippen) puzzelWeergave.addMatchItem(begrip);
        for (String betekenis : shuffledBetekenissen) puzzelWeergave.addTweedeMatchItem(betekenis);
        PuzzelControle puzzelControle = new PuzzelControle(correctAntwoord.toString());
        HelpHintProvider puzzelHint = new HelpHintProvider("Denk aan de kernwaarden en voordelen van Scrum.");
        Vraag puzzelVraag = new Vraag(puzzelWeergave, puzzelControle, monster, puzzelHint);

        // Observers en toevoegen aan kamer
        openVraag.addObserver(monster);
        openVraag.addObserver(SpelerSession.getSpeler().getStatus());
        meerkeuzeVraag.addObserver(monster);
        meerkeuzeVraag.addObserver(SpelerSession.getSpeler().getStatus());
        puzzelVraag.addObserver(monster);
        puzzelVraag.addObserver(SpelerSession.getSpeler().getStatus());
        kamer6.addVraag(openVraag);
        kamer6.addVraag(meerkeuzeVraag);
        kamer6.addVraag(puzzelVraag);

        // Monster meerkeuzevragen voor kamer 6
        MeerkeuzeWeergave m11 = new MeerkeuzeWeergave("Wat maakt Scrum geschikt voor veranderende eisen?");
        m11.addAntwoord("A: Vaste planningen");
        m11.addAntwoord("B: Iteratief werken en feedback");
        m11.addAntwoord("C: Geen communicatie");
        MeerkeuzeControle c11 = new MeerkeuzeControle("B");
        HelpHintProvider h11 = new HelpHintProvider("Scrum werkt in korte iteraties en gebruikt feedback.");
        Vraag v11 = new Vraag(m11, c11, monster, h11);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v11);

        MeerkeuzeWeergave m12 = new MeerkeuzeWeergave("Wat is een kernwaarde van Scrum?");
        m12.addAntwoord("A: Geheimhouding");
        m12.addAntwoord("B: Transparantie");
        m12.addAntwoord("C: Hiërarchie");
        MeerkeuzeControle c12 = new MeerkeuzeControle("B");
        HelpHintProvider h12 = new HelpHintProvider("Transparantie is essentieel in Scrum.");
        Vraag v12 = new Vraag(m12, c12, monster, h12);
        monster.getChallenge().getVraagBeheer().voegVraagToe(v12);

        return kamer6;
    }
    
}
