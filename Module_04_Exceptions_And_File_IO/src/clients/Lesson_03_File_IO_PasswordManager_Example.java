/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) File I/O
//			a) Plain Text I/O
//				i) FileInputStream, FileOutputStream, Scanner, PrintWriter, FileNotFoundException
//			a) Serialized Text I/O
//				i) FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream, EOFException, Serializable
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package clients;
import java.util.Scanner;
import models.UserAccount;

public class Lesson_03_File_IO_PasswordManager_Example {
	
	// File name constants initialization
	private static final String filenamePT = "accountsPlainText.txt";
	private static final String filenameSer = "accountsSerialized.txt";

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to read/write from/to file using plain and serialized I/O.");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);

		// Explain program to user
		System.out.println("Welcome to the account/password storage program!");
		UserAccount.printPasswordRules();
		System.out.println("---------------------------------------------------------\n");

		// Prompt user for file IO type

		// Create arraylist of accounts, read order into arraylist and print accounts
		
		// Prompt user to add more accounts and collect info

		// Print out all existing accounts and write to file
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// This method reads in accounts into the accounts ArrayList using the file
	// input method specified in the plainText parameter
	//		Parameters:
	//			accounts - An ArrayList to add accounts read in from file
	//			plainText - A boolean telling whether to read in as plain text (true)
	//						or serialized (false) input
	//		Returns:
	//			void (nothing) - But DOES update the accounts ArrayList
	////////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////////
	// This method writes out the accounts passed in via the ArrayList to file
	// using the file output method specified in the plainText parameter
	//		Parameters:
	//			accounts - An ArrayList of accounts to write to file
	//			plainText - A boolean telling whether to write as plain text (true)
	//						or serialized (false) output
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////////
	// This method prints all accounts passed in via the array list.
	//		Parameters:
	//			printHeader - A String to print as a header
	//			accounts - An ArrayList of accounts print
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
}
