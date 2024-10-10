package blackjack;

import java.util.ArrayList;

public class Blackjack {
    public static void main(String[] args) {
        ArrayList<String> playerNames = new ArrayList<>();
        playerNames.add("Player1");
        playerNames.add("Player2");

        Game game = new Game(playerNames);
        game.startGame();
    }
}
