package models;

import java.text.DecimalFormat;
import java.util.Random;

public class Humanoid extends GalacticID {

	/////////////////////////////////////////////////////////
	// Instance variables
	private String name;
	private String homeWorld;
	private String attack;
	private String defense;
	
	/////////////////////////////////////////////////////////
	// Default Constructor
	public Humanoid() {
		//super();
		name = "Ben Notsure";
		homeWorld = "Tatooine";
		attack = "Rock Throw";
		defense = "Block";
	}
	
	/////////////////////////////////////////////////////////
	// Overloaded Constructor
	public Humanoid(String humName, String humHomeWorld,
			String humAttack, String humDefense) {
		//super();
		name = humName;
		homeWorld = humHomeWorld;
		attack = humAttack;
		defense = humDefense;
	}

	/////////////////////////////////////////////////////////
	// Getters
	public String getName() { return name; }
	public String getHomeWorld() { return homeWorld; }
	public String getAttack() { return attack; }
	public String getDefense() { return defense; }

	/////////////////////////////////////////////////////////
	// Setters
	public void setName(String humName) { name = humName; }
	public void setHomeWorld(String humHomeWorld) { homeWorld = humHomeWorld; }
	public void setAttack(String humAttack) { attack = humAttack; }
	public void setDefense(String humDefense) { defense = humDefense; }

	/////////////////////////////////////////////////////////
	// Override the toString method (from the object class)
	public String toString() {
		String ret = name + " (" + getEmpireIdStr() + ")";
		ret += ", from " + homeWorld.toUpperCase();
		ret += ", has an attack of " + attack.toUpperCase();
		ret += " and a defense of " + defense.toUpperCase() + ".";
		
		return ret;				
	}

	/////////////////////////////////////////////////////////
	// Provide implementation for empire id which is composed of
	// the homeworld and the galactic id
	public String getEmpireIdStr() {
		// Create formatter
		DecimalFormat df = new DecimalFormat("00000000");
		
		// Compose empire id from its parts
		int hwLen = Math.min(homeWorld.length(), 3);
		String eid = homeWorld.substring(0, hwLen).toUpperCase();
		eid += "-";
		eid += df.format(getIdNum());
		
		// Return empire id
		return eid;
	}
	
	///////////////////////////////////////////////
	// Action Methods
	///////////////////////////////////////////////
	public String attack(Humanoid enemy) {
		// Generate attack
		String story = name + " attacks " + enemy.name;
		story += " with a " + attack + " attack";
		
		// Determine randomly who won
		Random randy = new Random();
		boolean iWin = randy.nextBoolean();
		
		// Generate defense and winner story
		if (iWin) {
			story += " and it was too great for " + enemy.name;
			story += "'s " + enemy.defense + " defense.";
		} else {
			story += " but it was not strong enough to overpower " + enemy.name;
			story += "'s " + enemy.defense + " defense.";
		}
		
		// Return a final summary
		String str = "\tRESULT: " + getName();
		str += iWin ? " WINS\n" : " LOSES\n";
		str += "\tSUMMARY: " + story;
		return str;
	}
}