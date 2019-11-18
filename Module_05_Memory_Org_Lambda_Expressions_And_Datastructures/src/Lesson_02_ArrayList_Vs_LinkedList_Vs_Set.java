/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) How the Stack and Heap are used to store variables and data
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Lesson_02_ArrayList_Vs_LinkedList_Vs_Set {

	// Timing/size variables
	private static int numElements = 100000;
	private static long start = 0;
	private static long stop = 0;
	
	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will start execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn performance characteristics of the ArrayList, LinkedList and Set.");
		System.out.println("===========================================================================");

		// Decimal Formatter
		DecimalFormat dfTh = new DecimalFormat("#,###");
		
		// Initialize data structures and variables
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Set<Integer> s = new HashSet<Integer>();

		System.out.println("\nTIME TO ADD " + dfTh.format(numElements) + " ELEMENTS AT END OF DATA STRUCTURE");
		System.out.println("--------------------------------------------");

		// Add bunch of elements to end of ArrayList
		startTimer();
		for (int i = 0; i < numElements; i++)
			al.add(i);
		stopTimerAndPrintElapsedSeconds("\tArrayList:\t");

		// Add bunch of elements to end of LinkedList 
		startTimer();
		for (int i = 0; i < numElements; i++)
			ll.add(i);
		stopTimerAndPrintElapsedSeconds("\tLinkedList:\t");

		// Add bunch of elements to the Set (no such thing as beginning in a set)
		startTimer();
		for (int i = 0; i < numElements; i++)
			s.add(i);
		stopTimerAndPrintElapsedSeconds("\tSet:\t\t");
		
		
		System.out.println("\nTIME TO ADD " + dfTh.format(numElements) + " ELEMENTS AT BEGINNING OF DATA STRUCTURE");
		System.out.println("--------------------------------------------");
		
		// Clear the data structures of all data for fair comparison
		al.clear();
		ll.clear();
		s.clear();
		
		// Add at startning of ArrayList (causes shifts)
		startTimer();
		for (int i = 0; i < numElements; i++)
			al.add(0, i);
		stopTimerAndPrintElapsedSeconds("\tArrayList:\t");
		
		// Add at startning of LinkedList (pointer changes)
		startTimer();
		for (int i = 0; i < numElements; i++)
			ll.add(0, i);
		stopTimerAndPrintElapsedSeconds("\tLinkedList:\t");
		
		// Add bunch of elements to the Set (no such thing as beginning in a set)
		startTimer();
		for (int i = 0; i < numElements; i++)
			s.add(i);
		stopTimerAndPrintElapsedSeconds("\tSet:\t\t");

		System.out.println("\nTIME TO SET/REPLACE VALUE IN MIDDLE OF " + dfTh.format(al.size()) + " ELEMENTS, " + dfTh.format(numElements) + " TIMES");
		System.out.println("--------------------------------------------");

		// Set an item in the middle of the ArrayList 
		startTimer();
		for (int i = 0; i < numElements; i++)
			al.set(numElements/2, i);
		stopTimerAndPrintElapsedSeconds("\tArrayList:\t");

		// Set an item in the middle of the LinkedList 
		startTimer();
		for (int i = 0; i < numElements; i++)
			ll.set(numElements/2, i);
		stopTimerAndPrintElapsedSeconds("\tLinkedList:\t");

		// Set an item in the middle of the Set (no such thing as middle of a set) 
		startTimer();
		for (int i = 0; i < numElements; i++) {
			s.remove(numElements/2);
			s.add(i);
		}
		stopTimerAndPrintElapsedSeconds("\tSet:\t\t");
		
		System.out.println("\nTIME TO SEARCH FOR AN ELEMENT NOT IN A DATA STRUCTURE CONTAINING " + dfTh.format(al.size()) + " ELEMENTS, " + dfTh.format(numElements) + " TIMES");
		System.out.println("--------------------------------------------");
		
		// The key is the item we want to search for (and is definitely not in the data structures)
		int searchKey = -1;

		// Search for an item not in ArrayList 
		startTimer();
		for (int i = 0; i < numElements; i++)
			if (al.contains(searchKey))
				System.out.println("Found " + searchKey + " in ArrayList.");
		stopTimerAndPrintElapsedSeconds("\tArrayList:\t");

		// Search for an item not in LinkedList 
		startTimer();
		for (int i = 0; i < numElements; i++)
			if (ll.contains(searchKey))
				System.out.println("Found " + searchKey + " in LinkedList.");
		stopTimerAndPrintElapsedSeconds("\tLinkedList:\t");

		// Search for an item not in LinkedList 
		startTimer();
		for (int i = 0; i < numElements; i++)
			if (s.contains(searchKey))
				System.out.println("Found " + searchKey + " in Set.");
		stopTimerAndPrintElapsedSeconds("\tSet:\t\t");
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// This method starts a timer by recording the current time in milliseconds.
	//		Parameters:
	//			none
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	public static void startTimer() {
		start = System.currentTimeMillis();
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// This method starts a timer by recording the current time in milliseconds. It 
	// also computes the elapsed time between the global start and stop variables
	// and prints it as a formatted string: 0.0000s
	//		Parameters:
	//			header - A string to print before the time
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	public static void stopTimerAndPrintElapsedSeconds(String header) {
		// Stop timer
		stop = System.currentTimeMillis();
		
		// Compute elapsed time
		double seconds = (stop - start) / 1000.0;
		
		// Print header and time
		DecimalFormat df = new DecimalFormat("0.0000s");
		System.out.println(header + df.format(seconds));
	}
}
