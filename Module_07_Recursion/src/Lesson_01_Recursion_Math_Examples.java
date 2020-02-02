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

		////////////////////////////////////////////////////////////
		// Recursive factorial computation	

		////////////////////////////////////////////////////////////
		// Recursive fibonacci number computation
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
}
