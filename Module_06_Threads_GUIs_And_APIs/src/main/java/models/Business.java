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
	private String yelpId;
	
	//////////////////////////////////////////////
	// Overloaded constructor
	public Business(String pName, double pRating, String pAddress, String pYelpId) {
		name = pName;
		rating = pRating;
		address = pAddress;
		yelpId = pYelpId;
	}

	//////////////////////////////////////////////
	// Getters
	public String getYelpId() { return yelpId; }

	//////////////////////////////////////////////
	// toString override
	public String toString() {
		if (rating > 0)
			return String.format("%s (%s/5.0)", name, rating);
		else
			return String.format("%s (NO RATINGS)", name);
	}
}
