package dominoes;

import java.util.Collections;
import java.util.LinkedList;

public class Dominoes {

	LinkedList<String> dominoes = new LinkedList<String>();
	
	public void shuffleDominoes() {Collections.shuffle(dominoes); }
	
	public void makeDominoes() {
		int[] sideOne = {0, 1, 2, 3, 4, 5, 6};
		
		for (int x = 0; x < sideOne.length; x++) {
			for (int y = 0; y < sideOne.length; y++) {
				String dominoe;
				
				int s1 = sideOne[x];
				int s2 = sideOne[y];
				
				if (s1 > s2 || s1 == s2) {
					dominoe = s1 + ":" + s2;
					if (dominoes.contains(dominoe) != true) { dominoes.add(dominoe);}
				} else if (s2 > s1) {
					dominoe = s2 + ":" + s1;
					if (dominoes.contains(dominoe) != true) { dominoes.add(dominoe);}
				} else {}
			}
		}
	}
	
	public int amountOfDominoes() { return dominoes.size();}
	
	public void start() { makeDominoes(); shuffleDominoes(); }
	
	public String getDominoe() { return dominoes.pollFirst(); }
}
