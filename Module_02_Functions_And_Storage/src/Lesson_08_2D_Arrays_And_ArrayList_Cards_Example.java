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
		ArrayList<String> newDeck = createOrderedDeck();
		printDeck("A new deck", newDeck);

		// Prompt user how many hands they'd like to deal
		System.out.print("Enter the number of players: ");
		int numPlayers = scan.nextInt();
		System.out.print("Enter the number of cards each player receives: ");
		int numCards = scan.nextInt();
		System.out.print("Enter the number of hands/rounds you'd like to deal/play: ");
		int numRounds = scan.nextInt();

		// Create a new shuffle of cards and print
		for (int r = 0; r < numRounds; r++) {
			// Get new shuffled deck
			ArrayList<String> shuffledDeck = createShuffledDeck(newDeck);
			
			// Populate the hands for this round into a 2D array
			//		Each row will represent a different player's hand
			//		Each column in a row will represent a card in that player's hand
			String [][] hands = new String[numPlayers][numCards];
			for (int p = 0; p < numPlayers; p++) {
				for (int cs = 0; cs < numCards; cs++) { // cs = card slot
					
					// If deck is empty, get new deck
					if (shuffledDeck.isEmpty())
						shuffledDeck = createShuffledDeck(newDeck);
					
					// Remove top/first card from shuffled deck and place in player's hand
					hands[p][cs] = shuffledDeck.remove(0);
				}
			}
			
			// Print out hands
			System.out.printf( "---------------------------------ROUND %s---------------------------------\n", (r+1) );
			for (int p = 0; p < numPlayers; p++)
				printDeck(String.format("Player %s's hand", (p+1)), hands[p]);
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////
	// This method creates a new unshuffled deck from scratch.
	// 		Parameters:
	//			NONE
	//
	//		Returns:
	//			An ArrayList of Strings containing an ordered deck of cards
	///////////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<String> createOrderedDeck() {
		// Create a new deck of "unshuffled" cards from the unique suits and values
		ArrayList<String> newDeck = new ArrayList<String>();
		for (int s = 0; s < SUITS.length; s++)
			for (int v = 0; v < VALUES.length; v++)
				newDeck.add(VALUES[v] + " of " + SUITS[s]);
		
		// Return new deck of cards
		return newDeck;
	}

	///////////////////////////////////////////////////////////////////////////////////////
	// This method prints out each card in the deck of cards passed in.
	// 		Parameters:
	//			deck - An ArrayList (array) of Strings (cards)
	//
	//		Returns:
	//			void (nothing)
	///////////////////////////////////////////////////////////////////////////////////////
	private static void printDeck(String cardSetName, ArrayList<String> deck) throws InterruptedException {
		
		// Print the header
		System.out.printf("%s (%s cards) contains:\n", cardSetName, deck.size());
		ensurePrintOrder();
		
		// Print the cards in the deck
		for (int i = 0; i < deck.size(); i++) {
			String card = deck.get(i);
			if (card.toUpperCase().contains("SPADES") || card.toUpperCase().contains("CLUBS")) {
				System.out.println("\t" + card);
				ensurePrintOrder();
			}
			else { // Diamonds or Hearts
				System.err.println("\t" + card);
				ensurePrintOrder();
			}
		}
		
		// Print a new line after all the cards are printed
		System.out.println();
		ensurePrintOrder();
	}
	private static void printDeck(String cardSetName, String[] deck) throws InterruptedException {
		ArrayList<String> deckCopy = new ArrayList<String>( Arrays.asList(deck) );
		printDeck(cardSetName, deckCopy);
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	// This method flushes the output and error streams and then pauses the code execution
	// for a few seconds to give time for the output/error streams to print to screen in
	// an effort to ensure that the output and error streams are in sync with one another.
	// 		Parameters:
	//			N/A
	//
	//		Returns:
	//			void (nothing)
	///////////////////////////////////////////////////////////////////////////////////////
	private static void ensurePrintOrder() throws InterruptedException {
		// Pause the thread to allow output to catch up
		System.out.flush();
		System.err.flush();
		TimeUnit.MILLISECONDS.sleep(1);
	}

	///////////////////////////////////////////////////////////////////////////////////////
	// This method creates a new shuffled deck from a new/stock deck.
	// 		Parameters:
	//			newDeck - An ArrayList of Strings (cards) in order
	//
	//		Returns:
	//			An ArrayList of Strings containing a randomly shuffled deck of cards
	///////////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<String> createShuffledDeck(ArrayList<String> originDeck) {
		// Make a copy of the originDeck, making sure we never change the originDeck
		// so we can always use it again to generate a new deck
		ArrayList<String> deckCopy = new ArrayList<String>(originDeck);
		ArrayList<String> shuffledDeck = new ArrayList<String>(); // Create empty deck of proper size
		
		// While the temporary deck copy is NOT empty, keep pulling cards randomly and add them to the shuffled deck
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
