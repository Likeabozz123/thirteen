package xyz.gamars;

public class Cards {

    private int value;
    private String suit;
    private Cards card;
    public Cards() {
        card.value = 3;
        card.suit = "Spades";
    }
    public Cards(int value, String suit) {
        this.card.value = value;
        this.card.suit = suit;
    }
    public Cards getCard(){
        return this.card;
    }
    public int getValue() {
        return this.card.value;
    }
    public String getSuit() {
        return this.card.suit;
    }
    public void setValue(int newValue) {
        this.card.value = newValue;
    }
    public void setSuit(String newSuit) {
        this.card.suit = newSuit;
    }
    public void setCard(int newVal, String newSuit) {
        this.card.value = newVal;
        this.card.suit = newSuit;
    }


}
