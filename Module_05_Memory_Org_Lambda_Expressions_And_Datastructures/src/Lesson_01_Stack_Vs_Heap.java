/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Memory Hierarchy & Computer Organization
//		2) Memory Structure and Storing Data (binary, decimal, hexadecimal)
//		3) How the Stack and Heap are used to store variables and data
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;

public class Lesson_01_Stack_Vs_Heap {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {	// Main method, which makes a call to methodA
		
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn the difference between the Stack and the Heap.");
		System.out.println("===========================================================================");
		
		// Create some variables
		ArrayList<Integer> mainList = new ArrayList<Integer>(); // An object
		int mainInt = 10; // A primitive
		mainList.add(mainInt); // Add the integer to the arrayList
		
		// Call methodA, passing in mainInt (by value BC primitive) and mainList (by reference BC object)
		methodA(mainInt, mainList);
		
		// Print the integer and list after ALL method calls to see which variables
		// were impacted by the method calls; if a variable changed, it means it was 
		// passed by reference and was in the heap; if a variable did not change, it 
		// means it was passed by value and a copy was added to the stack frame of the
		// method being called
		System.out.println("Printing mainInt after all method calls: " + mainInt);
		System.out.println("Printing all integers in mainList after all method calls:");
		for (int i : mainList)
			System.out.println("\t" + i);
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// This method takes in an integer (by value) and a list (by reference) and
	// makes updates 
	//		Parameters:
	//			aVar - An int, passed by value
	//			aList - An ArrayList of ints, passed by reference
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	public static void methodA(int aVar, ArrayList<Integer> aList) {
		// Modify the parameters
		int methAInt = 20;
		aVar++;
		aList.add(aVar);
		
		// Call methodB, passing in aVar (by value BC primitive) and aList (by reference BC object)
		methodB(aVar, aList);
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// This method takes in an integer (by value) and a list (by reference) and
	// makes updates 
	//		Parameters:
	//			aVar - An int, passed by value
	//			aList - An ArrayList of ints, passed by reference
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	public static void methodB(int bVar, ArrayList<Integer> bList) {
		// Modify the parameters
		int methBInt = 30;
		bVar++;
		bList.add(bVar);
	}

}
