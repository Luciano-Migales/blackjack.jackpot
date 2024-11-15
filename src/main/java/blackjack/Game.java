package blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    private Player dealer;
    private Scanner scanner;

    /**
     * Constructor for Game
     * @param playerNames List of player names
     */
    public Game(ArrayList<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        dealer = new Player("Dealer");
        deck = new Deck();
        scanner = new Scanner(System.in);
    }

    /**
     * Start the game
     */
    public void startGame() {
        while (true) {
            if (!handleBets()) break;
            dealInitialCards();
            playRound();
            determineWinner();
            
            System.out.println("Play another round? (Y/N)");
            if (!scanner.next().toUpperCase().equals("Y")) break;
            
            resetRound();
        }
    }

    /**
     * Handle betting phase
     * @return boolean indicating if betting was successful
     */
    private boolean handleBets() {
        for (Player player : players) {
            while (true) {
                System.out.printf("%s's balance: $%d%n", player.getName(), player.getBalance());
                if (player.getBalance() <= 0) {
                    System.out.println(player.getName() + " is out of money!");
                    return false;
                }
                
                System.out.print("Enter bet amount: ");
                int bet = scanner.nextInt();
                if (player.placeBet(bet)) break;
                
                System.out.println("Invalid bet amount. Try again.");
            }
        }
        return true;
    }

    /**
     * Deal initial cards to all players and dealer
     */
    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.drawCard(deck);
            }
            dealer.drawCard(deck);
        }
        
        // Show dealer's up card
        System.out.println("Dealer's up card: " + 
                         dealer.getHand().getCards().get(0));
    }

    /**
     * Play a round of the game
     */
    private void playRound() {
        // Player turns
        for (Player player : players) {
            handlePlayerTurn(player);
        }
        
        // Dealer's turn
        handleDealerTurn();
    }

    /**
     * Handle a player's turn
     * @param player The current player
     */
    private void handlePlayerTurn(Player player) {
        while (true) {
            int handValue = player.getHand().calculateHandValue();
            System.out.printf("%s's hand (%d): %s%n", 
                player.getName(), handValue, player.getHand().getCards());
            
            if (handValue > 21) {
                System.out.println(player.getName() + " busts!");
                return;
            }
            
            System.out.print("Hit or Stand? (H/S): ");
            if (scanner.next().toUpperCase().equals("S")) break;
            
            player.drawCard(deck);
        }
    }

    /**
     * Handle the dealer's turn
     */
    private void handleDealerTurn() {
        System.out.println("Dealer's hand: " + dealer.getHand().getCards());
        while (dealer.getHand().calculateHandValue() < 17) {
            dealer.drawCard(deck);
            System.out.println("Dealer draws: " + 
                             dealer.getHand().getCards());
        }
    }

    /**
     * Calculate hand value
     * @param hand The hand to calculate
     * @return int value of the hand
     */
    private int calculateHandValue(Hand hand) {
        return hand.calculateHandValue();
    }

    /**
     * Determine the winner of the round
     */
    private void determineWinner() {
        int dealerValue = calculateHandValue(dealer.getHand());
        
        for (Player player : players) {
            int playerValue = calculateHandValue(player.getHand());
            int bet = player.getBet();
            
            // Player busts
            if (playerValue > 21) {
                System.out.println(player.getName() + " loses $" + bet);
                continue;
            }
            
            // Dealer busts
            if (dealerValue > 21) {
                System.out.println(player.getName() + " wins $" + bet);
                player.addWinnings(2 * bet); // Player wins double their bet
                continue;
            }
            
            // Compare values
            if (playerValue > dealerValue) {
                System.out.println(player.getName() + " wins $" + bet);
                player.addWinnings(2 * bet);
            } else if (playerValue == dealerValue) {
                System.out.println(player.getName() + " ties with dealer.");
                player.addWinnings(bet); // Refund bet
            } else {
                System.out.println(player.getName() + " loses $" + bet);
            }
        }
    }

    /**
     * Reset the round for new game
     */
    private void resetRound() {
        for (Player player : players) {
            player.getHand().getCards().clear();
        }
        dealer.getHand().getCards().clear();
        deck.initializeDeck();
    }
}
