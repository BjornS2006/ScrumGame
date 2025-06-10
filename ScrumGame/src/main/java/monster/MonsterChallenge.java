package monster;

import usableitems.IUsableItem;

import usableitems.UsableItem;
import usableitems.Zwaard;
import utils.SpelerInputHandler;
import utils.SpelerSession;
import java.util.Iterator;


public class MonsterChallenge {
    private MonsterVerschijning monsterVerschijning;
    private MonsterDobbelsteen monsterDobbelsteen;
    private MonsterNieuweVraag monsterNieuweVraag;
    private monsterVraagBeheer vraagBeheer;
    private HitMonster hitMonster;

    public MonsterChallenge(String monsterNaam) {
        monsterVerschijning = new MonsterVerschijning(monsterNaam);
        monsterDobbelsteen = new MonsterDobbelsteen();
        vraagBeheer = new monsterVraagBeheer();
        monsterNieuweVraag = new MonsterNieuweVraag(vraagBeheer);
        hitMonster = new HitMonster();
    }

    public void startChallenge() {
        monsterVerschijning.uitvoeren();
        boolean verslagen = false;
        boolean heeftZwaard = false;

        for (IUsableItem item : SpelerSession.getSpeler().getItems()) {
            if (item instanceof usableitems.Zwaard) {
                heeftZwaard = true;
                break;
            }
        }
        Iterator<IUsableItem> iterator = SpelerSession.getSpeler().getItems().iterator();
        if (heeftZwaard) {
            while (iterator.hasNext()) {
                IUsableItem item = iterator.next();
                if (item instanceof usableitems.Zwaard) {
                    System.out.println("Wil je je zwaard gebruiken om te proberen het monster te verslaan? (j/n)");
                    if (SpelerInputHandler.spelerAntwoord().equals("j")) {
                        item.gebruik();
                        if (hitMonster.probeerMonsterHit()) {
                            System.out.println("Je hebt het monster geraakt met je zwaard!");
                            System.out.println("Het monster trekt zich terug...");
                            System.out.println("Het zwaard is gebroken en kan niet opnieuw gebruikt worden.");
                            verslagen = true;
                            iterator.remove();
                        } else {
                            System.out.println("Je hebt het monster niet geraakt!");
                            System.out.println("Je zwaard vliegt uit je hand en valt op de grond.");
                            System.out.println("De challenge gaat door...");
                            iterator.remove();
                        }
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