package utils;

import usableitems.*;

import java.util.Random;

public class ItemGiver {
    private static Random rand = new Random();

    public static IUsableItem giveRandomItem() {
        int randomNumber = rand.nextInt(4);
        switch (randomNumber) {
            case 0:
                return new JeffDeAssistent();
            case 1:
                return new Komkommer();
            case 2:
                return new KamerInforBoek();
            case 3:
                return new Zwaard();
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
        }
    }
}