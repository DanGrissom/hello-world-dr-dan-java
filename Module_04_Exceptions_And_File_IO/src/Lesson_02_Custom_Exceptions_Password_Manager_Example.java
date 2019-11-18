//*****Start with code from: Lesson_07_For_Loop_Char_Password_Analyzer

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Exceptions
//			a) Creating own password exception class
//			b) Throwing exceptions
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import models.IllegalUserAccountArgumentException;
import models.UserAccount;

public class Lesson_02_Custom_Exceptions_Password_Manager_Example {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to create a user-defined exception class and use it.");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);

		// Explain program to user
		System.out.println("Welcome to the password analyzer.");
		UserAccount.printPasswordRules();

		// Init variables for loop
		UserAccount account = null;
		boolean badInput = true;
		
		// Prompt user for account details (keep asking while they provide BAD input)
		do {
			try {
				// Prompt user for password and ask to repeat
				System.out.print("\nPlease enter a website: ");
				String website = scan.nextLine();
				System.out.print("Please enter a username: ");
				String username = scan.nextLine();
				System.out.print("Please enter a password: ");
				String p1 = scan.nextLine();
				System.out.print("Please enter your password again: ");
				String p2 = scan.nextLine();

				// Attempt to create a new password object
				account = new UserAccount(website, username, p1, p2);

				// If made it here, input was good!
				badInput = false;
			} catch (IllegalUserAccountArgumentException e) {
				System.out.println(e.getMessage());
				System.out.println("Please try again...");
			} catch (Exception e) {
				System.out.println("ERROR: An unkown error occurred: " + e.getMessage());
				System.out.println("Please try again...");
			}
		} while (badInput);

		// Print summary of class
		System.out.println(account);
	}

}
