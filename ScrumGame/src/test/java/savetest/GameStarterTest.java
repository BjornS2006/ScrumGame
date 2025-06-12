package savetest;

import gamelogic.Speler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameStarterTest {
    static class GameStarterTestable extends gamelogic.GameStarter {
        private final SaveSystemStub saveSystem;
        private final GameRouteMock gameRouteMock;
        public GameStarterTestable(SaveSystemStub saveSystem, GameRouteMock gameRouteMock) {
            super();
            this.saveSystem = saveSystem;
            this.gameRouteMock = gameRouteMock;
        }
        @Override
        public void startGame() {
            gameRouteMock.locatie();
        }
    }

    @Test
    void testGameStarterWithStubAndMock() {
        SaveSystemStub saveStub = new SaveSystemStub();
        GameRouteMock routeMock = new GameRouteMock();
        Speler speler = saveStub.loadGame();
        GameStarterTestable starter = new GameStarterTestable(saveStub, routeMock);
        saveStub.saveGame(speler);
        starter.startGame();
        assertTrue(routeMock.locatieCalled, "GameRoute.locatie() should be called");
        assertEquals("Start", saveStub.loadGame().getStatus().getPositie());
        assertEquals(5, saveStub.loadGame().getStatus().getScore());
    }
}
