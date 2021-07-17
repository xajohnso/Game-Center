package blackjack.person;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import blackjack.deck.Deck;

public class Person {

	protected LinkedList<String> hand = new LinkedList<String>();
	protected HashMap<String, Integer> valueReference = new HashMap<String, Integer>();
	protected int total = 0;
	
	public void hit(Deck deck) {
		hand.add(deck.deck.pollFirst());
	}
	
	public void showHand() {
		hand.forEach((k) -> System.out.print(" :: " + k));
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
	
	public void evaluation() {
		reference();
		hand.forEach((k) -> evCheck(k.substring(4)));
	}
	
	public void evCheck(String card) {
		boolean ace = card.contains("Ace");
		
		if (ace == true) {
			Scanner sn = new Scanner(System.in);
			System.out.println("1) 1 or 2) 11");
			int ac = sn.nextInt();
			switch(ac) {
			case 1: total = total + 1; break;
			
			case 2: total = total + 11; break;
			}
			sn.close();
		} else {
		total = total + valueReference.get(card);
		}
	}
	
	public int getTotal() {
		return total;
	}
	
	public Boolean bust(int pTotal) {
		boolean bust = pTotal > 21;
		return bust;
	}
}
