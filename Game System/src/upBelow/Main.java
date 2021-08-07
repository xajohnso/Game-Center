package upBelow;

import java.util.Scanner;

public class Main {

	static Deck deck = new Deck();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sn = new Scanner(System.in);
		start(sn);
		sn.close();
	}
	
	public static void start(Scanner scanner) {
		deck.start();
		System.out.println("1) Easy 2) Hard");
		switch(scanner.nextInt()) {
		case 1:
			easyMode(scanner);
		break;
		
		case 2:
			hardMode(scanner);
		break;
		
		default:
			System.out.println("Invalid choice.");
		break;
		}
	}
	
	public static void easyMode(Scanner scanner) {
		deck.getCards();
	
		do {
		System.out.println("Score: " + deck.score() + " Cards left: " + deck.deck.size());
		System.out.println("Current card: " + deck.cardOne);
		System.out.println("1) Up 2) Below");
		switch(scanner.nextInt()) {
		case 1:
			deck.evalEasy("up");
		break;
		
		case 2:
			deck.evalEasy("below");
		break;
		
		default:
		break;
		}
		} while(deck.counter == 0);
	}
	
	public static void hardMode(Scanner scanner) {
		deck.getCards();
		
		do {
		System.out.println("Score: " + deck.score() + " Cards left: " + deck.deck.size());
		System.out.println("Current card: " + deck.cardOne);
		System.out.println("1) Up 2) Below");
		switch(scanner.nextInt()) {
		case 1:
			deck.evalHard("up");
		break;
		
		case 2:
			deck.evalHard("below");
		break;
		
		default:
		break;
		}
		} while(deck.counter == 0);
		
	}

}
