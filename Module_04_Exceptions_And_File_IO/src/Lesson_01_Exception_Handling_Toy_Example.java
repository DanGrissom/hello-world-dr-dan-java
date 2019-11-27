/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Exceptions
//			a) Using try/catch/finally structure
//			b) Exception types and ordering
//			c) Using a do-while loop to repeatedly prompt the user after exceptions
//		2) JOptionPane for simple pop-up displays and inputs dialogs
//		3) System.exit() to halt program
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lesson_01_Exception_Handling_Toy_Example {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to catch basic exceptions using the try/catch/finally structure.");
		System.out.println("===========================================================================");
		
		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);
		
		// variables must be defined outside of the try block b/c we want to
		// use it in the catch and outside of the try/catch structure
		String result = null;
		boolean badInput = true;
		int num = 0;
		int res = 0;

		// Keep asking user for input while the input is bad
		do
		{
			try
			{
				result = JOptionPane.showInputDialog("Please enter an whole number to divide 21 by: ");
				num = Integer.parseInt(result); // May generate an exception
				res = 21 / num;
				//JOptionPane.showMessageDialog(null, "You entered " + num);
				badInput = false;
			}
			catch(NumberFormatException nfe)
			{
				// If they hit cancel, exit the program
				if (result == null) {
					JOptionPane.showMessageDialog(null, "You canceled the operation. Exiting program...", "STATUS UPDATE", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				
				// Generates NumberFormatException with: 'b', '3.14', etc. because the String cannot
				// be formatted as the number we are trying to format it as
				String msg = result + " is not a valid integer.\n\n" + nfe.getMessage();
				JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
				//nfe.printStackTrace(); // Will print the "ugly" stack trace to console
			}
			catch(ArithmeticException ae)
			{
				// If num is 0, we know this is a divide by 0 error (this is also encoded in ae.getMessage())...
				if (num == 0)
				{
					String msg = "Cannot divide by 0.";
					JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					// ...however, there may be other ArithmeticExceptions (other than / by 0) that we are
					// unaware of so we still want to be able to output them to the user.
					String msg = "Warning: " + ae.getMessage();
					JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception e)
			{
				// Catch every other exception for all the crazy, unexpected things that could occur
				JOptionPane.showMessageDialog(null, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} while (badInput);

		// If we made it here, we definitely have good input
		JOptionPane.showMessageDialog(null, "21 / " + num + " = " + res);
	}
}
