/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_05_Bonus_WindowBuilder_All_Components.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package models;

public class Person extends SocialSecurityNumber
{
	//////////////////////////////////////////////////////////////////////
	// Instance Variables
	private String firstName;
	private String lastName;
	private char gender;
	private int age;
	
	//////////////////////////////////////////////////////////////////////
	// Default Constructor
	public Person()
	{
		firstName = "Jim";
		lastName = "Doe";
		gender = 'M';
		age = 0;
	}
	
	//////////////////////////////////////////////
	// Overloaded constructor
	public Person(String pFirstName, String pLastName, char pGender, int pAge)
	{
		firstName = pFirstName;
		lastName = pLastName;
		gender = pGender;
		age = pAge;
	}

	//////////////////////////////////////////////////////////////////////
	// Getters/Setters	
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }	
	public String getLastName(boolean isJr) // Overloaded method
	{
		if (isJr)
			return lastName + ", Jr.";
		else
			return getLastName();
	}
	public char getGender() { return gender; }
	public int getAge() { return age; }
	public String getDisplayName() { return firstName + "-" + lastName; }
	
	public void setFirstName(String pFirstName) { firstName = pFirstName; }
	public void setLastName(String pLastName) { lastName = pLastName; }
	public void setGender(char pGender) { gender = pGender; }
	public void setAge(int pAge) { age = pAge; }
	
	
	//////////////////////////////////////////////////////////////////////
	// toString() overridden method
	public String toString()
	{
		String ret = "I am a " + age + " year old ";
		if (gender == 'M' || gender == 'm')
			ret += "male ";
		else
			ret += "female ";
		ret += "and my name is " + firstName + " " + lastName + ".";
		
		ret += " Also, b/c I trust you, my SSN is " + getSsnString("password123") + ".";
		
		return ret;
	}
}
