/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) How to create GUIs from scratch (using code and not code-generating GUI builders)
//			a) The JFrame class (and extending from it)
//			b) Initializing components
//				i) Setting window/frame properties
//				ii) Container and layout
//				iii) Initializing components (https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html)
//				iv) Adding components to container
//			b) Initializing events
//				i) Initializing listeners (event handlers)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Lesson_02_Handcoded_GUI_Self_Destructing {

	// Create random class

	// Component variables

	// Color constants
	
	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to create GUIs from code (not using a GUI builder) and GUI fundamentals.");
		System.out.println("===========================================================================");

		// A GUI must instantiate an object of itself (a JFrame) in the main
	}
	
	///////////////////////////////////////////////////////////////
	// Constructor - Simply calls two methods that do the real work
	//		Parameters:
	//			NONE
	///////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////
	// This method initializes all things related to style and appearance.
	//		Parameters:
	//			NONE
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////
	// This method creates and initializes all event handlers executed when a 
	// component (e.g., button) interaction occurs.
	//		Parameters:
	//			NONE
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
				// The process to draw the GUI is currently running in the same thread as this code.
				// Thus, if we cause this code to slow down by putting huge sleep commands in it,
				// the thread will not be able to draw the GUI b/c it will be busy in the FOR loop.
				// So, we create a new thread so that the code in this new thread 

	////////////////////////////////////////////////////////////////////////////////
	// This method obtains all the components in the JFrame's container and changes
	// their background and text (foreground) colors to random colors.
	//		Parameters:
	//			NONE
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
}
