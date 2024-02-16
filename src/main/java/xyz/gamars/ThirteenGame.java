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
        this.placedCards.add(new Card(Value.FOUR, Suit.CLUBS)); // temp
        this.placedCards.add(new Card(Value.FIVE, Suit.DIAMONDS)); // temp
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
     * Will sort the cards first before checking if they are a valid sequence
     * @param cards cards that are being checked
     * @return whether the given cards are a given a valid sequence
     */
    public boolean isValidSequence(ArrayList<Card> cards) {
        if (cards.size() < 3) return false;
        sortCards(cards);

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
     * Returns whether the given cards are a valid pair
     * @param card1 card is being checked
     * @param card2 card is being checked
     * @return whether the given cards are a valid pair
     */
    public boolean isValidPair(Card card1, Card card2) {
        if (card1.getValue() != card2.getValue()) return false;

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
     * Returns whether the given cards are a valid bomb
     * @param cards the given cards
     * @return whether the given cards are a valid bomb
     */
    public boolean isValidBomb(ArrayList<Card> cards) {
        if (cards.size() != 6) return false;
        sortCards(cards);

        if (!(isValidPair(cards.get(0), cards.get(1))
                && isValidPair(cards.get(2), cards.get(3))
                && isValidPair(cards.get(4), cards.get(5)))) return false;

        ArrayList<Card> bombSequence = new ArrayList<>();
        bombSequence.add(cards.get(0));
        bombSequence.add(cards.get(2));
        bombSequence.add(cards.get(4));

        if (!isValidSequence(bombSequence)) return false;

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

    /**
     * Returns whether you can place the given single
     * @param cards the given single
     * @return whether you can place the given single
     */
    public boolean canPlaceSingle(ArrayList<Card> cards) {
        if (cards.size() != 1) return false;

        return canPlaceSingle(cards.get(0));
    }

    /**
     * Returns whether you can place the given single
     * @param card the given single
     * @return whether you can place the given single
     */
    public boolean canPlaceSingle(Card card) {
        if (placedCards.size() != 1) return false;

        if (placedCards.get(0).equals(card)) return false;
        if (placedCards.get(0).compare(card)) return false;

        return true;
    }

    /**
     * Returns whether you can place the given pair
     * @param cards the given pair
     * @return whether you can place the given pair
     */
    public boolean canPlacePair(ArrayList<Card> cards) {
        if (placedCards.size() != 2) return false;
        if (cards.size() != 2) return false;

        sortCards(placedCards);
        sortCards(cards);

        if (!isValidPair(placedCards)) return false;
        if (!isValidPair(cards)) return false;

        return compareMultipleCards(cards);

    }

    /**
     * Returns whether you can place the given triplet
     * @param cards the given triplet
     * @return whether you can place the given triplet
     */
    public boolean canPlaceTriplet(ArrayList<Card> cards) {
        if (placedCards.size() != 3) return false;
        if (cards.size() != 3) return false;

        sortCards(placedCards);
        sortCards(cards);

        if (!isValidTriplet(placedCards)) return false;
        if (!isValidTriplet(cards)) return false;

        return compareMultipleCards(cards);
    }

    /**
     * Returns whether you can place the given quartet
     * @param cards the given quartet
     * @return whether you can place the given quartet
     */
    public boolean canPlaceQuartet(ArrayList<Card> cards) {
        if (placedCards.size() != 4) return false;
        if (cards.size() != 4) return false;

        sortCards(placedCards);
        sortCards(cards);

        if (!isValidQuartet(placedCards)) return false;
        if (!isValidQuartet(cards)) return false;

        return compareMultipleCards(cards);
    }

    /**
     * Returns whether you can place the given sequence
     * @param cards the given sequence
     * @return whether you can place the given sequence
     */
    public boolean canPlaceSequence(ArrayList<Card> cards) {
        if (placedCards.size() < 3) return false;
        if (cards.size() < 3) return false;
        if (placedCards.size() != cards.size()) return false;

        sortCards(placedCards);
        sortCards(cards);

        if (!isValidSequence(placedCards)) return false;
        if (!isValidSequence(cards)) return false;

        return compareMultipleCards(cards);
    }

    /**
     * Returns whether you can place the given bomb
     * @param cards the given bomb
     * @return whether you can place the given bomb
     */
    public boolean canPlaceBomb(ArrayList<Card> cards) {
        if (placedCards.size() != 6) return false;
        if (cards.size() != 6) return false;

        sortCards(placedCards);
        sortCards(cards);

        if (!isValidBomb(placedCards)) return false;
        if (!isValidBomb(cards)) return true;

        return compareMultipleCards(cards);
    }


    /**
     * Returns whether the cards are greater than the placed cards
     * First checks if the cards are the same,
     *  if they are the same then we check the final cards and if they are a greater suit,
     *      then the cards given are greater.
     * If they are not the same then we compare the value of the given cards vs the placed cards,
     *  if the given cards have a greater value
     *      then the given cards are greater.
     * @param cards the given cards
     * @return whether the given cards are greater than the placed cards
     */
    public boolean compareMultipleCards(ArrayList<Card> cards) {
        if (placedCards.get(0).getValue() == cards.get(0).getValue()) {
            if (placedCards.get(placedCards.size() - 1).compareSuit(cards.get(cards.size() - 1))) return false;
            else return true;
        } else {
            if (placedCards.get(0).compareValue(cards.get(0))) return false;
            else return true;
        }
    }



}
