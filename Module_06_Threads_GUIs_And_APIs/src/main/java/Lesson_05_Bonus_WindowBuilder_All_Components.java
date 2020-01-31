/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Hello World with Dr. Dan - A Complete Introduction to Programming from Java to C++ (Code and Course © Dan Grissom)
//
// Additional Lesson Resources from Dr. Dan:
//		High-Quality Video Tutorials: www.helloDrDan.com
//		Free Commented Code: https://github.com/DanGrissom/hello-world-dr-dan-java
//
// In this lesson you will learn:
//		1) Installing WindowBuilder in Eclipse (if necessary) using update sites
//		2) Creating WindowBuilder code (JFrame)
//		3) Clean coding recommendations (initComponents() & createEvents())
//		4) WindowBuilder Design tab/page (Properties pane, Structure/hierarchy pane, Component Palette pane)
//		5) Changing titles, colors and icons properly
//		6) Good practices for packages in GUI projects (views/common/resources)
//		7) Look and Feel (how to make program look like Windows/Mac/Linux/etc.)
//		8) Variables naming conventions and scope (local variable vs. instance variable)
//		9) GroupLayout for Layout Manager
//		10) Demo of JLabel, JTextField, JButton and an action handler for buttons
//		11) Component label naming conventions
//		12) Demo of JRadioButton, ButtonGroups, JCheckBox, JTextField, JScrollPane
//		13) How to add borders to (some) components
//		14) Difficulties with GroupLayout
//		15) Exporting your GUI to a runnable .JAR file
//		16) Demo of JPanel (titled border), JComboBox, JList
//		17) Demo of the underlying model to some components (JComboBox uses DefaultComboBoxModel, JList uses DefaultListModel) which contains the objects which are synced to the actual components
//		18) Removing items from JComboBox and JList components
//		19) Binding strings to JComboBox/JList
//		20) Binding objects (your own class) to components (JList)
//		21) Custom display string for objects in JList using setCellRenderer
//		22) Explanation Different types of handlers (mouseMoved, mouseClicked, mouseEntered, mousePressed, mouseReleased)
//		23) Demo of mouseMoved event/handler to set tool-tips displaying XY coordinates
//		24) Demo of mouseClicked event/handler to take action (pop-up message box, update other components based on the object that was clicked on in JList)
//		25) Demo of Menus of every kind:
//		    a) JMenuBar: The standard menu at top of program with File, Edit, etc.
//		    b) JMenu: The menu that pops up when you click File or Edit
//		    c) JMenuItem: The menu item to click on in the menu (e.g., Close, Save As, etc.)
//		    d) JCheckBoxMenuItem: Special menu item with a check box
//		    e) JRadioButtonMenuItem: Special menu item with a radio button
//		    f) JPopupMenu: Typically launches when we right-click somewhere and usually as Copy, Paste, etc.
//		26) Icons in menus and resizing issues
//		27) JDialog boxes as pop-up menus/dialogs
//		28) modal vs. non-modal (when a popup dialog appears, can we click on the other dialogs/frames?)
//		29) Demos of JProgressBar (including setting color), JSpinner, JSlider, JToggleButton and JTable
//		30) Demo of syncing up two controls to one another (JSpinner and JSlider)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import views.WBGuiComponentTourGUI;

public class Lesson_05_Bonus_WindowBuilder_All_Components {

	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will start execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to use WindowBuilder to create a GUI and make more API calls.");
		System.out.println("===========================================================================");

		// Launch GUI by instantiating an object of the GUI class
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());	// Checked exception...throws above exceptions
		WBGuiComponentTourGUI frame = new WBGuiComponentTourGUI();
		frame.setVisible(true);
	}

}
