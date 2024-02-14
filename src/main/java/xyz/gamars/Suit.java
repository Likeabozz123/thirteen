package xyz.gamars;

public enum Suit {

    SPADES(1),
    CLUBS(2),
    DIAMONDS(3),
    HEARTS(4);

    /**
     * Raw value of the card's suit
     */
    private final int value;

    /**
     * Suit constructor
     * @param value raw value of the card's suit
     */
    Suit(int value) {
        this.value = value;
    }

    /**
     * Returns the raw value of the card's suit
     * @return raw value of the card suit
     */
    public int getValue() {
        return value;
    }
}
