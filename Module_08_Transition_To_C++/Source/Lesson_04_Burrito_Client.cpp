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
#include <vector>
using namespace std;

#include "../Headers/Burrito.h"

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
	cout << "How many burritos do you want to order: ";
	int numBurritos;
	cin >> numBurritos;
	cout << endl;

	// Must clear off the new-line character from hitting ENTER
	// so it doesn't mess up NEXT getline call below
	string garbage;
	getline(cin, garbage);

	// Vector of burrito pointers
	vector<Burrito *> burritos;

	// Process burrito orders
	for (int i = 0; i < numBurritos; i++) {
		// Ask user what they want on each burrito
		string meatType, beanType;
		cout << "Burrito order " << (i+1) << endl;
		cout << "\tWhat type of meat would you like: ";
		getline(cin, meatType);
		cout << "\tWhat type of bean would you like: ";
		getline(cin, beanType);

		// Create a new burrito (pointer) and add it to the vector
		Burrito *burritoPtr = new Burrito(meatType, beanType);
		burritos.push_back(burritoPtr);
	}

	// Print the entire order
	cout << endl << "Your Order Contains:" << endl;
	for (int i = 0; i < burritos.size(); i++) {
		Burrito *bPtr = burritos.at(i);
		cout << "\t" << bPtr->getSummary() << endl;
		//cout << "\t" << bPtr->getMeatType() + "/" + bPtr->getBeanType() << endl;
	}

	// Cleanup memory (delete burrito pointers) - NOTE how we iterate backwards because we
	// are removing items from the vector. If we iterated forward, by the time we got to
	// the last item in the list, it would be GONE
	cout << endl << "Deleting Burrito Pointers: " << endl;
	for (int i = burritos.size() - 1; i >= 0; i--) {
		Burrito *bPtr = burritos.back();	// Get pointer to last item in vector
		burritos.pop_back();				// Remove last item in vector (bPtr from above)
		delete bPtr;						// Free memory
	}

	return 0;
}

TODO: Comment (uncomment) this line when you want to run (disable) this program */
