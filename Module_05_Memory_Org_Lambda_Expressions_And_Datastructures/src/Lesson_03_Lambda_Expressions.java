/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//In this lesson you will learn:
//		1) Lambda Expressions (Passing functions as method parameters)
//			a) Creating an interface
//			b) Lambda expression syntax ()->System.out.println()
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.text.DecimalFormat;
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
	private static long stop = 0;
	
	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will start execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use lambda expressiosn to pass functions as parameters.");
		System.out.println("===========================================================================");

		// Decimal Formatter
		DecimalFormat dfTh = new DecimalFormat("#,###");
		
		// Initialize data structures and variables
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		Set<Integer> s = new HashSet<Integer>();

		// Add bunch of elements to END of ArrayList/LinkedList/Set (NOTE: no such thing as end of set)
		System.out.println("\nTIME TO ADD " + dfTh.format(numElements) + " ELEMENTS AT END OF DATA STRUCTURE");
		System.out.println("--------------------------------------------");
		measureOperation("\tArrayList:\t", (int i)->al.add(i));
		measureOperation("\tLinkedList:\t", (int i)->ll.add(i));
		measureOperation("\tSet:\t\t", (int i)->s.add(i));
		
		// Clear the data structures of all data for fair comparison
		al.clear();
		ll.clear();
		s.clear();
		
		// Add bunch of elements to BEGINNING of ArrayList/LinkedList/Set (NOTE: no such thing as beginning of set)
		System.out.println("\nTIME TO ADD " + dfTh.format(numElements) + " ELEMENTS AT BEGINNING OF DATA STRUCTURE");
		System.out.println("--------------------------------------------");
		measureOperation("\tArrayList:\t", (int i)->al.add(0, i));
		measureOperation("\tLinkedList:\t", (int i)->ll.add(0, i));
		measureOperation("\tSet:\t\t", (int i)->s.add(i));
		
		// Search for an item not in ArrayList/LinkedList/Set (NOTE: no such thing as middle of set)
		System.out.println("\nTIME TO SET/REPLACE VALUE IN MIDDLE OF " + dfTh.format(al.size()) + " ELEMENTS, " + dfTh.format(numElements) + " TIMES");
		System.out.println("--------------------------------------------");
		measureOperation("\tArrayList:\t", (int i)->al.set(numElements/2, i));
		measureOperation("\tLinkedList:\t", (int i)->ll.set(numElements/2, i));
		measureOperation("\tSet:\t\t", (int i)->{ s.remove(numElements/2); s.add(i); });
		
		// Search for an item not in ArrayList/LinkedList/Set 
		int searchKey = -1;
		System.out.println("\nTIME TO SEARCH FOR AN ELEMENT NOT IN A DATA STRUCTURE CONTAINING " + dfTh.format(al.size()) + " ELEMENTS, " + dfTh.format(numElements) + " TIMES");
		System.out.println("--------------------------------------------");
		measureOperation("\tArrayList:\t", (int i)-> { if (al.contains(searchKey)) System.out.println("Found " + searchKey + " in ArrayList."); });
		measureOperation("\tLinkedList:\t", (int i)->{ if (ll.contains(searchKey)) System.out.println("Found " + searchKey + " in LinkedList."); } );
		measureOperation("\tSet:\t\t", (int i)->{ if (s.contains(searchKey)) System.out.println("Found " + searchKey + " in Set."); });
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
