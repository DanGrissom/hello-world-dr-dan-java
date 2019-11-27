/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Advanced object-oriented functionality
//			a) Inheritance
//				i) Using super() to call super constructors
//				ii) Using super. to call overridden methods from super class
//			b) Polymorphism
//			c) Abstract methods
//				i) Classes with abstract methods must be declared abstract as well
//			d) Abstract classes
// 				i) Classes that extend (inherit from) abstract classes must implement abstract methods or be
//					declared abstract as well
//			e) Interfaces
//				i) All variables are public static final, whether you declare them that way or not
//				ii) All methods are abstract (cannot define method body)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package client;

import java.util.ArrayList;
import models.Humanoid;
import models.Jedi;
import models.Sith;

public class Lesson_02_StarWarsUniverseClient_Advanced_OOP {

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
		Humanoid nick = new Humanoid("Windu", "Xi", "Sword Swing", "Run!!");
		Jedi rey = new Jedi("Rey", "Jakku", "Saber Throw", "Saber Block", 4);
		Humanoid konobe = new Humanoid("KonobeBryant", "LaLa Land", "Slam Dunk Yo' Head", "Block");
		Jedi yoda = new Jedi("Master Yoda", "Dagobah", "Force Push", "Baby Yoda Disguise", 10);
		
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
