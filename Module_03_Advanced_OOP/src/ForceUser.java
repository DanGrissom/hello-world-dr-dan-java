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
import java.util.Random;

public abstract class ForceUser extends Humanoid implements ForceActions {

	// Instance variables
	private int forceHealth;

	///////////////////////////////////////////////////////////////
	// Default Constructor
	//		Parameters:
	//			NONE
	///////////////////////////////////////////////////////////////
	public ForceUser() {
		// DO NOTHING (implicit call to super() )
		forceHealth = maxForceHealth;
	}

	///////////////////////////////////////////////////////////////
	// Overloaded Constructor
	//		Parameters:
	//			pName - A String representing the force user's name
	//			pHomeWorld - A String representing the force user's homeworld
	//			pAttack - A String representing the force user's default attack
	//			pDefense - A String representing the force user's default defense
	///////////////////////////////////////////////////////////////
	public ForceUser(String pName, String pHomeWorld,
			String pAttack, String pDefense) {
		// Pass parameters to super constructor (Humanoid)
		super(pName, pHomeWorld, pAttack, pDefense);
	}

	///////////////////////////////////////////////////////////////
	// This method takes a hit to the user's health, ensuring
	// that it never goes below 0.
	// on the homeworld and galactic id
	//		Parameters:
	//			powerLoss - An int representing the amount of health to lose
	//		Returns:
	//			void (nothing)
	///////////////////////////////////////////////////////////////
	private void getsHurt(int powerLoss) {
		forceHealth = Math.max(0, forceHealth - powerLoss);
	}
	
	///////////////////////////////////////////////////////////////
	// This method recharges the force user's health to the maximum
	// health
	//		Parameters:
	//			NONE
	//		Returns:
	//			void (nothing)
	///////////////////////////////////////////////////////////////
	private void rechargeHealth() {
		forceHealth = maxForceHealth;
	}
	
	///////////////////////////////////////////////////////////////
	// This method overrides the Humanoid's attack to ensure that
	// a ForceUser always uses their Force-attack
	//		Parameters:
	//			enemy - A Humanoid instance to fight
	//		Returns:
	//			A String representing a narrative/story of the fight
	///////////////////////////////////////////////////////////////
	public String attack(Humanoid enemy) {
		return forceAttack(enemy);
	}

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
	public boolean simulateForceBattle(ForceUser enemy) {

		// Initialize variables
		Random randy = new Random();
		int round = 1;

		// Initialize attacker/defender and recharge health for battle
		ForceUser attacker = this;
		ForceUser defender = enemy;
		attacker.rechargeHealth();
		defender.rechargeHealth();
		
		// Simulate rounds of battle until a winner emerges
		while (attacker.forceHealth > 0 && defender.forceHealth > 0) {				
				// Formulate attack/defense based on random nature
				int attackPower = attacker.getForceLevel() * randy.nextInt(10);
				int defensePower = defender.getForceLevel() * randy.nextInt(10);
				int powerLoss = Math.abs(attackPower - defensePower);
				System.out.printf("\tR%s) %s attacks (%s) & %s defends (%s)\n", round++, attacker.getName(), attackPower, defender.getName(), defensePower);
				
				// Decrease power from this round's loser
				if (attackPower > defensePower) {
					defender.getsHurt(powerLoss);
					System.out.printf("\t\t%s -%s health\n", defender.getName(), powerLoss);
				}
				else if (attackPower < defensePower) {
					attacker.getsHurt(powerLoss);
					System.out.printf("\t\t%s -%s health\n", attacker.getName(), powerLoss);
				}
				else
					System.out.printf("\t\tDRAW!\n", getName(), powerLoss);
				
				// Print out current standing
				System.out.printf("\t\tHealth Remaining: %s (%s) - %s (%s)\n", attacker.getName(), attacker.forceHealth, defender.getName(), defender.forceHealth);

				// Alternate attacker and defender
				ForceUser swap = attacker;
				attacker = defender;
				defender = swap;
		}
		
		// Determine who won and return result
		if (attacker.forceHealth > 0) {
			if (attacker == this)
				return true;
		} else if (defender == this)
			return true;
		return false;
	}
}
