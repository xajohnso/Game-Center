package blackjack;

import java.util.Scanner;

public class Main {
	
	static Deck deck = new Deck();
	static Player player = new Player();
	static Dealer dealer = new Dealer();

	public static void main(String[] args) {
		
		Scanner sn = new Scanner(System.in);
		
		deck.start();
		player.addMoney(300);
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
		
			player.showHand();
			betting(player, scanner);
		do {
			player.showHand();
			System.out.println("\n1) Hit or 2) Stand");
			
			switch(scanner.nextInt()) {
			case 1: 
				player.hit(deck);
			break;
			case 2:
				dealer.play(deck);
				player.winner(dealer.winner(dealer.dealerCheck(player)));
				
				System.out.println("Another round? 1) Yes 2) No");
				switch(scanner.nextInt()) {
				case 1: 
					player.resetBet(); player.clearHand(); dealer.clearHand(); 
					Start(deck, player, dealer);
					player.showHand();
					betting(player, scanner);
				break;
				case 2:
					dBust++;
				break;
				}
			break;
			}	
		} while(dBust < 1 || player.showMoney() <= 0);
	}
	
	public static void betting(Player player, Scanner scanner) {

		System.out.println("\n *** BETTING ***");
		if (player.showMoney() > 25) {
			player.takeMoney(25); player.increaseBet(25);
			System.out.println("Would you like to add to your bet? 1) Yes 2) No");
			switch (scanner.nextInt()) {
			case 1:
				bet(player, scanner);
			break;
			
			case 2:
				
			break;
			
			default:
				
			break;
			}
		} else {
			player.increaseBet(player.showMoney()); player.takeMoney(player.showMoney());
			System.out.println("Would you like to add to your bet? 1) Yes 2) No");
			switch (scanner.nextInt()) {
			case 1:
				bet(player, scanner);
			break;
			
			case 2:
		
			break;
			
			default:
				
			break;
			}
		}
		
	}
	
	public static void bet(Player player, Scanner scanner) {
		int counter = 0;
		
		System.out.println("Amount player has: " + player.showMoney() + "\nBet pool: " + player.showBet());
		System.out.println("How much would you like to bet? ");
		
		do {
		int amount = scanner.nextInt();
		if (amount < player.showMoney()) {
			player.increaseBet(amount); player.takeMoney(amount); counter++;
		} else {
			System.out.println("Invalid choice. How much would you like to add to your bet? Amount owned: " + player.showMoney());
			amount  = scanner.nextInt();
		}
		} while (counter < 1);
	}
	
}
