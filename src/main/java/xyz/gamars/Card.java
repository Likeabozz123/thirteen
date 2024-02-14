package xyz.gamars;

public class Card {

    private Value value;
    private Suit suit;

    public Card() {
        this.value = Value.THREE;
        this.suit = Suit.SPADES;
    }
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public boolean compare(Card card) {
        if (this.value.getValue() > card.value.getValue()) return true;
        if (this.suit.getValue() > card.suit.getValue()) return true;
        return false;
    }

    @Override
    public String toString() {
        return this.value + " of " + this.suit;
    }
}
