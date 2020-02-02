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
public class Lesson_01_Recursion_Math_Examples {

	public static void main(String[] args) {

		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to formulate base and recursive cases for select problems.");
		System.out.println("===========================================================================");

		////////////////////////////////////////////////////////////
		// Recursive power computation
		long b = 3;
		long e = 4;
		long result = recursivePower(b, e); // Equivalent => Math.pow(b, e);
		System.out.printf("%s^%s = %,d\n", b, e, result);

		////////////////////////////////////////////////////////////
		// Recursive factorial computation	
		long f = 5;
		result = recursiveFactorial(f);
		System.out.printf("%s! = %,d\n", f, result);

		////////////////////////////////////////////////////////////
		// Recursive fibonacci number computation
		long fibNumber = 1000;
		result = recursiveFibonacci(fibNumber);
		System.out.printf("Fibonacci number %s = %,d\n", fibNumber, result);
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
	private static long recursivePower(long base, long exp) {
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
	private static long recursiveFactorial(long f) {
		if (f == 0 || f == 1)
			return 1;
		else
			return f * recursiveFactorial(f-1);
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// Base case 1: fibNum = 0 ==> 0 (by definition)
	// Base case 2: fibNum = 1 ==> 1 (by definition)
	// Recursive case: Fib(fibNum) ==> Fib(fibNum-1) + Fib(fibNum-2)
	//
	// The idea here is to compute fibonacci numbers the simple definition of how
	// we define a fibonacci number. The main issue here is that the number of 
	// recursive calls is exponential (2 recursive calls to Fib() for every single
	// call to Fib(). You will notice this method will not be able to generate
	// fibonacci numbers in reasonable amounts of time a simple for loop can
	// generate quickly (try fibNum = 80).
	//		Parameters:
	//			fibNum - A long representing which fibonacci number to generate
	//		Returns:
	//			A long that represents the fibNum fibonacci number
	////////////////////////////////////////////////////////////////////////////////
	private static long recursiveFibonacci(long fibNum) {
		if (fibNum == 0)
			return 0;
		else if (fibNum == 1)
			return 1;
		else
			return recursiveFibonacci(fibNum - 1) + recursiveFibonacci(fibNum - 2);
		
//		// FOR LOOP IMPLEMENTATION - MUCH FASTER
//		long fi_min2 = 0;
//		long fi_min1 = 1;
//		long fi = -1;
//		for (int i = 2; i <= fibNum; i++) {
//			// Compute the ith fib number
//			fi = fi_min1 + fi_min2;
//			
//			// Update the ith-1 and ith-2 fib numbers for the next iteration
//			fi_min2 = fi_min1;
//			fi_min1 = fi;
//		}
//		
//		// fi is the fibNum being requested
//		return fi;		
	}
}









