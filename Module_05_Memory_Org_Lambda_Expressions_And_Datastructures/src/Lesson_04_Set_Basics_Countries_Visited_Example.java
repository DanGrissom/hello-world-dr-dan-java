/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//In this lesson you will learn:
//		1) Set Data structure
//			a) Declaring and initializing
//			b) Common methods: add(), remove(), size()
//			c) Normalizing String values for sets
//			d) Iterating through set values
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lesson_04_Set_Basics_Countries_Visited_Example {
	public static void main(String[] args) {

		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use the Set data structure in a practical example.");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);
		
		// Initialize data structures and variables
		Set<String> countriesVisited = new HashSet<String>();
		String country;

		// Add new countries to our set of visited countries until user says "Done"
		do {
			// Prompt the user for country visited and add to set
			System.out.print("Please enter a country you have visited (enter \"Done\" to stop): ");
			country = scan.nextLine().toUpperCase();	// Uppercase for consistency
			countriesVisited.add(country); 	// Will not add duplicate countries
		} while(!country.equals("DONE"));
		countriesVisited.remove("DONE");	// Remove the "DONE" from the set since it does not belong


		// Iterate through each unique value in the set (will print in no specific order)
		System.out.println("Your classmates have visited " + countriesVisited.size() + " unique countries, listed below:");
		for (String c : countriesVisited)
			System.out.println("\t" + c);		
	}
}
