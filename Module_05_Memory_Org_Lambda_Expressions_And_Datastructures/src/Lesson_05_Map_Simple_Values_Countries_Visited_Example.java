/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//In this lesson you will learn:
//		1) Map Data structure
//			a) Declaring and initializing
//			b) Mapping a String to an integer (primitive)
//			c) Common methods: containsKey(), get(), put(), remove(), size(), keySet()
//			d) Normalizing String values for map keys
//			e) Iterating through map keys and getting associate values
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson_05_Map_Simple_Values_Countries_Visited_Example {

	public static void main(String[] args) {
		
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use the Map data structure to map Strings to a primitive (integer).");
		System.out.println("===========================================================================");

		// Initialize Scanner to read in from user
		Scanner scan = new Scanner(System.in);

		// Initialize data structures and variables
		Map<String, Integer> mapCountryToVisitorCount = new HashMap<String, Integer>();
		String country;

		// Add new countries to our set of visited countries until user says "Done"
		do {
			// Prompt user for country to visit
			System.out.print("Please enter a country you have visited (enter \"Done\" to stop): ");
			country = scan.nextLine().toUpperCase();

			// If the map already contains the country, increment the count
			if (mapCountryToVisitorCount.containsKey(country)) {
				int value = mapCountryToVisitorCount.get(country);
				value++;
				mapCountryToVisitorCount.put(country, value);
			}
			else // Otherwise, set the count to 1 for this country
				mapCountryToVisitorCount.put(country, 1);
			
		} while(!country.equals("DONE"));
		mapCountryToVisitorCount.remove("DONE");	// Remove the "DONE" from the set since it does not belong

		// Iterate through each unique value in the set (will print in no specific order)
		System.out.println("Your classmates have visited " + mapCountryToVisitorCount.size() + " unique countries, listed below:");
		for (String c : mapCountryToVisitorCount.keySet())
			System.out.println("\t" + c + " had " + mapCountryToVisitorCount.get(c) + " unique visitor(s)");	
	}

}
