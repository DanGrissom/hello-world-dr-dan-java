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
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import models.Business;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Lesson_04_Windowbuilder_GUI_APIs extends JFrame {

	///////////////////////////////////////////////////////////////////
	// Instance variables/components
	private JTextField txtStartAddress = new JTextField();
	private JTextField txtFoodSearch = new JTextField();
	private JTextField txtRadius = new JTextField();
	private JList<Business> lstResults;
	private JTextArea txtDetails;
	private JButton btnReviews;
	private JButton btnSearch;
	private JButton btnHours;

	///////////////////////////////////////////////////////////////////
	// DefaultListModel is bound to lstResults
	private DefaultListModel<Business> dlmResults = new DefaultListModel<Business>();

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
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use WindowBuilder to create a GUI and make more API calls.");
		System.out.println("===========================================================================");

		// Launch GUI by instantiating an object of this class
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	// Checked exception...throws above exceptions
		Lesson_04_Windowbuilder_GUI_APIs frame = new Lesson_04_Windowbuilder_GUI_APIs();
		frame.setVisible(true);
	}

	////////////////////////////////////////////////////////////////////////////////
	// Constructor - calls initComponents and createEvents
	////////////////////////////////////////////////////////////////////////////////
	public Lesson_04_Windowbuilder_GUI_APIs() {
		setTitle("Dr. Dan's Yelp API & WindowBuilder Demo");
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////////////////
	// All component initializations done here in this method
	////////////////////////////////////////////////////////////////////////////////
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1050, 200, 700, 465);
		
		JLabel lblStartAddress = new JLabel("Start Address:");
		txtStartAddress.setColumns(10);
		JLabel lblRadius = new JLabel("Radius (miles):");
		txtRadius.setColumns(10);
		JLabel lblFoodSearch = new JLabel("Food Search:");
		txtFoodSearch.setColumns(10);
		btnSearch = new JButton("Search");
		JLabel lblResults = new JLabel("Results:");
		JScrollPane scrResults = new JScrollPane();
		btnHours = new JButton("Hours >");
		btnReviews = new JButton("Reviews >");
		JScrollPane scrDetails = new JScrollPane();
		
		JLabel lblDetails = new JLabel("Hours/Reviews:");
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
								.addComponent(scrResults, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtRadius, Alignment.LEADING)
									.addComponent(txtStartAddress, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
									.addComponent(txtFoodSearch, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnHours, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnReviews, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrDetails, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(lblDetails))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStartAddress)
							.addComponent(txtStartAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDetails))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
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
								.addComponent(lblResults)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(scrResults, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnHours)
										.addGap(7)
										.addComponent(btnReviews)
										.addGap(0, 244, Short.MAX_VALUE)))))
						.addComponent(scrDetails, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		txtDetails = new JTextArea();
		txtDetails.setEditable(false);
		scrDetails.setViewportView(txtDetails);
		
		lstResults = new JList<Business>(dlmResults);
		scrResults.setViewportView(lstResults);
		getContentPane().setLayout(groupLayout);
	}

	////////////////////////////////////////////////////////////////////////////////
	// All event handlers placed here in this method
	////////////////////////////////////////////////////////////////////////////////
	private void createEvents() {
		///////////////////////////////////////////////////////////////
		// btnFoodSearch/txtFoodSearch Handler - Calls Yelp Fusion API to return a list of
		// places with the search radius and search term from the starting
		// address
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				businessSearch();
			}
		});
		txtFoodSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				businessSearch();
			}
		});

		///////////////////////////////////////////////////////////////
		// btnHours Handler - Calls Yelp Fusion API to get the hours for
		// a particular business
		btnHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Generate request URL and get response
				Business selectedBusiness = (Business)lstResults.getSelectedValue();
				HttpRequest request = generateBusinessByIdRequestUrl(selectedBusiness.getYelpId());
				String formattedHours = getHoursFromBusinessByIdResponse(request);
				txtDetails.setText(formattedHours);
				txtDetails.setLineWrap(false);
			}
		});
		

		///////////////////////////////////////////////////////////////
		// btnReviews Handler - Calls Yelp Fusion API to get the reviews
		// for a particular business
		btnReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Generate request URL and get response
				Business selectedBusiness = (Business)lstResults.getSelectedValue();
				HttpRequest request = generateBusinessReviewsRequestUrl(selectedBusiness.getYelpId());
				String formattedReviews = getReviewsFromBusinessResponse(request);
				txtDetails.setText(formattedReviews);
				txtDetails.setLineWrap(true);
			}
		});
	}

	////////////////////////////////////////////////////////////////////////////////
	// Get the parameters from the text boxes and make a call to the Yelp api
	// to get business results
	//		Parameters:
	//			(NONE)
	//		Returns:
	//			void (NONE)
	////////////////////////////////////////////////////////////////////////////////
	private void businessSearch() {
		// Get info from text boxes
		String address = txtStartAddress.getText();
		int meters = (int)(Double.parseDouble( txtRadius.getText() ) * 1609.34);
		String query = txtFoodSearch.getText();
		
		// Generate request URL and get response as list of businesses
		HttpRequest request = generateBusinessSearchRequestUrl(address, query, meters);
		//System.out.println(request.getUrl());
		ArrayList<Business> businesses = getBusinessSearchResults(request);
		
		// Populate JList with our results
		dlmResults.clear();
		for (Business b : businesses)
			dlmResults.addElement(b);
		if (dlmResults.size() > 0)
			lstResults.setSelectedIndex(0);
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
	private HttpRequest generateBusinessSearchRequestUrl(String location, String query, int meters) {
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
	private ArrayList<Business> getBusinessSearchResults(HttpRequest request) {
		
		// Create new ArrayList of businesses
		ArrayList<Business> businesses = new ArrayList<Business>();
		
		try {
			// Get the main response
			JSONObject objResponse = request.asJson().getBody().getObject();
			//System.out.println("RESPONSE OBJECT: " + objResponse);
			
			// First, check if there is an error
			if (objResponse.has("error")) {
				String shortDescription = objResponse.getJSONObject("error").getString("code");
				String longDescription = objResponse.getJSONObject("error").getString("description");
				System.out.printf("%s: %s\n", shortDescription, longDescription);
				return businesses;
			}
			
			// Get the businesses array in the response
			JSONArray arrBusinesses = objResponse.getJSONArray("businesses");
			//System.out.println("BUSINESSES ARRAY: " + arrBusinesses);
			
			// Iterate through each JSON object (business) in the results (businesses) array
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
				
				// Pull the id from the business
				String yelpId = objBusiness.getString("id");
				
				// Add business to businesses ArrayList
				businesses.add(new Business(name, rating, address, yelpId));
			}
		} catch (UnirestException e) {
			System.out.println("API ERROR: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		// Return the businesses ArrayList
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
	protected HttpRequest generateBusinessByIdRequestUrl(String businessId) {
		// Start with the business_search end-point
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
	protected String getHoursFromBusinessByIdResponse(HttpRequest request) {
		
		// Init a formatted string for hours
		String strHours = "";
		
		try {
			// Get the main response
			JSONObject objResponse = request.asJson().getBody().getObject();
			//System.out.println("RESPONSE OBJECT: " + objResponse);
			
			// First, check if there is an error
			if (objResponse.has("error")) {
				String shortDescription = objResponse.getJSONObject("error").getString("code");
				String longDescription = objResponse.getJSONObject("error").getString("description");
				System.out.printf("%s: %s\n", shortDescription, longDescription);
				return strHours;
			}
			
			// Make sure hours exist
			if (!objResponse.has("hours")) {
				strHours += "No hours listed.";
				return strHours;
			}
			
			// Get hours array
			JSONObject objHours = objResponse.getJSONArray("hours").getJSONObject(0);
			
			// Get current status and add to hours string
			boolean isOpen = objHours.getBoolean("is_open_now");
			strHours += isOpen ? "OPEN NOW:\n   YES\n\n" : "OPEN NOW:\n   NO\n\n";
			
			// Get daily hours
			strHours += "DAILY HOURS:\n";
			JSONArray arrDays = objHours.getJSONArray("open");
			for (int i = 0; i < arrDays.length(); i++) {
				JSONObject objDay = arrDays.getJSONObject(i);
				strHours += String.format("   %s\n", getDailyHoursString(objDay));
			}
			
			
		} catch (UnirestException e) {
			System.out.println("API ERROR: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		// Return the hours
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
	private Object getDailyHoursString(JSONObject objDay) {
		// Convert the integer day value to a String
		String [] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		String day = days[objDay.getInt("day")];
		
		// Get the opening and closing times
		String openingTime = get12HourTime(objDay.getString("start"));
		String closingTime = get12HourTime(objDay.getString("end"));
		
		// Return formatted string
		return String.format("%s: %s - %s", day, openingTime, closingTime);
	}

	////////////////////////////////////////////////////////////////////////////////
	// Takes in a 4-digit 24-hour formatted time and returns a AM/PM time
	//		Parameters:
	//			time24Hour - A 4-digit 24 time (e.g., 0030, 1200, 1700)
	//		Returns:
	//			A String representing AM/PM 12-hour time (e.g., 12:30 AM, 12:00 PM, 5:00 PM)
	////////////////////////////////////////////////////////////////////////////////
	private String get12HourTime(String time24Hour) {
		// Pull off the hours and minutes
		String hour = time24Hour.substring(0, 2);
		String minutes = time24Hour.substring(2, 4);
		String ampm = "";
		
		// Format string as 12 hour time
		if (hour.equals("00")) { 					// Midnight
			hour = "12";
			ampm = "AM";
		} else if (hour.equals("12")) {				// Noon
			ampm = "PM";
		} else if (Integer.parseInt(hour) < 12) {	// AM hours
			hour = Integer.toString( Integer.parseInt(hour) );
			ampm = "AM";
		} else {									// PM hours
			hour = Integer.toString( Integer.parseInt(hour) - 12 );
			ampm = "PM";
		}
		
		// Return formatted string
		return String.format("%s:%s %s", hour, minutes, ampm);
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// Generates a URL request for the Yelp Fusion API according to the following
	// web-page: https://www.yelp.com/developers/documentation/v3/business_reviews
	//		Parameters:
	//			businessId - A string representing a business' Yelp ID
	//		Returns:
	//			An HttpRequest which contains the fully-specified URL
	////////////////////////////////////////////////////////////////////////////////
	protected HttpRequest generateBusinessReviewsRequestUrl(String businessId) {
		// Start with the business_search end-point
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
	protected String getReviewsFromBusinessResponse(HttpRequest request) {
		// Init a formatted string for hours
		String strReviews = "";
		
		try {
			// Get the main response
			JSONObject objResponse = request.asJson().getBody().getObject();
			//System.out.println("RESPONSE OBJECT: " + objResponse);
			
			// First, check if there is an error
			if (objResponse.has("error")) {
				String shortDescription = objResponse.getJSONObject("error").getString("code");
				String longDescription = objResponse.getJSONObject("error").getString("description");
				System.out.printf("%s: %s\n", shortDescription, longDescription);
				return strReviews;
			}
			
			// Make sure reviews exist
			if (!objResponse.has("reviews")) {
				strReviews += "No reviews posted.";
				return strReviews;
			}
			
			// Get reviews array and iterate through each review
			JSONArray arrReviews = objResponse.getJSONArray("reviews");
			for (int i = 0; i < arrReviews.length(); i++) {
				// Get the individual review
				JSONObject objReview = arrReviews.getJSONObject(i);
				
				// Pull off specific details
				String name = objReview.getJSONObject("user").getString("name");
				double rating = objReview.getDouble("rating");
				String time = objReview.getString("time_created");
				String review = objReview.getString("text");
				String url = objReview.getString("url");
				
				// Format details
				strReviews += String.format("%s (%s/5.0) - %s\n", name, rating, time);
				strReviews += String.format("%s\n\n", review);
				strReviews += String.format("For full review:\n%s\n\n", url);
				strReviews += "------------------------------------------------------------\n";
			}
			
			
		} catch (UnirestException e) {
			System.out.println("API ERROR: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		// Return the hours
		return strReviews;
	}
}
