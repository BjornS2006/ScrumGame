package Monster;
import UsableItems.I_UsableItem;
import UsableItems.Zwaard;
import Utils.SpelerInputHandler;
import Utils.SpelerSession;

import java.util.ArrayList;

public class MonsterChallenge {
    private MonsterVerschijning monsterVerschijning;
    private MonsterDobbelsteen monsterDobbelsteen;
    private MonsterNieuweVraag monsterNieuweVraag;
    private HitMonster hitMonster;
    private MonsterVraagBeheer vraagBeheer;

    public MonsterChallenge(String monsterNaam) {
        monsterVerschijning = new MonsterVerschijning(monsterNaam);
        monsterDobbelsteen = new MonsterDobbelsteen();
        vraagBeheer = new MonsterVraagBeheer(new ArrayList<>(), new ArrayList<>());
        monsterNieuweVraag = new MonsterNieuweVraag(vraagBeheer);
        hitMonster = new HitMonster();
    }

    public void startChallenge() {
        monsterVerschijning.uitvoeren();
        boolean verslagen = false;
        for (I_UsableItem item : SpelerSession.getSpeler().getItems()) {
             if (item instanceof Zwaard) {
                 System.out.println("Wil je je zwaard gebruiken om te proberen het monster te verslaan? (j/n)");
                 if (SpelerInputHandler.spelerAntwoord().equals("j")) {
                     item.gebruik();
                     if (hitMonster.probeerMonsterHit()) {
                         System.out.println("Je hebt het monster geraakt met je zwaard!");
                         System.out.println("Het monster trekt zich terug...");
                         System.out.println("Het zwaard is gebroken en kan niet opnieuw gebruikt worden.");
                         verslagen = true;
                         SpelerSession.getSpeler().getItems().remove(item);
                     }
                     else {
                         System.out.println("Je hebt het monster niet geraakt!");
                         System.out.println("De challenge gaat door...");
                     }
                 }
             }
      }
        if (!verslagen) {
            monsterDobbelsteen.uitvoeren();

            if (monsterDobbelsteen.getKeuze() == 1) {
                System.out.println("De monster geeft het correcte antwoord...");
                new MonsterAntwoordControle("Correcte Antwoord", vraagBeheer).uitvoeren();
            } else {
                monsterNieuweVraag.uitvoeren();
            }
        }
    }
}