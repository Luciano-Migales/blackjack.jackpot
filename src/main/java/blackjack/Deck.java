package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                                         "Jack", "Queen", "King"};

    /**
     * Constructor for Deck
     */
    public Deck() {
        initializeDeck();
    }

    /**
     * Initialize the deck with all 52 cards
     */
    public void initializeDeck() {
        cards = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                cards.add(new Card(suit, rank));
            }
        }
        shuffleDeck();
    }

    /**
     * Shuffle the deck
     */
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    /**
     * Draw a card from the deck
     * @return Card drawn from the top
     */
    public Card drawCard() {
        if (cards.isEmpty()) {
            initializeDeck();
        }
        return cards.remove(0);
    }
}
