package bs.player;

import java.util.ArrayList;
import java.util.Scanner;

import bs.deck.Deck;

public class Player {
	
	private int play = 0;
	
	private ArrayList<String> hand = new ArrayList<String>();
	private String[] cardPick;
	private int[] cP1;
	

	public void addCards(String card) {
		hand.add(card);
	}
	
	public int handSize() {
		return hand.size();
	}
	
	public void showHand() {
		for (int x = 0; x < hand.size(); x++) {
			System.out.println(x + ") " + hand.get(x));
		}
	}
	
	public void Play(Scanner scanner, Deck deck) {
		String choice = null;
		
		showHand();
		
		System.out.println("Pick cards to play. Format ie. 1-13-4");
		choice = scanner.next();
		cardPick = choice.split("-");
		cP1 = new int[cardPick.length];
		
		for (int x = 0; x < cardPick.length; x++) {
			cP1[x] = Integer.parseInt(cardPick[x]);
		}
		
		removeCards(deck);
		play++;
	}
	
	public void removeCards(Deck deck) {
		for (int x = 0; x < cP1.length; x++) {
			deck.addToCardPile(hand.get(cP1[x]));
			hand.remove(cP1[x]);
		}
	}
	
	public int getPlayNumber() {
		return play;
	}
}
