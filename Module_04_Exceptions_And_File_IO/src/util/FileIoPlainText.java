/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class is consumed by Lesson_03_File_IO_PasswordManager_Example.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import models.UserAccount;

public class FileIoPlainText {

	////////////////////////////////////////////////////////////////////////////////
	// This method reads in accounts into the accounts ArrayList using plain text
	//		Parameters:
	//			filename - A string representing the file to read from
	//			accounts - An ArrayList to add accounts read in from file
	//		Returns:
	//			void (nothing) - But DOES update the accounts ArrayList
	////////////////////////////////////////////////////////////////////////////////
	public static void readAccounts(String filename, ArrayList<UserAccount> accounts) {

		// Create input objects/classes
		FileInputStream fis = null;
		Scanner fScan = null;

		try {
			// Init input objects/classes
			fis = new FileInputStream(filename);
			fScan = new Scanner(fis);			

			// Read data in from file
			while (fScan.hasNextLine()) {
				// Create line scanner which uses CSVs
				String line = fScan.nextLine();
				Scanner lScan = new Scanner(line);
				lScan.useDelimiter(",");

				// Parse instance variables out of line
				String website = lScan.next().trim();
				String username = lScan.next().trim();
				String password = lScan.next().trim();
				int month = Integer.parseInt(lScan.next().trim());
				int year = Integer.parseInt(lScan.next().trim());
				UserAccount account = new UserAccount(website, username, password, password, month, year);
				
				// Add burrito from file/line into order
				accounts.add(account);
			}

		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found, but will be created as a new order.");
		} catch (Exception e) {
			System.out.println("ERROR: An unknown error occurred.");
			e.printStackTrace();
		} finally {

			try {
				// Close input objects
				if (fScan != null) fScan.close();
				if (fis != null) fis.close();
			} catch (Exception e) {
				System.out.println("ERROR: Problem occured while closing " + filename);
				e.printStackTrace();
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method writes accounts to file using plain text
	//		Parameters:
	//			filename - A string representing the file to write to 
	//			accounts - An ArrayList of accounts to write to file
	//		Returns:
	//			void (nothing) - But DOES update the accounts ArrayList
	////////////////////////////////////////////////////////////////////////////////
	public static void writeAccounts(String filename, ArrayList<UserAccount> accounts) {

		// Create file output class objects
		FileOutputStream fos = null;
		PrintWriter pw = null;
		
		try {
			// Init file output class objects
			fos = new FileOutputStream(filename);
			pw = new PrintWriter(fos);

			// Write data to the file
			for (UserAccount account : accounts) {
				pw.print(account.getWebsite() + ", ");
				pw.print(account.getUsername() + ", ");
				pw.print(account.getPassword() + ", ");
				pw.print(account.getMonthCreated() + ", ");
				pw.println(account.getYearCreated());
			}

		} catch (Exception e) {
			System.out.println("ERROR: An unknown error occurred.");
			e.printStackTrace();
		} finally {
			try {
				// Close file input objects
				if (pw != null) pw.close();
				if (fos != null) fos.close();
			} catch (Exception e) {
				System.out.println("ERROR: A problem occurred closing " + filename);
			}
		}
	}
}
