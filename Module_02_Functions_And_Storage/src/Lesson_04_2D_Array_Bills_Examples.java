/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) 2D Arrays
//			a) Declaring 2D arrays with constant data
//			b) Declaring 2D arrays from a variable
//			c) Iterating through and printing 2D arrays
//			d) Summing rows and columns of 2D arrays
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Random;
import java.util.Scanner;

public class Lesson_04_2D_Array_Bills_Examples {

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
		
		// Create a hard-coded 1D array
		double [][] arrHardCodedNums = {
											{1, 2, 3},
											{4, 5, 6},
											{7, 8, 9},
											{10, 11, 12}
										};
		//printArray("Hard-Coded 2D Array", arrHardCodedNums);
		//System.out.println( Arrays.deepToString(arrHardCodedNums));

		// Welcome user
		System.out.println("Welcome to the family bill analyzer.");
		
		// Prompt user to enter names
		System.out.print("Enter the number of family members who have bills: ");
		int numFamMems = scan.nextInt();
		String [] famNames = new String[numFamMems];
		for (int i = 0; i < famNames.length; i++) {
			System.out.printf("\tPlease enter family member number %s's name: ", (i+1));
			famNames[i] = scan.next();
		}
		
		// Prompt user to enter months
		System.out.print("Enter the number of months of bills: ");
		int numMonths = scan.nextInt();
		String [] months = new String[numMonths];
		for (int i = 0; i < months.length; i++) {
			System.out.printf("\tPlease enter name of month number %s: ", (i+1));
			months[i] = scan.next();
		}
		
		// Initialize a 2D array and collect data (months represent columns; names represent rows)
		double [][] bills = new double[numFamMems][numMonths];
		for (int m = 0; m < months.length; m++) {
			System.out.println("Collecting bills for " + months[m].toUpperCase() + ":");
			
			for (int p = 0; p < famNames.length; p++) {
				System.out.printf("\tEnter bill value for %s: ", famNames[p]);
				bills[p][m] = scan.nextDouble();
			}
		}
		
		// Print 2D array
		printArray("Family Bills", bills, famNames, months);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	// This method creates a new shuffled deck from a new deck.
	// 		Parameters:
	//			arrayName - String representing name of array to print
	//			array - array of ints to print
	//			rowNames - array of Strings with names for each row
	//			colNames - array of Strings with names for each col
	//
	//		Returns:
	//			void (nothing)
	///////////////////////////////////////////////////////////////////////////////////////
	private static void printArray(String arrayName, double [][] array, String [] rowNames, String [] colNames) {
		// Get number of rows and columns (assuming all rows have the same number of columns
		int numRows = array.length;
		double [] firstRow = array[0];
		int numCols = array[0].length;
		String spacing = "\t\t";
		
		// Standardize row/col names
		for (int i = 0; i < rowNames.length; i++)
			rowNames[i] = rowNames[i].length() > 3 ? rowNames[i].substring(0, 3).toUpperCase() : rowNames[i].toUpperCase();
		for (int i = 0; i < colNames.length; i++)
			colNames[i] = colNames[i].length() > 3 ? colNames[i].substring(0, 3).toUpperCase() : colNames[i].toUpperCase();
		
		// Print header
		System.out.printf("\nPrinting %s (size %s x %s)\n", arrayName, numRows, numCols);
		System.out.println("=================================");
		System.out.printf("r\\c%s", spacing);
		
		// Print column names...
		for (int c = 0; c < firstRow.length; c++)
			System.out.printf("%s%s", colNames[c], spacing);
		System.out.printf("SUM\n%s", spacing);
		//...and lines below (header continued)
		for (int c = 0; c <= firstRow.length; c++)
			System.out.printf("-----%s", spacing);
		System.out.println();
		
		// Create an array to sum up columns
		double [] colSums = new double[numCols];
		
		// Print out each row (proper dollar format)
		for (int r = 0; r < numRows; r++) {
			// Print row number
			System.out.printf("%s|%s", rowNames[r], spacing);
			
			// Print out column values and add col/row sums
			double rowSum = 0;
			for (int c = 0; c < array[r].length; c++) {
				System.out.printf("$%.2f%s", array[r][c], spacing);
				rowSum += array[r][c];
				colSums[c] += array[r][c]; 
			}
			System.out.printf("$%.2f\n\n", rowSum);
		}
		
		// Print out finally summary of columns
		System.out.printf("SUM|%s", spacing);
		double totalSum = 0;
		for (int c = 0; c < colSums.length; c++) {
			System.out.printf("$%.2f%s", colSums[c], spacing);
			totalSum += colSums[c];
		}
		System.out.printf("$%.2f%s", totalSum, spacing);
	}
}
