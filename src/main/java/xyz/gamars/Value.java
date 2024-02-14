package xyz.gamars;

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
    private final int value;

    /**
     * Value constructor
     * @param value raw value of the card's value
     */
    Value(int value) {
        this.value = value;
    }

    /**
     * Returns the raw value of the card's value
     * @return raw value of the card's value
     */
    public int getValue() {
        return value;
    }
}
