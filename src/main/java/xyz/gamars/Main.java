package xyz.gamars;

import xyz.gamars.card.Card;
import xyz.gamars.card.Suit;
import xyz.gamars.card.Value;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ThirteenGame thirteenGame =  new ThirteenGame();
        ArrayList<Card> freshDeck = thirteenGame.createDeck();

        System.out.println("Fresh deck: " + freshDeck);
        ArrayList<Card> shuffledDeck = thirteenGame.createDeck();
        Collections.shuffle(shuffledDeck);
        System.out.println("Shuffled deck: " + shuffledDeck);
        ArrayList<Card> sortedCards = thirteenGame.sortCards(shuffledDeck);
        System.out.println("Sorted deck: " + sortedCards);

        Card fourSpades = new Card(Value.FOUR, Suit.SPADES);
        Card threeClubs = new Card(Value.THREE, Suit.CLUBS);
        System.out.println("Is " + threeClubs + " greater than " + fourSpades + " : " + threeClubs.compare(fourSpades));

        ArrayList<Card> sequence = new ArrayList<>();
        sequence.add(new Card(Value.THREE, Suit.SPADES));
        sequence.add(new Card(Value.FOUR, Suit.HEARTS));
        sequence.add(new Card(Value.FIVE, Suit.HEARTS));
        System.out.println("Is " + sequence + " a valid sequence : " + thirteenGame.isValidSequence(sequence));

        ArrayList<Card> pair = new ArrayList<>();
        pair.add(new Card(Value.THREE, Suit.SPADES));
        pair.add(new Card(Value.THREE, Suit.HEARTS));
        System.out.println("Is " + pair + " a valid pair : " + thirteenGame.isValidPair(pair));

        ArrayList<Card> triplet = new ArrayList<>();
        triplet.add(new Card(Value.THREE, Suit.SPADES));
        triplet.add(new Card(Value.THREE, Suit.HEARTS));
        triplet.add(new Card(Value.THREE, Suit.DIAMONDS));
        System.out.println("Is " + triplet + " a valid triplet : " + thirteenGame.isValidTriplet(triplet));

        ArrayList<Card> quartet = new ArrayList<>();
        quartet.add(new Card(Value.ACE, Suit.SPADES));
        quartet.add(new Card(Value.ACE, Suit.HEARTS));
        quartet.add(new Card(Value.ACE, Suit.DIAMONDS));
        quartet.add(new Card(Value.ACE, Suit.CLUBS));
        System.out.println("Is " + quartet + " a valid quartet : " + thirteenGame.isValidQuartet(quartet));

        System.out.println(thirteenGame.canPlaceSingle(new Card(Value.THREE, Suit.CLUBS)));
        System.out.println(thirteenGame.canPlaceSingle(new Card(Value.TEN, Suit.CLUBS)));
        System.out.println(thirteenGame.canPlaceSingle(new Card()));

        System.out.println(thirteenGame.canPlacePair(pair));
        System.out.println(thirteenGame.canPlaceTriplet(triplet));
        System.out.println(thirteenGame.canPlaceQuartet(quartet));
        System.out.println(thirteenGame.canPlaceSequence(sequence));
    }


}
