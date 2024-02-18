package xyz.gamars.card;

public enum Suit {

    SPADES(1),
    CLUBS(2),
    DIAMONDS(3),
    HEARTS(4);

    /**
     * Raw value of the card's suit
     */
    private final int rawValue;

    /**
     * Suit constructor
     * @param rawValue raw value of the card's suit
     */
    Suit(int rawValue) {
        this.rawValue = rawValue;
    }

    /**
     * Returns the raw value of the card's suit
     * @return raw value of the card suit
     */
    public int getRawValue() {
        return rawValue;
    }

    @Override
    public String toString() {
        return super.toString().charAt(0) + super.toString().substring(1).toLowerCase();
    }
}
