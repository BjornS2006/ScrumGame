package monster;

import usableitems.IUsableItem;

import utils.SpelerInputHandler;
import utils.SpelerSession;
import vragen.Vraag;

import java.util.Iterator;


public class MonsterChallenge {
    private MonsterVerschijning monsterVerschijning;
    private MonsterVraagBeheer vraagBeheer;
    private HitMonster hitMonster;

    public MonsterChallenge(String monsterNaam) {
        monsterVerschijning = new MonsterVerschijning(monsterNaam);
        vraagBeheer = new MonsterVraagBeheer();
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
            int incorrectAnswerCount = 0;
            System.out.println("Je moet het monster verslaan door een vraag goed te beantwoorden!");
            System.out.println("Het monster stelt zijn eerste vraag...");
            for (Vraag vraag : vraagBeheer.getVragen()) {
                vraag.stelVraag();
                if (vraag.controleerAntwoord()) {
                    System.out.println("Correct! Je mag verder spelen.");
                    System.out.println("Het monster trekt zich terug...");
                    break;
                }
                else {
                    incorrectAnswerCount++;
                    if (incorrectAnswerCount == 2) {
                        System.out.println("Fout! Je hebt het monster niet kunnen verslaan. Je bent verslagen en wordt terug naar het begin gestuurd!");
                        SpelerSession.getSpeler().getStatus().resetNaarBegin();
                        System.exit(0);
                        return;
                    } else {
                        System.out.println("Fout! Je hebt nog 1 kans om een vraag goed te beantwoorden!");
                    }
                }
            }

        }
    }
    public MonsterVraagBeheer getVraagBeheer() {
        return vraagBeheer;
    }
}