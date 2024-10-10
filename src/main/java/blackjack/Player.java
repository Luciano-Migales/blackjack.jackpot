package blackjack;

public class Player {
    private String name;
    private Hand hand;
    private int balance;
    private int wins;

    public Player(String name, int balance) {
        this.name = name;
        this.hand = new Hand();
        this.balance = balance;
        this.wins = 0;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public int getBalance() {
        return balance;
    }

    public void drawCard(Deck deck) {
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
            hand.addCard(drawnCard);
        }
    }
}
