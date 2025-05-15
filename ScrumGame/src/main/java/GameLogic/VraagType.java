package GameLogic;

import java.util.Scanner;

public interface VraagType {
    void stelVraag();
    void checkGoedAntwoord(Scanner scanner);
    String getVraagNaam();
    String getCorrecteAntwoord();
}
