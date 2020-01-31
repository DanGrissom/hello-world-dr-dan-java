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
import models.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WBGuiComponentTourGUI extends JFrame
{
	///////////////////////////////////////////////////////////////////
	// Components
	private JPanel ctpMain;
	private JTextField txtFirstName;
	private JButton btnOrder;
	private final ButtonGroup btgEntree = new ButtonGroup();
	private JRadioButton rbBurrito;
	private JRadioButton rbBowl;
	private final ButtonGroup btgMeat = new ButtonGroup();
	private JCheckBox chkMildSauce;
	private JCheckBox chkMediumSauce;
	private JCheckBox chkHotSauce;
	private JRadioButton rbSofritas;
	private JRadioButton rbSteak;
	private JRadioButton rbChicken;
	private JTextArea taSpecialInstructions;
	private JComboBox cbCustomerType;
	private JLabel lblCustomers;
	private JList lstCustomers;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenuItem mntmExit;
	private JMenu mnCheckBoxOptions;
	private JMenu mnRadioOptions;
	private JCheckBoxMenuItem chckbxmntmNewCheckItem;
	private JCheckBoxMenuItem chckbxmntmCbOption;
	private JPopupMenu popupMenu;
	private JMenuItem mntmPaste;
	private JPopupMenu popupMenu_1;
	private JMenuItem mntmDoSomething;
	private JRadioButtonMenuItem rdbtnmntmRb;
	private JRadioButtonMenuItem rdbtnmntmRb_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JProgressBar pbOrders;
	private JSlider sldJimmy;
	private JSpinner spnSpin;
	private JToggleButton tglState;
	private JTable table;
	
	///////////////////////////////////////////////////////////////////
	// Component models
	DefaultListModel<Person> customerList = new DefaultListModel<Person>();

	////////////////////////////////////////////////////////////////////////////////
	// Constructor - calls initComponents and createEvents
	////////////////////////////////////////////////////////////////////////////////
	public WBGuiComponentTourGUI()
	{
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////////////////
	// All component initializations done here in this method
	////////////////////////////////////////////////////////////////////////////////
	private void initComponents()
	{
		setTitle("My Awesome GUI");
		setIconImage(Toolkit.getDefaultToolkit().getImage(WBGuiComponentTourGUI.class.getResource("/resources/monkey_128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 464);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(WBGuiComponentTourGUI.class.getResource("/resources/exit_16.png")));

		mnFile.add(mntmExit);
		
		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		mnCheckBoxOptions = new JMenu("Check Box Options");
		mnEdit.add(mnCheckBoxOptions);
		
		chckbxmntmNewCheckItem = new JCheckBoxMenuItem("CB Option 1");
		mnCheckBoxOptions.add(chckbxmntmNewCheckItem);
		
		chckbxmntmCbOption = new JCheckBoxMenuItem("CB Option 2");
		mnCheckBoxOptions.add(chckbxmntmCbOption);
		
		mnRadioOptions = new JMenu("Radio Options");
		mnEdit.add(mnRadioOptions);
		
		rdbtnmntmRb = new JRadioButtonMenuItem("RB 1");
		buttonGroup.add(rdbtnmntmRb);
		mnRadioOptions.add(rdbtnmntmRb);
		
		rdbtnmntmRb_1 = new JRadioButtonMenuItem("RB 2");
		buttonGroup.add(rdbtnmntmRb_1);
		mnRadioOptions.add(rdbtnmntmRb_1);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmAbout = new JMenuItem("About");

		mnHelp.add(mntmAbout);
		ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		
		JLabel lblFirstName = new JLabel("First Name:");
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		
		btnOrder = new JButton("Order");
		
		rbBurrito = new JRadioButton("Burrito");
		rbBurrito.setSelected(true);
		btgEntree.add(rbBurrito);
		
		rbBowl = new JRadioButton("Bowl");
		btgEntree.add(rbBowl);
		
		JLabel lblEntreeType = new JLabel("Entree Type:");
		
		JLabel lblMeat = new JLabel("Meat:");
		
		rbChicken = new JRadioButton("Chicken");
		rbChicken.setSelected(true);
		btgMeat.add(rbChicken);
		
		rbSteak = new JRadioButton("Steak");
		btgMeat.add(rbSteak);
		
		rbSofritas = new JRadioButton("Sofritas");
		btgMeat.add(rbSofritas);
		
		JLabel lblExtras = new JLabel("Extras:");
		
		chkMildSauce = new JCheckBox("Mild Sauce");
		
		chkMediumSauce = new JCheckBox("Medium Sauce");
		
		chkHotSauce = new JCheckBox("Hot Sauce");
		
		JLabel lblSpecialInstructions = new JLabel("Special Instructions:");
		
		JScrollPane scrSpecialInstructions = new JScrollPane();
		
		JPanel pnlCustomers = new JPanel();
		pnlCustomers.setBorder(new TitledBorder(null, "Customers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		popupMenu = new JPopupMenu();
		addPopup(ctpMain, popupMenu);
		
		mntmPaste = new JMenuItem("Paste");
		popupMenu.add(mntmPaste);
		
		pbOrders = new JProgressBar();
		pbOrders.setToolTipText("Number of burritos you have served!");
		pbOrders.setStringPainted(true);
		pbOrders.setMaximum(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"btnSubmit", "DavidHassenholf"},
				{"rbHotSauce", "theSpinner"},
			},
			new String[] {
				"Good Variable Names", "Bad Variable Names"
			}
		));

		GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
		gl_ctpMain.setHorizontalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_ctpMain.createSequentialGroup()
								.addComponent(lblFirstName)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtFirstName))
							.addGroup(gl_ctpMain.createSequentialGroup()
								.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblMeat)
									.addComponent(lblEntreeType)
									.addComponent(lblExtras)
									.addComponent(lblSpecialInstructions))
								.addGap(6)
								.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_ctpMain.createSequentialGroup()
										.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
											.addComponent(rbChicken)
											.addComponent(rbBurrito))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
											.addComponent(rbBowl)
											.addGroup(gl_ctpMain.createSequentialGroup()
												.addComponent(rbSteak)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(rbSofritas))))
									.addGroup(gl_ctpMain.createSequentialGroup()
										.addComponent(chkMildSauce)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(chkMediumSauce)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(chkHotSauce))
									.addComponent(scrSpecialInstructions, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
									.addComponent(pbOrders, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addComponent(btnOrder)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(pnlCustomers, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_ctpMain.setVerticalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlCustomers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFirstName)
								.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEntreeType)
								.addComponent(rbBurrito)
								.addComponent(rbBowl))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMeat)
								.addComponent(rbChicken)
								.addComponent(rbSteak)
								.addComponent(rbSofritas))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblExtras)
								.addComponent(chkMildSauce)
								.addComponent(chkMediumSauce)
								.addComponent(chkHotSauce))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSpecialInstructions)
								.addComponent(scrSpecialInstructions, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(pbOrders, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnOrder)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(15))))
		);
		
		cbCustomerType = new JComboBox();
		cbCustomerType.setModel(new DefaultComboBoxModel(new String[] {"Person", "Super Hero"}));
		cbCustomerType.setSelectedIndex(0);
		
		JLabel lblCustomerType = new JLabel("Customer Type:");
		
		lblCustomers = new JLabel("Customers:");
		
		JScrollPane scrCustomers = new JScrollPane();
		
		sldJimmy = new JSlider();
		sldJimmy.setMinorTickSpacing(5);
		sldJimmy.setPaintTicks(true);
		sldJimmy.setPaintLabels(true);
		sldJimmy.setMajorTickSpacing(10);
		
		spnSpin = new JSpinner();
		spnSpin.setModel(new SpinnerNumberModel(50, 0, 100, 5));
		
		tglState = new JToggleButton("OFF");


		GroupLayout gl_pnlCustomers = new GroupLayout(pnlCustomers);
		gl_pnlCustomers.setHorizontalGroup(
			gl_pnlCustomers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCustomers.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCustomers.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pnlCustomers.createSequentialGroup()
							.addGroup(gl_pnlCustomers.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCustomers)
								.addComponent(lblCustomerType))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlCustomers.createParallelGroup(Alignment.LEADING)
								.addComponent(cbCustomerType, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrCustomers, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_pnlCustomers.createSequentialGroup()
							.addComponent(sldJimmy, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(spnSpin, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addComponent(tglState))
					.addContainerGap())
		);
		gl_pnlCustomers.setVerticalGroup(
			gl_pnlCustomers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCustomers.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCustomers.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCustomerType)
						.addComponent(cbCustomerType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCustomers.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCustomers)
						.addComponent(scrCustomers, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_pnlCustomers.createParallelGroup(Alignment.LEADING)
						.addComponent(spnSpin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sldJimmy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(tglState)
					.addGap(45))
		);
		
		lstCustomers = new JList();

		lstCustomers.setModel(customerList);
		
		initCustomerList();

		scrCustomers.setViewportView(lstCustomers);
		pnlCustomers.setLayout(gl_pnlCustomers);
		
		taSpecialInstructions = new JTextArea();
		scrSpecialInstructions.setViewportView(taSpecialInstructions);
		
		popupMenu_1 = new JPopupMenu();
		addPopup(taSpecialInstructions, popupMenu_1);
		
		mntmDoSomething = new JMenuItem("Do Something");
		popupMenu_1.add(mntmDoSomething);
		ctpMain.setLayout(gl_ctpMain);
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// All component initializations done here in this method
	////////////////////////////////////////////////////////////////////////////////
	private void initCustomerList()
	{
		// Adding some "random" people and superheroes to the customerList
		customerList.addElement(new Person("Dan", "Grissom", 'M', 29));
		customerList.addElement(new Person("Jay", "Brown", 'M', 46));
		customerList.addElement(new Person("Jane", "Smith", 'F', 12));
		customerList.addElement(new Person("Jimmy", "Bartholomew", 'M', 20));
		customerList.addElement(new Person("Esther", "Obama", 'F', 73));
		customerList.addElement(new SuperHero("Clark", "Kent", 'M', 20, "X-Ray Vision", "Kryptonite", "Wonder Woman"));
		customerList.addElement(new SuperHero("Larry", "Boy", 'M', 30, "Joy", "Can't Read", "Archibald"));
		customerList.addElement(new Person("Montrell", "Thigpen", 'M', 19));
		customerList.addElement(new Person("Wallace", "Grommit", 'M', 44));
		customerList.addElement(new Person("Edward", "Kim", 'M', 21));
		
	}

	////////////////////////////////////////////////////////////////////////////////
	// All event handlers placed here in this method
	////////////////////////////////////////////////////////////////////////////////
	private void createEvents()
	{
		tglState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tglState.isSelected())
				{
					tglState.setText("ON");
					tglState.setForeground(Color.RED);
				}
				else
				{
					tglState.setText("OFF");
					tglState.setForeground(Color.BLACK);
				}
			}
		});
		
		spnSpin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sldJimmy.setValue((Integer)spnSpin.getValue());
			}
		});
		
		sldJimmy.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				spnSpin.setValue(sldJimmy.getValue());
			}
		});
		
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setModal(true);
				about.setVisible(true);
			}
		});
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if (ret == JOptionPane.YES_OPTION)
				{
					// Elegantly shut down program
					// Save any work into file or database, etc.
					System.exit(0);
				}
			}
		});
		
		lstCustomers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null, "Click");
				Person clickedPerson = customerList.getElementAt(lstCustomers.getSelectedIndex());
				//JOptionPane.showMessageDialog(null, clickedPerson.toString());
				//chkHotSauce.setSelected(clickedPerson.getBurrito().hasHotSauce());
				if (clickedPerson.getDisplayName().toUpperCase().contains("CLARK") &&
						clickedPerson.getDisplayName().toUpperCase().contains("KENT")	)
				{
					chkHotSauce.setSelected(false);
				}
				else
					chkHotSauce.setSelected(true);
				
				if (chckbxmntmNewCheckItem.isSelected())
					JOptionPane.showMessageDialog(null, "Check");
			}
		});
		
		lstCustomers.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lstCustomers.setToolTipText("(" + arg0.getX() + ", " + arg0.getY() + ")");
			}
		});
		
		lstCustomers.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Person) {
                    // Here value will be of the Type 'CD'
                    ((JLabel) renderer).setText(((Person) value).getDisplayName());
                }
                return renderer;
            }
        });
		
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				pbOrders.setValue(pbOrders.getValue() + 1);
				if (pbOrders.getValue() >= pbOrders.getMaximum())
					pbOrders.setForeground(Color.RED);
				else if (pbOrders.getValue() >= (pbOrders.getMaximum() - pbOrders.getMinimum()) / 2)
					pbOrders.setForeground(Color.YELLOW);
				else
					pbOrders.setForeground(Color.GREEN);
				
//				JOptionPane.showMessageDialog(null, txtFirstName.getText());
//				txtFirstName.setText(txtFirstName.getText() + " the Man");
//				
//				if (rbBurrito.isSelected())
//					JOptionPane.showMessageDialog(null, "Burrito!!!");
//				else
//					JOptionPane.showMessageDialog(null, "BOWL!!!!");
//				
//				
//				
//				
//				if (chkMildSauce.isSelected())
//					JOptionPane.showMessageDialog(null, "Mild!!!");
//				else
//					JOptionPane.showMessageDialog(null, "No Mild!!!!");

				//taSpecialInstructions.getText()s;
				
				//JOptionPane.showMessageDialog(null, lstCustomers.getSelectedIndex());
				//JOptionPane.showMessageDialog(null, lstCustomers.getSelectedValue());
				
				
				
				//DefaultComboBoxModel customerTypeModel = (DefaultComboBoxModel) cbCustomerType.getModel();
				//customerTypeModel.addElement("Burrito");
				//customerTypeModel.removeAllElements();
				//customerList.addElement("Test");
				
				
			}
		});		
	}
	
	////////////////////////////////////////////////////////////////////////////////
	// Popup menu method.
	////////////////////////////////////////////////////////////////////////////////
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
