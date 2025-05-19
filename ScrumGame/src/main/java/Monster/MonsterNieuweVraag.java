package Monster;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MonsterNieuweVraag implements MonsterActie {
    private MonsterVraagBeheer vraagBeheer;

    public MonsterNieuweVraag(MonsterVraagBeheer vraagBeheer) {
        this.vraagBeheer = vraagBeheer;
    }
    //Dit deel van de code checkt of er nog vragen en antwoorden zijn ingevuld.
    public void CheckVragenIngevult() {
        if (vraagBeheer.getVragen().isEmpty()) {
            System.out.println("Er zijn geen vragen toegevoegd.");
            return;
        }
        System.out.println("Deze vraag heeft een antwoord: " + vraagBeheer.getVragen());
    }
    public void CheckAntwoordenIngevult() {
        if (vraagBeheer.getAntwoorden().isEmpty()) {
            System.out.println("Er zijn geen antwoorden toegevoegd.");
        } else
            System.out.println("Deze vraag heeft een antwoord: " + vraagBeheer.getAntwoorden());

        }
    @Override
    public void uitvoeren() {
        CheckVragenIngevult();
        CheckAntwoordenIngevult();
    }
    }
