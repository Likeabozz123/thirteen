package xyz.gamars;

public enum Suit {

    SPADES(1),
    CLUBS(2),
    DIAMONDS(3),
    HEARTS(4);

    private final int value;
    private Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
