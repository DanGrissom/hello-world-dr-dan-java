/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Map Data structure
//			a) Mapping a String to an ArrayList of Strings (an object)
//			b) Creating new objects before putting new data in map
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson_06_Map_Complex_Values_Countries_Visited_Example {

	public static void main(String[] args) {

		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use the Map data structure to map Strings to an object (ArrayList of Strings).");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);

		// Initialize data structures and variables
		Map<String, ArrayList<String>> mCountryToVisitorNames = new HashMap<String, ArrayList<String>>();
		String country;

		// Add new countries to our set of visited countries until user says "Done"
		do {
			// Prompt user for name
			System.out.print("Please enter your name: ");
			String name = scan.nextLine();

			// Prompt user for country to visit
			System.out.print("Please enter a country you have visited (enter \"Done\" to stop): ");
			country = scan.nextLine().toUpperCase();

			// If the map already contains the country, get the existing list and add the new name
			if (mCountryToVisitorNames.containsKey(country)) {
				ArrayList<String> names = mCountryToVisitorNames.get(country);
				names.add(name);
				//mCountryToVisitorNames.put(country, names);		// Not necessary b/c the names ArrayList is in the heap and is the same list the map is already pointing to
			} else {
				// Otherwise, create a new list and add the name
				ArrayList<String> names = new ArrayList<String>();
				names.add(name);
				mCountryToVisitorNames.put(country, names);
			}
		} while (!country.equals("DONE"));
		mCountryToVisitorNames.remove("DONE");		// Remove the "DONE" from the set since it does not belong

		// Iterate through each unique value in the set (will print in no specific order)
		System.out.println("Your group has visited " + mCountryToVisitorNames.size() + " unique countries, listed below:");
		for (String c : mCountryToVisitorNames.keySet()) {
			ArrayList<String> names = mCountryToVisitorNames.get(c);
			
			// Print each name in the country's visitor list
			System.out.printf("\t%s had %s unique visitor(s):\n", c, names.size());
			for (String name : names)
				System.out.println("\t\t" + name);
		}
	}
}
