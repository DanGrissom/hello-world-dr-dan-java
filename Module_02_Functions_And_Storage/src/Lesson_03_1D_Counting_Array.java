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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Random;
import java.util.Scanner;

public class Lesson_03_1D_Counting_Array {

	// Define a constant int array with bill values
	private static final int[] BILL_VALS = { 1, 2, 5, 10, 20, 50, 100, 500 };

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn how to store data in 1D arrays as counting arrays");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);

		// Initialize random number generator
		Random randy = new Random();

		// Prompt user for a number of elements to store
		System.out.print("\n\nEnter a number of random numbers to generate: ");
		int numElements = scan.nextInt();

		// Create 1D array from initial size
		int [] a = new int [numElements];
		for (int i = 0; i < a.length; i++)
			a[i] = randy.nextInt(100);
		int debt = printAndSumArray("Amount I Owe Several Individuals", a);

		// Count the number of each bill		
		// MAPPING: billCounts[0] = #1s, billCounts[1] = #2s, billCounts[2] = #5s...
		int [] billCounts = new int[BILL_VALS.length];

		// Iterate through each of the bill values and determine how many we need
		int remDebt = debt;
		for (int b = BILL_VALS.length - 1; b >= 0; b--) {
			// Get next largest bill value
			int billVal = BILL_VALS[b];
			int numBillsFittingInDebt = remDebt / billVal;
			billCounts[b] += numBillsFittingInDebt;
			remDebt -= (billVal * numBillsFittingInDebt);
		}

		// Print out summary
		System.out.printf("\n\nFewest bills required to pay off debt ($%s): \n", debt);
		for (int i = billCounts.length-1; i > 0; i--)
			if (billCounts[i] > 0)
				System.out.printf("\tNumber of $%s bills: %s\n", BILL_VALS[i], billCounts[i]);
	}

	///////////////////////////////////////////////////////////////////////////////////////
	// This method creates a new shuffled deck from a new deck.
	// 		Parameters:
	//			arrayName - String representing name of array to print
	//			array - array of ints to print
	//
	//		Returns:
	//			An integer representing the sum of the array
	///////////////////////////////////////////////////////////////////////////////////////
	private static int printAndSumArray(String arrayName, int [] array) {
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
		int total = 0;
		for (int i = 0; i < array.length; i++) {
			System.out.printf("$%s\t", array[i]);
			total += array[i];
		}

		// Print and return total
		System.out.printf("= $%s (TOTAL)", total);
		return total;
	}

}








