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
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Lesson_02_Handcoded_GUI_Self_Destructing extends JFrame {

	// Create random class
	private Random randy = new Random();

	// Component variables
	private JButton b1 = new JButton("Press Me!!");
	private JButton b2 = new JButton("You Better Not Press Me!");

	// Color constants
	private final Color ucrBlue = new Color(45, 108, 192);
	private final Color ucrNavy = new Color(0, 48, 102);
	private final Color ucrGold = new Color(241, 171, 0);
	private final Color ucrGray = new Color(122, 110, 103);
	
	///////////////////////////////////////////////////////////////
	// MAIN - Entry point where code will begin execution for file
	///////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// Simple welcome statements printed to screen
		System.out.println("Program Objective: Learn to create GUIs from code (not using a GUI builder) and GUI fundamentals.");
		System.out.println("===========================================================================");

		// A GUI must instantiate an object of itself (a JFrame) in the main
		Lesson_02_Handcoded_GUI_Self_Destructing gui = new Lesson_02_Handcoded_GUI_Self_Destructing();
	}
	
	///////////////////////////////////////////////////////////////
	// Constructor - Simply calls two methods that do the real work
	//		Parameters:
	//			NONE
	///////////////////////////////////////////////////////////////
	public Lesson_02_Handcoded_GUI_Self_Destructing() {
		initComponents();
		initEvents();
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method initializes all things related to style and appearance.
	//		Parameters:
	//			NONE
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private void initComponents() {
		// Init general properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Dr. Dan's Self-Destructing GUI");

		// Get content pane and set layout to FlowLayout
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		//Iinit components
		c.setBackground(ucrGray);
		b1.setBackground(ucrBlue);
		b1.setForeground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b2.setForeground(ucrNavy);
		b2.setToolTipText("I thought I told you...");
		//b1.setEnabled(false);
		b2.setVisible(false);
		b2.setOpaque(false);

		// Add components to the content pane
		c.add(b1);
		c.add(b2);

		// Style 50 more buttons
		for(int i = 0; i < 50; i++) {
			// Create button
			JButton b = new JButton(String.valueOf(i));

			// Style button
			if (i % 2 == 0) {	// Even iteration
				b.setBackground(ucrNavy);
				b.setForeground(ucrGold);
			} else {			// Odd iteration
				b.setBackground(ucrGold);
				b.setForeground(ucrNavy);
			}

			// Add button to container
			c.add(b);
		}


		// Init size and visibility
		setVisible(true);
		setBounds(800, 200, 600, 400);		
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method creates and initializes all event handlers executed when a 
	// component (e.g., button) interaction occurs.
	//		Parameters:
	//			NONE
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	private void initEvents() {
		/////////////////////////////////////////////////////////////////////////////
		// Event handler for the b1 button (Press Me)
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Display a pop-up
				JOptionPane.showMessageDialog(null, "Congrats! You can follow directions!");
				b2.setVisible(true);
			}
		});

		/////////////////////////////////////////////////////////////////////////////
		// Event handler for the b2 button (You better not press....)
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display a countdown pop-ups
				JOptionPane.showMessageDialog(null, "Uh oh, you didn't follow directions. This GUI will self-destruct in 5...", "Warning", JOptionPane.WARNING_MESSAGE);
				randomizeComponentColors();
				JOptionPane.showMessageDialog(null, "4...", "Warning", JOptionPane.WARNING_MESSAGE);
				randomizeComponentColors();
				JOptionPane.showMessageDialog(null, "3...", "Warning", JOptionPane.WARNING_MESSAGE);
				randomizeComponentColors();
				JOptionPane.showMessageDialog(null, "2...", "Warning", JOptionPane.WARNING_MESSAGE);
				randomizeComponentColors();
				JOptionPane.showMessageDialog(null, "1...", "Warning", JOptionPane.WARNING_MESSAGE);
				randomizeComponentColors();

				// The process to draw the GUI is currently running in the same thread as this code.
				// Thus, if we cause this code to slow down by putting huge sleep commands in it,
				// the thread will not be able to draw the GUI b/c it will be busy in the FOR loop.
				// So, we create a new thread so that the code in this new thread 
				new Thread() {
					public void run() {
						try {
							// Get the container that has all the buttons
							Container c = getContentPane();
							int numComponents = c.getComponentCount();
							
							// Init variables for how often to update the display
							int numFlashesPerButtonDis = 10; 	// How many times to flash a color change before making a button disappear
							int millisBetweenButtonDis = 100;	// Number of milliseconds between each each button disappearing

							// Iterate for each flash
							for (int i = 0; i < numFlashesPerButtonDis * numComponents; i++) {
								// Randomize colors (flash) each iteration and sleep (long enough for us to redraw and see change)
								randomizeComponentColors();
								Thread.sleep(millisBetweenButtonDis / numFlashesPerButtonDis);

								// Every numFlashesPerButtonDis of flashes means it's time for a button to disappear
								if (i % numFlashesPerButtonDis == 0) {
									// Grab a random component and remove it
									Component comp = c.getComponent(randy.nextInt(c.getComponentCount()));
									c.remove(comp);
									
									// When remove a button, also change the background color
									c.setBackground(new Color(randy.nextInt(256), randy.nextInt(256), randy.nextInt(256)));
								}
							}
							
							// Once all buttons have been removed, close the GUI/program
							System.exit(0);
						} catch (Exception exp) {
							// Do nothing
						}
					}
				}.start();
			}
		});

		/////////////////////////////////////////////////////////////////////////////
		// More event handlers for the b2 button (You better not press...)
		b2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {	}
			public void mouseEntered(MouseEvent e) { /*b2.setVisible(false);*/ }
			public void mouseExited(MouseEvent e) { /*b2.setVisible(true);*/ }
			public void mousePressed(MouseEvent e) { }
			public void mouseReleased(MouseEvent e) { }
		});
	}

	////////////////////////////////////////////////////////////////////////////////
	// This method obtains all the components in the JFrame's container and changes
	// their background and text (foreground) colors to random colors.
	//		Parameters:
	//			NONE
	//		Returns:
	//			void (nothing)
	////////////////////////////////////////////////////////////////////////////////
	protected void randomizeComponentColors() {
		// Grab the container
		Container c = getContentPane();

		// Iterate through all the components and change their styles
		for (int i = 0; i < c.getComponentCount(); i++) {
			Component comp = c.getComponent(i);
			comp.setBackground(new Color(randy.nextInt(256), randy.nextInt(256), randy.nextInt(256)));
			comp.setForeground(new Color(randy.nextInt(256), randy.nextInt(256), randy.nextInt(256)));
		}

		// Repaint the GUI so it draws the style changes
		repaint();
	}

}
