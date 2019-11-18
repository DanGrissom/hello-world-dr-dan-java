// *****NOTE: Create createOrderedDeck() LAST so we can show pass by value when creating new shuffled deck

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) 2D Arrays
//			a) Declaring 2D arrays with variable size
//			b) Initializing 2D arrays from data
//			c) Iterating through and printing 2D arrays
//		2) ArrayList
//			a) Create a new ArrayList from an array
//			b) Initializing a new ArrayList
//			c) ArrayList methods:
//				i) add(), isEmpty(), remove()
//		3) Output hacks
//			a) Using System.out and System.err to get black/red output
//			b) Flushing System.out and System.err to force output
//			c) Using the .sleep method to pause your program
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Lesson_08_2D_Arrays_And_ArrayList_Cards_Example {

	// Constants
	private static final String [] SUITS =  { "Spades", "Diamonds", "Clubs", "Hearts" };
	private static final String [] VALUES = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

	// Create random object
	private static Random randy = new Random();

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) throws InterruptedException {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to pass (array) by reference and to copy arrays");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);
		
		// Generate a new deck of ordered cards and print
		String [] newDeck = createOrderedDeck();
		printDeck("A new deck", newDeck);

		// Prompt user how many hands they'd like to deal
		System.out.print("Enter the number of players: ");
		int numPlayers = scan.nextInt();
		System.out.print("Enter the number of cards each player receives: ");
		int numCards = scan.nextInt();
		System.out.print("Enter the number of hands/rounds you'd like to deal/play: ");
		int numHands = scan.nextInt();
		
		// Create a new shuffle of cards and print
		for (int i = 0; i < numHands; i++) {
			// Get new shuffled deck
			ArrayList<String> shuffledDeck = createShuffledDeck(newDeck);
			//printDeck(String.format("Shuffled deck %s", (i+1)), shuffledDeck);
			
			// Populate the hands into a 2D array
			// Each row will represent a different players hand
			// Each column in a row will represent a card in the player's hand
			String [][] game = new String[numPlayers][numCards];
			for (int p = 0; p < numPlayers; p++) {
				for (int c = 0; c < numCards; c++) {
					// If deck is empty, get new deck
					if (shuffledDeck.isEmpty())
						shuffledDeck = createShuffledDeck(newDeck);
					
					// Remove top/first card from shuffled deck and place in player's hand
					game[p][c] = shuffledDeck.remove(0);
				}
			}
			
			// Print out hands
			for (int p = 0; p < numPlayers; p++)
				printDeck(String.format("Player %s's hand", p), game[p]);
			
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
	private static void printDeck(String cardSetName, String[] deck) throws InterruptedException {
		// Print the cards in the deck
		System.out.printf(cardSetName + " of %s cards contains:\n", deck.length);
		for (int i = 0; i < deck.length; i++) {
			if (deck[i].toUpperCase().contains("SPADES") || deck[i].toUpperCase().contains("CLUBS"))
				System.out.println("\t" + deck[i]);
			else
				System.err.println("\t" + deck[i]);
		}
		
		// Flush the output streams
		System.out.flush();
		System.err.flush();
		TimeUnit.MILLISECONDS.sleep(200);
		System.out.println();
		System.out.flush();
		TimeUnit.MILLISECONDS.sleep(200);
	}

	///////////////////////////////////////////////////////////////////////////////////////
	// This method creates a new shuffled deck from a new deck.
	// 		Parameters:
	//			newDeck - An array of Strings (cards) in order
	//
	//		Returns:
	//			An array of Strings containing a randomly shuffled deck of cards
	///////////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<String> createShuffledDeck(String[] originDeck) {
		// Create a copy of the deck (for temporary usage) and init a shuffled deck (to return)
		ArrayList<String> deckCopy = new ArrayList<String>(Arrays.asList(originDeck));
		ArrayList<String> shuffledDeck = new ArrayList<String>();
		
		// While the temporary deck copy is not empty, keep pulling cards randomly and add them to the shuffled deck
		while (!deckCopy.isEmpty()) {
			int pullIndex = randy.nextInt(deckCopy.size());
			String pulledCard = deckCopy.get(pullIndex);
			shuffledDeck.add(pulledCard);
			deckCopy.remove(pullIndex);
		}
		
		// Return shuffled deck
		return shuffledDeck;
	}

}
