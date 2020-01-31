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
import java.util.Random;

public class SuperHero extends Person implements GenericSuperHeroActions
{
	//////////////////////////////////////////////////////////////////////
	// Instance Variables
	private String superPower;
	private String weakness;
	private String sideKick;
	
	//////////////////////////////////////////////////////////////////////
	// Default Constructor
	public SuperHero()
	{
		super();
		superPower = "Flying";
		weakness = "Homework";
		sideKick = "Mom";
	}
	
	//////////////////////////////////////////////
	// Overloaded constructor
	public SuperHero(String pFirstName, String pLastName, char pGender, int pAge, String pSuperPower, String pWeakness, String pSideKick)
	{
		super(pFirstName, pLastName, pGender, pAge); // Overloaded super constructor		
		superPower = pSuperPower;
		weakness = pWeakness;
		sideKick = pSideKick;
	}
	
	//////////////////////////////////////////////////////////////////////
	// Getters/Setters	
	public String getFirstName() { return "Really?" + "I can't tell you, but it's definitely not " + super.getFirstName(); }
	public String getLastName() { return "Seriously?"; }
	
	public void setFirstName(String fName) { attackPerp(); }
	public void setLastName(String lName) { attackPerp(); }
	
	//////////////////////////////////////////////////////////////////////
	// Additional methods
	private String attackPerp()
	{
		String a = "Boom! Pow!";
		System.out.println(a);
		return a;
	}
	
	public String toString()
	{
		String ret = "I am also a super-hero with " + superPower + " abilities,";
		ret += "an unfortuante weakness of " + weakness;
		ret += ", and an amazing sidekick known as " + sideKick;
		ret = super.toString() + ret;
		return ret;
	}
	
	public String revealSecretWeakness(String password, boolean isFriend)
	{
		return weakness;		
	}
	
	
	//////////////////////////////////////////////////////////////////////
	// Methods implemented for GenericSuperHeroActions interface
	public String fly()
	{
		return "Weeeeeeeee";
	}
	public String punch()
	{
		return "Pow";
	}
	public String defend()
	{
		return "Ching";
	}
	public String randomAttack()
	{
		Random r = new Random();		
		return attacks[r.nextInt(attacks.length)];
	}
}
