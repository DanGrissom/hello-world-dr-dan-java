/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Another example of when recursion can be used 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class Lesson_02_Recusion_Binary_Search_Example {

	// Used to track the number of recursive calls made 
	// (that is, the number of binary searches)
	public static int numRecursiveCalls = 0;
	
	public static void main(String[] args) {

		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to perform recursive binary search.");
		System.out.println("===========================================================================");
		
		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);
		
		// Hardcoded, sorted array
		int [] sortedArray = {10, 20, 38, 40, 102, 182, 553, 919, 931, 937, 949, 1623, 2039 };
		// Index values:	   0,  1,  2,  3,   4,   5,  6*,   7,   8,   9,  10,   11,   12

		// Prompt the user for a number to search
		System.out.println("Please enter a number to search for in the array: ");
		int key = scan.nextInt();		

		// Search for the key in the sortedArray and return the index
		int index = binarySearch(sortedArray, key);

		// Print out results
		if (index >= 0)
			System.out.println(key + " found at index " + index + " after " + numRecursiveCalls + " recursive calls.");
		else
			System.out.println(key + " not found after " + numRecursiveCalls + " recursive calls.");
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method is a public method that can be called from main or externally
	// by another client (like an autograder). You may NOT change this method
	// header or the code within.
	//		Parameters:
	//			sortedArray - A sorted array of integers
	//			key - The value being searched for in sortedArray
	//		Returns:
	//			An int representing the index at which key is located (-1 if not found)
	////////////////////////////////////////////////////////////////////////////////
	public static int binarySearch(int[] sortedArray, int key)
	{
		// Start off by performing a binary search on the ENTIRE array
		return recursiveBinarySearch(sortedArray, key, 0, sortedArray.length - 1);
	}

	////////////////////////////////////////////////////////////////////////////////
	// This is a recursive method which performs binary search (think of the 
	// "higher/lower" number guessing game. Each recursive call checks to see
	// if the number in the middle of the array is the number being looked
	// for (that is, they key); if the key is not found, a recursive call is
	// made which splits the area being searched in half and either searches
	// the top half or bottom half of the CURRENT array.
	//
	// If the method completes and determines that the key is not in the array,
	// the method should return -1; otherwise, the method should return the index
	// of the key.
	//
	// NOTE: The sortedArray never changes...only the beginning/end search indices
	// (beginSearchIndex/endSearchIndex), which effectively changes the portions of the 
	// array that we are searching through.
	//		Parameters:
	//			sortedArray - A sorted array of integers
	//			key - The value being searched for in sortedArray
	//			beginSearchIndex - The index at which this call should start searching for key
	//			endSearchIndex - The index at which this call should end searching for key
	//		Returns:
	//			An int representing the index at which key is located (-1 if not found)
	////////////////////////////////////////////////////////////////////////////////
	private static int recursiveBinarySearch(int[] sortedArray, int key, int beginSearchIndex, int endSearchIndex)
	{
		numRecursiveCalls++; // Do NOT erase/change. Used for autograding and counting the number of recursive calls

		// Your code goes here
		int midSearchIndex = (beginSearchIndex + endSearchIndex) / 2;

		// If the key is right in the middle of the array, return the middle index
		if (sortedArray[midSearchIndex] == key)
			return midSearchIndex;
		else if (beginSearchIndex < 0 || endSearchIndex >= sortedArray.length || beginSearchIndex == endSearchIndex)
			return -1; // Else, if the (sub-)array is empty 
		else if (key > sortedArray[midSearchIndex]) // Else, if key is greater than middle element, search to right 
			return recursiveBinarySearch(sortedArray, key, midSearchIndex+1, endSearchIndex);
		else // Else, if key is less than middle element, search to left
			return recursiveBinarySearch(sortedArray, key, beginSearchIndex, midSearchIndex-1);
	}
}
