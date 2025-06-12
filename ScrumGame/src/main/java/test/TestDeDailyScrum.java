package test;

import kamers.DeDailyScrum;
import utils.SaveSystem;
import utils.SaveSystemInterface;
import utils.SpelerSession;
import gamelogic.Speler;

public class TestDeDailyScrum {

    public static void main(String[] args) {
        SaveSystemInterface saveSystem  =new SaveSystem();

        Speler testSpeler = saveSystem.loadGame();
        if (testSpeler.getStatus() != null) {
            testSpeler.getStatus().setSaveSystem(saveSystem);
        }
        SpelerSession.setSpeler(testSpeler);

        testSpeler.setAantalFoutenTest(4);
        checkAantalFouten foutenChecker = new checkAantalFouten();
        if (foutenChecker.check(SpelerSession.getSpeler().getAantalFoutenTest())) {
            System.out.println("TEST: int is in range");
        } else {
            System.out.println("TEST: int is buiten range");
        }

        testSpeler.setAantalFoutenTest(5);
        checkAantalFouten foutenChecker2 = new checkAantalFouten();
        if (foutenChecker.check(SpelerSession.getSpeler().getAantalFoutenTest())) {
            System.out.println("TEST: int is in range");
        } else {
            System.out.println("TEST: int is buiten range");
        }

        testSpeler.setAantalFoutenTest(50);
        checkAantalFouten foutenChecker3 = new checkAantalFouten();
        if (foutenChecker.check(SpelerSession.getSpeler().getAantalFoutenTest())) {
            System.out.println("TEST: int is in range");
        } else {
            System.out.println("TEST: int is buiten range");
        }

        testSpeler.setAantalFoutenTest(100);
        checkAantalFouten foutenChecker4 = new checkAantalFouten();
        if (foutenChecker.check(SpelerSession.getSpeler().getAantalFoutenTest())) {
            System.out.println("TEST: int is in range");
        } else {
            System.out.println("TEST: int is buiten range");
        }

        testSpeler.setAantalFoutenTest(101);
        checkAantalFouten foutenChecker5 = new checkAantalFouten();
        if (foutenChecker.check(SpelerSession.getSpeler().getAantalFoutenTest())) {
            System.out.println("TEST: int is in range");
        } else {
            System.out.println("TEST: int is buiten range");
        }
    }
}
