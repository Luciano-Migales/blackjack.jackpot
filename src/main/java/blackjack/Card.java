package blackjack;

public class Card {
    private final String suit;
    private final String rank;

    /**
     * Constructor for Card
     * @param suit The suit of the card
     * @param rank The rank of the card
     */
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Get the suit of the card
     * @return String representing the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Get the rank of the card
     * @return String representing the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * Get the value of the card for Blackjack
     * @return int value of the card
     */
    public int getValue() {
        switch (rank) {
            case "Ace": return 11;
            case "King":
            case "Queen":
            case "Jack": return 10;
            default: return Integer.parseInt(rank);
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
