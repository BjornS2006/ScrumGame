package Monster;
import java.util.ArrayList;

public class MonsterChallenge {
    private MonsterVerschijning monsterVerschijning;
    private MonsterDobbelsteen monsterDobbelsteen;
    private MonsterNieuweVraag monsterNieuweVraag;
    private MonsterVraagBeheer vraagBeheer;

    public MonsterChallenge(String monsterNaam) {
        monsterVerschijning = new MonsterVerschijning(monsterNaam);
        monsterDobbelsteen = new MonsterDobbelsteen();
        vraagBeheer = new MonsterVraagBeheer(new ArrayList<>(), new ArrayList<>());
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