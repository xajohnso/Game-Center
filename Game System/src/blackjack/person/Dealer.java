package blackjack.person;

import java.util.ArrayList;

import blackjack.deck.Deck;



public class Dealer extends Person{

	private ArrayList<String> dHand = new ArrayList<String>();
	
	public void showHand() {
		hand.forEach((k) -> dHand.add(k));
		System.out.println(" ::DEALER HAND::");
		for (int x = 1; x < dHand.size(); x++) {
			System.out.print(" :: " + dHand.get(x));
		}
		
	}
	
	public void play(Deck deck) {
		evaluation();
		if (getTotal() < 16) {
			hit(deck);
		} else {}
		
		total = 0;
	}
	
	public void evCheck(String card) {
		boolean ace = card.contains("Ace");
		
		if (ace == true) {		
			if ((total + 11) > 21) {
				total = total + 1;
			} else {
				total = total + 11;
			}
		} else {
		total = total + valueReference.get(card);
		}
	}
	public String dealerCheck(Player person) {
		String winner = null;
		evaluation(); int dealerValue = getTotal();
		person.evaluation(); int playerValue = person.getTotal();
		
		if (bust(playerValue) == true) {playerValue = 0;} else {}
		if (bust(dealerValue) == true) {dealerValue = 0;} else {}
		
		System.out.println("PLAYER: " + playerValue);
		System.out.println("DEALER: " + dealerValue);
		
		if (playerValue > dealerValue) {
			winner = "Player";
		} else if (dealerValue > playerValue){
			winner = "Dealer";
		} else {
			winner = "No";
		}
		
		return winner;
	}
	
	public void winner(String decision) {
		if (decision.contains("Player")) {
			System.out.println(" ::DEALER HAND::");
			hand.forEach((k) -> System.out.print(" :: " + k));
			System.out.println(" PLAYER WINS");
		} else if (decision.contains("Dealer")) {
			System.out.println(" ::DEALER HAND::");
			hand.forEach((k) -> System.out.print(" :: " + k));
			System.out.println(" DEALER WINS");
		} else if (decision.contains("No")) {
			System.out.println(" ::DEALER HAND::");
			hand.forEach((k) -> System.out.print(" :: " + k));
			System.out.println(" NO WINNER");
		} else {
			System.out.println(" ERROR");
		}
	}
	
	public void clearHand() {
		hand.removeAll(hand); 
		dHand.removeAll(dHand);
		total = 0;
	}
}
