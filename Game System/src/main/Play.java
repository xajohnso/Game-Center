package main;

import java.util.Scanner;

public class Play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Which type of game would you like to play? 1) Cards 2) Dominoes 3) Chess");
		
		switch (scanner.nextInt()) {
		case 1: 
			System.out.println("1) Blackjack 2) BS 3) Speed 4) Uno 5) Set Memorization 6) Speed Arithmetic 7) Up Below");
			switch(scanner.nextInt()) {
			case 1:
				blackjack.Main.main(args);
			break;
			
			case 2:
				bs.Main.main(args);
			break;
			
			case 5:
				setMemorization.SMMain.main(args);
			break;
			
			case 6:
				speedArithmetic.Main.main(args);
			break;
			
			case 7:
				upBelow.Main.main(args);
			break;
			}
		break;
		
		case 2:
			dominoes.DominoesMain.main(args);
		break;
		
		case 3:
		break;
		default: break;
		}
		
		scanner.close();
		
	}

}
