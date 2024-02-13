package xyz.gamars;

public class Cards {

    private int value;
    private Suit suit;

    public Cards() {
        this.value = 3;
        this.suit = Suit.SPADES;
    }
    public Cards(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setCard(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }


}
