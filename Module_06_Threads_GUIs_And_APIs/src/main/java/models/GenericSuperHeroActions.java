/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_05_Bonus_WindowBuilder_All_Components.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package models;

public interface GenericSuperHeroActions
{
	//////////////////////////////////////////////////////////////////////
	// Static final instance variables
	public static final String [] attacks = {"Pow", "Wahm", "Wop", "Ching", "Foo", "Bam" };
	
	//////////////////////////////////////////////////////////////////////
	// Abstract methods
	public String fly();
	public String punch();
	public String defend();
	public String randomAttack();
}
