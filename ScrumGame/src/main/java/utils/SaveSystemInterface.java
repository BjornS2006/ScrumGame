package utils;

import gamelogic.Speler;

public interface SaveSystemInterface {
    void saveGame(Speler speler);
    Speler loadGame();
    void reset();
}
