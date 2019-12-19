/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_02_StarWarsUniverseClient_Advanced_OOP.
//		This class encapsulates the Jedi, which describes unique Jedi properties and methods not applicable to the
// 		ForceUser class (which it inherits methods/variables from).	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Random;

public class Jedi extends ForceUser {

	// Instance variables
	private int forceHonorRank;

	///////////////////////////////////////////////////////////////
	// Default Constructor
	//		Parameters:
	//			NONE
	///////////////////////////////////////////////////////////////
	public Jedi() {
		forceHonorRank = 0;
	}

	///////////////////////////////////////////////////////////////
	// Overloaded Constructor
	//		Parameters:
	//			pName - A String representing the Jedi's name
	//			pHomeWorld - A String representing the Jedi's homeworld
	//			pAttack - A String representing the Jedi's default attack
	//			pDefense - A String representing the Jedi's default defense
	//			pForceRageRank - An int representing the Jedi's honor rank
	///////////////////////////////////////////////////////////////
	public Jedi(String pName, String pHomeWorld,
			String pAttack, String pDefense, int pForceHonorRank) {
		// Pass parameters to super constructor (Force User)
		super(pName, pHomeWorld, pAttack, pDefense);
		setForceLevel(pForceHonorRank);
	}

	///////////////////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////////////////
	public int getForceLevel() { return forceHonorRank; }

	///////////////////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////////////////
	public void setForceLevel(int honorRank) {
		forceHonorRank = Math.min(honorRank, maxForceLevel); // Limit the Jedi's honor ranking
	}

	///////////////////////////////////////////////////////////////
	// This method provides an implementation for the abstract
	// method it is overriding. The Jedi creates a fake ID by
	// changing the homeworld and galactic ID.
	//		Parameters:
	//			NONE
	//		Returns:
	//			A String representing a formatted (fake) empire id
	///////////////////////////////////////////////////////////////
	public String getFormattedEmpireIdStr() {
		
		// Get the actual empire string
		String realId = super.getFormattedEmpireIdStr();
		
		// Fake out authorities by changing the homeworld and
		// modifying one of the digits
		Random randy = new Random();
		String realIdEnd = realId.substring(realId.indexOf("-")+1);
		int indexToChange = randy.nextInt(realIdEnd.length());
		String fakeIdEnd = realIdEnd.substring(0, indexToChange) + randy.nextInt(10) + realIdEnd.substring(indexToChange);
		String fakeId = String.format("%s-%s", "BAT", fakeIdEnd); // Batuu from Galaxy's Edge
		
		// Return fake empire id
		return fakeId;
	}
	
	///////////////////////////////////////////////////////////////
	// This method provides an implementation for forceAttack
	// (defined in the interface); the method describes the attack,
	// generates an outcome using the simulateForceBattle() method
	// (for force battles) and then describes the result (who won).
	// Jedi fights differently depending on enemy.
	//		Parameters:
	//			enemy - A Humanoid instance to fight
	//		Returns:
	//			A String representing a narrative/story of the fight
	///////////////////////////////////////////////////////////////
	public String forceAttack(Humanoid enemy) {
		// Generate attack
		String story = String.format("%s attacks %s with a %s attack", getName(), enemy.getName(), getAttack());
		
		// Determine result and story, depending on who enemy is
		boolean iWin;
		if (enemy instanceof Sith) {
			// Determine if I (the Jedi) won
			Sith sithEnemy = (Sith)enemy;
			iWin = simulateForceBattle(sithEnemy);
			
			if (iWin)
				story += String.format(" and it was too great for %s's %s defense.", enemy.getName(), enemy.getDefense());
			else
				story += String.format(" but it was not strong enough to overpower %s's %s defense.", enemy.getName(), enemy.getDefense());
		
		} else if (enemy instanceof Jedi) {
			story += " but then realizes they will never fight a fellow Jedi!";
			iWin = true;
		} else if (enemy instanceof Humanoid) {
			story += " but then realizes this enemy is a mere humanoid";
			story += " and their honor is too great to fight. ";
			story += enemy.getName() + "'s life has been spared.";
			iWin = true;
		} else {
			story += " but....what even are you?!?";
			iWin = true;
		}

		// Generate and return a final summary
		String finalSummary = String.format("\tRESULT: %s %s\n", getName(), iWin ? "WINS" : "LOSES");
		finalSummary += String.format("\tSUMMARY: %s", story);
		return finalSummary;
	}
}
