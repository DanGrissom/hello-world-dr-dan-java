/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) The basics of pass-by-value vs. pass-by-reference in C++
//			a) Passing primitives by value
//			b) Passing objects/pointers by reference
//		2) Calling methods in C++
//			a) Placing a prototype at top of file
//			b) Placing prototype (header) and method body below
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include <iostream>		// Needed for input/output
using namespace std;	// Needed for cout, cin, endl, etc.

// Method headers required BEFORE main() when method bodies are BELOW main

//////////////////////////////////////////////////////////
// NOTE: Only one "main()" can be active in this project.
// Please comment out the "main()s" in the other lessons
// before trying to run this program or you will get compiler
// errors.
//////////////////////////////////////////////////////////
/* TODO: TODO: Comment (uncomment) this line when you want to run (disable) this program

int main() {
	
	// Simple welcome statements printed to screen
	cout << "Program Objective: Learn how to create functions that pass-by-value and pass-by-reference in C++." << endl;
	cout << "===========================================================================" << endl;

	// Create some variables

	// Print out the value of a (a) and the address of a (aPtr)

	// Pass by value - Will NOT change value of a

	// Pass by reference - WILL change value of a

	return 0;
}

TODO: Comment (uncomment) this line when you want to run (disable) this program */

////////////////////////////////////////////////////////////////////////////////
// This method takes in a COPY of some value val such that when you change val in
// this method, it does NOT change the variable's value in main()
//		Parameters:
//			val - An integer that is passed by value
//		Returns:
//			void (NOTHING)
////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
// This method takes in a POINTER of some variable such that when you dereference
// the valPtr and change the dereferenced value, you will see this change reflected
// in main() with the dereferenced location of the value passed into this method
//		Parameters:
//			*valPtr - A pointer to an integer (passed by reference)
//		Returns:
//			void (NOTHING)
////////////////////////////////////////////////////////////////////////////////
