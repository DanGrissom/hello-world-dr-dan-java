/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_02_StarWarsUniverseClient_Advanced_OOP.
//		This class encapsulates the Sith, which describes unique Sith properties and methods not applicable to the
// 		ForceUser class (which it inherits methods/variables from).	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Sith extends ForceUser {

	// Instance variables
	private int forceRageRank;

	///////////////////////////////////////////////////////////////
	// Default Constructor
	//		Parameters:
	//			NONE
	///////////////////////////////////////////////////////////////
	public Sith() {
		forceRageRank = 0;
	}

	///////////////////////////////////////////////////////////////
	// Overloaded Constructor
	//		Parameters:
	//			pName - A String representing the Sith's name
	//			pHomeWorld - A String representing the Sith's homeworld
	//			pAttack - A String representing the Sith's default attack
	//			pDefense - A String representing the Sith's default defense
	//			pForceRageRank - An int representing the Sith's rage rank
	///////////////////////////////////////////////////////////////
	public Sith(String pName, String pHomeWorld,
			String pAttack, String pDefense, int pForceRageRank) {
		// Pass parameters to super constructor (Force User)
		super(pName, pHomeWorld, pAttack, pDefense);
		setForceLevel(pForceRageRank);	
	}

	///////////////////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////////////////
	public int getForceLevel() { return forceRageRank; }

	///////////////////////////////////////////////////////////////
	// Setters
	///////////////////////////////////////////////////////////////
	public void setForceLevel(int pForceRageRank) { forceRageRank = pForceRageRank; } // No limit to Sith power?!?

	///////////////////////////////////////////////////////////////
	// This method provides an implementation for forceAttack
	// (defined in the interface); the method describes the attack,
	// generates an outcome using the simulateForceBattle() method
	// (for force battles) and then describes the result (who won).
	// Sith fights differently depending on enemy.
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
		if (enemy instanceof Jedi) {
			// Determine if I (the Sith) won
			Jedi jediEnemy = (Jedi)enemy;
			iWin = simulateForceBattle(jediEnemy);

			// Finish fight story
			if (iWin)
				story += String.format(" and it was too great for %s's %s defense.", enemy.getName(), enemy.getDefense());
			else
				story += String.format(" but it was not strong enough to overpower %s's %s defense.", enemy.getName(), enemy.getDefense());

		
		} else if (enemy instanceof Sith) {
			story += String.format(" but decides not to attack in case %s is the secret emperor.", enemy.getName());
			iWin = true;
		} else if (enemy instanceof Humanoid) {
			story += String.format(" and then realizes this enemy is a mere humanoid and strikes down %s with no mercy.", enemy.getName());
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
