package blackjack.main;

import java.util.Scanner;

import blackjack.deck.Deck;
import blackjack.person.Dealer;
import blackjack.person.Player;

public class Main {
	
	static Deck deck = new Deck();
	static Player player = new Player();
	static Dealer dealer = new Dealer();

	public static void main(String[] args) {
		
		Scanner sn = new Scanner(System.in);
		
		deck.start();
		Start(deck, player, dealer);
		Play(deck, player, dealer, sn);
		
		sn.close();
		
		
	}
	
	public static void Start(Deck deck, Player player, Dealer dealer) {
		
		dealer.hit(deck); dealer.hit(deck);
		player.hit(deck); player.hit(deck);
		
		dealer.showHand();
	}
	
	public static void Play(Deck deck, Player player, Dealer dealer, Scanner scanner) {
		int dBust = 0;
		do {
			System.out.println("\n1) Hit or 2) Stand");
			player.showHand();
			switch(scanner.nextInt()) {
			case 1: 
				player.hit(deck);
			break;
			case 2:
				dealer.play(deck);
				dealer.winner(dealer.dealerCheck(player));
				
				System.out.println("Another round? 1) Yes 2) No");
				switch(scanner.nextInt()) {
				case 1: 
					player.clearHand(); dealer.clearHand();
					Start(deck, player, dealer);
				break;
				case 2:
					dBust++;
				break;
				}
			break;
			}	
		} while(dBust < 1);
	}
	
}
