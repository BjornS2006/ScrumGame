package monster;

public class MonsterChallenge {
    private MonsterVerschijning monsterVerschijning;
    private MonsterDobbelsteen monsterDobbelsteen;
    private MonsterNieuweVraag monsterNieuweVraag;
    private monsterVraagBeheer vraagBeheer;

    public MonsterChallenge(String monsterNaam) {
        monsterVerschijning = new MonsterVerschijning(monsterNaam);
        monsterDobbelsteen = new MonsterDobbelsteen();
        vraagBeheer = new monsterVraagBeheer();
        monsterNieuweVraag = new MonsterNieuweVraag(vraagBeheer);
    }

    public void startChallenge() {
        monsterVerschijning.uitvoeren();
        monsterDobbelsteen.uitvoeren();

        if (monsterDobbelsteen.getKeuze() == 1) {
            System.out.println("De monster geeft het correcte antwoord...");
            new MonsterAntwoordControle("Correcte Antwoord", vraagBeheer).uitvoeren();
        } else {
            monsterNieuweVraag.uitvoeren();
        }
    }
}