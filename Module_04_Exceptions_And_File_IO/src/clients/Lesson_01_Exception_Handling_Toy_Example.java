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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package clients;

import javax.swing.JOptionPane;

public class Lesson_01_Exception_Handling_Toy_Example {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to catch basic exceptions using the try/catch/finally structure.");
		System.out.println("===========================================================================");

		// Variables must be defined outside of the try block b/c we want to 
		// use them in the catch and outside of the try/ catch structure
		String strInput = null;
		int input = 0;
		int result = 0;
		boolean badInput = true;
		
		do {
			try {	// Place code that could potentially generate an exception in the TRY block
				strInput = JOptionPane.showInputDialog("Please enter a whole number to divide 21 by: ");
				input = Integer.parseInt(strInput);
				result = 21 / input;
				badInput = false;
			} catch (NumberFormatException nfe) { // Respond to exception that occurred from code in the TRY block
				if (strInput == null) { 			// If they hit cancel, exit program
					JOptionPane.showMessageDialog(null, "You canceled the operataion. Exiting program...", "STATUS UPDATE", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				} else if (strInput.isBlank()) {	// If they don't enter anything...
					JOptionPane.showMessageDialog(null, "You must enter something!", "STATUS UPDATE", JOptionPane.ERROR_MESSAGE);
				} else {							// If they enter non-numeric characters
					String msg = String.format("%s is not a valid integer.\n\n%s", strInput, nfe.getMessage());
					JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
					//System.out.println("nfe.toString(): " + nfe.toString());
				}
			} catch (ArithmeticException ae) {
				if (input == 0)	// If input is 0, we know this is a divide by 0 error (this is also encoded in ae.getMessage())...
					JOptionPane.showMessageDialog(null, "Cannot divide by 0.", "ERROR", JOptionPane.ERROR_MESSAGE);
				else {
					// ...however, there may be other ArithmeticExceptions (other than / by 0) that we are
					// unaware of so we still want to output them to the user.
					String msg = "Warning: " + ae.getMessage();
					JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			} catch(Exception e) {		// Always include the most generic exceptions last
				JOptionPane.showMessageDialog(null, "Unknown Error Occurred: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				//System.out.println("e.toString(): " + e.toString());
				//System.out.println("e.getMessage(): " + e.getMessage());
				//e.printStackTrace();
			} finally { // Code in the FINALLY block always executes regardless of whether an exception occurred or not
				JOptionPane.showMessageDialog(null, "Hey, this always displays!", "UNNECESSARY STATUS UPDATE", JOptionPane.INFORMATION_MESSAGE);
			}
		} while (badInput);

		// If we made it here, we definitely have good input
		String equation = String.format("21 / %s = %s", input, result);
		JOptionPane.showMessageDialog(null, equation, "STATUS UPDATE", JOptionPane.INFORMATION_MESSAGE);
	}
}
