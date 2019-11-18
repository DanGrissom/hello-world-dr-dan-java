/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) 1D Arrays
//			a) Declaring 1D arrays with constant data
//			b) Declaring 1D arrays from a variable
//			c) Iterating through and printing 1D arrays
//		2) Random class
//			a) Generating random numbers
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Random;
import java.util.Scanner;

public class Lesson_02_1D_Array_Toy_Examples {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to store and access data in 1D arrays using a toy example");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);
		
		// Initialize random number generator
		Random randy = new Random();
		
		// Create a hard-coded 1D array
		int [] arrHardCodedNums = { 1, 2, 3, 4, 5, 6};
		printArray("Hard-Coded 1D Array", arrHardCodedNums);
		//System.out.println( Arrays.toString(arrHardCodedNums));

		// Prompt user for a number of elements to store
		System.out.print("\n\nEnter a number of random numbers to generate: ");
		int numElements = scan.nextInt();
		
		// Create 1D array from initial size
		int [] a = new int [numElements];
		for (int i = 0; i < a.length; i++)
			a[i] = randy.nextInt(200);
		printArray("Randomly Generated 1D Array", a);
		
		// Prompt user to change the value at a particular index
		System.out.print("\n\nEnter an index you'd like to overwrite: ");
		int iNew = scan.nextInt();
		System.out.printf("Enter a value to overwrite the current data (a[%s] = %s): ", iNew, a[iNew]);
		int vNew = scan.nextInt();
		
		// Overwrite value and print updated array
		a[iNew] = vNew;
		printArray("Updated Randomly Generated 1D Array", a);
		
		// Prompt user to overwrite a particular value, regardless of its index (Same as search)
		System.out.print("\n\nEnter a value to overwrite the current data (index unknown): ");
		int findVal = scan.nextInt();
		
		// Search for value and replace if found
		boolean foundVal = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == findVal) {
				System.out.printf("FOUND - Enter a value to overwrite the current data (a[%s] = %s): ", i, a[i]);
				vNew = scan.nextInt();
				a[i] = vNew;
				foundVal = true;
				//break;	// Only replace the first value
			}
		}
		
		// Print result of the search
		if (foundVal)
			printArray("Updated Randomly Generated 1D Array", a);
		else
			System.out.printf("\t%s not found in the array; array unchanged", findVal);
	
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	// This method creates a new shuffled deck from a new deck.
	// 		Parameters:
	//			arrayName - String representing name of array to print
	//			array - array of ints to print
	//
	//		Returns:
	//			void (nothing)
	///////////////////////////////////////////////////////////////////////////////////////
	private static void printArray(String arrayName, int [] array) {
		// Print header
		System.out.printf("\nPrinting %s (size %s)\n", arrayName, array.length);
		System.out.println("=================================");
		
		// Print index numbers
		for (int i = 0; i < array.length; i++)
			System.out.printf("a[%s]\t", i);
		
		// Print = sign for each index/value
		System.out.println();
		for (int i = 0; i < array.length; i++)
			System.out.printf("=\t", i);
		
		// Print array values
		System.out.println();
		for (int i = 0; i < array.length; i++)
			System.out.printf("%s\t", array[i]);
	}

}
