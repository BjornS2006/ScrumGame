package GameLogic;


import Utils.SaveSystem;
import Utils.SpelerSession;
import GameLogic.GameStarter;
import GameLogic.GameRoute;


public class Main {


    public static void main(String[] args) {
        System.out.println("boooooo");
        GameStarter gameStarter = new GameStarter();
        gameStarter.printInstructies();
        gameStarter.startGame();

        }
    }


