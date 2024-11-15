package blackjack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    /**
     * Constructor for Hand
     */
    public Hand() {
        cards = new ArrayList<>();
    }

    /**
     * Add a card to the hand
     * @param card The card to add
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Remove a card from the hand
     * @param card The card to remove
     */
    public void removeCard(Card card) {
        cards.remove(card);
    }

    /**
     * Calculate the total value of the hand
     * @return int representing the hand value
     */
    public int calculateHandValue() {
        int value = 0;
        int aces = 0;

        for (Card card : cards) {
            if (card.getRank().equals("Ace")) {
                aces++;
            }
            value += card.getValue();
        }

        // Adjust for aces
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }

        return value;
    }

    /**
     * Get the cards in the hand
     * @return ArrayList of cards
     */
    public ArrayList<Card> getCards() {
        return new ArrayList<>(cards); // Return a copy for encapsulation
    }
}
