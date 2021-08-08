package speedArithmetic;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	static Deck deck = new Deck();
	static int firstAnswer;
	static int secondAnswer;
	static int counter = 0;
	static String tt = null;
	static String operation = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		startGame();
		do {
		operation();
		problem(sc, firstAnswer, deck.cardOneNum, deck.cardTwoNum);
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
	public static void problem(Scanner scanner, int answer, int a, int b) {
		System.out.println(a + operation + b + " =");
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
		answer = scanner.nextInt();
		timer.cancel();
		
		 
		problemCheck(scanner, answer);
	}
	
	public static void problemTwo(Scanner scanner, int answer, int a, int b) {
		operation();
		System.out.println(a + operation + b + " =");
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
		answer = scanner.nextInt();
		timer.cancel();
		int newA = a;
		int newB = b;
		 
		problemCheck2(answer, newA, newB);
	}
	
	//Randomizes the operation used for each problem
	public static void operation() {
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
	
	public static void problemCheck(Scanner sc, int answer) {
		switch(operation) {
		case " + ":
			boolean addCheck = answer == deck.cardTwoNum + deck.cardOneNum;
			if (addCheck == true) {
				deck.cardThree();
				problemTwo(sc, secondAnswer, answer, deck.cardThreeNum);
			} else {
				System.out.println("Incorrect! Score: " + deck.score());
				counter++;
			}
		break;
		
		case " - ":
			boolean subtractCheck = answer == deck.cardOneNum - deck.cardTwoNum;
			if (subtractCheck == true) {
				deck.cardThree();
				problemTwo(sc, secondAnswer, answer, deck.cardThreeNum);
			} else {
				System.out.println("Incorrect! Score: " + deck.score());
				counter++;
			}
		break;
		
		case " * ":
			boolean multiplicationCheck = answer == deck.cardOneNum * deck.cardTwoNum;
			if (multiplicationCheck == true) {
				deck.cardThree();
				problemTwo(sc, secondAnswer, answer, deck.cardThreeNum);
			} else {
				System.out.println("Incorrect! Score: " + deck.score());			
				counter++;
			}
		break;
		}
	}
	
	public static void problemCheck2(int answer, int a, int b) {
		switch(operation) {
		case " + ":
			boolean addCheck = answer == a + b;
			if (addCheck == true) {
				
			} else {
				System.out.println("Incorrect! Answer: " + (a + b) + " Score: " + deck.score());			
				counter++;
			}
		break;
		
		case " - ":
			boolean subtractCheck = answer == a - b;
			if (subtractCheck == true) {
				
			} else {
				System.out.println("Incorrect! Answer: " + (a - b) + " Score: " + deck.score());
				counter++;
			}
		break;
		
		case " * ":
			boolean multiplicationCheck = answer == a * b;
			if (multiplicationCheck == true) {
				
			} else {
				System.out.println("Incorrect! Answer: " + (a * b) + " Score: " + deck.score());			
				counter++;
			}
		break;
		}
	}

}
