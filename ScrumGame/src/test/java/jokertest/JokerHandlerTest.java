package jokertest;

import joker.*;
import kamers.Kamer;
import org.junit.jupiter.api.*;
import usableitems.IUsableItem;
import utils.SpelerSession;

import java.util.List;

public class JokerHandlerTest {
    static SpelerStub spelerStub;
    static StatusStub statusStub;
    static KamerStub kamerStub;

    @BeforeAll
    static void setup() {
        kamerStub = new KamerStub();
        statusStub = new StatusStub(kamerStub);
        spelerStub = new SpelerStub(statusStub);
        SpelerSessionStub.setSpeler(spelerStub);
    }

    @Test
    void testHandleJokerUsage_withHintJoker() {
        HintJokerStub hintJoker = new HintJokerStub(false);
        spelerStub.setItems(List.of(hintJoker));
        JokerHandler.handleJokerUsage();
        Assertions.assertTrue(hintJoker.usedInCalled, "HintJoker should be used");
    }

    @Test
    void testHandleJokerUsage_withKeyJoker() {
        KeyJokerMock keyJoker = new KeyJokerMock();
        spelerStub.setItems(List.of(keyJoker));
        kamerStub.setType("DeDailyScrum");
        JokerHandler.handleJokerUsage();
        Assertions.assertTrue(keyJoker.usedInCalled, "KeyJoker should be used");
    }
}