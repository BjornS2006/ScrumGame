package Monster;

public class MonsterChallenge {
    private MonsterVerschijning monsterVerschijning;
    private MonsterDobbelsteen monsterDobbelsteen;
    private MonsterNieuweVraag monsterNieuweVraag;

    public MonsterChallenge(String monsterNaam) {
        monsterVerschijning = new MonsterVerschijning(monsterNaam);
        monsterDobbelsteen = new MonsterDobbelsteen();
        monsterNieuweVraag = new MonsterNieuweVraag();
    }

    public void startChallenge() {
        monsterVerschijning.uitvoeren();
        monsterDobbelsteen.uitvoeren();

        if (monsterDobbelsteen.getKeuze() == 1) {
            System.out.println("De monster geeft het correcte antwoord...");
            new MonsterAntwoordControle("Correcte Antwoord").uitvoeren();
        } else {
            monsterNieuweVraag.uitvoeren();
        }
    }
}
