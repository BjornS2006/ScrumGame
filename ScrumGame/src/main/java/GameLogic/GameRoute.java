package GameLogic;

import Kamers.Kamer;
import Utils.SpelerSession;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameRoute {
    private static final Map<String, Supplier<Kamer>> kamerMap = new HashMap<>();

    static {
        kamerMap.put("Start", Game::maakEersteKamerAan);
        kamerMap.put("De Sprint Planning", Game::maakEersteKamerAan);
        kamerMap.put("De Daily Scrum", Game::maakTweedeKamerAan);
        kamerMap.put("Het Scrum Board", Game::maakDerdeKamerAan);
        kamerMap.put("De Sprint Review", Game::maakVierdeKamerAan);
        kamerMap.put("De Sprint Retrospective", Game::maakVijfdeKamerAan);
        kamerMap.put("De Finale", Game::maakLaatsteKamerAan);
    }

    public static void locatie() {
        String positie = SpelerSession.getSpeler().getStatus().getPositie();
        Supplier<Kamer> kamerSupplier = kamerMap.get(positie);

        if (kamerSupplier != null) {
            kamerSupplier.get().speelKamer();
        } else {
            System.out.println("Onbekende positie.");
        }
    }
}