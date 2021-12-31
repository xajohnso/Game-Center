package setMemorization;

import java.util.Collections;
import java.util.LinkedList;


public class Deck {

	public LinkedList<String> deck = new LinkedList<String>();
	public String[][] nn = new String[17][3];
	public int score = 0;
	
	public enum Suit{
		H, D, C, S
	}
	
	public enum Number{
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
	}
	
	// Creates a deck from enum classes Suit and Number
	public void makeDeck() {
		for (Suit Suit : setMemorization.Deck.Suit.values()) {
			for (Number Number: setMemorization.Deck.Number.values()) {
				this.deck.add(Suit + " - " + Number);
			}
		}
	}
	
	// Uses Collections class shuffle method
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public String pullCard() {
		return deck.poll();
	}
	
	public void createSets() {
		for (int x = 0; x < 17; x++) {
			for (int y = 0; y < 3; y++) {
				nn[x][y] = pullCard();
			}
		}
		
	}
	
	public void start() {
		makeDeck(); shuffleDeck(); createSets();
	}
	
	
	
	public void printSets() {
		for (int x = 0; x < 17; x++) {
			System.out.println(" ");
			for (int y = 0; y < 3; y++) {
				 System.out.print(nn[x][y]);
			}
		}
	}
	
	public void printSet(int setNumber) {
		System.out.println("Set " + (setNumber + 1) + ": " + nn[setNumber][0] + " :: " + nn[setNumber][1] + " :: " + nn[setNumber][2]);
	}
	
	public String getSetCard(int set, int card) {
		return nn[set][card];
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int num) {
		this.score = num;
	}
}
