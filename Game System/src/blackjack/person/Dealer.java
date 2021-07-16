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
	}
	
	public void dealerCheck(Player person) {
		evaluation();
		person.evaluation();
		int playerValue = person.getTotal();
		int dealerValue = getTotal();
		boolean checkWin = playerValue > dealerValue;
		System.out.println(checkWin);
		if (checkWin == true) {
			System.out.println("Player wins");
		} else {
			System.out.println("Dealer wins");
		}
	}
}
