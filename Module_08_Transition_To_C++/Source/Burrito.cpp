/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_04_Burrito_Client.cpp
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
#include "../Headers/Burrito.h"

///////////////////////////////////////////////////////////////
// Default Constructor
//		Parameters:
//			(NONE)
///////////////////////////////////////////////////////////////
Burrito::Burrito() {
	meatType = "Chicken";
	beanType = "Pinto Beans";
	guacPtr = new string("Guacamole");
}

///////////////////////////////////////////////////////////////
// Overloaded Constructor
//		Parameters:
//			pMeatType - A string representing the burrito's meat type
//			pBeanType - A string representing the burrito's bean type
///////////////////////////////////////////////////////////////
Burrito::Burrito(string pMeatType, string pBeanType) {
	meatType = pMeatType;
	beanType = pBeanType;
	guacPtr = new string("Guacamole");
}

///////////////////////////////////////////////////////////////
// Destructor - Called when an object of this type is "delete"d
// Nothing to do here, but this is typically where any instance
// variable pointers (if they exist) are deleted.
//		Parameters:
//			NONE
///////////////////////////////////////////////////////////////
Burrito::~Burrito() {
	// Print out summary of burrito being deleted
	cout << "\tDEBUG: DELETING " << getSummary() << endl;

	// Delete any pointers created within the Burrito class (constructor)
	delete guacPtr;
}

///////////////////////////////////////////////////////////////
// A method that returns a string summarizing the object's
// instance variables.
//		Parameters:
//			NONE
//		Returns:
//			A String representing the object's (Burrito's) properties
///////////////////////////////////////////////////////////////
string Burrito::getSummary() {
	string summary = "Burrito w/ " + meatType + " & " + beanType + " & " + *guacPtr;
	return summary;
}
