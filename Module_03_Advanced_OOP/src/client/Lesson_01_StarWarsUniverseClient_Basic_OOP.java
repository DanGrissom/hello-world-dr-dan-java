/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Basic object-oriented functionality
//			a) Class Creation
//				i) Instance variables
//				ii) Access modifiers
//				iii) Constructors (default, overloaded)
//				iv) Getters/Setters
//				v) Overriding methods
//				vi) Custom/Class methods
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package client;

import java.util.ArrayList;
import models.Humanoid;

public class Lesson_01_StarWarsUniverseClient_Basic_OOP {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Welcome user to our program
		System.out.println("Welcome to the Star Wars Galaxy!!");
		System.out.println("---------------------------------\n");
		
		// Create a number of humanoids
		Humanoid luca = new Humanoid("Luca Skyscraper", "Compton", "Rock-Paper-Scissors", "Shield Block");
		Humanoid tim = new Humanoid("Obi-wan Canoli", "Endor", "Ultimate Punch", "Sike - Ultimate Punch");
		Humanoid nick = new Humanoid("Windu", "Xi", "Sword Swing", "Run!!");
		Humanoid konobe = new Humanoid("KonobeBryant", "LaLa Land", "Slam Dunk Yo' Head", "Block");
		
		// Add each person to an ArrayList to be processed
		ArrayList<Humanoid> empireDMV = new ArrayList<Humanoid>();
		empireDMV.add(luca);
		empireDMV.add(tim);
		empireDMV.add(nick);
		empireDMV.add(konobe);
		
		// Processes everyone in the empire DMV line 
		System.out.println("Welcome to the Empire DMV. Please provide your identification:");
		for (int i = 0; i < empireDMV.size(); i++) {
			Humanoid unhappyCustomer = empireDMV.get(i);
			System.out.printf("\tCustomer %s: %s\n", (i+1), unhappyCustomer);
		}
	}
}
