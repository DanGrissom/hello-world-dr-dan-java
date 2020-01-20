/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) API Calls
//			a) How to use the Yelp API
//			b) Forming and understanding HTTP URLs
//			c) Making HTTP requests and receiving a response
//			d) Understanding the JSON data specification
//			e) Parsing JSON to get desired data
//			f) API authentication
//		2) Importing external libraries to add new functionality
//			a) Using Maven and the MVN repository to add new jar libraries to your project
//
//	***NOTE: Before you begin this project, you must complete the steps in the READ_ME: 
//				https://github.com/DanGrissom/hello-world-dr-dan-java/blob/master/Module_06_Threads_GUIs_And_APIs/READ_ME.txt
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Lesson_03_APIs_JSON_Libraries_Maven
{
	// Base address for yelp business search API
	private final static String baseUrl = "https://api.yelp.com/v3/businesses/search";

	// API key for Yelp (get yours here: https://www.yelp.com/developers/v3/manage_app)
	// Once you obtain a key, include it here instead of "YOUR_KEY_HERE":
	private final static String apiKey = "YOUR_KEY_HERE";

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will start execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args)
	{
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to make API calls to utilize external data, process JSON and import external libraries using Maven.");
		System.out.println("===========================================================================");
		
		// Initialize Scanner to read in from user
		
		// Prompt the user for the search query

		// Generate request URL

		// Get response (from request), parse JSON response and print each result
	}

	////////////////////////////////////////////////////////////////////////////////
	// Generates a URL request for the Yelp Fusion API according to the following
	// web-page: https://www.yelp.com/developers/documentation/v3/business_search
	//		Parameters:
	//			location - A string representing the location to search
	//			query - A string representing the search term
	//			meters - An integer representing the radius to search (in meters)
	//		Returns:
	//			An HttpRequest which contains the fully-specified URL
	////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////
	// Uses JSON external library to make HTTP request, parse JSON objects/
	// arrays/values. Specifically parses out the main/secondary text/description
	// of each establishment and prints.
	//
	// https://www.yelp.com/developers/documentation/v3/business_search
	//		Parameters:
	//			request - An object which contains the fully-specified URL
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
}