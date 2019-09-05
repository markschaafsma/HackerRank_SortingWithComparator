package comparator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test0() {
		int n = 5;
		
		// Define input 
		Player[] players = new Player[n];
		players[0] = new Player("amy", 100);
		players[1] = new Player("david", 100);
		players[2] = new Player("heraldo", 50);
		players[3] = new Player("aakansha", 75);
		players[4] = new Player("aleksa", 150);

		// Define expected output
		//   Sort order:
		//   1)  decreasing player score
		//   2)  ascending player name
		Player[] sortedPlayers = new Player[n];
		sortedPlayers[0] = new Player("aleksa", 150);
		sortedPlayers[1] = new Player("amy", 100);
		sortedPlayers[2] = new Player("david", 100);
		sortedPlayers[3] = new Player("aakansha", 75);
		sortedPlayers[4] = new Player("heraldo", 50);
		
		// Run test using assertArrayEquals
		try {		
		
//			// Print input object references
//			System.out.println(Arrays.toString(players));
		
			// Instantiate Comparator		
			Checker checker = new Checker();
			// Perform sort
			Arrays.sort(players, checker);
        
//      	// Print input object references after sorting
//			System.out.println(Arrays.toString(players));
//      	// Print expected output object references
//			System.out.println(Arrays.toString(sortedPlayers));
        
//	        System.out.println("Sorted Players ");
//	        for (int i = 0; i < players.length; i++){
//	        	System.out.printf("%s %s\n", players[i].name, players[i].score);
//	        }
//	        System.out.println("Expected Sorted Players");
//	        for (int i = 0; i < sortedPlayers.length; i++){
//	        	System.out.printf("%s %s\n", sortedPlayers[i].name, sortedPlayers[i].score);
//	        }

			assertArrayEquals(players, sortedPlayers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		// Run test using AssertTrue
//		Checker checker = new Checker();
//		Arrays.sort(players, checker);
//		assertTrue(Arrays.equals(players, sortedPlayers));
		
	}

	
	@Test
	void test1() {
		
		// Define input 
		Player[] players = new Player[] {
			new Player("davis", 15),
			new Player("davis", 20),
			new Player("davis", 10),
			new Player("edgehill", 15)
		};

		// Define expected output 
		//   Sort order:
		//   1)  decreasing player score
		//   2)  ascending player name
		Player[] sortedPlayers = new Player[] {
			new Player("davis", 20),
			new Player("davis", 15),
			new Player("edgehill", 15),	
			new Player("davis", 10)			
		};
		
		// This test has been written 5 different ways illustrating how the code can be 
		// written more efficiently and elegantly in Java 8:
		//  1. Run test with Comparator defined in a separate class - commented out.
		//  2. Run test with Comparator defined in a anonymous in-line class - commented out.
		//  3. Run test with Comparator defined in-line within the sort statement - commented out.
		//  4. Run test with Comparator defined in-line within the sort statement using a Lambda expression - commented out.
		//  5. Run test with Java 8 Comparator methods comparing() and thenComparing(), and method reference :: - final version.   		

		
/*		// Run test with Comparator defined in a separate class
		try {
			Checker checker = new Checker();
	        Arrays.sort(players, checker);
			assertArrayEquals(players, sortedPlayers);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
		
/*		// Run test with Comparator defined in-line.  
		try {
			Comparator<Player> checker = new Comparator<Player>() {
		    	@Override
		    	public int compare(Player a, Player b) {
		    		// Compare first attribute
		    		int lastCompare = Integer.compare(b.score, a.score);
		    		// If scores are equal, then compare next attribute.
		    		return (lastCompare != 0 ? lastCompare : a.name.compareTo(b.name));
		    	}
			};
	        Arrays.sort(players, checker);
			assertArrayEquals(players, sortedPlayers);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/

/*		// Run test with Comparator defined in-line within the sort statement.  
		try {
	        Arrays.sort(players, new Comparator<Player>() {
		    	@Override
		    	public int compare(Player a, Player b) {
		    		// Compare first attribute
		    		int lastCompare = Integer.compare(b.score, a.score);
		    		// If scores are equal, then compare next attribute.
		    		return (lastCompare != 0 ? lastCompare : a.name.compareTo(b.name));
		    	}
			});
			assertArrayEquals(players, sortedPlayers);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/		

/*		// Run test with Comparator defined in-line within the sort statement using a Lambda expression.  
		try {
	        Arrays.sort(players, (a, b) -> {
	    		// Compare first attribute
	    		int lastCompare = Integer.compare(b.score, a.score);
	    		// If scores are equal, then compare next attribute.
	    		return (lastCompare != 0 ? lastCompare : a.name.compareTo(b.name));
			});
			assertArrayEquals(players, sortedPlayers);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/				

		// Run test with Java 8 Comparator methods comparing() and thenComparing(), and method reference :: 
		try {
			Arrays.sort(players, Comparator.comparing(Player::getScore).reversed().thenComparing(Player::getName));
			assertArrayEquals(players, sortedPlayers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
