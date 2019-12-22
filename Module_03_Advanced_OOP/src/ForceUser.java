/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This abstract class is consumed by Lesson_02_StarWarsUniverseClient_Advanced_OOP.
//		This class encapsulates the ForceUser, which describes unique ForceUser properties and methods not applicable to the
// 		Humanoid class (which it inherits methods/variables from), but that are applicable to any of ForceUser's
// 		sub-classes (Jedi and Sith). This class also implements the ForceActions interface.	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class ForceUser {

	///////////////////////////////////////////////////////////////
	// Instance variables
	///////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////
	// Default Constructor
	//		Parameters:
	//			NONE
	///////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////
	// Overloaded Constructor
	//		Parameters:
	//			pName - A String representing the force user's name
	//			pHomeWorld - A String representing the force user's homeworld
	//			pAttack - A String representing the force user's default attack
	//			pDefense - A String representing the force user's default defense
	//			pDroid - A droid that the humanoid owns
	//			pForceHealth - An int representing the force user's health (for battle) 
	///////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////
	// This method takes a hit to the user's health, ensuring
	// that it never goes below 0.
	// on the homeworld and galactic id
	//		Parameters:
	//			powerLoss - An int representing the amount of health to lose
	//		Returns:
	//			void (nothing)
	///////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////
	// This method recharges the force user's health to the maximum
	// health
	//		Parameters:
	//			NONE
	//		Returns:
	//			void (nothing)
	///////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////
	// This method overrides the Humanoid's attack to ensure that
	// a ForceUser always uses their Force-attack
	//		Parameters:
	//			enemy - A Humanoid instance to fight
	//		Returns:
	//			A String representing a narrative/story of the fight
	///////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////
	// This method simulates a fight between two force users. The
	// two force users alternate turns attacking and defending
	// until one is defeated. Results of each round are printed
	// in real-time.
	//		Parameters:
	//			enemy - A ForceUser instance to fight
	//		Returns:
	//			A boolean: 	true if this force user beat the enemy
	//						false if this force user lost to the enemy
	///////////////////////////////////////////////////////////////
}
