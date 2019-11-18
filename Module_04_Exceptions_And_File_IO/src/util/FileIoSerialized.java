/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_03_File_IO_PasswordManager_Example.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package util;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import models.UserAccount;

public class FileIoSerialized {

	////////////////////////////////////////////////////////////////////////////////
	// This method reads in accounts into the accounts ArrayList using serialized text
	//		Parameters:
	//			filename - A string representing the file to read from
	//			accounts - An ArrayList to add accounts read in from file
	//		Returns:
	//			void (nothing) - But DOES update the accounts ArrayList
	////////////////////////////////////////////////////////////////////////////////
	public static void readAccounts(String filename, ArrayList<UserAccount> accounts) {

		// Create input objects/classes
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			// Init input objects/classes
			fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);			

			// Read data in from file
			while (true) {
				UserAccount account = (UserAccount) ois.readObject();
				accounts.add(account);
			}

		} catch (EOFException e) {
			System.out.println(filename + " successfully read.");
		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found, but will be created as a new file of accounts.");
		} catch (Exception e) {
			System.out.println("ERROR: An unknown error occurred.");
			e.printStackTrace();
		} finally {

			try {
				// Close input objects
				if (ois != null) ois.close();
				if (fis != null) fis.close();
			} catch (Exception e) {
				System.out.println("ERROR: Problem occured while closing " + filename);
				e.printStackTrace();
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method writes accounts to file using serialized text
	//		Parameters:
	//			filename - A string representing the file to write to 
	//			accounts - An ArrayList of accounts to write to file
	//		Returns:
	//			void (nothing) - But DOES update the accounts ArrayList
	////////////////////////////////////////////////////////////////////////////////
	public static void writeAccounts(String filename, ArrayList<UserAccount> accounts) {

		// Create file output class objects
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			// Init file output class objects
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);

			// Write data to the file
			for (UserAccount account : accounts)
				oos.writeObject(account);

		} catch (Exception e) {
			System.out.println("ERROR: An unknown error occurred.");
			e.printStackTrace();
		} finally {
			try {
				// Close file input objects
				if (oos != null) oos.close();
				if (fos != null) fos.close();
			} catch (Exception e) {
				System.out.println("ERROR: A problem occurred closing " + filename);
			}
		}
	}
}
