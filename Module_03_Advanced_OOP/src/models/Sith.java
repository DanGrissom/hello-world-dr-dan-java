package models;

import java.util.Random;

public class Sith extends ForceUser {

	/////////////////////////////////////////////////////////
	// Instance variables
	private int forceRageRank;

	/////////////////////////////////////////////////////////
	// Default Constructor
	public Sith() {
		forceRageRank = 0;
	}

	/////////////////////////////////////////////////////////
	// Overloaded Constructor
	public Sith(String humName, String humHomeWorld,
			String humAttack, String humDefense, int rageRank) {
		super(humName, humHomeWorld, humAttack, humDefense);
		forceRageRank = rageRank;
	}

	/////////////////////////////////////////////////////////
	// Getters
	public int getForceLevel() { return forceRageRank; }

	/////////////////////////////////////////////////////////
	// Setters
	public void setForceLevel(int rageRank) { forceRageRank = rageRank; }

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
		if (enemy instanceof Jedi) {
			// Determine if I (the Sith) won
			Jedi jedi = (Jedi)enemy;
			iWin = winsFight(jedi);

			// Finish fight story
			if (iWin) {
				story += " and their powers were too great for ";
				story += enemy.getName() + "'s " + enemy.getDefense() + " defense.";
			} else {
				story += " but " + enemy.getName() + "'s ";
				story += enemy.getDefense() + " defense was too great for them.";
			}
		} else if (enemy instanceof Sith) {
			story += " but decides not to attack in case " + enemy.getName();
			story += " is the secret emperor.";
			iWin = true;
		} else if (enemy instanceof Humanoid) {
			story += " and then realizes this enemy is a mere humanoid";
			story += " and strikes down " + enemy.getName() + " with no mercy.";
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




