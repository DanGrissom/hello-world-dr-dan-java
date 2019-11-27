/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_01_StarWarsUniverseClient_Basic_OOP & Lesson_02_StarWarsUniverseClient_Advanced_OOP.
//		This class encapsulates the Humanoid, which describes basic human properties; it also inherits methods/variables
// 		from the GalacticID class.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package models;

import java.text.DecimalFormat;
import java.util.Random;

public class Humanoid extends GalacticID {

	// Instance variables
	private String name;
	private String homeWorld;
	private String attack;
	private String defense;
	
	///////////////////////////////////////////////////////////////
	// Default Constructor
	//		Parameters:
	//			NONE
	///////////////////////////////////////////////////////////////
	public Humanoid() {
		//super();
		name = "Ben Notsure";
		homeWorld = "Tatooine";
		attack = "Rock Throw";
		defense = "Block";
	}
	
	///////////////////////////////////////////////////////////////
	// Overloaded Constructor
	//		Parameters:
	//			pName - A String representing the humanoid's name
	//			pHomeWorld - A String representing the humanoid's homeworld
	//			pAttack - A String representing the humanoid's default attack
	//			pDefense - A String representing the humanoid's default defense
	///////////////////////////////////////////////////////////////
	public Humanoid(String pName, String pHomeWorld,
			String pAttack, String pDefense) {
		//super();
		name = pName;
		homeWorld = pHomeWorld;
		attack = pAttack;
		defense = pDefense;
	}

	///////////////////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////////////////
	public String getName() { return name; }
	public String getHomeWorld() { return homeWorld; }
	public String getAttack() { return attack; }
	public String getDefense() { return defense; }

	///////////////////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////////////////
	public void setName(String pName) { name = pName; }
	public void setHomeWorld(String pHomeWorld) { homeWorld = pHomeWorld; }
	public void setAttack(String pAttack) { attack = pAttack; }
	public void setDefense(String pDefense) { defense = pDefense; }

	///////////////////////////////////////////////////////////////
	// Override the toString method (from the object class)
	//		Parameters:
	//			NONE
	//		Returns:
	//			A String representing the object's (Humanoid's) properties
	///////////////////////////////////////////////////////////////
	public String toString() {
		String ret = String.format("%s (%s), from %s, has an attack of %s and a defense of %s.",
				getName(), getFormattedEmpireIdStr(), homeWorld.toUpperCase(), attack.toUpperCase(), defense.toUpperCase());
		return ret;				
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
		
		// Compose empire id from its parts
		int hwLen = Math.min(homeWorld.length(), 3);
		String hw = homeWorld.substring(0, hwLen).toUpperCase();
		String eid = String.format("%s-%s", hw, df.format(getIdNum()));
		
		// Return empire id
		return eid;
	}
	
	///////////////////////////////////////////////////////////////
	// This method describes the attack, generates a random outcome
	// and then describes the result (who won).
	//		Parameters:
	//			enemy - A Humanoid instance to fight
	//		Returns:
	//			A String representing a narrative/story of the fight
	///////////////////////////////////////////////////////////////
	public String attack(Humanoid enemy) {
		// Generate attack
		String story = String.format("%s attacks %s with a %s attack", getName(), enemy.getName(), getAttack());
		
		// Determine randomly who won
		Random randy = new Random();
		boolean iWin = randy.nextBoolean();
		
		// Generate defense and winner story
		if (iWin)
			story += String.format(" and it was too great for %s's %s defense.", enemy.getName(), enemy.getDefense());
		else
			story += String.format(" but it was not strong enough to overpower %s's %s defense.", enemy.getName(), enemy.getDefense());
		
		// Generate and return a final summary
		String finalSummary = String.format("\tRESULT: %s %s\n", getName(), iWin ? "WINS" : "LOSES");
		finalSummary += String.format("\tSUMMARY: %s", story);
		return finalSummary;
	}
}