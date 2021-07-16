package blackjack.deck;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {

	public  LinkedList<String> deck = new LinkedList<String>();
	
	public enum Suit{
		H, D, C, S
	}
	
	public enum Number{
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
	}
	
	// Creates a deck from enum classes Suit and Number
	public void makeDeck() {
		for (Suit Suit : blackjack.deck.Deck.Suit.values()) {
			for (Number Number: blackjack.deck.Deck.Number.values()) {
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
	}
}
