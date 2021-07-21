package bs.main;

import java.util.Scanner;

import bs.deck.Deck;
import bs.player.Player;

public class Main {
	
	static Deck deck = new Deck();
	static Player player00 = new Player();
	static Player player01 = new Player();
	static Player player02 = new Player();
	static Player player03 = new Player();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Start();
		Rotation(sc);
		sc.close();
	}
	
	public static void Start() {
		deck.start();
		deck.dealDeck(player00, player01, player02, player03);
	}
	
	public static void Rotation(Scanner scanner) {
		for (int x = 0; x < 13; x++) {
			switch (x) {
			case 0:
				System.out.println("Card: Ace");
				pickPlayer(scanner);
			break;
			
			case 1:
				System.out.println("Card: 2");
				pickPlayer(scanner);
			break;
			
			case 2:
				System.out.println("Card: 3");
				pickPlayer(scanner);
			break;
			
			case 3:
				System.out.println("Card: 4");
				pickPlayer(scanner);
			break;
			
			case 4:
				System.out.println("Card: 5");
				pickPlayer(scanner);
			break;
			
			case 5:
				System.out.println("Card: 6");
				pickPlayer(scanner);
			break;
			
			case 6:
				System.out.println("Card: 7");
				pickPlayer(scanner);
			break;
			
			case 7:
				System.out.println("Card: 8");
				pickPlayer(scanner);
			break;
			
			case 8:
				System.out.println("Card: 9");
				pickPlayer(scanner);
			break;
			
			case 9:
				System.out.println("Card: 10");
				pickPlayer(scanner);
			break;
			
			case 10:
				System.out.println("Card: Jack");
				pickPlayer(scanner);
			break;
			
			case 11:
				System.out.println("Card: Queen");
				pickPlayer(scanner);
			break;
			
			case 12:
				System.out.println("Card: King");
				pickPlayer(scanner);
			break;
			}
			
			if (x == 13) {
				x = -1;
			}
		}
	}
	
	public static void pickPlayer(Scanner scanner) {
		boolean check00 = player00.getPlayNumber() == player03.getPlayNumber();
		boolean check01 = player01.getPlayNumber() < player00.getPlayNumber();
		boolean check02 = player02.getPlayNumber() < player03.getPlayNumber();
		boolean check03 = player03.getPlayNumber() < player00.getPlayNumber();
		
		if (check00 == true) {
			player00.Play(scanner, deck);
		}
		
		if (check01 == true){
			player01.Play(scanner, deck);
		}
		
		if (check02 == true) {
			player02.Play(scanner, deck);
		}
		
		if (check03 == true) {
			player03.Play(scanner, deck);
		}
	}

}
