/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) The basics of C++
//			a) #include and using statements
//			b) cout, cin and getline() for console I/O
//			c) Loops (for and while)
//			d) Conditionals (If statements)
//			e) Storage using arrays and vectors (equivalent to Java ArrayList)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include <iostream>		// Needed for input/output
#include <vector>		// Needed for cout, cin, endl, etc.
using namespace std;

//////////////////////////////////////////////////////////
// NOTE: Only one "main()" can be active in this project.
// Please comment out the "main()s" in the other lessons
// before trying to run this program or you will get compiler
// errors.
//////////////////////////////////////////////////////////
int main() {

	// Prompt user for some personal info
	cout << "Please tell me your first and last name: ";								// cout instead of System.out.print
	string name;
	getline(cin, name); 																		// Similar to scan.nextLine()
	cout << endl << "Welcome " + name << "! Let's learn some basic C++!" << endl << endl;		// endl is newline character

	// Prompt user for a number
	int num;
	cout << "Please enter a number: ";
	cin >> num;

	// Simple FOR loop to print out numbers from 0 to num-1
	cout << endl << "Printing ALL numbers in range [0, " << (num-1) << "]:" << endl;
	for (int i = 0; i < num; i++)
		cout << "\t" << i << endl;

	// Simple WHILE loop that prints out multiples of 3
	cout << endl << "Printing out MULTIPLES OF 3 in range [0, " << (num*5-1) << "]: " << endl;
	int count = 0;
	while (count < (num * 5)) {
		if (count % 3 == 0 && count != 0)
			cout << "\t" << count << endl;
		count++;
	}

	// Prompt the user
	cout << endl << "How many numbers would you like to save: ";
	cin >> num;

	// Create array/vector
	int myArray [num];
	vector<int> myVector;

	// Get values from user
	cout << endl << "Please enter " << num << " values:" << endl;
	for (int i = 0; i < num; i++) {
		// Prompt user for each value
		cout << "\tValue " << (i+1) << ": ";
		int val;
		cin >> val;

		// Add into array and vector
		myArray[i] = val;
		myVector.push_back(val);
	}

	// Iterate through array and print values
	cout << endl << "Printing values in myArray:" << endl;
	int arraySize = sizeof(myArray) / sizeof(int); // Number of bytes in array divided by number of bytes in integer
	for (int i = 0; i < arraySize; i++)
		cout << "\tmyArray[" << i << "] = " << myArray[i] << endl;

	// Iterate through vector and print values
	cout << endl << "Printing values in myVector:" << endl;
	for (int i = 0; i < myVector.size(); i++)
		cout << "\tmyVector.at(" << i << ") = " << myVector.at(i) << endl;

	return 0;
}
