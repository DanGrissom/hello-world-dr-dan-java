/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//In this lesson you will learn:
//		1) WindowBuilder GUI
//			a) How to use WindowBuilder to create a GUI
//		2) Continued practice with API calls
//			a) How to use more Yelp API methods
//
//	***NOTE: Before you begin this project, you must complete the steps in the READ_ME
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import javax.swing.JFrame;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;

import models.Business;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Lesson_04_Windowbuilder_GUI_APIs extends JFrame {

	///////////////////////////////////////////////////////////////////
	// Instance variables/components
	private JTextField txtStartAddress;
	private JTextField txtRadius;
	private JTextField txtFoodSearch;
	private JButton btnSearch;
	private JList lstResults;
	private JButton btnHours;
	private JButton btnReviews;
	private JTextArea txtDetails;

	///////////////////////////////////////////////////////////////////
	// DefaultListModel is bound to lstResults
	private DefaultListModel<Business> dlmResult = new DefaultListModel<Business>();

	///////////////////////////////////////////////////////////////////
	// APIs SECTION
	///////////////////////////////////////////////////////////////////
	private final static String baseUrl = "https://api.yelp.com/v3/businesses/";

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
		setBounds(100, 100, 1160, 664);

		JLabel lblStartAddress = new JLabel("Start Address:");

		txtStartAddress = new JTextField();
		txtStartAddress.setColumns(10);

		JLabel lblRadius = new JLabel("Radius (miles):");

		txtRadius = new JTextField();
		txtRadius.setColumns(10);

		JLabel lblFoodSearch = new JLabel("Food Search:");

		txtFoodSearch = new JTextField();
		txtFoodSearch.setColumns(10);

		btnSearch = new JButton("Search");

		JLabel lblResults = new JLabel("Results:");

		JScrollPane scrResults = new JScrollPane();

		btnHours = new JButton("Hours >");

		btnReviews = new JButton("Reviews >");

		JLabel lblHoursReviews = new JLabel("Hours/Reviews:");

		JScrollPane scrDetails = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSearch)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblFoodSearch)
												.addComponent(lblRadius)
												.addComponent(lblStartAddress)
												.addComponent(lblResults))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(scrResults, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(txtFoodSearch)
														.addComponent(txtRadius)
														.addComponent(txtStartAddress, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)))))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnHours, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnReviews, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrDetails, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
								.addComponent(lblHoursReviews))
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStartAddress)
								.addComponent(txtStartAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHoursReviews))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblRadius)
												.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblFoodSearch)
												.addComponent(txtFoodSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnSearch)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnHours)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnReviews))
												.addComponent(lblResults)
												.addComponent(scrResults, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)))
								.addComponent(scrDetails, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
						.addContainerGap())
				);

		txtDetails = new JTextArea();
		txtDetails.setEditable(false);
		scrDetails.setViewportView(txtDetails);

		lstResults = new JList(dlmResult);
		scrResults.setViewportView(lstResults);
		getContentPane().setLayout(groupLayout);
	}

	////////////////////////////////////////////////////////////////////////////////
	// All event handlers placed here in this method
	////////////////////////////////////////////////////////////////////////////////
	private void createEvents() {
		///////////////////////////////////////////////////////////////
		// Calls Yelp Fusion API to return a list of places with the
		// search radius and search term from the starting address
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Get info from text boxes
				String address = txtStartAddress.getText();
				double meters = Double.parseDouble(txtRadius.getText()) * 1609.34;
				String query = txtFoodSearch.getText();

				// Generate request URL and get response
				HttpRequest busSearchRequest = generateBusinessSearchRequestUrl(address, query, (int)meters);
				ArrayList<Business> businesses = getBusinessSearchResults(busSearchRequest);

				// Populate JList with our results
				dlmResult.clear();
				for (Business p : businesses)
					dlmResult.addElement(p);
			}
		});


		///////////////////////////////////////////////////////////////
		// Calls Yelp Fusion API to get the hours for a particular 
		// business
		btnHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Generate request URL and get response
				Business selectedBusiness = (Business)lstResults.getSelectedValue();
				HttpRequest busByIdRequest = generateBusinessByIdUrl(selectedBusiness.getBusinessId());
				String formattedHours = getHoursFromBusinessByIdResponse(busByIdRequest);
				txtDetails.setText(formattedHours);
			}
		});


		///////////////////////////////////////////////////////////////
		// Calls Yelp Fusion API to get the reviews for a particular 
		// business
		btnReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Generate request URL and get response
				Business selectedBusiness = (Business)lstResults.getSelectedValue();
				HttpRequest busReviewsRequest = generateBusinessReviewsUrl(selectedBusiness.getBusinessId());
				String formattedReviews = getReviewsFromBusinessResponse(busReviewsRequest);
				txtDetails.setText(formattedReviews);
			}
		});
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
	public static HttpRequest generateBusinessSearchRequestUrl(String location, String query, int meters)
	{
		// Start with the business_search end-point
		HttpRequest request = Unirest.get(baseUrl + "search");

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
	// of each business and returns a list of businesses
	//
	// https://www.yelp.com/developers/documentation/v3/business_search
	//		Parameters:
	//			request - An object which contains the fully-specified URL
	//		Returns:
	//			An ArrayList containing all the businesses
	////////////////////////////////////////////////////////////////////////////////
	private static ArrayList<Business> getBusinessSearchResults(HttpRequest request)
	{
		// Create new arraylist of businesses
		ArrayList<Business> businesses = new ArrayList<Business>();

		try {
			// Get the main response
			JSONObject objResponse = request.asJson().getBody().getObject();

			// First, check if there is an error
			if (objResponse.has("error")) {
				String shortDescription = objResponse.getJSONObject("error").getString("code");
				String longDescription = objResponse.getJSONObject("error").getString("description");
				System.out.println("ERROR: " + shortDescription + ": ");
				System.out.println("\t" + longDescription);
				return null;
			}			

			// Get the businesses array in the response
			JSONArray arrBusinesses = objResponse.getJSONArray("businesses");

			// Iterate through each JSON object (business) in the results array
			for (int i = 0; i < arrBusinesses.length(); i++) {
				// Get the next business
				JSONObject objBusiness = arrBusinesses.getJSONObject(i);

				// Pull the name from the business
				String name = objBusiness.getString("name");

				// Pull address info from the business
				JSONObject objLocation = objBusiness.getJSONObject("location");
				String address = objLocation.getString("address1");
				address += ", " + objLocation.getString("city") + ", " + objLocation.getString("state") + " (" + objLocation.getString("country") + ")";

				// Pull the rating and id from the business
				double rating = objBusiness.getDouble("rating");
				String id = objBusiness.getString("id");

				// Add business to arraylist
				businesses.add(new Business(name, rating, address, id));
			}
		} catch (UnirestException e) {
			System.out.println("API ERROR: " + e.getMessage());
		}  catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		// Return the results
		return businesses;
	}


	////////////////////////////////////////////////////////////////////////////////
	// Generates a URL request for the Yelp Fusion API according to the following
	// web-page: https://www.yelp.com/developers/documentation/v3/business
	//		Parameters:
	//			businessId - A string representing a business' Yelp ID
	//		Returns:
	//			An HttpRequest which contains the fully-specified URL
	////////////////////////////////////////////////////////////////////////////////
	public static HttpRequest generateBusinessByIdUrl(String businessId)
	{
		// Start with the business search by id end-point
		HttpRequest request = Unirest.get(baseUrl + businessId);

		// Add authorization in header
		request = request.header("Authorization", "Bearer " + apiKey);

		// Return request/URL
		return request;
	}

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
	private static String getHoursFromBusinessByIdResponse(HttpRequest request)
	{
		// Init a formatted string
		String strHours = "";

		try {
			// Get the main response
			JSONObject objResponse = request.asJson().getBody().getObject();

			// First, check if there is an error
			if (objResponse.has("error")) {
				String shortDescription = objResponse.getJSONObject("error").getString("code");
				String longDescription = objResponse.getJSONObject("error").getString("description");
				System.out.println("ERROR: " + shortDescription + ": ");
				System.out.println("\t" + longDescription);
				return null;
			}	
			
			// Make sure hours exist
			if (!objResponse.has("hours")) {
				strHours += "No hours listed";
				return strHours;
			}

			// Get hours array
			JSONObject objHours = objResponse.getJSONArray("hours").getJSONObject(0);

			// Get current status and add to hours string
			boolean isOpen = objHours.getBoolean("is_open_now");
			strHours += isOpen ? "OPEN NOW:\n    YES\n\n" : "OPEN NOW:\n    NO\n\n";

			// Get daily hours
			strHours += "DAILY HOURS:\n";
			JSONArray arrDays = objHours.getJSONArray("open");
			for (int i = 0; i < arrDays.length(); i++) {
				JSONObject objDay = arrDays.getJSONObject(i);
				strHours += String.format("    %s\n", getDailyHoursString(objDay));
			}
		} catch (UnirestException e) {
			System.out.println("API ERROR: " + e.getMessage());
		}  catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		// Return the formatted hours
		return strHours;
	}

	////////////////////////////////////////////////////////////////////////////////
	// Takes in a JSON object (from Yelp API) and returns a formatted String
	// representing the day of week and hours open.
	//		Parameters:
	//			objDay - A JSONObject with hours for that day
	//		Returns:
	//			A String representing the day and open hours
	////////////////////////////////////////////////////////////////////////////////
	private static String getDailyHoursString(JSONObject objDay) {

		// Convert the integer day value to a String
		String [] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		String day = days[objDay.getInt("day")];

		// Get the opening and closing times
		String openingTime = objDay.getString("start");
		String closingTime = objDay.getString("end");

		// Return formatted string
		return String.format("%s: %s - %s", day, get12HourTime(openingTime), get12HourTime(closingTime));
	}

	////////////////////////////////////////////////////////////////////////////////
	// Takes in a 4-digit 24-hour formatted time and returns a AM/PM time
	//		Parameters:
	//			time24Hour - A 4-digit 24 time (e.g., 0030, 1200, 1700)
	//		Returns:
	//			A String representing AM/PM 12-hour time (e.g., 12:30 AM, 12:00 PM, 5:00 PM)
	////////////////////////////////////////////////////////////////////////////////
	private static String get12HourTime(String time24Hour) {
		
		// Pull off the hours and minutes
		String hour = time24Hour.substring(0, 2);
		String minute = time24Hour.substring(2, 4);
		String ampm = "";

		// If 00, then midnight
		if (hour.equals("00")) {
			hour = "12";
			ampm = "AM";
		} else if (hour.equals("12")) { // If 12, then noon
			ampm = "PM";
		} else if (Integer.parseInt(hour) < 12) { // If < 12, then AM
			hour = Integer.toString(Integer.parseInt(hour));
			ampm = "AM";
		} else { // If > 12, then PM
			hour = Integer.toString(Integer.parseInt(hour) - 12);
			ampm = "PM";
		}

		// Return formatted string
		return String.format("%s:%s %s", hour, minute, ampm);
	}

	
	////////////////////////////////////////////////////////////////////////////////
	// Generates a URL request for the Yelp Fusion API according to the following
	// web-page: https://www.yelp.com/developers/documentation/v3/business_reviews
	//		Parameters:
	//			businessId - A string representing a business' Yelp ID
	//		Returns:
	//			An HttpRequest which contains the fully-specified URL
	////////////////////////////////////////////////////////////////////////////////
	public static HttpRequest generateBusinessReviewsUrl(String businessId)
	{
		// Start with the business reviews end-point
		HttpRequest request = Unirest.get(baseUrl + businessId + "/reviews");

		// Add authorization in header
		request = request.header("Authorization", "Bearer " + apiKey);

		// Return request/URL
		return request;
	}

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
	private static String getReviewsFromBusinessResponse(HttpRequest request)
	{
		// Init a formatted string
		String strReviews = "REVIEWS:\n";

		try {
			// Get the main response
			JSONObject objResponse = request.asJson().getBody().getObject();

			// First, check if there is an error
			if (objResponse.has("error")) {
				String shortDescription = objResponse.getJSONObject("error").getString("code");
				String longDescription = objResponse.getJSONObject("error").getString("description");
				System.out.println("ERROR: " + shortDescription + ": ");
				System.out.println("\t" + longDescription);
				return null;
			}	
			
			// Make sure hours exist
			if (!objResponse.has("reviews")) {
				strReviews += "No reviews listed";
				return strReviews;
			}

			// Get reviews array and iterate through each array
			JSONArray arrReviews = objResponse.getJSONArray("reviews");
			for (int i = 0; i < arrReviews.length(); i++) {
				// Get the individual review
				JSONObject objReview = arrReviews.getJSONObject(i);
				
				// Pull off specific details
				String name = objReview.getJSONObject("user").getString("name");
				String time = objReview.getString("time_created");
				String review = objReview.getString("text");
				
				// Format details
				strReviews += String.format("%s - %s\n", name, time);
				strReviews += String.format("%s\n\n", review);
				strReviews += "----------------------------------------------\n";
			}
		} catch (UnirestException e) {
			System.out.println("API ERROR: " + e.getMessage());
		}  catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		// Return the formatted hours
		return strReviews;
	}
}
