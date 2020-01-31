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
package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public About() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(About.class.getResource("/resources/monkey_128.png")));
		setTitle("About");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JTextArea txtrAuthorCsStudents = new JTextArea();
		txtrAuthorCsStudents.setBackground(SystemColor.menu);
		txtrAuthorCsStudents.setEditable(false);
		txtrAuthorCsStudents.setText("Author: HelloDrDan.com\r\nRelease Date: January 26, 2020\r\nVersion: 1.0");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(txtrAuthorCsStudents, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(txtrAuthorCsStudents, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
