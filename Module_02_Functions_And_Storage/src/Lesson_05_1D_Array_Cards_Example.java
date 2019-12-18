/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Arrays
//			a) Hard-coded arrays 1D-arrays
//			b) 1D-arrays with size determined at run-time
//		2) Random class
//			a) Generating random numbers
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Random;

public class Lesson_05_1D_Array_Cards_Example {

	// Constants
	private static final String [] SUITS =  { "Spades", "Diamonds", "Clubs", "Hearts" };
	private static final String [] VALUES = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use 1D arrays");
		System.out.println("===========================================================================");

		// Print out Suits
		System.out.print("Listing unique card suits: ");
		for (int i = 0; i < SUITS.length; i++)
			System.out.print(SUITS[i] + "   ");
		System.out.println();
		System.out.println();

		// Print out Values
		System.out.print("Listing unique card values: ");
		for (int i = 0; i < VALUES.length; i++)
			System.out.print(VALUES[i] + "   ");
		System.out.println();
		System.out.println();

		// Create a new deck of "unshuffled" cards from the unique suits and values
		int numCardsInDeck = SUITS.length * VALUES.length;
		String [] newDeck = new String[numCardsInDeck];
		int cardCount = 0;
		for (int s = 0; s < SUITS.length; s++) {
			for (int v = 0; v < VALUES.length; v++) {
				String newCard = VALUES[v] + " of " + SUITS[s];
				newDeck[cardCount] = newCard;
				cardCount++;
				//newDeck[cardNumber++] = VALUES[v] + " of " + SUITS[s];
			}
		}

		// Print out deck of "unshuffled" cards
		System.out.printf("A new deck of %s cards contains:\n", newDeck.length);
		for (int i = 0; i < newDeck.length; i++)
			System.out.println("\t" + newDeck[i]);
		System.out.println();		
		
		// Create random class
		Random randy = new Random();

		//////////////////////////////////////////////////////////
		// Shuffle the deck of cards (into a new deck)
		//////////////////////////////////////////////////////////		
		// Create empty deck of proper size
		String [] shuffledDeck = new String [numCardsInDeck];
		
		// Copy cards over, one at a time (in random order)
		for (int i = 0; i < numCardsInDeck; i++) {
			String pulledCard = null;

			// Check a random card slot to see if it has not already been pulled
			int randomIndex = randy.nextInt(numCardsInDeck);
			if (!newDeck[randomIndex].equals("X")) {
				pulledCard = newDeck[randomIndex];
				newDeck[randomIndex] = "X";
			} else {
				// Look for the first card AFTER the random index...
				for (int j = randomIndex + 1; j < newDeck.length; j++) {
					if (!newDeck[j].equals("X")) {
						pulledCard = newDeck[j];
						newDeck[j] = "X";
						break;
					}
				}

				// If no card after the random index, look for the first card BEFORE the random index
				if (pulledCard == null) {
					for (int j = randomIndex - 1; j >= 0; j--) {
						if (!newDeck[j].equals("X")) {
							pulledCard = newDeck[j];
							newDeck[j] = "X";
							break;
						}
					}
				}

			}

			// ...and place pulled card into shuffledCards
			shuffledDeck[i] = pulledCard;
		}
		

		// Print a shuffled deck of cards
		System.out.printf("A shuffled deck of %s cards contains:\n", shuffledDeck.length);
		for (int i = 0; i < shuffledDeck.length; i++)
			System.out.println("\t" + shuffledDeck[i]);
	}

}
