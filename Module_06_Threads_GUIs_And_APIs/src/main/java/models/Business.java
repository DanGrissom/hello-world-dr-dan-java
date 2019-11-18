/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_04_Windowbuilder_GUI_APIs.
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
