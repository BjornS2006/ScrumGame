package Kamers;

import Vragen.Vraag;

import java.util.Scanner;

public class KamerVraagPresenter {
    public void stelVragen(KamerVraagManager vraagManager, Scanner scanner) {
        for (Vraag vraag : vraagManager.getVragen()) {
            vraag.stelVraag();
            vraag.controleerAntwoord(scanner);
        }
    }
}

