/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// Lesson Note:
// 		This class is consumed by Lesson_07_Maps_Sets_Table_Contents_Word_Count_Example.
// 		This class acts as a simple pair class which connects a String and int together
// 		in a single class/object, which makes sorting easier in our particular problem.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package models;

public class WordCountPair
{
	// Instance variables
	private String word = "";
	private int count = 0;
	
	// Overloaded constructor
	public WordCountPair(String wordStr, int wordCount)
	{
		word = wordStr;
		count = wordCount;
	}
	
	// Getters
	public String getWord() { return word; }
	public int getCount() { return count; }
	
	// Setters
	public void setWord(String wordStr) { word = wordStr; }
	public void setCount(int wordCount) { count = wordCount; }
}