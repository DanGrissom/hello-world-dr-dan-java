/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_01_StarWarsUniverseClient_Basic_OOP & Lesson_02_StarWarsUniverseClient_Advanced_OOP.
//		This class encapsulates the Droid, which describes basic droid properties; it also inherits methods/variables
// 		from the GalacticID class.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package models;

import java.text.DecimalFormat;
import java.util.Random;

public class Droid {
	
	///////////////////////////////////////////////////////////////
	// Instance variables
	///////////////////////////////////////////////////////////////
	private String name;
	private int mfgYear;
	private int mfgMonth;
	
	///////////////////////////////////////////////////////////////
	// Default Constructor
	//		Parameters:
	//			NONE
	///////////////////////////////////////////////////////////////
	public Droid() {
		//super();
		name = "Basic Droid";
		mfgYear = 0;
		mfgMonth = 0;
	}
	
	///////////////////////////////////////////////////////////////
	// Overloaded Constructor
	//		Parameters:
	//			pName - A String representing the droid's name
	//			mfgYear - An int representing the droid's manufacturing year
	//			mfgMonth - An int representing the droid's manufacturing year
	///////////////////////////////////////////////////////////////
	public Droid(String pName, int pMfgYear, int pMfgMonth) {
		//super();
		name = pName;
		mfgYear = pMfgYear;
		mfgMonth = pMfgMonth;
	}

	///////////////////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////////////////
	public String getName() { return name; }
	public int getMfgYear() { return mfgYear; }
	public int getMfgMonth() { return mfgMonth; }

	///////////////////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////////////////
	public void setName(String pName) { name = pName; }
	public void setMfgYear(int pMfgYear) { mfgYear = pMfgYear; }
	public void setMfgMonth(int pMfgMonth) { mfgMonth = pMfgMonth; }

	///////////////////////////////////////////////////////////////
	// Override the toString method (from the object class)
	//		Parameters:
	//			NONE
	//		Returns:
	//			A String representing the object's (Droid's) properties
	///////////////////////////////////////////////////////////////
	public String toString() {
		String ret = String.format("My human-supplied name is %s (%s); I was manufactured in %s/%s.",
				getName(), getFormattedEmpireIdStr(), mfgMonth, mfgYear);
		return ret;				
	}
	
	///////////////////////////////////////////////////////////////
	// Override the equals method (from the object class)
	//		Parameters:
	//			An object to compare with THIS object
	//		Returns:
	//			A boolean that is true if this object's variables
	//			have the same values/properties as Object o
	///////////////////////////////////////////////////////////////
	public boolean equals(Object o) {
		// If object o is NOT a droid, then not equal
		if (!(o instanceof Droid))
			return false;
		
		// If THIS object has properties that do NOT match with other droid's properties, then not equal
		Droid otherDroid = (Droid)o;
		if (!name.equals(otherDroid.name) || mfgYear != otherDroid.mfgYear || mfgMonth != otherDroid.mfgMonth)
			return false;
		
		// If we made it thus far, THIS droid's properties all match the other droid's properties, so they are equal
		return true;
	}
	
	///////////////////////////////////////////////////////////////
	// This method provides an implementation for the abstract
	// method it is overriding. It provides an empire id based
	// on the homeworld and galactic id
	//		Parameters:
	//			NONE
	//		Returns:
	//			A String representing a formatted empire id
	///////////////////////////////////////////////////////////////
	public String getFormattedEmpireIdStr() {
		// Create formatter
		DecimalFormat df = new DecimalFormat("00000000");
		Random randy = new Random();
		
		// Compose empire id from its parts
		String eid = String.format("%s-%s-%s", mfgYear, mfgMonth, df.format(randy.nextInt(100000000)));
		
		// Return empire id
		return eid;
		
		
//		// Create formatter
//		DecimalFormat df = new DecimalFormat("00000000");
//		
//		// Compose empire id from its parts
//		int hwLen = Math.min(homeWorld.length(), 3);
//		String hw = homeWorld.substring(0, hwLen).toUpperCase();
//		String eid = String.format("%s-%s", hw, df.format(getIdNum()));
//		
//		// Return empire id
//		return eid;
	}
}
