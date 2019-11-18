/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) The basic Java math operators
// 			a) + for addition
//			b) - for subtraction
//			c) * for multiplication
//			d) / for division
//			e) % for modulus	(modulus is remainder, so if 6 / 4 = 1 with remainder of 2, then 6 % 4 = 2)
//		2) Basic Math class operators
//			a) Math.pow() for powers
//		3) The Java short-hand operator
//			a) +=, -=, *= and /=
//		4) The Java incrementer and decrementer operators
//			a) ++ for incrementer
//			b) -- decrementer
//		5) Introduction to conditional logic
//			a) if, else if, else statements
//			b) switch statements
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Lesson_05_Basic_Math {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn Java mathematical operators and conditional statements");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);

		// Welcome user to program and explain functionality
		System.out.println("Welcome to the simple calculator program. Supported operations are: ");
		System.out.println("\t+ for addition");
		System.out.println("\t- for subtraction");
		System.out.println("\t* for multiplication");
		System.out.println("\t/ for division");
		System.out.println("\t% for modulus");
		System.out.println("\t^ for power (NOT A BASIC OPERATOR)\n");

		
		//////////////////////////////////////////////////////////////////////////////////////
		// Perform basic math operation with doubles (numbers that can have decimal points.
		//////////////////////////////////////////////////////////////////////////////////////		
		// Prompt user for equation and read input
		System.out.print("Please enter an equation with spacing between equation parts (decimals supported; Ex: 4.5 + 2.65): ");
		double operand1 = scan.nextDouble();
		String operator = scan.next();
		double operand2 = scan.nextDouble();

		// Examine operator and compute answer based on operator
		double answer = 0;
		if (operator.length() > 1) {
			System.out.println("Operator can only be one character long. You entered: " + operator);
			System.out.println("Exiting program...");
			System.exit(0);
		}
		
		if (operator.contains("+"))
			answer = operand1 + operand2;
		else if (operator.contains("-")) 
			answer = operand1 - operand2;
		else if (operator.contains("*")) 
			answer = operand1 * operand2;
		else if (operator.contains("/")) 
			answer = operand1 / operand2;
		else if (operator.contains("%")) 
			answer = operand1 % operand2;
		else if (operator.contains("^")) 
			answer = Math.pow(operand1, operand2);
		else {
			System.out.println("Operators must be one of the following: +, -, *, /, %. You entered: " + operator);
			System.out.println("Exiting program...");
			System.exit(0);
		}

		// Print result
		System.out.printf("\t%.2f %s %.2f = %.2f\n\n", operand1, operator, operand2, answer);




		//////////////////////////////////////////////////////////////////////////////////////
		// Perform basic math operation with integers (whole numbers with no decimals).
		//////////////////////////////////////////////////////////////////////////////////////		
		// Prompt user for equation and read input
		System.out.print("Please enter an equation with spacing between equation parts (whole numbers supported; Ex: 4 + 2): ");
		int op1 = scan.nextInt();
		operator = scan.next();
		int op2 = scan.nextInt();

		int ans = 0;
		if (operator.length() > 1) {
			System.out.println("Operator can only be one character long. You entered: " + operator);
			System.out.println("Exiting program...");
			System.exit(0);
		}

		// Examine operator and compute answer based on operator
		switch(operator) {
			case "+":
				ans = op1 + op2;
				break;
			case "-": 
				ans = op1 - op2;
				break;
			case "*":
			case "x":
				ans = op1 * op2;
				break;
			case "/": 
				ans = op1 / op2;
				break;
			case "%": 
				ans = op1 % op2;
				break;
			case "^": 
				ans = (int) Math.pow(op1, op2);
				break;
			default:
				System.out.println("Operators must be one of the following: +, -, *, /, %. You entered: " + operator);
				System.out.println("Exiting program...");
				System.exit(0);
		}
		
		// Print result
		System.out.printf("\t%s %s %s = %s\n\n", op1, operator, op2, ans);
		
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		// Perform basic math operation to demonstrate short-hand operators
		//////////////////////////////////////////////////////////////////////////////////////
		// Prompt user to modify their answer
		System.out.println("You can now modify your answer by adding to it, subtracting from it, multiplying or dividing it.");
		System.out.print("\tWhat operator would you like to modify " + ans + " by (+, -, *, /): ");
		operator = scan.next();
		
		// Check operator length
		if (operator.length() > 1) {
			System.out.println("Operator can only be one character long. You entered: " + operator);
			System.out.println("Exiting program...");
			System.exit(0);
		}
		
		// Prompt user for new operand
		int op3 = 0;
		int prevAns = ans;
		if (operator.contains("+")) {
			System.out.print("\tAdd how many to " + ans + ": ");
			op3 = scan.nextInt();
			
			// If they want to add 1, we can use the increment operator (++)
			if (op3 == 1)
				ans++;
			else
				ans += op3;
		} else if (operator.contains("-")) {
			System.out.print("\tSubtract how many from " + ans + ": ");
			op3 = scan.nextInt();

			// If they want to subtract 1, we can use the decrement operator (++)
			if (op3 == 1)
				answer--;
			else
				ans -= op3;
		} else if (operator.contains("*")) {
			System.out.print("\tMultiply " + ans + " by: ");
			op3 = scan.nextInt();
			ans *= op3;
		} else if (operator.contains("/")) {
			System.out.print("\tDivide " + ans + " by: ");
			op3 = scan.nextInt();
			ans /= op3;
		}
		
		// Print result
		System.out.printf("\t%s %s %s = %s\n\n", prevAns, operator, op3, ans);
		
		// Exit program
		System.out.println("Exiting program...");
	}

}
