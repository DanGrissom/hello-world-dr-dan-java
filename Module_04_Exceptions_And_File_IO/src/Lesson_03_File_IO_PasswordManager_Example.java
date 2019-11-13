//*****Start with code from: Lesson_02_Custom_Exceptions_Password_Manager_Example

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// In this lesson you will learn:
//		1) File I/O
//			a) Plain Text I/O
//				i) FileInputStream, FileOutputStream, Scanner, PrintWriter, FileNotFoundException
//			a) Serialized Text I/O
//				i) FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream, EOFException, Serializable
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;
import models.IllegalUserAccountArgumentException;
import models.UserAccount;
import util.FileIoPlainText;
import util.FileIoSerialized;

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
		System.out.println("Would you like to print using plain text (P) or serialized (S)?");
		boolean plainTextChosen = scan.nextLine().toUpperCase().charAt(0) == 'P';

		// Create arraylist of accounts, read order into arraylist and print accounts
		ArrayList<UserAccount> accounts = new ArrayList<UserAccount>();
		readOrder(accounts, plainTextChosen);
		printAccounts("Existing Accounts", accounts);
		
		// Prompt user to add more accounts and collect info
		System.out.println("\n-------Add New Accounts-------");
		boolean moreAccounts = true;
		do {
			try {
				// Prompt user for password and ask to repeat
				System.out.print("Please enter a website: ");
				String website = scan.nextLine();
				System.out.print("Please enter a username: ");
				String username = scan.nextLine();
				System.out.print("Please enter a password: ");
				String p1 = scan.nextLine();
				System.out.print("Please enter your password again: ");
				String p2 = scan.nextLine();

				// Attempt to create a new password object
				UserAccount account = new UserAccount(website, username, p1, p2);
				accounts.add(account);

				// Ask if user wants to add more accounts
				System.out.print("Would you like to add another account (Y/N): ");
				moreAccounts = scan.nextLine().toUpperCase().charAt(0) == 'Y';	
			} catch (IllegalUserAccountArgumentException e) {
				System.out.println(e.getMessage());
				System.out.println("Please try again...");
			} catch (Exception e) {
				System.out.println("ERROR: An unkown error occurred: " + e.getMessage());
				System.out.println("Please try again...");
			} finally {
				System.out.println();
			}
		} while (moreAccounts);

		// Print out all existing accounts and write to file
		printAccounts("Updated Accounts", accounts);
		writeOrder(accounts, plainTextChosen);
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
	public static void readOrder(ArrayList<UserAccount> accounts, boolean plainText) {
		if (plainText)
			FileIoPlainText.readAccounts(filenamePT, accounts);
		else
			FileIoSerialized.readAccounts(filenameSer, accounts);
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// This method writes out the accounts passed in via the ArrayList to file
	// using the file output method specified in the plainText parameter
	//		Parameters:
	//			accounts - An ArrayList of accounts to write read to file
	//			plainText - A boolean telling whether to write as plain text (true)
	//						or serialized (false) output
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	public static void writeOrder(ArrayList<UserAccount> accounts, boolean plainText) {
		if (plainText)
			FileIoPlainText.writeAccounts(filenamePT, accounts);
		else
			FileIoSerialized.writeAccounts(filenameSer, accounts);
	}
	
	public static void printAccounts(String printHeader, ArrayList<UserAccount> accounts) {
		System.out.printf("-------%s-------\n", printHeader);
		if (accounts.size() > 0) {
		for (int i = 0; i < accounts.size(); i++)
			System.out.println((i + 1) + ": " + accounts.get(i).toString());
		} else
			System.out.println("No accounts exist yet");
	}

}
