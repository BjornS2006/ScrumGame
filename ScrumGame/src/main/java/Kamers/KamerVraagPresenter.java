package Kamers;

import HintSysteem.HintPresenter;
import Utils.SpelerInputHandler;
import Vragen.Vraag;

import java.util.Scanner;

public class KamerVraagPresenter {


    public void stelVragen(KamerVraagManager vraagManager) {
        for (Vraag vraag : vraagManager.getVragen()) {
            vraag.stelVraag();
            if (vraag.controleerAntwoord()){
                System.out.println("Volgende vraag!");
            } else {
                System.out.println("Wil je een hint?");
                String aapje = SpelerInputHandler.spelerAntwoord();
                if (aapje.equals("Ja")) {
                    HintPresenter hintPresenter = new HintPresenter(vraag);
                    hintPresenter.presentHint();
                }
            }
        }
    }
}

