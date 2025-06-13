package jokertest;

import gamelogic.Speler;
import gamelogic.Status;
import joker.*;
import org.junit.jupiter.api.*;
import savetest.SaveSystemStub;
import utils.SpelerSession;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JokerHandlerTest {
    static SpelerStub spelerStub;
    static StatusStub statusStub;
    static KamerStub kamerStub;

    @BeforeAll
    static void setup() {
        SpelerSession.clear();
        kamerStub = new KamerStub();
        statusStub = new StatusStub(kamerStub);
        spelerStub = new SpelerStub(statusStub);
        SpelerSessionStub.setSpeler(spelerStub);
        utils.SpelerSession.setSpeler(spelerStub);
    }

    @Test
    void testHandleJokerUsage_withHintJoker() {
        HintJokerStub hintJoker = new HintJokerStub();
        spelerStub.setItems(List.of(hintJoker));
        SpelerSession.getSpeler().getItems().add(new HintJoker());
        JokerHandler.handleJokerUsage();
        assertTrue(hintJoker.usedInCalled, "HintJoker should be used");
    }


    @Test
    void testHandleJokerUsage_withKeyJoker() {
        DeDailyScrumStub kamer = new DeDailyScrumStub();
        Status status = new Status(0, "De Daily Scrum", new SaveSystemStub());
        status.setActieveKamer(kamer);
        Speler speler = new Speler(status);
        KeyJoker keyJoker = new KeyJoker();
        speler.addItem(keyJoker);
        SpelerSession.setSpeler(speler);

        JokerHandlerStub jokerHandlerStub = new JokerHandlerStub();
        jokerHandlerStub.handleJokerUsage(kamer);

        assertTrue(kamer.skipRoomCalled, "skipRoom() should be called on the kamer when KeyJoker is used");
        assertTrue(jokerHandlerStub.handleJokerUsageCalled, "handleJokerUsage should be called");
        assertEquals(kamer, jokerHandlerStub.usedKamer, "Kamer should be passed to the handler");
    }
}