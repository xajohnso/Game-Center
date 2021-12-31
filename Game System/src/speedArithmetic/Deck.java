package speedArithmetic;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


public class Deck {

	public  LinkedList<String> deck = new LinkedList<String>();
	protected HashMap<String, Integer> valueReference = new HashMap<String, Integer>();
	
	public String cardOne; public int cardOneNum;
	public String cardTwo; public int cardTwoNum;
	public String cardThree; public int cardThreeNum;
	
	public enum Suit{
		H, D, C, S
	}
	
	public enum Number{
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
	}
	
	
	// Creates a deck from enum classes Suit and Number
	public void makeDeck() {
		for (Suit Suit : Deck.Suit.values()) {
			for (Number Number: Deck.Number.values()) {
				this.deck.add(Suit + " - " + Number);
			}
		}
	}
	
	// Uses Collections class shuffle method
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	// Prints deck in console for confirmation
	public void showDeck() {
		for (int z = 0; z < deck.size(); z++) {
			System.out.println(deck.get(z));
		}
	}
	
	public void start() {
		makeDeck();
		shuffleDeck();
		reference();
	}
	
	public void getCards() {
		cardOne = deck.pollFirst(); cardOne = cardOne.substring(4);
		cardTwo = deck.pollFirst(); cardTwo = cardTwo.substring(4);
	}
	
	public void reference() {
		valueReference.put("Ace", 1);
		valueReference.put("Two", 2);
		valueReference.put("Three", 3);
		valueReference.put("Four", 4);
		valueReference.put("Five", 5);
		valueReference.put("Six", 6);
		valueReference.put("Seven", 7);
		valueReference.put("Eight", 8);
		valueReference.put("Nine", 9);
		valueReference.put("Ten", 10);
		valueReference.put("Jack", 10);
		valueReference.put("Queen", 10);
		valueReference.put("King", 10);
	} 
	
	public void cardNumber() {
		cardOneNum = valueReference.get(cardOne);
		cardTwoNum = valueReference.get(cardTwo);
	}
	
	public int cardThree() {
		cardThree = deck.pollFirst(); cardThree = cardThree.substring(4);
		cardThreeNum = valueReference.get(cardThree);
		return cardThreeNum;
	}
	
	public void nextRound() {
		getCards();
		cardNumber();
	}
	
	public int score() {
		int score = 52 - deck.size();
		
		return score;
	}
}
