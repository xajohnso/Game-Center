package setMemorization;

import java.util.Scanner;

public class SMMain {

	static Deck deck = new Deck();
	static String[] setAnswer = new String[3];
	static int counter = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		
		deck.start();
		do { play(scanner, deck.getScore()); } while (counter == 0);
		
		System.out.println("Final Score: " + deck.getScore());
		
	}
	
	public static void answer(Scanner sn, int setNumber) {
		for (int x = 0; x < 3; x++) {
			System.out.println("Enter card " + (x + 1) + " for set " + (setNumber + 1) + ":");
			setAnswer[x] = sn.nextLine();
		}
	}
	
	public static void play(Scanner scanner, int score) {
		System.out.println("Newest set:");
		deck.printSet(score);
		
		for (int x = 0; x <= score; x++) {
			answer(scanner, x); check(x);
		}
		
		deck.setScore(deck.getScore() + 1);
	}
	
	public static void check(int set) {
		for (int x = 0; x < 3; x++) {
			if (deck.getSetCard(set, x).matches(setAnswer[x]) == true) {
				
			} else { counter++; break;}
		}
	}

}
