package gamelogic;

public class Main {


    public static void main(String[] args) {
        while(true) {
            GameStarter gameStarter = new GameStarter();
            gameStarter.printInstructies();
            gameStarter.startGame();
        }
    }
}


