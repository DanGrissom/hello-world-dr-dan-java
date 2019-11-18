/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) The basic equality and relational operators
// 			a) > for greater than
// 			b) >= for greater than or equal to
// 			c) < for less than
// 			d) <= for less than or equal to
// 			e) == for equal to
// 			f) != for not equal to
//		2) Unary logic operator
//			a) ! for NOT
//		3) The conditional operators
//			a) || for OR
//			b) && for AND
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Lesson_04_Logic {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn basic logic operators");
		System.out.println("===========================================================================");
		
		// Initialize scanner
		Scanner scan = new Scanner(System.in);
		
		// Prompt user for two integers
		System.out.println("Please enter two integers.");
		System.out.print("\tInteger 1: ");
		int num1 = scan.nextInt();
		System.out.print("\tInteger 2: ");
		int num2 = scan.nextInt();
		
		// Print out basic logic outcomes using the 6 relational operators
		System.out.println("The 6 relational operators in practice: ");
		System.out.printf("\t(%s > %s) ==> %s", num1, num2, (num1 > num2));
		System.out.printf("\t(%s >= %s) ==> %s", num1, num2, (num1 >= num2));
		System.out.printf("\t(%s < %s) ==> %s", num1, num2, (num1 < num2));
		System.out.printf("\t(%s <= %s) ==> %s", num1, num2, (num1 <= num2));
		System.out.printf("\t(%s == %s) ==> %s", num1, num2, (num1 == num2));
		System.out.printf("\t(%s != %s) ==> %s", num1, num2, (num1 != num2));
		
		// Print out basic logic outcomes using the 6 relational operators, but INVERTED
		System.out.println("\n\nThe 6 relational operators in practice with the expression being INVERTED with a NOT symbol: ");
		System.out.printf("\t!(%s > %s) ==> %s", num1, num2, !(num1 > num2));
		System.out.printf("\t!(%s >= %s) ==> %s", num1, num2, !(num1 >= num2));
		System.out.printf("\t!(%s < %s) ==> %s", num1, num2, !(num1 < num2));
		System.out.printf("\t!(%s <= %s) ==> %s", num1, num2, !(num1 <= num2));
		System.out.printf("\t!(%s == %s) ==> %s", num1, num2, !(num1 == num2));
		System.out.printf("\t!(%s != %s) ==> %s", num1, num2, !(num1 != num2));
		
		// Print out conditional outcome tables to show definitions of logical AND (&&)
		// && evaluates to true if and only if the left and right sides BOTH evaluate to true
		System.out.println("\n\nTruth table for the logical AND (&&): ");
		System.out.printf("\t(%s && %s) ==> %s", false, false, (false && false));
		System.out.printf("\t(%s && %s) ==> %s", false, true, (false && true));
		System.out.printf("\t(%s && %s) ==> %s", true, false, (true && false));
		System.out.printf("\t(%s && %s) ==> %s", true, true, (true && true));
		
		// Print out conditional outcome tables to show definitions of logical OR (||)
		// || evaluates to true when EITHER the left or right side evaluate to true
		System.out.println("\n\nTruth table for the logical OR (||): ");
		System.out.printf("\t(%s || %s) ==> %s", false, false, (false || false));
		System.out.printf("\t(%s || %s) ==> %s", false, true, (false || true));
		System.out.printf("\t(%s || %s) ==> %s", true, false, (true || false));
		System.out.printf("\t(%s || %s) ==> %s", true, true, (true || true));
		
		// Prompt user for two more integers
		System.out.println("\n\nPlease enter two additional integers.");
		System.out.print("\tInteger 3: ");
		int num3 = scan.nextInt();
		System.out.print("\tInteger 4: ");
		int num4 = scan.nextInt();
		
		// Print out a pseudo-random logical statement with &&
		boolean entireExpression = !(num1 >= num2) && (num3 < num4);
		System.out.printf("\nEvaluating:\t!(%s >= %s) && (%s < %s) ==> %s\n", num1, num2, num3, num4, entireExpression);
		boolean innerLeft = (num1 >= num2);
		boolean innerRight = (num3 < num4);
		System.out.printf("\t\t!(%s) && (%s) ==> %s\n", innerLeft, innerRight, (!innerLeft && innerRight));
		boolean notInnerLeft = !innerLeft;
		System.out.printf("\t\t%s && %s ==> %s\n", notInnerLeft, innerRight, (notInnerLeft && innerRight));
		
		// Print out a pseudo-random logical statement with ||
		entireExpression = !(!(num4 >= num3) || (num2 < num1));
		System.out.printf("\nEvaluating:\t!(!(%s >= %s) || (%s < %s)) ==> %s\n", num4, num3, num2, num1, entireExpression);
		innerLeft = (num4 >= num3);
		innerRight = (num2 < num1);
		System.out.printf("\t\t!(!(%s) || (%s)) ==> %s\n", innerLeft, innerRight, !(!innerLeft || innerRight));
		notInnerLeft = !innerLeft;
		boolean inner = notInnerLeft || innerRight;
		System.out.printf("\t\t!(%s || %s) ==> %s\n", notInnerLeft, innerRight, !(inner));
		System.out.printf("\t\t!(%s) ==> %s\n", inner, !(inner));
		
	}

}
