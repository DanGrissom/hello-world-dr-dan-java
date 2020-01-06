/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_02_Custom_Exceptions_Password_Manager_Example.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package models;

import java.io.Serializable;
import java.util.Calendar;

public class UserAccount implements Serializable {

	////////////////////////////////////////////////////////////////////////////////
	// Instance Variables
	////////////////////////////////////////////////////////////////////////////////
	private String website;
	private String username;
	private String password;
	private int monthCreated;
	private int yearCreated;
	private transient int passwordLength;

	////////////////////////////////////////////////////////////////////////////////
	// Constructor
	//		Parameters:
	//			pWebsite - A String representing the website
	//			pUsername - A String representing the username for the website
	//			p1 - A String representing the password
	//			p2 - A String representing a duplicate of the password
	//			pMonthCreated - An integer representing the month the account was created
	//			pYearCreated - An integer representing the year the account was created
	////////////////////////////////////////////////////////////////////////////////
	public UserAccount(String pWebsite, String pUsername, String p1, String p2, int pMonthCreated, int pYearCreated) {
		website = pWebsite;
		username = pUsername;
		setPassword(p1, p2);
		passwordLength = password.length();
		monthCreated = pMonthCreated;
		yearCreated = pYearCreated;
	}

	////////////////////////////////////////////////////////////////////////////////
	// Constructor (Month/Year initialized from today's date)
	//		Parameters:
	//			pWebsite - A String representing the website
	//			pUsername - A String representing the username for the website
	//			p1 - A String representing the password
	//			p2 - A String representing a duplicate of the password
	////////////////////////////////////////////////////////////////////////////////
	public UserAccount(String pWebsite, String pUsername, String p1, String p2) {
		website = pWebsite;
		username = pUsername;
		setPassword(p1, p2);
		passwordLength = password.length();

		// Get month/year from calendar
		Calendar cal = Calendar.getInstance();
		monthCreated = cal.get(Calendar.MONTH) + 1;
		yearCreated = cal.get(Calendar.YEAR);
	}

	////////////////////////////////////////////////////////////////////////////////
	// Getters/setters
	////////////////////////////////////////////////////////////////////////////////
	public String getWebsite() { return website; }
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public int getMonthCreated() { return monthCreated; }
	public int getYearCreated() { return yearCreated; }
	
	private void setPassword(String p1, String p2) {
		validatePassword(p1, p2);
		password = p1;
	}


	////////////////////////////////////////////////////////////////////////////////
	// This method checks if the two passwords equal one another. If they don't, an
	// exception is thrown; if they do equal, nothing happens.
	//		Parameters:
	//			p1 - A String representing the password
	//			p2 - A String representing a duplicate of the password
	//		Returns:
	//			void (nothing) - but THROWS exception if error found
	////////////////////////////////////////////////////////////////////////////////
	private void validatePassword(String p1, String p2) {
		// Initialize an empty error message
		String errorMessage = "";

		// Check that password match
		if (!p1.equals(p2)) {
			errorMessage += "\tERROR: Password do not match\n";
			if (p1.equalsIgnoreCase(p2))
				errorMessage += "\t\tNOTICE: Passwords match other than casing\n";
		}

		// Check that password length is sufficient
		if (p1.length() < 7)
			errorMessage += "\tERROR: Password must be 7+ characters long\n";

		// Init boolean variables
		boolean containsUpper = false;
		boolean containsLower = false;
		boolean containsNumber = false;
		boolean containsWhiteSpace = false;
		boolean containsSpecialCharacter = false;

		// Cycle through each letter and check for special symbols
		for (int i = 0; i < p1.length(); i++) {
			// Get the character at index i
			char c = p1.charAt(i);

			// Use the Character wrapper class to evaluate each character for requirements
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
			errorMessage += "\tERROR: Password must contain an upper case letter\n";
		if (!containsLower)
			errorMessage += "\tERROR: Password must contain an upper case letter\n";
		if (!containsNumber)
			errorMessage += "\tERROR: Password must contain a number\n";
		if (containsWhiteSpace)		// Note we have NO ! symbol here
			errorMessage += "\tERROR: Password must NOT contain whitespace\n";
		if (!containsSpecialCharacter)
			errorMessage += "\tERROR: Password must contain a special character\n";

		// Print out error message or success
		if (!errorMessage.isEmpty())
			throw new IllegalUserAccountArgumentException(errorMessage);
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method prints out the rules for the password.
	//		Parameters:
	//			NONE
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	public static void printPasswordRules() {
		System.out.println("Your password must: ");
		System.out.println("\tBe at least 7 characters in length");
		System.out.println("\tContain at least one of the following special symbols:");
		System.out.print("\t\t");
		for (int c = 0; c <= 127; c++)
			if ( (c >= 33 && c <=47) || (c >= 58 && c <= 64)  || (c >= 91 && c <= 96) || (c >= 123 && c <= 126) )
				System.out.print((char)c + " ");	// Only print the special characters according to http://www.asciitable.com/
		System.out.println("\n\tContain at least one upper case character");
		System.out.println("\tContain at least one lower case character");
		System.out.println("\tContain at least one number");
		System.out.println("\tNOT contain spaces");		
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method overrides the toString() method for a standard summary of the class.
	//		Parameters:
	//			NONE
	//		Returns:
	//			A String representing the instance variables
	////////////////////////////////////////////////////////////////////////////////
	public String toString() {
		String str = String.format("%s (%s / %s) - Created %02d/%s", website, username, password, monthCreated, yearCreated);
		return str;
	}
}
