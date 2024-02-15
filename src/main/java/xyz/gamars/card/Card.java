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
     * Returns whether the card is greater than the given card
     * @param card the given card
     * @return whether card is greater
     */
    public boolean compare(Card card) {
        if (this.value.getRawValue() > card.value.getRawValue()) return true;
        if (this.value == card.value) {
            if (this.suit.getRawValue() > card.suit.getRawValue()) return true;
            else return false;
        }

        return false;
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
