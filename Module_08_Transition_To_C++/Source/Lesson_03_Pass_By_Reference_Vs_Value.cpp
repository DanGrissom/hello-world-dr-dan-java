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
void passByValue(int val);
void passByReference(int *valPtr);

//////////////////////////////////////////////////////////
// NOTE: Only one "main()" can be active in this project.
// Please comment out the "main()s" in the other lessons
// before trying to run this program or you will get compiler
// errors.
//////////////////////////////////////////////////////////
int main() {
	// Welcome user to program
	cout << "Welcome to the Pass-By-Value vs. Pass-By-Reference Demo!" << endl << endl;

	// Create some variables
	int a = 10;					// Create variable called "a"
	int *aPtr = &a;				// aPtr is a pointer that holds the address of a (& gets a's address)

	// Print out the value of a (a) and the address of a (aPtr)
	cout << "A's INITIAL VALUES" << endl << "-----------------------------" << endl;
	cout << "\ta = " << a << endl;
	cout << "\taPtr = " << aPtr << " (a's address)" << endl << endl;

	// Pass by value - Will NOT change value of a
	cout << "PASS BY VALUE" << endl << "-----------------------------" << endl;
	passByValue(a);
	cout << "\tA's VALUES AFTER PASS BY VALUE" << endl << "\t-----------------------------" << endl;
	cout << "\t\ta = " << a << endl;
	cout << "\t\taPtr = " << aPtr << " (a's address)" << endl << endl;

	// Pass by reference - WILL change value of a
	cout << "PASS BY REFERENCE" << endl << "-----------------------------" << endl;
	passByReference(aPtr);
	cout << "\tA's VALUES AFTER PASS BY REFERENCE" << endl << "\t-----------------------------" << endl;
	cout << "\t\ta = " << a << endl;
	cout << "\t\taPtr = " << aPtr << " (a's address)" << endl << endl;

	return 0;
}

////////////////////////////////////////////////////////////////////////////////
// This method takes in a COPY of some value val such that when you change val in
// this method, it does NOT change the variable's value in main()
//		Parameters:
//			val - An integer that is passed by value
//		Returns:
//			void (NOTHING)
////////////////////////////////////////////////////////////////////////////////
void passByValue(int val) {
	val += 10;
	cout << "\tVAL's VALUES INSIDE passByValue(a)" << endl << "\t-----------------------------" << endl;
	cout << "\t\tval = " << val << endl;
	cout << "\t\t&val = " << &val << " (val's address)" << endl << endl;
}

////////////////////////////////////////////////////////////////////////////////
// This method takes in a POINTER of some variable such that when you dereference
// the valPtr and change the dereferenced value, you will see this change reflected
// in main() with the dereferenced location of the value passed into this method
//		Parameters:
//			*valPtr - A pointer to an integer (passed by reference)
//		Returns:
//			void (NOTHING)
////////////////////////////////////////////////////////////////////////////////
void passByReference(int *valPtr) {
	*valPtr += 10;
	cout << "\tVAL's VALUES INSIDE passByReference(aPtr)" << endl << "\t-----------------------------" << endl;
	cout << "\t\t*valPtr = " << *valPtr << endl;
	cout << "\t\tvalPtr = " << valPtr << " (valPtr - also a's address)" << endl << endl;
}
