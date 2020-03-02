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
#ifndef BURRITO_H
#define BURRITO_H

#include <iostream>
using namespace std;
#include <string>

class Burrito {
	private:
		// Instance variables
		string meatType;
		string beanType;
		string *guacPtr;

	public:
		// Constructors & Destructors
		Burrito();
		Burrito(string pMeatType, string pBeanType);
		virtual ~Burrito();

		// Methods
		string getSummary();

		// Getters/Setters
		string getMeatType() { return meatType; }
		string getBeanType() { return beanType; }
		void setMeatType(string pMeatType) { meatType = pMeatType; }
		void setBeanType(string pBeanType) { beanType = pBeanType; }

		// Friend classes are classes that can access private data
		// (instance variables, constructors, destructors, methods, etc.)
		//friend ChipotleStore;		// This class doesn't exist in this project...just hypothetical example
};

#endif /* BURRITO_H */
