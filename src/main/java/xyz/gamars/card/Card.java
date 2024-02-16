package xyz.gamars.card;

public class Card {

    /**
     * Value of the card
     */
    private Value value;

    /**
     * Suit of the card
     */
    private Suit suit;

    /**
     * Default card constructor
     * Automatically defaults to a 3 of Spades
     */
    public Card() {
        this.value = Value.THREE;
        this.suit = Suit.SPADES;
    }

    /**
     * Card constructor
     *
     * @param value value of the card
     * @param suit suit of the card
     */
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Gets the value of the card
     * @return value of the card
     */
    public Value getValue() {
        return value;
    }

    /**
     * Sets the value of the card
     * @param value value of the card
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * Gets the suit of the card
     * @return suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Sets the suit of the card
     * @param suit suit of the card
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * Sets the value and suit of the card
     * @param value value of the card
     * @param suit suit of the card
     */
    public void setCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Returns whether this card is overall greater than the given card
     * @param card the given card
     * @return whether card is greater
     */
    public boolean compare(Card card) {
        if (compareValue(card)) return true;
        if (this.value == card.value) {
            if (compareSuit(card)) return true;
            else return false;
        }

        return false;
    }

    /**
     * Returns whether this card has a higher suit than the given card
     * @param card the given card
     * @return whether the suit is greater
     */
    public boolean compareSuit(Card card) {
        if (this.suit.getRawValue() > card.getSuit().getRawValue()) return true;

        return false;
    }

    /**
     * Returns whether this value has a higher value than the given card
     * @param card the given card
     * @return whether the value is greater
     */
    public boolean compareValue(Card card) {
        if (this.value.getRawValue() > card.getValue().getRawValue()) return true;
        return false;
    }

    /**
     * Whether this card and the given card have the same value and same suit
     * @param card the given card
     * @return whether they are the same
     */
    public boolean equals(Card card) {

        if (this.getValue() != card.getValue()) return false;
        if (this.getSuit() != card.getSuit()) return false;

        return true;
    }

    /**
     * String version of the card
     * @return formatted string of the card
     */
    @Override
    public String toString() {
        return this.value + " of " + this.suit;
    }
}
