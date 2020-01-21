/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) WindowBuilder GUI
//			a) How to use WindowBuilder to create a GUI
//		2) Continued practice with API calls
//			a) How to use more Yelp API methods
//
//	***NOTE: Before you begin this project, you must complete the steps in the READ_ME: 
//				https://github.com/DanGrissom/hello-world-dr-dan-java/blob/master/Module_06_Threads_GUIs_And_APIs/READ_ME.txt
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import javax.swing.JFrame;

public class Lesson_04_Windowbuilder_GUI_APIs extends JFrame {

	///////////////////////////////////////////////////////////////////
	// Instance variables/components

	///////////////////////////////////////////////////////////////////
	// DefaultListModel is bound to lstResults

	///////////////////////////////////////////////////////////////////
	// APIs SECTION
	///////////////////////////////////////////////////////////////////
	private final static String baseUrl = "https://api.yelp.com/v3/businesses/";

	// API key for Yelp (get yours here: https://www.yelp.com/developers/v3/manage_app)
	// Once you obtain a key, include it here instead of "YOUR_KEY_HERE":
	private final static String apiKey = "YOUR_KEY_HERE"; // Yelp API key

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will start execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use WindowBuilder to create a GUI and make more API calls.");
		System.out.println("===========================================================================");

		// Launch GUI by instantiating an object of this class
		Lesson_04_Windowbuilder_GUI_APIs frame = new Lesson_04_Windowbuilder_GUI_APIs();
		frame.setVisible(true);
	}

	////////////////////////////////////////////////////////////////////////////////
	// Constructor - calls initComponents and createEvents
	////////////////////////////////////////////////////////////////////////////////
	public Lesson_04_Windowbuilder_GUI_APIs() {
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////////////////
	// All component initializations done here in this method
	////////////////////////////////////////////////////////////////////////////////
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
	}

	////////////////////////////////////////////////////////////////////////////////
	// All event handlers placed here in this method
	////////////////////////////////////////////////////////////////////////////////
	private void createEvents() {
		///////////////////////////////////////////////////////////////
		// btnFoodSearch/txtFoodSearch Handler - Calls Yelp Fusion API to return a list of
		// places with the search radius and search term from the starting
		// address

		///////////////////////////////////////////////////////////////
		// btnHours Handler - Calls Yelp Fusion API to get the hours for
		// a particular business

		///////////////////////////////////////////////////////////////
		// btnReviews Handler - Calls Yelp Fusion API to get the reviews
		// for a particular business
	}

	////////////////////////////////////////////////////////////////////////////////
	// Get the parameters from the text boxes and make a call to the Yelp api
	// to get business results
	//		Parameters:
	//			(NONE)
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////

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
	// of each business and returns a list of businesses
	//
	// https://www.yelp.com/developers/documentation/v3/business_search
	//		Parameters:
	//			request - An object which contains the fully-specified URL
	//		Returns:
	//			An ArrayList containing all the businesses
	////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////
	// Generates a URL request for the Yelp Fusion API according to the following
	// web-page: https://www.yelp.com/developers/documentation/v3/business
	//		Parameters:
	//			businessId - A string representing a business' Yelp ID
	//		Returns:
	//			An HttpRequest which contains the fully-specified URL
	////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////
	// Uses JSON external library to make HTTP request, parse JSON objects/
	// arrays/values. Specifically parses out hours for the business in the given
	// request.
	//
	// https://www.yelp.com/developers/documentation/v3/business
	//		Parameters:
	//			request - An object which contains the fully-specified URL
	//		Returns:
	//			A formatted String representing the hours
	////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////
	// Takes in a JSON object (from Yelp API) and returns a formatted String
	// representing the day of week and hours open.
	//		Parameters:
	//			objDay - A JSONObject with hours for that day
	//		Returns:
	//			A String representing the day and open hours
	////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////
	// Takes in a 4-digit 24-hour formatted time and returns a AM/PM time
	//		Parameters:
	//			time24Hour - A 4-digit 24 time (e.g., 0030, 1200, 1700)
	//		Returns:
	//			A String representing AM/PM 12-hour time (e.g., 12:30 AM, 12:00 PM, 5:00 PM)
	////////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////////
	// Generates a URL request for the Yelp Fusion API according to the following
	// web-page: https://www.yelp.com/developers/documentation/v3/business_reviews
	//		Parameters:
	//			businessId - A string representing a business' Yelp ID
	//		Returns:
	//			An HttpRequest which contains the fully-specified URL
	////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////
	// Uses JSON external library to make HTTP request, parse JSON objects/
	// arrays/values. Specifically parses out the reviews and returns in a formatted
	// string.
	//
	// https://www.yelp.com/developers/documentation/v3/business_reviews
	//		Parameters:
	//			request - An object which contains the fully-specified URL
	//		Returns:
	//			A formatted String representing the reviews
	////////////////////////////////////////////////////////////////////////////////
}
