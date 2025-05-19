package Vragen;

import java.util.Scanner;

public interface VraagControleStrategie {
    boolean checkGoedAntwoord(Scanner scanner);

    String getCorrectAntwoord();
}
