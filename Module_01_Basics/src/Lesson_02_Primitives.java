/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
// 		1) The primitive data types and their ranges
//			a) Whole numbers: byte, short, int, long
//			b) Decimal-point numbers: float, double
//			c) Misc.: boolean, char
// 		2) Best practices for when to use certain primitive data types
//			a) You should almost always use int for whole numbers (unless keeping track of a unique ID, then use long)
//			b) You should almost always use double for decimal-point numbers
//		3) To further master System.out.printf() by:
//			a) Formatting decimal numbers with a certain number of digits after the decimal point
//			b) Formatting numbers with thousands separators
//			c) Formatting numbers to scientific notation
//		4) To use the Scanner to read user input from the console into variables of any of the primitive data types
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Lesson_02_Primitives {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn primitive data types, printf() mastery, scanner input.");
		System.out.println("===========================================================================");
		System.out.println();
		
		// A scanner allows us to read in variables/data from the user
		Scanner scan = new Scanner(System.in);
		
		////////////////////////////////////////////////////////
		// Primitive whole number data types
		////////////////////////////////////////////////////////
		// Print basic BYTE info
		System.out.println("BYTE DATATYPE");
		System.out.println("===========================================================================");
		byte bMin = Byte.MIN_VALUE;
		byte bMax = Byte.MAX_VALUE;
		int numBits = 8;
		int numBytes = numBits / 8; // 8 bits/byte
		System.out.printf("The BYTE datatype uses %d-byte(s) (%d-bits) to represent negative numbers [%d, -1] and non-negative numbers [0, %d].\n", numBytes, numBits, bMin, bMax); 
		System.out.printf("Thus, a BYTE can represent %d distinct values (2^%d = %.0f).\n", bMax + Math.abs(bMin) + 1, numBits, Math.pow(2, numBits));
		
		// Prompt user for input, read input and print
		System.out.printf("Please enter a whole number within the range [%d, %d]: ", bMin, bMax);
		byte b = scan.nextByte();
		System.out.printf("\t%s <= %s <= %s\n\n", bMin, b, bMax);
		
		
		// Print basic SHORT info
		System.out.println("SHORT DATATYPE");
		System.out.println("===========================================================================");
		short sMin = Short.MIN_VALUE;
		short sMax = Short.MAX_VALUE;
		numBits = 16;
		numBytes = numBits / 8; // 8 bits/byte
		System.out.printf("The SHORT datatype uses %d-byte(s) (%d-bits) to represent negative numbers [%,d, -1] and non-negative numbers [0, %,d].\n", numBytes, numBits, sMin, sMax); 
		System.out.printf("Thus, a SHORT can represent %,d distinct values (2^%d = %,.0f).\n", sMax + Math.abs(sMin) + 1, numBits, Math.pow(2, numBits));
		
		// Prompt user for input, read input and print
		System.out.printf("Please enter a whole number within the range [%,d, %,d]: ", sMin, sMax);
		short s = scan.nextShort();
		System.out.printf("\t%,d <= %,d <= %,d\n\n", sMin, s, sMax);
		
		
		// Print basic INT info
		System.out.println("INT DATATYPE");
		System.out.println("===========================================================================");
		int iMin = Integer.MIN_VALUE;
		int iMax = Integer.MAX_VALUE;
		numBits = 32;
		numBytes = numBits / 8; // 8 bits/byte
		System.out.printf("The INT datatype uses %d-byte(s) (%d-bits) to represent negative numbers [%,d, -1] and non-negative numbers [0, %,d].\n", numBytes, numBits, iMin, iMax); 
		System.out.printf("Thus, a INT can represent %,d distinct values (2^%d = %,.0f).\n", iMax + Math.abs(iMin) + 1, numBits, Math.pow(2, numBits));
		
		// Prompt user for input, read input and print
		System.out.printf("Please enter a whole number within the range [%,d, %,d]: ", iMin, iMax);
		int i = scan.nextInt();
		System.out.printf("\t%,d <= %,d <= %,d\n\n", iMin, i, iMax);

		
		// Print basic LONG info
		System.out.println("LONG DATATYPE");
		System.out.println("===========================================================================");
		long lMin = Long.MIN_VALUE;
		long lMax = Long.MAX_VALUE;
		numBits = 64;
		numBytes = numBits / 8; // 8 bits/byte
		System.out.printf("The LONG datatype uses %d-byte(s) (%d-bits) to represent negative numbers [%,d, -1] and non-negative numbers [0, %,d].\n", numBytes, numBits, lMin, lMax); 
		System.out.printf("Thus, a LONG can represent %,d distinct values (2^%d = %,.0f).\n", lMax + Math.abs(lMin) + 1, numBits, Math.pow(2, numBits));
		
		// Prompt user for input, read input and print
		System.out.printf("Please enter a whole number within the range [%,d, %,d]: ", lMin, lMax);
		long l = scan.nextLong();
		System.out.printf("\t%,d <= %,d <= %,d\n\n", lMin, l, lMax);

		
		////////////////////////////////////////////////////////
		// Primitive decimal-point number data types
		////////////////////////////////////////////////////////
		// Print basic FLOAT info
		System.out.println("FLOAT DATATYPE");
		System.out.println("===========================================================================");
		float fMin = -Float.MAX_VALUE;
		float fMax = Float.MAX_VALUE;
		numBits = 32;
		numBytes = numBits / 8; // 8 bits/byte
		System.out.printf("The FLOAT datatype uses %d-byte(s) (%d-bits) to represent negative and positive numbers [%,f, %,f].\n", numBytes, numBits, fMin, fMax); 
		
		// Prompt user for input, read input and print
		System.out.printf("Please enter a decimal number within the range [%,f, %,f]: ", fMin, fMax);
		float f = scan.nextFloat();
		System.out.printf("\t%,f <= %,f <= %,f\n\n", fMin, f, fMax);
		
		// Print basic DOUBLE info
		System.out.println("DOUBLE DATATYPE");
		System.out.println("===========================================================================");
		double dMin = -Double.MAX_VALUE;
		double dMax = Double.MAX_VALUE;
		numBits = 64;
		numBytes = numBits / 8; // 8 bits/byte
		System.out.printf("The DOUBLE datatype uses %d-byte(s) (%d-bits) to represent negative and positive numbers [%e, %e].\n", numBytes, numBits, dMin, dMax); 
		
		// Prompt user for input, read input and print
		System.out.printf("Please enter a decimal number within the range [%e, %e]: ", dMin, dMax);
		double d = scan.nextDouble();
		System.out.printf("\t%e <= %e <= %e\n\n", dMin, d, dMax);
		
		////////////////////////////////////////////////////////
		// Primitive data types (boolean, char)
		////////////////////////////////////////////////////////
		// Print basic BOOLEAN info
		System.out.println("BOOLEAN DATATYPE");
		System.out.println("===========================================================================");
		System.out.printf("Booleans can take on two values: \n\t%b\n\t%b\n", Boolean.TRUE, Boolean.FALSE);
		
		// Prompt user for input, read input and print
		System.out.print("Please enter a boolean: ");
		boolean bool = scan.nextBoolean();
		System.out.printf("\tYou entered: %b\n\n", bool);
		
		
		// Print basic CHAR info
		System.out.println("CHAR DATATYPE");
		System.out.println("===========================================================================");
		
		// Prompt user for input, read input and print
		System.out.print("Please enter a character: ");
		char c = scan.next().charAt(0);
		System.out.printf("\tYou entered: %s\n", c);
	}
}
