package GameLogic;

import Kamers.*;

public class Game {
    public static Kamer maakEersteKamerAan () {
        DeSprintPlanning kamer1 = new DeSprintPlanning();
        return kamer1;
    }
    public static Kamer maakTweedeKamerAan() {
        DeDailyScrum kamer2 = new DeDailyScrum();
        return kamer2;
    }
    public static Kamer maakDerdeKamerAan() {
        HetScrumBoard kamer3 = new HetScrumBoard();
        return kamer3;
    }
    public static Kamer maakVierdeKamerAan() {
        DeSprintReview kamer4 = new DeSprintReview();
        return kamer4;
    }
    public static Kamer maakVijfdeKamerAan() {
        DeSprintRetrospective kamer5 = new DeSprintRetrospective();
        return kamer5;
    }
    public static Kamer maakLaatsteKamerAan() {
        Finale kamer6 = new Finale();
        return kamer6;
    }
}
