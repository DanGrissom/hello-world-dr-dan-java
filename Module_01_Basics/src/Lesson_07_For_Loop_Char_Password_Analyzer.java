/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Loop Constructs
//			a) FOR loop (for when we know how many times we need to do something) - looping through Strings
//		2) String operations
//			a) equals() - For comparing two strings to see if they have the same contents
//			b) equalsIgnoreCase() - For comparing two strings to see if they have the same contents, but ignoring casing
//			c) charAt() - For getting a character at a certain index of the string
//		3) char and Character operations
//			a) The Character wrapper class and some of its methods:
//				i) isUpperCase(), isLowerCase(), isDigit(), isWhitespace()
//			b) Understanding the ASCII Table and converting chars to ints
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Lesson_07_For_Loop_Char_Password_Analyzer {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn the for loop construct ");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);

		// Explain program to user
		System.out.println("Welcome to the password analyzer, your password must: ");
		System.out.println("\tBe at least 7 characters in length");
		System.out.println("\tContain at least one of the following special symbols:");
		//if ( (c >= 33 && c <=47) || (c >= 58 && c <= 64)  || (c >= 91 && c <= 96) || (c >= 123 && c <= 126) )
		System.out.print("\t\t");
//		for (int i = 33; i <= 47; i++)
//			System.out.print((char)i + " ");
//		for (int i = 58; i <= 64; i++)
//			System.out.print((char)i + " ");
//		for (int i = 91; i <= 96; i++)
//			System.out.print((char)i + " ");
//		for (int i = 123; i <= 126; i++)
//			System.out.print((char)i + " ");
		for (int c = 0; c <= 127; c++)
			if ( (c >= 33 && c <=47) || (c >= 58 && c <= 64)  || (c >= 91 && c <= 96) || (c >= 123 && c <= 126) )
				System.out.print((char)c + " ");
		System.out.println("\n\tContain at least one upper case character");
		System.out.println("\tContain at least one lower case character");
		System.out.println("\tContain at least one number");
		System.out.println("\tNOT contain spaces");

		// Prompt user for password and ask to repeat
		System.out.print("\nPlease enter a password: ");
		String p1 = scan.nextLine();
		System.out.print("Please enter your password again: ");
		String p2 = scan.nextLine(); 

		// Initialize an empty error message
		String errorMessage = "";

		// Check that password match
		if (!p1.equals(p2)) {
			errorMessage += "ERROR: Password do not match\n";
			if (p1.equalsIgnoreCase(p2))
				errorMessage += "\tNOTICE: Passwords match other than casing\n";
		}

		// Check that password length is sufficient
		if (p1.length() < 7)
			errorMessage += "ERROR: Password must be 7+ characters long\n";
		
		// Print out the string and it's indices for learning purposes
//		System.out.print("index:\t");
//		for (int i = 0; i < p1.length(); i++)
//			System.out.print(i + "\t");
//		System.out.print("\np1(i):\t");
//		for (int i = 0; i < p1.length(); i++)
//			System.out.print(p1.charAt(i) + "\t");
			
		// Init boolean variables
		boolean containsUpper = false;
		boolean containsLower = false;
		boolean containsNumber = false;
		boolean containsWhiteSpace = false;
		boolean containsSpecialCharacter = false;
		
		// Cycle through each letter and check for special symbols
		for (int i = 0; i < p1.length(); i++) {
			char c = p1.charAt(i);
			
			if (Character.isUpperCase(c))
				containsUpper = true;
			if (Character.isLowerCase(c))
				containsLower = true;
			if (Character.isDigit(c))
				containsNumber = true;
			if (Character.isWhitespace(c))
				containsWhiteSpace = true;
			if ( (c >= 33 && c <=47) || (c >= 58 && c <= 64)  || (c >= 91 && c <= 96) || (c >= 123 && c <= 126) )
				containsSpecialCharacter = true;
		}
		
		// Update error message based off of boolean variables
		if (!containsUpper)
			errorMessage += "ERROR: Password must contain an upper case letter\n";
		if (!containsLower)
			errorMessage += "ERROR: Password must contain an upper case letter\n";
		if (!containsNumber)
			errorMessage += "ERROR: Password must contain a number\n";
		if (containsWhiteSpace)
			errorMessage += "ERROR: Password must NOT contain whitespace\n";
		if (!containsSpecialCharacter)
			errorMessage += "ERROR: Password must contain a special character\n";
		
		// Print out error message or success
		if (errorMessage.isEmpty())
			System.out.println("Password accepted!");
		else
			System.out.println("\nFINAL SUMMARY\n=============\n" + errorMessage);

	}

}
