/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
// 		1) Print to console using System.out.print()
//		2) Print to console using System.out.println()
//		3) Print to console using System.out.printf()
//		4) Utilize escape characters \n (new line), \t (tab), \" (quotes) and \\ (backslash) to print special characters
//		5) Use // and /* */ to comment single and multiple lines of code, respectively
//		6) Recognize errors and read error output
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Lesson_01_Basics {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to print to console, escape characters & comments.");
		System.out.println("===========================================================================");
		//System.out.println();

		// Variable test and output
		String name = "Dr. Dan";
		int numWorkDays = 5;
		int numWeekendDays = 2;
		int numDaysInWeek = numWorkDays + numWeekendDays;
		
		// Print out variables in output
		/*System.out.println(name + " there are " + numWorkDays + " days in a work week.");
		System.out.println(name + " there are " + numWeekendDays + " days in a weekend.");
		System.out.println(name + " there are " + numDaysInWeek + " days in a week.");*/
		System.out.printf("%s, there are %s work days and %s weekend days, which makes %s total days.\n\n", name, numWorkDays, numWeekendDays, numDaysInWeek);

		// Testing the escape ('\') character (tabs, new-lines, quotes
		System.out.print("I'm so glad I don't have to work the two weekend days:\n\tSaturday\n\tSunday\n\n");
		System.out.printf("When the weekend comes, %s says \"Yay, let's visit http:\\\\dangrissom.com\"", name);
	}
}
