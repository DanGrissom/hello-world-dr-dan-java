/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
// 		High-Quality Video Tutorials: www.helloDrDan.com
// 		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Basic object-oriented functionality
//			a) Class creation from scratch
//				i) Instance variables
//					a) Primitive data types
//					b) Object (custom class) data types
//				ii) Access modifiers
//				iii) Constructors (default, overloaded)
//				iv) Getters/Setters
//				v) Overriding methods
//					a) toString() method
//					b) equals() method (equals vs. ==)
//				vi) Custom/Class methods
//			b) Class creation using from Eclipse helpers
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package client;
import java.util.ArrayList;
import java.util.Random;
import models.Humanoid;
import models.Droid;

public class Lesson_01_StarWarsUniverseClient_Basic_OOP {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn basic object oriented programming concepts.");
		System.out.println("===========================================================================");
		
		// Create a number of humanoids
		Humanoid luca = new Humanoid("Luca Skyscraper", "Tatooine", "Rock-Paper-Scissors", "Force Projection");
		Humanoid babyYoda = new Humanoid("Baby Yoda", "Dagobah", "Force Choke", "Cuteness");
		Humanoid mace = new Humanoid("Mace Windu", "Xi", "Purple Saber Slash", "Run!!");
		Humanoid konobe = new Humanoid("Konobe Bryant", "LaLa Land", "Slam Dunk Yo' Head", "Smack Down Block", new Droid("C-3P0", 3045, 6));
		
		// Create a new droid and add it to 
		Droid r2d2 = new Droid("R2-D2", 3088, 1);
		babyYoda.setDroid(r2d2);
		
		// Add each person to an ArrayList to be processed
		ArrayList<Humanoid> empireDMV = new ArrayList<Humanoid>();
		empireDMV.add(luca);
		empireDMV.add(babyYoda);
		empireDMV.add(mace);
		empireDMV.add(konobe);
		
		// Processes everyone in the empire DMV line 
		System.out.println("Welcome to the Empire DMV:");
		for (int i = 0; i < empireDMV.size(); i++) {
			Humanoid unhappyCustomer = empireDMV.get(i);
			processDmvCustomer(unhappyCustomer, i+1);
		}
		
		// Pick two random customers from the line
		Random randy = new Random();
		Humanoid unhappyCustomer1 = empireDMV.get(randy.nextInt(empireDMV.size()));
		Humanoid unhappyCustomer2 = empireDMV.get(randy.nextInt(empireDMV.size()));
		while (unhappyCustomer1 == unhappyCustomer2)
			unhappyCustomer2 = empireDMV.get(randy.nextInt(empireDMV.size()));
			
		// Customers are so unhappy with their DMV experience, they get into a fight
		System.out.printf("\n%s is so disgruntled by his/her DMV experience that he/she decides to fight %s:\n", unhappyCustomer1.getName(), unhappyCustomer2.getName());
		System.out.println(unhappyCustomer1.attack(unhappyCustomer2));
	}
	
	///////////////////////////////////////////////////////////////
	// This method describes an interaction between the DMV and the
	// humanoid passed into the method. All interactions are printed
	// to the console.
	//		Parameters:
	//			h - A Humanoid to be processed
	//			placeInLine - The humanoid's (h's) place in line 
	//		Returns:
	//			void (nothing)
	///////////////////////////////////////////////////////////////
	private static void processDmvCustomer(Humanoid h, int placeInLine) {
		// Print initial interaction between DMV and humanoid
		System.out.printf("\tCustomer %s Interaction:\n", placeInLine);
		System.out.println("\t\tDMV: Please identify yourself.");
		System.out.printf("\t\t\t%s: %s\n", h.getName(), h);
		System.out.println("\t\tDMV: Please identify the droid you wish to register to drive your landspeeder.");
		
		// Print end of interaction based on if humanoid has a droid
		if (h.getDroid() != null) {
			System.out.printf("\t\t\t%s: %s, please identify yourself.\n", h.getName(), h.getDroid().getName());
			System.out.printf("\t\t\t\t%s: %s\n", h.getDroid().getName(), h.getDroid());
			System.out.printf("\t\tDMV: Registration for %s DENIED due to insufficient documentation.\n", h.getDroid().getName());
		} else {
			System.out.printf("\t\t\t%s: What?!? I need a droid to be here?!?\n", h.getName());
			System.out.println("\t\tDMV: Goodbye.");
		}
		System.out.println();
	}
}
