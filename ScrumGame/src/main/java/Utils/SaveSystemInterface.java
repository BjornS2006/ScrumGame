package Utils;

import GameLogic.Speler;

public interface SaveSystemInterface {
    void saveGame(Speler speler);
    Speler loadGame();
    void Reset();
}

