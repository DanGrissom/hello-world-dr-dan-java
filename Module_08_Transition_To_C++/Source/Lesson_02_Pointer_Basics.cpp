/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) The basics of C++ Pointers
//			a) The * syntax for declaring pointers
//			b) The * syntax for dereferencing pointers
//			c) The & syntax for obtaining the address of a variable
//			d) Using pointer arithmetic to iterate through an array
//
// NOTE: You will not code this from scratch, but rather, follow along through detailed slides.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include <iostream>		// Needed for input/output
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
	cout << "Program Objective: Learn the basics of pointers in C++." << endl;
	cout << "===========================================================================" << endl;

	// Welcome user to program
	cout << "Welcome to the C++ Basic Pointer Demo" << endl << endl;

	// Create variables a and b
	int a = 11;
	int b = 77;
	int *aPtr = &a;				// Creating a pointer (aPtr) which stores the address at which "a" is located
	int *bPtr = &b;				// Creating a pointer (bPtr) which stores the address at which "b" is located

	// Print out values of a/aPtr
	cout << "A's VALUES" << endl << "-----------------------------" << endl;
	cout << "a = " << a << endl;
	cout << "&a = " << &a << " (a's address)" << endl;
	cout << "aPtr = " << aPtr << " (a's address)" << endl;
	cout << "&aPtr = " << &aPtr << " (address of aPtr var)" << endl;
	cout << "*aPtr = " << *aPtr << " (value pointed to by aPtr; a)" << endl << endl;

	// Print out values of b/bPtr
	cout << "B's VALUES" << endl << "-----------------------------" << endl;
	cout << "b = " << b << endl;
	cout << "&b = " << &b << " (b's address)" << endl;
	cout << "bPtr = " << bPtr << " (b's address)" << endl;
	cout << "&bPtr = " << &bPtr << " (address of bPtr var)" << endl;
	cout << "*bPtr = " << *bPtr << " (value pointed to by bPtr; b)" << endl << endl;

	// Change values
	cout << "CHANGE OF A's VALUES" << endl << "-----------------------------" << endl;
	a = 22;					// Change value of "a" directly
	cout << "a = " << a << " (changed DIRECTLY by: a = 22;)" << endl;
	cout << "&a = " << &a << " (a's address)" << endl << endl;
	*aPtr = 33;				// Change value of "a" indirectly through aPtr
	cout << "a = " << a << " (changed INDIRECTLY by: *aPtr = 33;)" << endl;
	cout << "&a = " << &a << " (a's address)" << endl << endl;

	// Set pointers equal
	cout << "SETTING POINTERS EQUAL" << endl << "-----------------------------" << endl;
	bPtr = aPtr;		// aPtr and bPtr are now both poitning to "a"
	*bPtr = 44;			// Changes value of "a"
	cout << "aPtr = " << aPtr << " (a's address)" << endl;
	cout << "bPtr = " << bPtr << " (b's address)\tSAME ADDRESS" << endl << endl;
	cout << "a = " << a << endl;
	cout << "b = " << b << "\t\t\t\tDIFFERENT VALUES" << endl << endl;
	cout << "&a = " << &a << " (a's address)" << endl;
	cout << "&b = " << &b << " (b's address)\tDIFFERENT ADDRESS" << endl << endl;

	// Initialize an array with 5 pieces of data
	int arraySize = 5;
	int array [] = { 100, 200, 300, 400, 500 };

	// An array is naturally a pointer to the first place of data in the array
	cout << "ARRAY POINTER ARITHMETIC" << endl << "-----------------------------" << endl;
	cout << "&array = " << &array << "\t(array's address is really just address of 0th element - SEE BELOW)" << endl;

	// Iterate through the array using normal [] notation AND/OR pointer arithmetic
	for (int i = 0; i < arraySize; i++) {
		cout << "\tarray[" << i << "] = " << array[i] << endl;
		cout << "\t*(array + " << i << ") = " << *(array + i) << " @ addr " << (array + i) << endl << endl;
	}

	return 0;
}

TODO: Comment (uncomment) this line when you want to run (disable) this program */
