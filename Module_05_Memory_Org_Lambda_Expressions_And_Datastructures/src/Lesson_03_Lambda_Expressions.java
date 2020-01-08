/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Lambda Expressions (Passing functions as method parameters)
//			a) Creating an interface
//			b) Lambda expression syntax ()->System.out.println()
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Lesson_03_Lambda_Expressions {

	// Operation Interface to be executed using Lambda Expressions
	interface MyOperation { void execute(int i); }
	
	// Timing/size variables
	private static int numElements = 100000;
	private static long start = 0;
	
	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will start execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use lambda expressiosn to pass functions as parameters.");
		System.out.println("===========================================================================");
		
		// Initialize data structures and variables
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Set<Integer> s = new HashSet<Integer>();

		// Add bunch of elements to end of ArrayList/LinkedList/Set (no such thing as end in a set)
		System.out.printf("\nTIME TO ADD %,d ELEMENTS AT END OF DATA STRUCTURE\n", numElements);
		System.out.println("--------------------------------------------");
		measureOperation("ArrayList:\t", (int i)->al.add(i));
		measureOperation("LinkedList:\t", (int i)->ll.add(i));
		measureOperation("Set:\t\t", (int i)->s.add(i));

		// Clear the data structures of all data for fair comparison
		al.clear();
		ll.clear();
		s.clear();
		
		// Add at beginning of ArrayList(causes shifts)/LinkedList(pointer changes)/Set (no such thing as beginning in a set)
		System.out.printf("\nTIME TO ADD %,d ELEMENTS AT BEGINNING OF DATA STRUCTURE\n", numElements);
		System.out.println("--------------------------------------------");
		measureOperation("ArrayList:\t", (int i)->al.add(0, i));
		measureOperation("LinkedList:\t", (int i)->ll.add(0, i));
		measureOperation("Set:\t\t", (int i)->s.add(i));

		// Set an item in the middle of the ArrayList/LinkedList/Set (no such thing as middle of a set) 
		System.out.printf("\nTIME TO SET/REPLACE VALUE IN MIDDLE OF %,d ELEMENTS, %,d TIMES\n", al.size(), numElements);
		System.out.println("--------------------------------------------");
		measureOperation("ArrayList:\t", (int i)->al.set(al.size() / 2, i));
		measureOperation("LinkedList:\t", (int i)->ll.set(ll.size() / 2, i));
		measureOperation("Set:\t\t", (int i)->{s.remove(i);s.add(i);});

		// Search for an item not in ArrayList/LinkedList/Set
		int searchKey = -1; // The key is the item we want to search for (and is definitely not in the data structures)
		System.out.printf("\nTIME TO SEARCH FOR AN ELEMENT NOT IN A DATA STRUCTURE CONTAINING %,d ELEMENTS, %,d TIMES\n", al.size(), numElements);
		System.out.println("--------------------------------------------");
		measureOperation("ArrayList:\t", (int i)->{if (al.contains(searchKey)) System.out.println("Found " + searchKey + " in ArrayList.");});
		measureOperation("LinkedList:\t", (int i)->{if (ll.contains(searchKey)) System.out.println("Found " + searchKey + " in LinkedList.");});
		measureOperation("Set:\t\t", (int i)->{if (s.contains(searchKey)) System.out.println("Found " + searchKey + " in Set.");});
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// This method starts a timer, performs an operation repetitively, stops a timer
	// and prints the results.
	//		Parameters:
	//			header - A string to print before the time
	//			myOp - The function to call repetitively
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private static void measureOperation(String header, MyOperation myOp) {
		startTimer();
		for (int i = 0; i < numElements; i++)
			myOp.execute(i);
		stopTimerAndPrintElapsedSeconds(header);
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
