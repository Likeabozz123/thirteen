package xyz.gamars;

import xyz.gamars.card.Card;
import xyz.gamars.card.Suit;
import xyz.gamars.card.Value;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Game logic for Thirteen Game
 */
public class ThirteenGame {

    public ArrayList<Card> placedCards;

    public ThirteenGame() {
        this.placedCards = new ArrayList<>();
        this.placedCards.add(new Card()); // temp
    }

    /**
     * Sorts the cards from decreasing to increasing
     * Value comes first, then the suit comes second
     * @param cards cards to be sorted
     * @return sorted list of cards
     */
    public ArrayList<Card> sortCards(ArrayList<Card> cards) {
        for (int outer = 0; outer < cards.size() - 1; outer++) {
            for (int inner = 0; inner < cards.size() - outer - 1; inner++) {

                if (cards.get(inner).compare(cards.get(inner + 1))) {
                    Card temp = cards.get(inner);
                    cards.set(inner, cards.get(inner + 1));
                    cards.set(inner + 1, temp);
                }

            }
        }
        return cards;
    }

    /**
     * Returns whether the given cards are a valid sequence
     * @param cards cards that are being checked
     * @return whether the given cards are a given a valid sequence
     */
    public boolean isValidSequence(ArrayList<Card> cards) {
        if (cards.size() < 3) return false;

        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getValue().getRawValue() != cards.get(i + 1).getValue().getRawValue() - 1) return false;
        }

        return true;
    }

    /**
     * Returns whether the given cards are a valid pair
     * @param cards cards that are being checked
     * @return whether the given cards are a valid pair
     */
    public boolean isValidPair(ArrayList<Card> cards) {
        if (cards.size() != 2) return false;
        if (cards.get(0).getValue() != cards.get(1).getValue()) return false;

        return true;
    }

    /**
     * Returns whether the given cards are a valid triplet
     * @param cards cards that are being checked
     * @return whether the given cards are a valid triplet
     */
    public boolean isValidTriplet(ArrayList<Card> cards) {
        if (cards.size() != 3) return false;
        if ((cards.get(0).getValue() != cards.get(1).getValue())
                && (cards.get(0).getValue() != cards.get(2).getValue())) return false;

        return true;
    }

    /**
     * Returns whether the given cards are a valid quartet
     * @param cards cards that are being checked
     * @return whether the given cards are a valid quartet
     */
    public boolean isValidQuartet(ArrayList<Card> cards) {
        if (cards.size() != 4) return false;
        if ((cards.get(0).getValue() != cards.get(1).getValue())
                && (cards.get(0).getValue() != cards.get(2).getValue())
                && (cards.get(0).getValue() != cards.get(3).getValue())) return false;

        return true;
    }

    /**
     * Creates a deck of cards
     * @return list of cards
     */
    public ArrayList<Card> createDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (Value value : Value.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(value, suit));
            }
        }
        return deck;
    }




}
