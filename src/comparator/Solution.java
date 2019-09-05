package comparator;

/**
 * Problem 
 * 
 *   Comparators are used to compare two objects. In this challenge, you'll create a comparator and 
 *   use it to sort an array. The Player class is provided. It has two fields:
 *     1. name:  a string.
 *     2. score: an integer.
 *     
 *   Given an array of n Player objects, write a comparator that sorts them in order of decreasing 
 *   score. If 2 or more players have the same score, sort those players alphabetically ascending by 
 *   name. To do this, you must create a Checker class that implements the Comparator interface, then 
 *   write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) 
 *   method.
 *   
 *   In short, when sorting in ascending order, a comparator function returns -1 if a < b, 
 *   0 if a = b, and 1 if a> b.
 *   
 *   For example, given n = 3 Player objects with Player.name, Player.score values of 
 *     data = [[Smith,20],[Jones,15],[Jones,20]],
 *   we want to sort the list as
 *     dataSorted = [[Jones,20],[Smith,20],[Jones,15]].
 *   
 * Function Description
 *
 *   Declare a Checker class that implements the comparator method as described. It should sort 
 *   first descending by score, then ascending by name. The code stub reads the input, creates a 
 *   list of Player objects, uses your method to sort the data, and prints it out properly.
 *   
 * Input Format
 * 
 *   The first line contains an integer, n, the number of players.
 *   Each of the next n lines contains a player's respective name and score, a string and an integer.
 * 
 *   
 * Constraints
 * 
 *   0 <= score <= 1000
 *   two or more players can have the same name
 *   Player names consist of lowercase English alphabetic letters.
 * 
 * Output Format
 * 
 *   You are not responsible for printing any output to stdout. Locked stub code in Solution will 
 *   create a Checker object, use it to sort the Player array, and print each sorted element.
 */   

import java.util.*;

class Player {

	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
	// Override equals method to facilitate JUnit testing
	@Override
	public boolean equals(Object o) {
		
        // Check if object is being compared with itself.
        if (o == this) { 
            return true; 
        } 

        // Check if object is an instance of Player or not.
        if (!(o instanceof Player)) { 
        	return false; 
        }
        
        // Cast o to Player so that we can compare data members.  
        Player p = (Player) o; 
          
        // Compare the data members and return accordingly.  
        return p.name.equals(name) && p.score == score;
	}
	
}

class Checker implements Comparator<Player> {
	
	// Complete the compare method

	// Sort order:
	// 1)  decreasing player score
	// 2)  ascending player name
	
	// When comparing objects:
	//   a negative integer  indicates  less than
	//   zero                indicates  equal to
	//   a positive integer  indicates  greater than 
	
	@Override
	public int compare(Player a, Player b) {

		// Compare first attribute
		int lastCompare = Integer.compare(b.score, a.score);
		// If scores are equal, then compare next attribute.
		return (lastCompare != 0 ? lastCompare : a.name.compareTo(b.name));

		// Alternatively
//		if (b.score < a.score) return -1;
//		if (b.score > a.score) return 1;
//		// Use Comparable interface method compareTo which provides natural order. 
//		return a.name.compareTo(b.name);
		
    }
}


public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for (int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}