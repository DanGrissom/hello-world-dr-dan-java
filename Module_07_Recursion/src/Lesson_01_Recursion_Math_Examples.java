/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Recursion (a method is called recursive if it calls itself)
//			a) Base Case(s)
//			b) Recursive Case(s)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Lesson_01_Recursion_Math_Examples {

	public static void main(String[] args) {

		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to formulate base and recursive cases for select problems.");
		System.out.println("===========================================================================");

		////////////////////////////////////////////////////////////
		// Recursive power computation
		long b = 2;
		long e = 25;
		long result = recursivePower(b, e);
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(b + "^" + e + " = " + df.format(result));

		////////////////////////////////////////////////////////////
		// Recursive factorial computation		
		long f = 20;
		result = recursiveFactorial(f);
		System.out.println(f + "! = " + df.format(result));

		////////////////////////////////////////////////////////////
		// Recursive fibonacci number computation
		long fibCount = 40;
		System.out.println("First " + fibCount + "fibonacci numbers:");
		recursiveFibonacciPrintFast(0, 1, fibCount);
		System.out.println("Fibonacci number " + fibCount + " is: " + recursiveFibonacciSlow(fibCount));
		
		////////////////////////////////////////////////////////////
		// Recursive Prime computation
		long maxPrimeCand = 40L;
		System.out.println("Prime numbers less than " + df.format(maxPrimeCand));
		for (long pc = 0; pc <= maxPrimeCand; pc++)
		{
			if (isPrime(pc))
				System.out.println("\t" + df.format(pc));
		}

		////////////////////////////////////////////////////////////
		// Recursive Binary compute
		int bin = 8;
		ArrayList<Integer> binArray = new ArrayList<Integer>(); // Will contain binary
		recursiveBinaryPrint(bin, binArray);

		System.out.println("\nBinary Print for " + bin + ": ");
		for (int bit : binArray)
			System.out.print(bit);
	}

	////////////////////////////////////////////////////////////////////////////////
	// Recursive Method definitions
	////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////
	// Base case: x^0 = 1
	// Recursive case: x^y = x * x^(y-1)
	//
	// The idea here is that the power method can keep being decomposed into
	// smaller and smaller powers until we need to use the definition of base^0 = 1;
	//		Parameters:
	//			base - A long that represents the base of the computation
	//			exp - A long that represents the exponential of the computation
	//		Returns:
	//			A long that represents base^exp 
	////////////////////////////////////////////////////////////////////////////////
	private static long recursivePower(long base, long exp)
	{
		if (exp == 0)
			return 1;
		else
			return base * recursivePower(base, exp-1);		
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// Base case 1: 0! = 1
	// Base case 2: 1! = 1
	// Recursive case: x! = x * (x-1)!
	//
	// The idea here is that the factorial method can keep being decomposed into
	// smaller and smaller factorials until we need to use the definitions of 0! and 1!.
	//		Parameters:
	//			f - A long that represents the factorial to compute
	//		Returns:
	//			A long that represents f! 
	////////////////////////////////////////////////////////////////////////////////
	private static long recursiveFactorial(long f)
	{
		if (f == 0)
			return 1;
		else if (f == 1)
			return 1;
		else
			return f * recursiveFactorial(f-1);
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// Base case: fibCount = 1 ==> Done
	// Recursive case: Fib(fibNum1, fibNum2, fibCount) ==> Fib(fibNum2, fibNum + fibNum2, fibCount-1)
	//
	// The idea here is to compute fibonacci numbers by starting with the first numbers (which must
	// be passed into the first recursiveFibonacciPrint(0, 1, x) call. As fibCount counts down to 0,
	// fibNum and fibNum2 are being built up.
	//		Parameters:
	//			fibNum - A long that represents a number in the fibonacci sequence
	//			fibNum2 - A long that represents the next number in the fibonacci sequence after fibNum
	//			fibCount - A long that starts off as how many fib numbers to print (counts down to 0)
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private static void recursiveFibonacciPrintFast(long fibNum, long fibNum2, long fibCount)
	{
		// Print out the fibonacci number
		System.out.println(fibNum);

		// If we've output all numbers return
		if (fibCount == 1)
			return;
		else {	// Otherwise, computer the next fibonacci number
			long fibNum3 = fibNum + fibNum2;
			recursiveFibonacciPrintFast(fibNum2, fibNum3, --fibCount);
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// Base case 1: fibCount = 1 ==> 0 (by definition)
	// Base case 2: fibCount = 2 ==> 1 (by definition)
	// Recursive case: Fib(fibNum) ==> Fib(fibNum-1) + Fib(fibNum-2)
	//
	// The idea here is to compute fibonacci numbers the simple definition of how
	// we define a fibonacci number. The main issue here is that the number of 
	// recursive calls is exponential (2 recursive calls to Fib() for every single
	// call to Fib(). You will notice this slow version will not be able to generate
	// fibonacci numbers in reasonable amounts of time that the fast version above
	// can generate easily (try fibCount = 80).
	//		Parameters:
	//			fibCount - A long that starts off as how many fib numbers to print (counts down to 0)
	//		Returns:
	//			A long that represents the fibCount fibonacci number
	////////////////////////////////////////////////////////////////////////////////
	private static long recursiveFibonacciSlow(long fibCount) {
		
		if (fibCount == 1)
			return 0;
		else if (fibCount == 2)
			return 1;
		else
			return recursiveFibonacciSlow(fibCount - 1) + recursiveFibonacciSlow(fibCount - 2);
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// Base case 1: primeCand = 1 OR primeCand = 2 ==> Not Prime
	// Base case 2: Divide-by-value = 1 ==> Is Prime
	// Base case 3: primeCand % Divide-by-value = 0 ==> Not Prime 
	// Recursive case: Prime(primeCand, divVal) ==> Prime(primeCand, divVal-1)
	//
	// The idea here is to essentially divide the primeCand value by (primeCand-1)
	// all the way down to 1. If there is ever a division with no remainder (base case 3, determined
	// by the mod), then the number is not prime; else, if we make it down to dividing by
	// 1 (base case 2), then the number is prime. One final base case (base case 1) is needed
	// to specify the fact that 0 and 1 are not prime.
	//		Parameters:
	//			primeCand - A long that represents the value we want to determine if prime
	//			divByVal - A long that represents the value attempting to divide primeCand by
	//		Returns:
	//			A boolean returning true (false) if primeCand is prime (not prime)
	////////////////////////////////////////////////////////////////////////////////
	public static boolean recursivePrime(long primeCand, long divByVal)
	{
		if (primeCand == 0 || primeCand == 1) // Base case 1: 0 and 1 are not prime, testVal is not prime
			return false;
		else if (divByVal == 1) 			// Base case 2: testVal only divisible by 1, testVal is prime
			return true;
		else if (primeCand % 2 == 0)
			return false;
		else if (primeCand % divByVal == 0) 	// Check if testVal can be evenly divided by divVal
			return false;
		else								// If not, recursive call to isPrime with testVal and (divVal - 1)
			return recursivePrime(primeCand, divByVal-1);
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// Acts as a simple wrapper to the recursivePrime method to 
	// get it kicked off. Takes into account intuition that we
	// never need to divide/modulus by numbers in the range
	// [primeCand/2+1, primeCand-1] because they will NEVER be
	// a factor of primeCand.
	//		Parameters:
	//			primeCand - A long that represents the value we want to determine if prime
	//		Returns:
	//			A boolean returning true (false) if primeCand is prime (not prime)
	////////////////////////////////////////////////////////////////////////////////
	private static boolean isPrime(long primeCand) {
		return recursivePrime(primeCand, primeCand / 2);
	}

	////////////////////////////////////////////////////////////////////////////////
	// Base case 1: If the value is 0, then we're done!
	// Recursive case 1: If value is odd, add a 1 and recurse on value/2
	// Recursive case 2: If value is even, add a 0 and recurse on value/2 
	//
	// The idea here is to keep dividing by two (odd numbers yield a 1, even numbers yield a 0)
	// until we reach 0. When we reach 0, we have an array full of the binary repereseting the
	// original value passed in.
	//		Parameters:
	//			val - An int representing the remaining portion of the value to convert to binary
	//			binArray - An ArrayList containing the 0's and 1's representation (binary) of val
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private static void recursiveBinaryPrint(int val, ArrayList<Integer> binArray)
	{
		// If reach 0, you are done!
		if (val == 0)
			return;
		else if (val % 2 == 1) 							// If remainder of 1 (odd)...
		{	
			binArray.add(0, 1);							// ...add a 1 to beginning of array...
			recursiveBinaryPrint(val/2, binArray);		// ..., divide by 2 and repeat
		}
		else 											// Else if remainder of 0 (even)...
		{
			binArray.add(0, 0);							// ...add a 0 to beginning of array...
			recursiveBinaryPrint(val/2, binArray);		// ..., divide by 2 and repeat. 
		}
	}

}
