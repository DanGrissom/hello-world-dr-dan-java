/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Separating your files into SOURCE (.cpp) and HEADER (.h) files
//		2) Creating classes in C++
//			a) #ifndef #define #endif preprocessor (compiler) directives for .h files
//			b) Deconstructor (~) syntax and implementation
//			c) Access modifiers
//			d) friend classes
//		3) Creating object pointers using "new" and deleting them using "delete"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include <iostream>
using namespace std;

//////////////////////////////////////////////////////////
// NOTE: Only one "main()" can be active in this project.
// Please comment out the "main()s" in the other lessons
// before trying to run this program or you will get compiler
// errors.
//////////////////////////////////////////////////////////
/* TODO: Comment (uncomment) this line when you want to run (disable) this program

int main() {

	// Simple welcome statements printed to screen
	cout << "Program Objective: Learn how to create classes (source and header files) in C++." << endl;
	cout << "===========================================================================" << endl;
	
	// Prompt user for number of burritos and read in value

	// Must clear off the new-line character from hitting ENTER
	// so it doesn't mess up NEXT getline call below

	// Vector of burrito pointers

	// Process burrito orders

	// Print the entire order

	// Cleanup memory (delete burrito pointers) - NOTE how we iterate backwards because we
	// are removing items from the vector. If we iterated forward, by the time we got to
	// the last item in the list, it would be GONE

	return 0;
}

TODO: Comment (uncomment) this line when you want to run (disable) this program */
