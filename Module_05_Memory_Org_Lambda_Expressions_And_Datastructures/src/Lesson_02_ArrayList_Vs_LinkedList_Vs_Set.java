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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Lesson_02_ArrayList_Vs_LinkedList_Vs_Set {
	
	// Timing/size variables
	private static int numElements = 100000;
	private static long start = 0;

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will start execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {

		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn performance characteristics of the ArrayList, LinkedList and Set.");
		System.out.println("===========================================================================");

		// Initialize data structures and variables
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Set<Integer> s = new HashSet<Integer>();

		System.out.printf("\nTIME TO ADD %,d ELEMENTS AT END OF DATA STRUCTURE\n", numElements);
		System.out.println("--------------------------------------------");
		// Add bunch of elements to end of ArrayList
		startTimer();
		for (int i = 0; i < numElements; i++)
			al.add(i);
		stopTimerAndPrintElapsedSeconds("ArrayList:\t");

		// Add bunch of elements to end of LinkedList 
		startTimer();
		for (int i = 0; i < numElements; i++)
			ll.add(i);
		stopTimerAndPrintElapsedSeconds("LinkedList:\t");

		// Add bunch of elements to the Set (no such thing as end in a set)
		startTimer();
		for (int i = 0; i < numElements; i++)
			s.add(i);
		stopTimerAndPrintElapsedSeconds("Set:\t\t");

		System.out.printf("\nTIME TO ADD %,d ELEMENTS AT BEGINNING OF DATA STRUCTURE\n", numElements);
		System.out.println("--------------------------------------------");
		// Clear the data structures of all data for fair comparison
		al.clear();
		ll.clear();
		s.clear();
		
		// Add at beginning of ArrayList (causes shifts)
		startTimer();
		for (int i = 0; i < numElements; i++)
			al.add(0, i);
		stopTimerAndPrintElapsedSeconds("ArrayList:\t");
		
		// Add at beginning of LinkedList (pointer changes)
		startTimer();
		for (int i = 0; i < numElements; i++)
			ll.add(0, i);
		stopTimerAndPrintElapsedSeconds("LinkedList:\t");
		
		// Add bunch of elements to the Set (no such thing as beginning in a set)
		startTimer();
		for (int i = 0; i < numElements; i++)
			s.add(i);
		stopTimerAndPrintElapsedSeconds("Set:\t\t");

		System.out.printf("\nTIME TO SET/REPLACE VALUE IN MIDDLE OF %,d ELEMENTS, %,d TIMES\n", al.size(), numElements);
		System.out.println("--------------------------------------------");
		// Set an item in the middle of the ArrayList 
		startTimer();
		for (int i = 0; i < numElements; i++)
			al.set(al.size() / 2, i);
		stopTimerAndPrintElapsedSeconds("ArrayList:\t");
		
		// Set an item in the middle of the LinkedList 
		startTimer();
		for (int i = 0; i < numElements; i++)
			ll.set(ll.size() / 2, i);
		stopTimerAndPrintElapsedSeconds("LinkedList:\t");
		
		// Set an item in the middle of the Set (no such thing as middle of a set) 
		startTimer();
		for (int i = 0; i < numElements; i++) {
			s.remove(i);
			s.add(i);
		}
		stopTimerAndPrintElapsedSeconds("Set:\t\t");

		System.out.printf("\nTIME TO SEARCH FOR AN ELEMENT NOT IN A DATA STRUCTURE CONTAINING %,d ELEMENTS, %,d TIMES\n", al.size(), numElements);
		System.out.println("--------------------------------------------");
		// The key is the item we want to search for (and is definitely not in the data structures)
		int searchKey = -1;
		
		// Search for an item not in ArrayList
		startTimer();
		for (int i = 0; i < numElements; i++)
			if (al.contains(searchKey))
				System.out.println("Found " + searchKey + " in ArrayList.");
		stopTimerAndPrintElapsedSeconds("ArrayList:\t");
		
		// Search for an item not in LinkedList 
		startTimer();
		for (int i = 0; i < numElements; i++)
			if (ll.contains(searchKey))
				System.out.println("Found " + searchKey + " in LinkedList.");
		stopTimerAndPrintElapsedSeconds("LinkedList:\t");
		
		// Search for an item not in Set 
		startTimer();
		for (int i = 0; i < numElements; i++)
			if (s.contains(searchKey))
				System.out.println("Found " + searchKey + " in Set.");
		stopTimerAndPrintElapsedSeconds("Set:\t\t");
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method starts a timer by recording the current time in milliseconds.
	//		Parameters:
	//			none
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private static void startTimer() {
		start = System.currentTimeMillis();
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method records the current time in milliseconds and saves as the stop time. 
	// It also computes the elapsed time between the global start and stop variables
	// and prints it as a formatted string: 0.0000s
	//		Parameters:
	//			header - A string to print before the time
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private static void stopTimerAndPrintElapsedSeconds(String header) {
		long stop = System.currentTimeMillis();						// Stop timer
		double elapsedTimeSeconds = (stop - start) / 1000.0;		// Compute elapsed time
		System.out.printf("\t%s%.04fs\n", header, elapsedTimeSeconds);	// Print header and time
	}
}
