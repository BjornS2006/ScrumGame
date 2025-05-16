package Kamers;

import Vragen.VraagType;

import java.util.Scanner;

public class KamerVraagPresenter {
    public void stelVragen(KamerVraagManager vraagManager, Scanner scanner) {
        for (VraagType vraag : vraagManager.getVragen()) {
            vraag.stelVraag();
        }
    }
}

