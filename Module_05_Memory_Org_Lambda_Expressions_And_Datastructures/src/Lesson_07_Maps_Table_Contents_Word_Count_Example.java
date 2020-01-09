/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Complex usage of the Map data structure
//			a) Creating a Table of Contents
//				i) Sorting a Map by key (using Collections.sort() to sort the map's key set)
//			b) Creating a Word Frequency Table
//				i) Sorting a Map by value, (using Collections.sort(), a custom Comparator and a simple Class to
//					connect the map-key pair)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Lesson_07_Maps_Table_Contents_Word_Count_Example {

	public static void main(String[] args) {

		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use Maps in complex scenarios.");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);

		// Initial welcome and prompt for filename
		System.out.println("Welcome to the file analyzer.");
		System.out.print("Please enter the file you would like to analyze: ");
		String fileName = scan.next();

		// Prompt for option
		System.out.println("Please select an option by typing the number of the option:");
		System.out.println("\t1. Print Table of Contents (ToC)");
		System.out.println("\t2. Print words with top word count");
		int option = scan.nextInt();

		if (option == 1)
		{
			// Declare Map and obtain instance from method call
			Map<String, ArrayList<Integer>> toc = getTableOfContents(fileName);
			printOrderedTableOfContents(toc);
		}
		else if (option == 2)
		{
			// Declare Map and obtain instance from method call
			Map<String, Integer> wordCount = getWordCount(fileName);

			// Ask the user how many of the most frequent words they'd like to print and print them
			System.out.print("How many words would you like to print from the most frequent words? ");
			int numWords = scan.nextInt();
			printTopWordCounts(numWords, wordCount);
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method takes in a filename, parses it and returns a table of contents
	// (i.e., a mapping of words to page numbers corresponding words appear on in
	// the input file).
	//		Parameters:
	//			filename - A string of the filename to open and convert to a ToC
	//		Returns:
	//			A Map which maps words (Strings) to an ArrayList of page numbers
	////////////////////////////////////////////////////////////////////////////////
	private static Map<String, ArrayList<Integer>> getTableOfContents(String filename)
	{
		// Keep track of the current page while search through the file

		// Create the Map that you will eventually return and call it toc (for Table of Contents)

		// Init file input objects
		FileInputStream fis = null;
		Scanner scan = null;

		try
		{
			fis = new FileInputStream(filename);
			scan = new Scanner(fis);

			// Keep reading words from file...
			while (scan.hasNext())
			{
				// Read in next word and update it so that we ignore the following
				// symbols: . , ; : ( ) ! ? $ (HINT: Replace these symbols with "", i.e., NOTHING!)
				// We do this b/c "today." is the same word as "today" to a table of contents
				// Also, force all words to lowercase ("The" is same as "the")
				
				// If we find the sequence of characters denoting the page number ("%%%%")
					// Read in pg number and clear off the closing "%%%%" sequence
				// Else make sure to only print words that begin with a letter
					// If the word is found in the toc map
						// Get the current list of pages for this word and add the current page IF NOT ALREADY in the ArrayList
					// ...if word not already in toc map...
						// Create a new list, add the current page to your list, and PUT the list in the toc map with the key as the word
			}
		}
		catch(Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
		finally
		{
			// Close file
			try
			{
				if (scan != null) scan.close();
				if (fis != null) fis.close();
			}
			catch(Exception e)
			{
				System.out.println("ERROR: " + e.getMessage());
			}

		}

		// Return the table of contents
		return null;
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method prints the table of contents in alphabetical order followed by
	// page numbers each word appears on (separated by commas).
	//		Parameters:
	//			toc - A Map representing the Table of Contents
	//					(mapping String->ArrayList of page numbers)
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private static void printOrderedTableOfContents(Map<String, ArrayList<Integer>> toc)
	{
		// Get Unique words in a Set (get the key set) and call the set uniqueWords

		// It is not easy to sort a map (it wasn't designed for this). We really just need to sort
		// the keys. Once the keys are sorted, we can then iterate through the sorted keys and
		// use the map to obtain the value associated with the key.

		// Create a new ArrayList called orderedWords and add all of the words from the map to it.
		// Then, sort it using the Collections.sort() method.

		// Now that the words (keys) from the maps are sorted alphabetically within
		// orderedWords, cycle through each word and obtain the matching value from
		// the map (an ArrayList of ints). Print out each word and page numbers like:
		//		topology:	2, 3, 5, 8
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method takes in a filename, parses it and returns a mapping of words to
	// their frequency (count) in the input file.
	//		Parameters:
	//			filename - A string of the filename to open and convert to a word count
	//		Returns:
	//			A Map which maps words (Strings) to a frequency count (int)
	////////////////////////////////////////////////////////////////////////////////
	private static Map<String, Integer> getWordCount(String filename)
	{
		// Create the Map that you will eventually return and call it wordCount

		// Init file input objects
		FileInputStream fis = null;
		Scanner scan = null;

		try
		{
			fis = new FileInputStream(filename);
			scan = new Scanner(fis);

			// Keep reading words from file...
			while (scan.hasNext())
			{
				// Read in next word and update it so that we ignore the following
				// symbols: . , ; : ( ) ! ? $  (HINT: Replace these symbols with "", i.e., NOTHING!)
				// We do this b/c "today." is the same word as "today" to a table of contents
				// Also, force all words to lowercase ("The" is same as "the")

				// If we find the sequence of characters denoting the page number ("%%%%")
					// Read in pg number and clear off the closing "%%%%" sequence
				// Else make sure to only print words that begin with a letter
					// If the word is found in the wordCount map
						// Get the current word count for this word and increment it
					// ...if word not already in wordCount map...
						// PUT the word in the wordCount map with a count (value) of 1 (first appearance)
			}
		}
		catch(Exception e)
		{
			System.out.println("ERROR: " + e.getMessage());
		}
		finally
		{
			// Close file
			try
			{
				if (scan != null) scan.close();
				if (fis != null) fis.close();
			}
			catch(Exception e)
			{
				System.out.println("ERROR: " + e.getMessage());
			}
		}

		// Return the wordCount
		return null;
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method prints the corresponding number of most-frequently-used words in wordCount. 
	//		Parameters:
	//			numWords - An int representing how many word counts to print
	//			wordCount - A Map which maps words (Strings) to a frequency count (int)
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private static void printTopWordCounts(int numWords, Map<String, Integer> wordCount)
	{
		// Like earlier, it is hard to sort things in a map. We want to sort based on the
		// values, which is even harder (because we cannot easily re-associate values with
		// the key b/c the values can be repeated in the map; for example, there may be 
		// numerous words that appear exactly 5 times).
		//
		// Create an ArrayList of WordCountPairs* called sortedWordCountPairs. For every word in the
		// map, you should create a new WordCountPair object with the word and count and add
		// it to the sortedWordCountPairs ArrayList.
		//
		// *NOTE: WordCountPair is a custom class we created to encapsulate the entire key-value
		// pair (that is, the word-count pair).

		// Once we have the ArrayList of WordCountPairs, we must use a custom Comparator. This is 
		// a VERY VALUABLE thing to learn as it allows for more interesting/complex sortings.
		//
		// Inside the compare method, you'll need some code that compares the word counts of each
		// WordCountPair object and returns an integer.

		// Now, using the numWords parameter, print out word counts for the numWords most-frequent
		// words HINT: You are just iterating through the first numWords words in sortedWordCount
		// and printing in the following format:
		// 		pcb: 76 times
	}
}
