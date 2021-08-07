package upBelow;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


public class Deck {

	public LinkedList<String> deck = new LinkedList<String>();
	public HashMap<String, Integer> valueReference = new HashMap<String, Integer>();
	public HashMap<String, Integer> suitReference = new HashMap<String, Integer>();
	public String cardOne; public String cardTwo;
	public int c1N; public int c2N;
	public int s1N; public int s2N;
	public int counter = 0;
	
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
		suitReference();
	}
	
	public void getCards() {
		cardOne = deck.pollFirst();
		cardTwo = deck.pollFirst(); 
	}
	
	//Reference to help evaluate the numerical value of each card
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
		valueReference.put("Jack", 11);
		valueReference.put("Queen", 12);
		valueReference.put("King", 13);
	} 
	
	public void suitReference() {
		suitReference.put("H", 1);
		suitReference.put("C", 2);
		suitReference.put("D", 3);
		suitReference.put("S", 4);
	}
	
	
	public int score() {
		int score = 52 - deck.size();
		return score;
	}
	
	public void evalEasy(String choice) {
		//Numerical value of a card is placed into an int variable 
		c1N = valueReference.get(cardOne.substring(4));
		c2N = valueReference.get(cardTwo.substring(4));
		
		boolean ch1 = c1N > c2N;
		
		//After a choice (will next card value be higher or lower than current card?) there is a check between the values of two cards
		switch(choice){
		case "up":
			if (ch1 == true) {
				counter++;
				System.out.println("Incorrect! Score: " + score());
			} else {
				cardOne = cardTwo; cardTwo = deck.pollFirst();
			}
		break;
		
		case "below":
			if (ch1 == true) {
				cardOne = cardTwo; cardTwo = deck.pollFirst();
			} else {
				counter++;
				System.out.println("Incorrect! Score: " + score());
			}
		break;
		}
		
	}
	
	public void evalHard(String choice) {
		s1N = suitReference.get(cardOne.substring(0, 1));
		s2N = suitReference.get(cardTwo.substring(0, 1));
		c1N = valueReference.get(cardOne.substring(4));
		c2N = valueReference.get(cardTwo.substring(4));
		
		boolean sc1 = s1N > s2N; boolean sc2 = s1N == s2N; boolean nc1 = c1N > c2N;
		
		switch(choice) {
		case "up":
			if (sc1 == true) {
				counter++;
				System.out.println("Incorrect! Score: " + score());
				System.out.println("Card one: " + cardOne + " Card two: " + cardTwo);
			} else if (sc2 == true){
				if (nc1 == true) {
					counter++;
					System.out.println("Incorrec! Score: " + score());
					System.out.println("Card one: " + cardOne + " Card two: " + cardTwo);
				} else {
					cardOne = cardTwo; cardTwo = deck.pollFirst();
				}
			} else {
				cardOne = cardTwo; cardTwo = deck.pollFirst();
			}
		break;
		
		case "below":
			if (sc1 == true) {
				cardOne = cardTwo; cardTwo = deck.pollFirst();
			} else if (sc2 == true) {
				if (nc1 == true) {
					cardOne = cardTwo; cardTwo = deck.pollFirst();
				} else {
					counter++;
					System.out.println("Incorrect! Score: " + score());
					System.out.println("Card one: " + cardOne + " Card two: " + cardTwo);
				}
			} else {
				counter++;
				System.out.println("Incorrect! Score: " + score());
				System.out.println("Card one: " + cardOne + " Card two: " + cardTwo);
			}
		break;
		}
	}
}
		reference();
	}
	
	public void getCards() {
		cardOne = deck.pollFirst();
		cardTwo = deck.pollFirst(); 
	}
	
	//Reference to help evaluate the numerical value of each card
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
		valueReference.put("Jack", 11);
		valueReference.put("Queen", 12);
		valueReference.put("King", 13);
	} 
	
	
	public int score() {
		int score = 52 - deck.size();
		return score;
	}
	
	public void evalEasy(String choice) {
		//Numerical value of a card is placed into an int variable 
		c1N = valueReference.get(cardOne.substring(4));
		c2N = valueReference.get(cardTwo.substring(4));
		
		boolean ch1 = c1N > c2N;
		
		//After a choice (will next card value be higher or lower than current card?) there is a check between the values of two cards
		switch(choice){
		case "up":
			if (ch1 == true) {
				counter++;
				System.out.println("Incorrect! Score: " + score());
			} else {
				cardOne = cardTwo; cardTwo = deck.pollFirst();
			}
		break;
		
		case "below":
			if (ch1 == true) {
				cardOne = cardTwo; cardTwo = deck.pollFirst();
			} else {
				counter++;
				System.out.println("Incorrect! Score: " + score());
			}
		break;
		}
		
	}
}
