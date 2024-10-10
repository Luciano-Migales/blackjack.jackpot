package blackjack;

import java.util.ArrayList;

public class Game {
    protected ArrayList<Player> players;
    protected Deck deck;
    protected Player dealer;

    public Game(ArrayList<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name, 100));
        }
        dealer = new Player("Dealer", 0);
        deck = new Deck();
    }

    public void startGame() {
        System.out.println("Starting a new game...");
        for (Player player : players) {
            player.drawCard(deck);
        }
    }
}
