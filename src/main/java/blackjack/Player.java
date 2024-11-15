package blackjack;

public class Player {
    private String name;
    private int bet;
    private int balance;
    private Hand hand;
    private static final int INITIAL_BALANCE = 100;

    /**
     * Constructor for Player
     * @param name The player's name
     */
    public Player(String name) {
        this.name = name;
        this.balance = INITIAL_BALANCE;
        this.hand = new Hand();
    }

    /**
     * Place a bet
     * @param amount The amount to bet
     * @return boolean indicating if bet was successful
     */
    public boolean placeBet(int amount) {
        if (amount <= balance && amount > 0) {
            this.bet = amount;
            this.balance -= amount;
            return true;
        }
        return false;
    }

    /**
     * Add winnings to balance
     * @param amount Amount won
     */
    public void addWinnings(int amount) {
        this.balance += amount;
    }

    /**
     * Draw a card from the deck
     * @param deck The deck to draw from
     */
    public void drawCard(Deck deck) {
        hand.addCard(deck.drawCard());
    }

    // Getters
    public String getName() { return name; }
    public int getBet() { return bet; }
    public int getBalance() { return balance; }
    public Hand getHand() { return hand; }
}
