package blackjack.main;

import java.util.Scanner;

import blackjack.deck.Deck;
import blackjack.person.Dealer;
import blackjack.person.Player;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Dbust = 0;
		int choice = 0;
		
		Deck deck = new Deck();
		deck.start();
		
		Player player00 = new Player();
		Dealer dealer = new Dealer();
		
		dealer.hit(deck); dealer.hit(deck); player00.hit(deck); player00.hit(deck);
		dealer.showHand(); 
		
		Scanner sn = new Scanner(System.in);
		
		do {
			System.out.println("1) Hit or 2) Stand");
			player00.showHand();
			choice = sn.nextInt();
			switch(choice) {
			case 1: 
				player00.hit(deck);
				player00.bust();
			break;
			case 2:
				dealer.play(deck);
				dealer.bust();
				dealer.dealerCheck(player00);
				Dbust++;
			break;
			}
			
		} while(Dbust < 1);
		
	}
	
}
