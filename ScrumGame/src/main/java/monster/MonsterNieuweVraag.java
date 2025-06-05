package monster;

public class MonsterNieuweVraag implements MonsterActie {
    private monsterVraagBeheer vraagBeheer;

    public MonsterNieuweVraag(monsterVraagBeheer vraagBeheer) {
        this.vraagBeheer = vraagBeheer;
    }
    //Dit deel van de code checkt of er nog vragen en antwoorden zijn ingevuld.
    public void checkVragenIngevult() {
        if (vraagBeheer.getVragen().isEmpty()) {
            System.out.println("Er zijn geen vragen toegevoegd.");
            return;
        }
        System.out.println("Deze vraag heeft een antwoord: " + vraagBeheer.getVragen());
    }
    public void checkAntwoordenIngevult() {
        if (vraagBeheer.getAntwoorden().isEmpty()) {
            System.out.println("Er zijn geen antwoorden toegevoegd.");
        } else
            System.out.println("Deze vraag heeft een antwoord: " + vraagBeheer.getAntwoorden());

        }
    @Override
    public void uitvoeren() {
        checkVragenIngevult();
        checkAntwoordenIngevult();
    }
    }
