package jokertest;

import kamers.Kamer;

public class JokerHandlerStub {
    public boolean handleJokerUsageCalled = false;
    public Kamer usedKamer = null;

    public void handleJokerUsage(Kamer kamer) {
        handleJokerUsageCalled = true;
        usedKamer = kamer;
        // Simulate KeyJoker usage
        if (kamer instanceof DeDailyScrumStub) {
            ((DeDailyScrumStub) kamer).skipRoom();
        }
    }
}