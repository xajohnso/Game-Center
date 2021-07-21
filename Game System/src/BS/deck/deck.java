package bs.deck;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

import bs.player.Player;

public class Deck{
	
	private LinkedList<String> deck = new LinkedList<String>();
	private LinkedList<String> cardPile = new LinkedList<String>();
	private HashSet<String> playHand = new HashSet<String>();
	
	public enum Suit{
		H, D, C, S
	}
	
	public enum Number{
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
	}
	
	// Creates a deck from enum classes Suit and Number
	public void makeDeck() {
		for (Suit Suit : bs.deck.Deck.Suit.values()) {
			for (Number Number: bs.deck.Deck.Number.values()) {
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
	
	public void dealDeck(Player player00, Player player01, Player player02, Player player03) {
		
		for (int x = 0; x < 4; x++) {
			switch(x) {
			case 1:
				dealHand(player01);
			break;
			
			case 2:
				dealHand(player02);
			break;
			
			case 3:
				dealHand(player03);
			break;
			
			case 0:
				dealHand(player00);
			break;
			
			default:
			break;
			}
		}
	}
	
	public void dealHand(Player player) {
		for (int x = 0; x < 13; x++) {
			player.addCards(deck.pollFirst());
		}
	}
	
	public void addToCardPile(String string) {
		cardPile.add(string);
		playHand.add(string);
	}
	
	public void clearPlayHand() {
		playHand.clear();
	}
	
}
