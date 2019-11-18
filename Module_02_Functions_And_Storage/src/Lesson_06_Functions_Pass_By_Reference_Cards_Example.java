// *****NOTE: Create createOrderedDeck() LAST so we can show pass by value when creating new shuffled deck

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Functions
//			a) Passing arrays by reference instead of value
//			b) More practice converting repeated code into functions
//		2) String class methods
//			a) String.format() to format Strings
//		3) Array copying
//			a) Using the Arrays class to make a shallow copy of an array
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;
import java.util.Random;

public class Lesson_06_Functions_Pass_By_Reference_Cards_Example {

	// Constants
	private static final String [] SUITS =  { "Spades", "Diamonds", "Clubs", "Hearts" };
	private static final String [] VALUES = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	// Create random object
	private static Random randy = new Random();

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to pass (array) by reference and to copy arrays");
		System.out.println("===========================================================================");

		// Generate a new deck of ordered cards and print
		String [] newDeck = createOrderedDeck();
		printDeck("A new deck", newDeck);

		// Create a new shuffle of cards and print
		for (int i = 0; i < 5; i++) {
			String [] shuffledDeck = createShuffledDeck(newDeck);
			printDeck(String.format("Shuffled deck %s", (i+1)), shuffledDeck);
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////
	// This method creates a new shuffled deck from a new deck.
	// 		Parameters:
	//			NONE
	//
	//		Returns:
	//			An array of Strings containing an ordered deck of cards
	///////////////////////////////////////////////////////////////////////////////////////
	private static String[] createOrderedDeck() {
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
		
		// Return new deck of cards
		return newDeck;
	}

	///////////////////////////////////////////////////////////////////////////////////////
	// This method prints out each card in the deck of cards passed in.
	// 		Parameters:
	//			deck - An array of Strings (cards)
	//
	//		Returns:
	//			void (nothing)
	///////////////////////////////////////////////////////////////////////////////////////
	private static void printDeck(String cardSetName, String[] deck) {
		System.out.printf(cardSetName + " of %s cards contains:\n", deck.length);
		for (int i = 0; i < deck.length; i++)
			System.out.println("\t" + deck[i]);
		System.out.println();	
	}

	///////////////////////////////////////////////////////////////////////////////////////
	// This method creates a new shuffled deck from a new deck.
	// 		Parameters:
	//			newDeck - An array of Strings (cards) in order
	//
	//		Returns:
	//			An array of Strings containing a randomly shuffled deck of cards
	///////////////////////////////////////////////////////////////////////////////////////
	private static String[] createShuffledDeck(String[] originDeck) {
		
		// Make a copy of the originDeck, making sure we never change the origin deck
		// so we can always use it again to generate a new deck
		String[] deckCopy = Arrays.copyOf(originDeck, originDeck.length);
		
		// Get number of cards in deck
		int numCardsInDeck = deckCopy.length;

		// Create empty deck of proper size
		String [] shuffledDeck = new String [numCardsInDeck];

		// Copy cards over, one at a time
		for (int i = 0; i < numCardsInDeck; i++) {
			// Randomly pull card from new deck...
			//String pulledCard = newDeck[i];
			String pulledCard = null;

			// Check a random card slot to see if it has not already been pulled
			int randomIndex = randy.nextInt(numCardsInDeck);
			if (!deckCopy[randomIndex].equals("X")) {
				pulledCard = deckCopy[randomIndex];
				deckCopy[randomIndex] = "X";
			} else {
				// Look for the first card AFTER the random index...
				for (int j = randomIndex + 1; j < deckCopy.length; j++) {
					if (!deckCopy[j].equals("X")) {
						pulledCard = deckCopy[j];
						deckCopy[j] = "X";
						break;
					}
				}

				// If no card after the random index, look for the first card BEFORE the random index
				if (pulledCard == null) {
					for (int j = randomIndex - 1; j >= 0; j--) {
						if (!deckCopy[j].equals("X")) {
							pulledCard = deckCopy[j];
							deckCopy[j] = "X";
							break;
						}
					}
				}

			}

			// ...and place pulled card into shuffledCards
			shuffledDeck[i] = pulledCard;
		}

		return shuffledDeck;
	}

}
