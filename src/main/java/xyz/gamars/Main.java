package xyz.gamars;

public class Main {

    public static void main(String[] args) {
        Card card = new Card();
        System.out.println(card);

        Card ten = new Card(Value.TEN, Suit.HEARTS);
        System.out.println(ten);
        System.out.println(ten.compare(new Card(Value.FOUR, Suit.SPADES)));
    }


}
