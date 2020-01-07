/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) How ArrayLists, LinkedLists and Sets differ:
//			a) Functionally
//			b) In Efficiency, when 
//				i) Adding elements to end of data structure
//				ii) Adding elements to beginning of data structure
//				iii) Setting/replacing a value in middle of data structure
//				iv) Searching for an element not in the data structure
//		2) How to use System.currentTimeMillis() to time how long your code takes to do something (code profiling)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Lesson_02_ArrayList_Vs_LinkedList_Vs_Set {

	// Timing/size variables
	private static int numElements = 100000;
	
	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will start execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn performance characteristics of the ArrayList, LinkedList and Set.");
		System.out.println("===========================================================================");
		
		// Initialize data structures and variables

		System.out.printf("\nTIME TO ADD %,d ELEMENTS AT END OF DATA STRUCTURE\n", numElements);
		System.out.println("--------------------------------------------");
		// Add bunch of elements to end of ArrayList
		// Add bunch of elements to end of LinkedList 
		// Add bunch of elements to the Set (no such thing as beginning in a set)
		
		System.out.printf("\nTIME TO ADD %,d ELEMENTS AT BEGINNING OF DATA STRUCTURE\n", numElements);
		System.out.println("--------------------------------------------");
		// Clear the data structures of all data for fair comparison
		// Add at beginning of ArrayList (causes shifts)
		// Add at beginning of LinkedList (pointer changes)
		// Add bunch of elements to the Set (no such thing as beginning in a set)

		System.out.printf("\nTIME TO SET/REPLACE VALUE IN MIDDLE OF %,d ELEMENTS, %,d TIMES\n", -1, numElements); // TODO: Replace -1
		System.out.println("--------------------------------------------");
		// Set an item in the middle of the ArrayList 
		// Set an item in the middle of the LinkedList 
		// Set an item in the middle of the Set (no such thing as middle of a set) 
		
		System.out.printf("\nTIME TO SEARCH FOR AN ELEMENT NOT IN A DATA STRUCTURE CONTAINING %,d ELEMENTS, %,d TIMES\n", -1, numElements);  // TODO: Replace -1
		System.out.println("--------------------------------------------");
		// The key is the item we want to search for (and is definitely not in the data structures)
		// Search for an item not in ArrayList 
		// Search for an item not in LinkedList 
		// Search for an item not in Set 
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// This method starts a timer by recording the current time in milliseconds.
	//		Parameters:
	//			none
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////////
	// This method records the current time in milliseconds and saves as the stop time. 
	// It also computes the elapsed time between the global start and stop variables
	// and prints it as a formatted string: 0.0000s
	//		Parameters:
	//			header - A string to print before the time
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
}
