package xyz.gamars.card;

public enum Value {

    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14),
    TWO(15);

    /**
     * Raw value of the card's value
     */
    private final int rawValue;

    /**
     * Value constructor
     * @param rawValue raw value of the card's value
     */
    Value(int rawValue) {
        this.rawValue = rawValue;
    }

    /**
     * Returns the raw value of the card's value
     * @return raw value of the card's value
     */
    public int getRawValue() {
        return rawValue;
    }

    @Override
    public String toString() {
        return super.toString().charAt(0) + super.toString().substring(1).toLowerCase();
    }
}
