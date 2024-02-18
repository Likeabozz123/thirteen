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

        ArrayList<Card> bomb = new ArrayList<>();
        bomb.add(new Card(Value.THREE, Suit.SPADES));
        bomb.add(new Card(Value.THREE, Suit.CLUBS));
        bomb.add(new Card(Value.FOUR, Suit.SPADES));
        bomb.add(new Card(Value.FOUR, Suit.CLUBS));
        bomb.add(new Card(Value.FIVE, Suit.SPADES));
        bomb.add(new Card(Value.FIVE, Suit.CLUBS));
        System.out.println("Is " + bomb + " a valid bomb : " + thirteenGame.isValidBomb(bomb));

        // i got lazy and didnt label all this
        System.out.println(thirteenGame.canPlaceSingle(new Card(Value.THREE, Suit.CLUBS)));
        System.out.println(thirteenGame.canPlaceSingle(new Card(Value.TEN, Suit.CLUBS)));
        System.out.println(thirteenGame.canPlaceSingle(new Card()));

        System.out.println(thirteenGame.canPlacePair(pair));
        System.out.println(thirteenGame.canPlaceTriplet(triplet));
        System.out.println(thirteenGame.canPlaceQuartet(quartet));
        System.out.println(thirteenGame.canPlaceSequence(sequence));

        thirteenGame.clearPlacedCards();
        ArrayList<Card> placedCards = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        placedCards.add(new Card(Value.KING, Suit.SPADES));
        hand.add(new Card(Value.ACE, Suit.SPADES));

        thirteenGame.setPlacedCards(placedCards);
        System.out.println("Can " + hand + " be placed on " + thirteenGame.getPlacedCards() + " : " + thirteenGame.canPlaceCards(hand));

        placedCards.add(new Card(Value.KING, Suit.CLUBS));
        hand.add(new Card(Value.ACE, Suit.CLUBS));

        thirteenGame.setPlacedCards(placedCards);
        System.out.println("Can " + hand + " be placed on " + thirteenGame.getPlacedCards() + " : " + thirteenGame.canPlaceCards(hand));

        placedCards.add(new Card(Value.KING, Suit.DIAMONDS));
        hand.add(new Card(Value.SEVEN, Suit.DIAMONDS));

        thirteenGame.setPlacedCards(placedCards);
        System.out.println("Can " + hand + " be placed on " + thirteenGame.getPlacedCards() + " : " + thirteenGame.canPlaceCards(hand));

        placedCards.add(new Card(Value.KING, Suit.HEARTS));
        hand.add(new Card(Value.SEVEN, Suit.HEARTS));

        thirteenGame.setPlacedCards(placedCards);
        System.out.println("Can " + hand + " be placed on " + thirteenGame.getPlacedCards() + " : " + thirteenGame.canPlaceCards(hand));

        hand.clear();
        hand.add(new Card(Value.FIVE, Suit.DIAMONDS));
        hand.add(new Card(Value.FIVE, Suit.HEARTS));
        hand.add(new Card(Value.SIX, Suit.DIAMONDS));
        hand.add(new Card(Value.SIX, Suit.HEARTS));
        hand.add(new Card(Value.SEVEN, Suit.DIAMONDS));
        hand.add(new Card(Value.SEVEN, Suit.HEARTS));
        thirteenGame.clearPlacedCards();
        placedCards.clear();
        placedCards.add(new Card(Value.TWO, Suit.HEARTS));
        thirteenGame.setPlacedCards(placedCards);
        System.out.println("Can " + hand + " be placed on " + thirteenGame.getPlacedCards() + " : " + thirteenGame.canPlaceCards(hand));

    }

}
