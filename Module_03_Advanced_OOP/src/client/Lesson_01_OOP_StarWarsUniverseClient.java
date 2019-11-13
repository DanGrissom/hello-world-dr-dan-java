/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//In this lesson you will learn:
//		1) Class Creation
//			a) Instance variables
//			b) Access modifiers
//			c) Constructors (default, overloaded)
//			d) Getters/Setters
//			e) Overriding methods
//			f) Custom/Class methods
//		2) Advanced object-oriented functionality
//			a) Abstract methods
//			b) Abstract classes
//			c) Interfaces
//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package client;

import java.util.ArrayList;

import models.GalacticID;
import models.Humanoid;
import models.Jedi;
import models.Sith;

public class Lesson_01_OOP_StarWarsUniverseClient {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Welcome user to our program
		System.out.println("Welcome to the Star Wars Galaxy!!");
		System.out.println("---------------------------------\n");
		
		// There are many happy people in our universe...
		Humanoid luca = new Humanoid("Luca Skyscraper", "Compton", "Rock-Paper-Scissors", "Shield Block");
		Humanoid tim = new Humanoid("Obi-wan Canoli", "Endor", "Ultimate Punch", "Sike - Ultimate Punch");
		Sith kylo = new Sith("Kylo Ren", "Sololand", "Force Lightning", "Saber Fury Block", 10);
		Humanoid nick = new Humanoid("Windu", "Sword Swing", "Run!!", "Xi");
		Jedi rey = new Jedi("Rey", "Jakku", "Saber Throw", "Saber Block", 4);
		Humanoid konobe = new Humanoid("KonobeBryant", "Slam Dunk Yo' Head", "Block", "Jakku");
		Jedi yoda = new Jedi("Master Yoda", "Dagobah", "Force Push", "For(c)eseen Duck", 10);
		
		// ...until Vader enters the scene...
		Sith vader = new Sith("Darth Vader", "Tatooine", "Force Choke", "Saber Block", 10);
		
		// ...and orders everyone into his line of doom
		ArrayList<Humanoid> vadersLineOfDoom = new ArrayList<Humanoid>();
		vadersLineOfDoom.add(luca);
		vadersLineOfDoom.add(tim);
		vadersLineOfDoom.add(kylo);
		vadersLineOfDoom.add(nick);
		vadersLineOfDoom.add(rey);
		vadersLineOfDoom.add(konobe);
		vadersLineOfDoom.add(yoda);
		
		// Vader processes everyone through his line of doom, and
		// naturally decides to fight them all
		System.out.println("Welcome to Vader's Line of DOOOOOOOM: ");
		for (Humanoid unluckyFoe : vadersLineOfDoom) {
			System.out.printf("%s VS. %s\n", vader.getName(), unluckyFoe.getName());
			System.out.println(vader.attack(unluckyFoe));
			System.out.println();
		}
	}
}



