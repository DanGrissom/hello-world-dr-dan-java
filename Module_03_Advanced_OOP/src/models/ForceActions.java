/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// This class is consumed by Lesson_01_OOP_StarWarsUniverseClient.
package models;

public interface ForceActions {

	/////////////////////////////////////////////////////////
	// Variables
	public static final int maxForceLevel = 10;
	public static final int maxForceHealth = 100;
	
	/////////////////////////////////////////////////////////
	// Interface actions - to be implemented by subclasses
	// (ForceUser, Jedi and Sith)
	public abstract String forceAttack(Humanoid enemy);	
	public abstract int getForceLevel();
	public abstract void setForceLevel(int level);
	
//	public void getsHurt(int powerLoss);
//	public void rechargeHealth();
	
	/////////////////////////////////////////////////////////
	// 
	//public abstract boolean winsFight(ForceUser forceUser);
}
