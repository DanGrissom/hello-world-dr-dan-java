/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class is consumed by Lesson_04_Windowbuilder_GUI_APIs.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package models;

public class Business {
	//////////////////////////////////////////////
	// Instance variables
	private String name;
	private double rating;
	private String address;
	private String businessId;
	
	//////////////////////////////////////////////
	// Overloaded constructor
	public Business(String placeName, double placeRating, String placeAddress, String placeId) {
		super();
		name = placeName;
		rating = placeRating;
		address = placeAddress;
		businessId = placeId;
	}

	//////////////////////////////////////////////
	// Getters
	public String getName() { return name; }
	public double getRating() { return rating; }
	public String getAddress() { return address; }
	public String getBusinessId() { return businessId; }

	//////////////////////////////////////////////
	// toString override
	public String toString() {
		if (rating > 0)
			return name + " (" + rating + "/5.0)";
		else
			return name + " (NO RATINGS)";
	}
}
