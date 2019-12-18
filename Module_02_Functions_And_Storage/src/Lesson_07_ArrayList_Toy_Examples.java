/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) The ArrayList class
//			a) Declaring ArrayLists
//			b) ArrayList methods
//				i) size(), get(), add(), contains(), isEmpty()
//			c) Iterating through and printing ArrayList contents
//			d) Sorting arrays and comparators
//			e) Nesting ArrayLists
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Lesson_07_ArrayList_Toy_Examples {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to store, access and analyze data in 2D arrays using a toy example");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);

		// Initialize random number generator
		Random randy = new Random();

		///////////////////////////////////////////////////////////////////////////
		// ARRAYLIST DECLARATION & BUILDING
		// Declare and init arraylist of places
		ArrayList<String> favPlaces = new ArrayList<String>();

		// Prompt user to keep adding new places to store in arraylist
		boolean morePlaces = true;
		do {
			System.out.print("Please enter a favorite place (Type Done when done): ");
			String place = scan.nextLine();

			// If they did NOT type in DONE, then they have more places
			morePlaces = !place.trim().equalsIgnoreCase("DONE");

			// If they do have more places, add the current place
			if (morePlaces && !favPlaces.contains(place))
				favPlaces.add(place);
		} while(morePlaces);

		// Print favorite places
		printArrayList("Favorite Places (in order as provided)", favPlaces);

		///////////////////////////////////////////////////////////////////////////
		// ARRAYLIST SORTING
		// Sort alphabetically and print again
		Collections.sort(favPlaces);
		printArrayList("Favorite Places (sorted alphabetically)", favPlaces);

		// Sort reverse-alphabetically and print again
		Collections.sort(favPlaces, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s2.compareTo(s1); 
			}
		});
		printArrayList("Favorite Places (sorted reverse-alphabetically)", favPlaces);

		// Sort from shortest length to longest length
		Collections.sort(favPlaces, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		printArrayList("Favorite Places (shortest to longest)", favPlaces);
		
		///////////////////////////////////////////////////////////////////////////
		// ARRAYLIST MANIPULATION
		// Prompt user for index of value to remove
		System.out.print("\nPlease enter an INDEX to remove: ");
		int iRemove = scan.nextInt();
		favPlaces.remove(iRemove);
		printArrayList("Favorite Places (after removing a value by index)", favPlaces);
		scan.nextLine();
		
		// Prompt user for value to remove
		System.out.print("\nPlease enter a VALUE to remove: ");
		String valRemove = scan.nextLine();
		favPlaces.remove(valRemove);
		printArrayList("Favorite Places (after removing a value)", favPlaces);
		
		///////////////////////////////////////////////////////////////////////////
		// Nested (2D) ArrayList of ints
		ArrayList<ArrayList<Integer>> nestedList = new ArrayList<ArrayList<Integer>>();
		int numRows = randy.nextInt(5) + 2; // Generate random number between 2 and 7
		int numCols = randy.nextInt(5) + 2; // Generate random number between 2 and 7
		for (int r = 0; r < numRows; r++) {
			// For each row, add a new ArrayList of integers
			nestedList.add(new ArrayList<Integer>());
			
			// Then, for each column, add a new random int
			for (int c = 0; c < numCols; c++)
				nestedList.get(r).add(randy.nextInt(50));
		}
		
		// Print out contents of arraylist (similar to 2D array)
		System.out.printf("\nRandomly generated a %s x %s matrix (rows x cols):\n", numRows, numCols);
		for (int r = 0; r < nestedList.size(); r++) {
			//System.out.println(nestedList.get(r));
			for (int c = 0; c < nestedList.get(r).size(); c++)
				System.out.print(nestedList.get(r).get(c) + "\t"); // Same as array2d[r][c] for 2D array
			System.out.println();
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////
	// This method prints the name and contents of the ArrayList.
	// 		Parameters:
	//			aListName - String representing name of array to print
	//			aList - ArrayList of Strings to print
	//
	//		Returns:
	//			void (nothing)
	///////////////////////////////////////////////////////////////////////////////////////
	private static void printArrayList(String aListName, ArrayList<String> aList) {
		// Print header
		System.out.printf("\nPrinting %s (size %s)\n", aListName, aList.size());
		System.out.println("=================================");

		// If Arraylist is empty, print message saying so
		if (aList.isEmpty())
			System.out.println("\t***ArrayList empty");
		else { // If ArrayList DOES have elements
			// Print array values
			for (int i = 0; i < aList.size(); i++)
				System.out.printf("\t%s\t(index %s)\n", aList.get(i), i);
		}
	}
}
