/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_05_Bonus_WindowBuilder_All_Components.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package models;

public abstract class SocialSecurityNumber
{
	//////////////////////////////////////////////////////////////////////
	// Instance Variables
	private long ssn;
	private static long nextSSN = 1; // Class/static variable
	
	//////////////////////////////////////////////////////////////////////
	// Default Constructor
	public SocialSecurityNumber()
	{
		ssn = nextSSN++;
	}
	
	//////////////////////////////////////////////////////////////////////
	// Member methods
	protected long getSSN(String password)
	{
		if (password.equals("password123"))
			return ssn;
		else
			return -1;
	}
	
	///////////////////////////////////////////////////////////////
	// This method takes in a password and if the password matches
	// the saved password, converts it from a long to a String.
	//		Parameters:
	//			password - A String representing a password
	//		Returns:
	//			A String representing the SSN
	///////////////////////////////////////////////////////////////
	protected String getSsnString(String password)
	{
		if (password.equals("password123"))
			return convertSsnToString(getSSN(password));
		else
			return "You do not have access to my SSN.";
	}
	
	///////////////////////////////////////////////////////////////
	// This method takes in a SSN (as a long) and converts it to
	// a String.
	//		Parameters:
	//			ssn - A String representing a SSN
	//		Returns:
	//			A String representing the SSN
	///////////////////////////////////////////////////////////////
	private String convertSsnToString(long ssn)
	{
		String ssnStr = "";
		long divideBy = 100000000;
		while (divideBy > 0)
		{
			long digit = ssn / divideBy;
			ssnStr += (ssn / divideBy);
			ssn -= (digit * divideBy); // Get rid of digit in overall number
			divideBy /= 10; // Go to next digit
			
			if (divideBy == 100000 || divideBy == 1000)
				ssnStr += "-";
		}
		return ssnStr;
	}
}
