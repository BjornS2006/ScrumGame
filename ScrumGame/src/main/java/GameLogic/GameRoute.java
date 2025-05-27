package GameLogic;

import Utils.SpelerInputHandler;
import Utils.SpelerSession;

public class GameRoute {
    public static void locatie() {

        switch (SpelerSession.getSpeler().getStatus().getPositie()) {
            case "Start", "De Sprint Planning":
                Game.maakEersteKamerAan().speelKamer();
                break;
            case "De Daily Scrum":
                Game.maakTweedeKamerAan().speelKamer();
                break;
            case "Het Scrum Board":
                Game.maakDerdeKamerAan().speelKamer();
                break;
            case "De Sprint Review":
                Game.maakVierdeKamerAan().speelKamer();
                break;
            case "De Sprint Retrospective":
                Game.maakVijfdeKamerAan().speelKamer();
                break;
            case "De Finale":
                Game.maakLaatsteKamerAan().speelKamer();
                break;
            default:
                System.out.println("Onbekende positie.");
                break;
        }
    }
}