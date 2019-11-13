import java.util.Scanner;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// In this lesson you will learn:
//		1) Functions
//			a) Function Prototype: accessModifier static returnType functionName(parameters)
//			b) Passing parameters by value
//		2) Static variables
//			a) Variables that can be used anywhere in the file when using a main() method
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Lesson_01_Functions_Pass_By_Value_And_Static {

	//////////////////////////////////////////////////////////////////
	// Static Variables
	static Scanner scan = new Scanner(System.in); 		// Initialize Scanner to read in from user
	static double runningSum = 0;						// Initialize variables for stats
	static double minGrade = Double.MAX_VALUE;
	static double maxGrade = Double.MIN_VALUE;
	static double avgGrade = 0;

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use functions and static variables to simplify code ");
		System.out.println("===========================================================================");

		// Prompt user for number
		System.out.print("Please enter the number of assignments submitted on time: ");
		int numGrades = scan.nextInt();
		final double LATE_PENALTY = 10;

		////////////////////////////////////////////////////////////////////////////////////
		// For each grade to collect: Get next grade from user, update and print stats
		for (int i = 0; i < numGrades; i++) {
			double newGrade = getNextGrade(i+1);
			updateStats(newGrade, i+1);
			if (i != (numGrades - 1))				// Do not print during last iteration
				printStatistics(i+1, false);
		}

		// Print final statistics
		printStatistics(numGrades, true);

		// Ask user if there are any late grades to collect
		scan.nextLine(); // Flush new line
		System.out.print("\nAre there any late grades to collect (Y/N): ");
		boolean moreGrades = scan.nextLine().toUpperCase().charAt(0) == 'Y';

		////////////////////////////////////////////////////////////////////////////////////
		// WHILE the user wants to collect more grades...
		while (moreGrades) {
			// Get next grade from user, update and print stats
			double newGrade = getNextGrade(numGrades+1);
			updateStats(newGrade, numGrades+1);
			printStatistics(++numGrades, false);

			// Ask user if there are any late grades to collect
			scan.nextLine(); // Flush new line
			System.out.print("\nAre there any late grades to collect (Y/N): ");
			moreGrades = scan.nextLine().toUpperCase().charAt(0) == 'Y';
		}

		// Print final statistics
		printStatistics(numGrades, true);

	}

	////////////////////////////////////////////////////////////////////////////////
	// This method repeatedly asks the user to enter a new grade while it is within
	// the range of appropriate grades.
	//		Parameters:
	//			gradeNumber: An integer which represents how many grades will have 
	//							been collected with this grade
	//		Returns:
	//			A double which represents the new grade entered by the user
	////////////////////////////////////////////////////////////////////////////////
	private static double getNextGrade(int gradeNumber) {
		double newGrade = 0;

		// Continue to read grades while the input is bad (that is, until it is good!)
		boolean badInput = true;
		do {
			// Prompt user for grade and read
			System.out.print("Enter grade " + gradeNumber + ": ");
			newGrade = scan.nextDouble();

			// Check if grade is valid
			if (newGrade < 0 || newGrade > 100) {
				System.out.println("\tGrade must be from 0% - 100%. You entered: " + newGrade + "%");
				System.out.println("\tPlease try again...");
			} else {
				badInput = false;
			}
		} while (badInput);

		return newGrade;
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method updates basic statistics of sum, min, max and average.
	//		Parameters:
	//			grade:			A double which represents the new grade to process
	//			gradeNumber: 	An integer which represents how many grades will have 
	//							been collected with this grade
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private static void updateStats(double grade, int gradeNumber) {
		// Compute stats
		runningSum += grade;
		minGrade = Math.min(minGrade, grade);
		maxGrade = Math.max(maxGrade, grade);
		avgGrade = runningSum / gradeNumber;
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method prints the basic statistics of sum, min, max and average.
	//		Parameters:
	//			numGradesCollected: 	An integer which represents how many grades have 
	//									been collected
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private static void printStatistics(int numGradesCollected, boolean finalStatistics) {
		// Make sure grades were collected
		if (numGradesCollected <= 0)
			System.out.println("You did not enter any grades!");
		else {
			// Print appropriate prefix
			if (finalStatistics)
				System.out.println("\nFinal statistics for " + numGradesCollected + " grades:");
			else
				System.out.printf("\tAfter %s grades: ", avgGrade, minGrade, maxGrade);
			
			// Print stats
			System.out.printf("\tAvg = %.2f; Min = %.2f; Max = %.2f\n", avgGrade, minGrade, maxGrade);
		}

	}
}
