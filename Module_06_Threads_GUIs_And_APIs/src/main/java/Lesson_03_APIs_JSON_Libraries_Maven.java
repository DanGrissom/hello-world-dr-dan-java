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
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;

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
		Scanner scan = new Scanner(System.in);
		
		// Prompt the user for the search query
		System.out.print("Enter the search location (e.g., City, Address, etc.): ");
		String location = scan.nextLine();
		System.out.print("Enter the type of food or restaurant you are hungry for: ");
		String query = scan.nextLine();
		System.out.print("Enter the number of miles you are willing to travel: ");
		double miles = scan.nextDouble();
		int meters = (int)(miles * 1609.34);

		// Generate request URL
		HttpRequest request = generateRequestUrl(location, query, meters);
		//System.out.println("URL: " + request.getUrl());

		// Get response (from request), parse JSON response and print each result
		getAndParseResponseAndPrintResults(request);
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
	public static HttpRequest generateRequestUrl(String location, String query, int meters)
	{
		// Start with the business_search end-point
		HttpRequest request = Unirest.get(baseUrl);
		
		// Add parameters
		request = request.queryString("location", location);
		request = request.queryString("term", query);
		request = request.queryString("radius", meters);
		
		// Add authorization in header
		request = request.header("Authorization", "Bearer " + apiKey);
		
		// Return request/URL
		return request;
	}

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
	private static void getAndParseResponseAndPrintResults(HttpRequest request) {
		try {
			// Get the main response
			JSONObject objResponse = request.asJson().getBody().getObject();
			//System.out.println("RESPONSE OBJECT: " + objResponse);
			
			// First, check if there is an error
			if (objResponse.has("error")) {
				String shortDescription = objResponse.getJSONObject("error").getString("code");
				String longDescription = objResponse.getJSONObject("error").getString("description");
				System.out.printf("%s: %s\n", shortDescription, longDescription);
				return;
			}
			
			// Get the businesses array in the response
			JSONArray arrBusinesses = objResponse.getJSONArray("businesses");
			//System.out.println("BUSINESSES ARRAY: " + arrBusinesses);
			
			// Iterate through each JSON object (business) in the results (businesses) array
			System.out.println("Yelp Search Results:");
			for (int i = 0; i < arrBusinesses.length(); i++) {
				// Get the next business
				JSONObject objBusiness = arrBusinesses.getJSONObject(i);
				//System.out.println("BUSINESS: " + objBusiness);
				
				// Pull the name from the business
				String name = objBusiness.getString("name");
				
				// Pull the address info from the business
				JSONObject objLocation = objBusiness.getJSONObject("location");
				String address = String.format("%s, %s, %s (%s)",
						objLocation.getString("address1"), objLocation.getString("city"), objLocation.getString("state"), objLocation.getString("country"));
				
				// Pull the rating from the business
				double rating = objBusiness.getDouble("rating");
				
				// Print result
				System.out.printf("\t%s) %s - %s (%s/5.0)\n", (i+1), name, address, rating);
			}
		} catch (UnirestException e) {
			System.out.println("API ERROR: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}