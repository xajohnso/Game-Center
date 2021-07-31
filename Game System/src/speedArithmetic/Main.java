package speedArithmetic.main;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	static Deck deck = new Deck();
	static int firstAnswer = 0;
	static int secondAnswer = 0;
	static int counter = 0;
	static String tt = null;
	static String operation = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		startGame();
		do {
		firstProblem();
		problem(sc);
		deck.nextRound();
		
		} while(counter == 0);
		
		deck.score();
		sc.close();
		
	}
	
	public static void startGame() {
		deck.start();
		deck.nextRound();
	}
	
	//Creates the problem. Timer is set for 5 seconds; if individual answers before then the timer is stopped
	public static void problem(Scanner scanner) {
		System.out.println(deck.cardOneNum + operation + deck.cardTwoNum + " =");
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			public void run() {
				if (tt == null) {
				System.out.println("TIME!!" + deck.score()); counter++;
				} else {
					
				}
			}
		};
		
		timer.schedule(task, 5000);
		firstAnswer = scanner.nextInt();
		timer.cancel();
		problemCheck(scanner);
		
	}
	
	//Randomizes the operation used for each problem
	public static void firstProblem() {
	int ranNum = (int) (Math.random() * 3);
		switch (ranNum) {
		case 0:
			operation = " + ";
		break;
		
		case 1:
			operation = " - ";
		break;
		
		case 2:
			operation = " * ";
		break;
		
		}
	}
	
	//Similar to first problem. (ie. a + b = c - > c + d = e :: c is used in the new problem set)
	public static void secondProblem(Scanner scanner) {
		firstProblem();
		System.out.println(firstAnswer  + operation + deck.cardThree());
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			public void run() {
				if (tt == null) {
				System.out.println("TIME!!" + deck.score()); counter++;
				} else {
					
				}
			}
		};
		
		timer.schedule(task, 5000);
		secondAnswer = scanner.nextInt();
		timer.cancel();
		problemCheck2();
	}
	
	public static void problemCheck(Scanner sc) {
		switch(operation) {
		case " + ":
			boolean addCheck = firstAnswer == deck.cardTwoNum + deck.cardOneNum;
			if (addCheck == true) {
				secondProblem(sc);
			} else {
				System.out.println("Incorrect! Score: " + deck.score());
				counter++;
			}
		break;
		
		case " - ":
			boolean subtractCheck = firstAnswer == deck.cardOneNum - deck.cardTwoNum;
			if (subtractCheck == true) {
				secondProblem(sc);
			} else {
				System.out.println("Incorrect! Score: " + deck.score());
				counter++;
			}
		break;
		
		case " * ":
			boolean multiplicationCheck = firstAnswer == deck.cardOneNum * deck.cardTwoNum;
			if (multiplicationCheck == true) {
				secondProblem(sc);
			} else {
				System.out.println("Incorrect! Score: " + deck.score());			
				counter++;
			}
		break;
		}
	}
	
	public static void problemCheck2() {
		switch(operation) {
		case " + ":
			boolean addCheck = secondAnswer == firstAnswer + deck.cardThreeNum;
			if (addCheck == true) {
				
			} else {
				System.out.println("Incorrect! Score: " + deck.score());			
				counter++;
			}
		break;
		
		case " - ":
			boolean subtractCheck = secondAnswer == firstAnswer - deck.cardThreeNum;
			if (subtractCheck == true) {
				
			} else {
				System.out.println("Incorrect! Score: " + deck.score());
				counter++;
			}
		break;
		
		case " * ":
			boolean multiplicationCheck = secondAnswer == firstAnswer * deck.cardThreeNum;
			if (multiplicationCheck == true) {
				
			} else {
				System.out.println("Incorrect! Score: " + deck.score());			
				counter++;
			}
		break;
		}
	}

}
