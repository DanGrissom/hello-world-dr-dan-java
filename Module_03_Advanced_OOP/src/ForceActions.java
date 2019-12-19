/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This interface is consumed by Lesson_02_StarWarsUniverseClient_Advanced_OOP. 
//		This interface describes ForceActions to be implemented by all ForceUsers.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public interface ForceActions {

	// Variables (all interface variables are public static final)
	public static final int maxForceLevel = 10;
	public static final int maxForceHealth = 100;
	
	///////////////////////////////////////////////////////////////
	/////////////////INTERFACE (ABSTRACT) METHODS////////////////// 
	///////////////////////////////////////////////////////////////
	//  To be implemented by subclass (EX: ForceUser/Jedi/Sith)  //
	///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////
	// The sub-class should provide a definition that implements
	// an attack strategy and story for a force user.
	//		Parameters:
	//			enemy - A Humanoid instance to fight
	//		Returns:
	//			A String representing a narrative/story of the fight
	///////////////////////////////////////////////////////////////
	public abstract String forceAttack(Humanoid enemy);	
	
	///////////////////////////////////////////////////////////////
	// The sub-class should provide a definition that gets the
	// force user's force level.
	//		Parameters:
	//			NONE
	//		Returns:
	//			A String representing a formatted empire id
	///////////////////////////////////////////////////////////////
	public abstract int getForceLevel();
	
	///////////////////////////////////////////////////////////////
	// The sub-class should provide a definition that sets the
	// users force level based on the parameter and interface
	// maximum values.
	//		Parameters:
	//			level - An integer to set the person's force level
	//		Returns:
	//			A String representing a formatted empire id
	///////////////////////////////////////////////////////////////
	public abstract void setForceLevel(int level);
}
