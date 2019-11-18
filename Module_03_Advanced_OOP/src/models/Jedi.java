/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_01_OOP_StarWarsUniverseClient.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package models;

public class Jedi extends ForceUser {

	/////////////////////////////////////////////////////////
	// Instance variables
	private int forceHonorRank;

	/////////////////////////////////////////////////////////
	// Default Constructor
	public Jedi() {
		forceHonorRank = 0;
	}

	/////////////////////////////////////////////////////////
	// Overloaded Constructor
	public Jedi(String humName, String humHomeWorld,
			String humAttack, String humDefense, int honorRank) {
		super(humName, humHomeWorld, humAttack, humDefense);
		setForceLevel(honorRank);
	}

	/////////////////////////////////////////////////////////
	// Getters
	public int getForceLevel() { return forceHonorRank; }

	/////////////////////////////////////////////////////////
	// Setters
	public void setForceLevel(int honorRank) {
		forceHonorRank = Math.min(honorRank, maxForceLevel);
	}

	/////////////////////////////////////////////////////////
	// Provide implementation for forceAttack. Displays attack
	// information and result, based on what type of person
	// I am attacking and their power level.
	public String forceAttack(Humanoid enemy) {
		// Create attack string
		String story = this.getName() + " attacks " + enemy.getName();
		story += " using " + this.getAttack();
		
		// Determine result and story, depending on who enemy is
		boolean iWin;
		if (enemy instanceof Sith) {
			// Determine if I (the Jedi) won
			Sith sith = (Sith)enemy;
			iWin = winsFight(sith);
			
			// Finish fight story
			if (iWin) {
				story += " and their powers were too great for ";
				story += enemy.getName() + "'s " + enemy.getDefense() + " defense.";
			} else {
				story += " but " + enemy.getName() + "'s ";
				story += enemy.getDefense() + " defense was too great for them.";
			}
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

		// Return a final summary
		String str = "\tRESULT: " + getName();
		str += iWin ? " WINS\n" : " LOSES\n";
		str += "\tSUMMARY: " + story;
		return str;
	}
}
