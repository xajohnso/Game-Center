package dominoes;

import java.util.HashMap;
import java.util.Scanner;

public class DominoesMain {

	static Dominoes dominoes = new Dominoes();
	static Player player1 = new Player(1); static Player player2 = new Player(2); 
	static Player player3 = new Player(3); static Player player4 = new Player(4);
	static HashMap<String, Integer> bc = new HashMap<String, Integer>();
	static String[][] board = new String[3][3];
	static int finish = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		startGame();
		firstRound();
		do {
			checkPlayer();
		} while (finish == 0);
		
	}
	
	public static void bcm() {
		bc.put("north", 0); bc.put("east", 0); bc.put("south", 0); bc.put("west", 0);
	}
	
	public static void makeBoard() {
		
		board[1][1] = "M"; board[1][0] = "W"; board[1][2] = "E";
		board[2][1] = "S"; board[0][1] = "N"; board[0][0] = " ";
		board[2][0] = " "; board[0][2] = " "; board[2][2] = " ";
		
	}
	
	public static void printBoard() {
		for (int x = 0; x < 3; x++) {
			System.out.println(" ");
			for (int y = 0; y < 3; y++) {
				System.out.print(board[x][y]);
			}
		}
	}
	
	public static void handingDominoes (Dominoes dominoes, Player player) {
		do { player.addDominoe(dominoes.getDominoe()); } while (player.getHandSize() < 7);
	}
	
	public static void dealingDominoes(Dominoes dominoes, Player player1, Player player2, Player player3, Player player4) {
		handingDominoes(dominoes, player1); handingDominoes(dominoes, player2); handingDominoes(dominoes, player3); handingDominoes(dominoes, player4);
	}
	
	public static void startGame() {
		dominoes.start(); makeBoard(); bcm();
		dealingDominoes(dominoes, player1, player2, player3, player4);
	}
	
	public static void firstRound() {
		if (player1.dominoeCheck("6:6") == true) {
			board[1][1] = "6"; board[1][0] = "6"; board[1][2] = "6";
			board[2][1] = "6"; board[0][1] = "6"; 
			bc.replace("north", 1); bc.replace("south", 1);
			player1.removeDominoe("6:6"); player2.changeCounter(1);
		} else if (player2.dominoeCheck("6:6") == true) {
			board[1][1] = "6"; board[1][0] = "6"; board[1][2] = "6";
			board[2][1] = "6"; board[0][1] = "6"; 
			bc.replace("north", 1); bc.replace("south", 1);
			player2.removeDominoe("6:6"); player3.changeCounter(1);
		} else if (player3.dominoeCheck("6:6") == true) {
			board[1][1] = "6"; board[1][0] = "6"; board[1][2] = "6";
			board[2][1] = "6"; board[0][1] = "6"; 
			bc.replace("north", 1); bc.replace("south", 1);
			player3.removeDominoe("6:6"); player4.changeCounter(1);
		} else if (player4.dominoeCheck("6:6") == true) {
			board[1][1] = "6"; board[1][0] = "6"; board[1][2] = "6";
			board[2][1] = "6"; board[0][1] = "6"; 
			bc.replace("north", 1); bc.replace("south", 1);
			player4.removeDominoe("6:6"); player1.changeCounter(1);
		} else {}
	}
	
	public static void checkPlayer() {
		if (player1.getCounter() == 1) {
			
			if (canPlay(player1) == true) {
			play(player1); player1.changeCounter(0); player2.changeCounter(1);
			} else { player1.changeCounter(0); player2.changeCounter(1); }
			
		} else if (player2.getCounter() == 1) {
			if (canPlay(player2) == true) {
			play(player2); player2.changeCounter(0); player3.changeCounter(1);
			} else { player2.changeCounter(0); player3.changeCounter(1); }
			
		} else if (player3.getCounter() == 1) {
			if (canPlay(player3) == true) {
				play(player3); player3.changeCounter(0); player4.changeCounter(1);
			} else { player3.changeCounter(0); player4.changeCounter(1); }
			
		} else if (player4.getCounter() == 1) {
			if (canPlay(player4) == true) {
			play(player4); player4.changeCounter(0); player1.changeCounter(1);
			} else { player4.changeCounter(0); player1.changeCounter(1); }
		} else {}
	}
	
	public static void play (Player player) {
		Scanner scanner = new Scanner(System.in);
		int term = 0;
		int location = 0;
		int dominoe = 0;
		do {
			player.showHand(); printBoard();
			player.choose();
			location = scanner.nextInt();
			switch(location) {
			
			case 1, 2, 3, 4:
				System.out.println("Which dominoe?");
				dominoe = scanner.nextInt();
				if (playCheck(location, dominoe, player) == true) { 
					playingDominoe(player.getDominoe(dominoe - 1), location);
					player.removeDominoe(player.getDominoe(dominoe - 1));
					calculateScore(player);
					term++;
				}
			break;
			
			default:
				System.out.println("Invalid choice");
			break;
			}
			
		} while (term == 0);
		
	}
	
	public static void playingDominoe(String dominoe, int location) {
		
		String n = gn(location);
		
		String[] numbers = dominoe.split(":");
		if (numbers[0].contentEquals(numbers[1]) == true) {
			switch(location) {
			case 1: bc.replace("north", 2); break;
			
			case 2: bc.replace("east", 2); break;
			
			case 3: bc.replace("south", 2); break;
			
			case 4: bc.replace("west", 2); break;
			}
		} else {
			switch(location) {
			case 1:
				if (n.contains(numbers[0])) {board[0][1] = numbers[1]; bc.replace("north", 1); }
				else {board[0][1] = numbers[0]; bc.replace("north", 1);}
			break;
			
			case 2:
				if (n.contains(numbers[0]) == true) {board[1][2] = numbers[1]; bc.replace("east", 1); }
				else {board[1][2] = numbers[0]; bc.replace("east", 1); }
			break;
			
			case 3:
				if (n.contains(numbers[0])) {board[2][1] = numbers[1]; bc.replace("south", 1); }
				else {board[2][1] = numbers[0]; bc.replace("south", 1);}
			break;
			
			case 4:
				if (n.contains(numbers[0])) {board[1][0] = numbers[1]; bc.replace("west", 1); }
				else {board[1][0] = numbers[0]; bc.replace("west", 1);}
			break;
			}
		}
	}
	
	public static String gn (int location) {
		String d = null;
		switch (location) {
		case 1: d = board[0][1]; break;
		case 2: d = board[1][2]; break;
		case 3: d = board[2][1]; break;
		case 4: d = board[1][0]; break;
		}
		return d;
	}
	
	public static boolean canPlay(Player player) {
		boolean cp = false;
		String[] ends = {board[0][1], board[1][2], board[2][1], board[1][0]};
		
		String[] dominoes = player.returnHand();
		
		for (int x = 0; x < ends.length; x++) {
			for (int y = 0; y < dominoes.length; y++) {
				if (dominoes[y].contains(ends[x]) == true) { cp = true; }
			}
		}
		
		return cp;
	}
	
	public static boolean playCheck(int location, int dominoe, Player player) {
		String l = null;
		String d = player.getDominoe(dominoe - 1);
		boolean check = false;
		switch (location) {
		case 1:
			l = board[0][1];
			if (d.contains(l) == true) { check = true; }
		break;
		
		case 2:
			l = board[1][2];
			if (d.contains(l) == true) { check = true; }
		break;
		
		case 3:
			l = board[2][1];
			if (d.contains(l) == true) { check = true; }
		break;
		
		case 4:
			l = board[1][0];
			if (d.contains(l) == true) { check = true; }
		break;
		}
		
		return check;
	}
	
	public static void calculateScore (Player player) {
		
		int sum = 0; String b = null; String d = null;
		String[] ends = {board[0][1], board[1][2], board[2][1], board[1][0]};
		String[] en = {"north", "east", "south", "west"};
		
		for (int x = 0; x < ends.length; x++) {
			b = ends[x]; d = en[x];
			
			if (bc.get(d) == 0) {}
			else if (bc.get(d) == 1) {sum = sum + Integer.valueOf(b); }
			else if (bc.get(d) == 2) {sum = sum + (Integer.valueOf(b) * 2); }

		}
		
		
		if (sum%5 == 0) {player.changeScore(player.getScore() + sum); }
		
	}
	
	
	public static void gameFinish(Player player) {
		if (player.isHandEmpty() == true) {
			finish++;
		}
	}
	
	
	
}
