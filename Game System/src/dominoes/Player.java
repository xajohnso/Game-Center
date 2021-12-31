package dominoes;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	


	private ArrayList<String> hand = new ArrayList<String>();
	private int score = 0;
	private int counter = 0;
	private int playerNumber = 0;
	
	public Player(int playerNumber) {
		super();
		this.playerNumber = playerNumber;
	}
	
	public void choose() {
		System.out.println("\nPlayer " + playerNumber + ": Where would you like to play? 1) North 2) East 3) South 4) West");
	}
	public void addDominoe(String dominoe) { hand.add(dominoe); }
	
	public int getHandSize() { return hand.size(); }
	
	public void showHand() {
		int count = 1;
		Iterator<String> it = hand.iterator();
		
		while (it.hasNext()) {
			String dominoe = it.next();
			System.out.print(" " + count + ") " + dominoe);
			count++;
		}	
	}
	
	public int getScore() { return score; }
	
	public void changeScore(int amount) { this.score = amount; }
	
	public boolean dominoeCheck(String dominoe) { return hand.contains(dominoe); }
	
	public void removeDominoe(String dominoe) { hand.remove(dominoe); }
	
	public void changeCounter(int counter) { this.counter = counter; }
	
	public int getCounter() { return counter; }
	
	public String getDominoe(int index) { return hand.get(index); }
	
	public boolean isHandEmpty() { return hand.isEmpty(); }
	
	public String[] returnHand() {
		String[] dominoes = hand.toArray(new String[hand.size()]);
		
		return dominoes;
	}
}
