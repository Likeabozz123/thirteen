package xyz.gamars;

import xyz.gamars.card.Card;
import xyz.gamars.card.Suit;
import xyz.gamars.card.Value;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Card card = new Card();
        System.out.println(card);

        Card ten = new Card(Value.TEN, Suit.HEARTS);
        System.out.println(ten);
        System.out.println(ten.compare(new Card(Value.FOUR, Suit.SPADES)));

        ThirteenGame thirteenGame = new ThirteenGame();
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(ten);
        hand.add(ten);

        System.out.println("Can place cards: " + thirteenGame.placeCards(hand));

        ArrayList<Card> deck = thirteenGame.createDeck();
        System.out.println(deck);
        Collections.shuffle(deck);
        System.out.println(deck);
        System.out.println(thirteenGame.sortCards(deck));
    }


}
