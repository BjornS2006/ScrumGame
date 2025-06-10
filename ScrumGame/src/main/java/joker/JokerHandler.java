package joker;

import kamers.Kamer;
import usableitems.IUsableItem;
import utils.SpelerSession;

public class JokerHandler {
    public static void handleJokerUsage() {
        Kamer kamer = SpelerSession.getSpeler().getStatus().getActieveKamer();
        IUsableItem joker = SpelerSession.getSpeler().getItems().stream()
            .filter(item -> item instanceof HintJoker || item instanceof KeyJoker)
            .findFirst().orElse(null);
        switch (joker) {
            case null -> {
                System.out.println("Je hebt geen joker om te gebruiken.");
            }
            case HintJoker hintJoker -> {
                if (!hintJoker.isUsed()) {
                    hintJoker.useIn(kamer);
                } else {
                    System.out.println("Je hebt de HintJoker al gebruikt.");
                }
            }
            case KeyJoker keyJoker -> {
                if (!(kamer instanceof kamers.DeDailyScrum || kamer instanceof kamers.DeSprintReview)) {
                    System.out.println("De KeyJoker kan alleen gebruikt worden in de Daily Scrum of Sprint Review kamer.");
                } else if (!keyJoker.isUsed()) {
                    keyJoker.useIn(kamer);
                } else {
                    System.out.println("Je hebt de KeyJoker al gebruikt.");
                }
            }
            default -> {
            }
        }
    }
}

