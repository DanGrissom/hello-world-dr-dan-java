package models;

import java.util.Random;

public abstract class ForceUser extends Humanoid implements ForceActions {

	/////////////////////////////////////////////////////////
	// Instance variables
	private int forceHealth;

	/////////////////////////////////////////////////////////
	// Default constructor
	public ForceUser() {
		// DO NOTHING (implicit call to super() )
		forceHealth = maxForceHealth;
	}

	/////////////////////////////////////////////////////////
	// Overloaded constructor
	public ForceUser(String humName, String humHomeWorld,
			String humAttack, String humDefense) {
		super(humName, humHomeWorld, humAttack, humDefense);
	}

	/////////////////////////////////////////////////////////
	// This method takes a hit to the user's health, ensuring
	// that it never goes below 0.
	private void getsHurt(int powerLoss) {
		forceHealth = Math.max(0, forceHealth - powerLoss);
	}
	
	/////////////////////////////////////////////////////////
	// Recharges force user's health to the maximum health
	private void rechargeHealth() {
		forceHealth = maxForceHealth;
	}
	
	/////////////////////////////////////////////////////////
	// Override the Humanoid's attack to ensure that a ForceUser
	// always uses their Force-attack
	public String attack(Humanoid enemy) {
		return forceAttack(enemy);
	}

	/////////////////////////////////////////////////////////
	// This method simulates a fight between two force users.
	// The two force users alternate turns attacking and 
	// defending until one is defeated. Returns TRUE if THIS
	// user wins and FALSE if the ENEMY wins.
	public boolean winsFight(ForceUser enemy) {

		// Initialize variables
		Random r = new Random();
		int round = 1;

		// Initialize attacker/defender and recharge health for battle
		ForceUser attacker = this;
		ForceUser defender = enemy;
		attacker.rechargeHealth();
		defender.rechargeHealth();
		
		// Simulate rounds of battle until a winner emerges
		while (attacker.forceHealth > 0 && defender.forceHealth > 0) {				
				// Formulate attack/defense based on random nature
				int attackPower = attacker.getForceLevel() * r.nextInt(10);
				int defensePower = defender.getForceLevel() * r.nextInt(10);
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
