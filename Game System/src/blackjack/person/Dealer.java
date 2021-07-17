package blackjack.person;

import blackjack.deck.Deck;

public class Dealer extends Person{

	public void showHand() {
		System.out.println("::DEALER HAND::");
		hand.forEach((k) -> System.out.print(":: " + k + " "));
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
			showHand();
			System.out.println("PLAYER WINS");
		} else if (decision.contains("Dealer")) {
			showHand();
			System.out.println("DEALER WINS");
		} else if (decision.contains("No")) {
			showHand();
			System.out.println("NO WINNER");
		} else {
			System.out.println("ERROR");
		}
	}
}
