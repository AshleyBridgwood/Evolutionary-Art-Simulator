/**
 * @author Ibrahim Farah
 */
package view;


import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.BioController;
import model.Export;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class UserInterface extends MouseAdapter{

	private JFrame frame;
	
	JButton btnMutate = new JButton("Mutate !");
	JPanel panelOutput = new JPanel();
	JPanel panelBiomorph1 = new JPanel();
	JPanel panelBiomorph2 = new JPanel();
	JPanel panelBiomorph3 = new JPanel();
	JPanel panelBiomorph4 = new JPanel();
	JPanel panelBiomorph5 = new JPanel();
	JPanel panelBiomorph6 = new JPanel();
	JPanel panelBiomorph7= new JPanel();
	JPanel panelBiomorph8 = new JPanel();
	JPanel panelBiomorph9 = new JPanel();
	JPanel HOFPanel1 = new JPanel();
	JPanel HOFPanel2 = new JPanel();
	JPanel HOFPanel3 = new JPanel();
	
	static int colourChoice = -1;
	static int lineThicknessChoice = 1;
	static int lineAmountChoice = 20;
	int hofCounter = BioController.getCurrentHallOfFameNumber();
	
	int slot;
	int attempts = 0;
	int hofSelected = 0;
	static boolean changes = false;

	private ArrayList<Integer> panelsSelected = new ArrayList<Integer>();
	
	JPanel[] panels = {panelBiomorph1,panelBiomorph2, panelBiomorph3, panelBiomorph4, panelBiomorph5, panelBiomorph6, 
			panelBiomorph7, panelBiomorph8, panelBiomorph9};
	
	JPanel[] hofPanels = {HOFPanel1, HOFPanel2, HOFPanel3};


	/**	
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =	new JFrame();	

		frame.setBounds(100, 100, 1093, 825);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Dimension d = new Dimension (1093, 885); //dimensions set to be used as parameter for mainFrame.setPreferedSize(d) method.
		//frame.setPreferredSize(d);
		
		frame.setState(Frame.NORMAL);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		frame.setSize(dimension);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		frame.setResizable(false);
		
		
		
		//Exit prompt
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (changes == true){ // if changes have been made, direct user where they will get prompt to save work.
					exit();
				} else {
					exitNoChange(); // if no changes, direct to normal exit.
				}
				
			}
		});

		
		JLabel lblHOF = new JLabel("Hall Of Fame"); //Hall of Fame Label
		lblHOF.setFont(new Font("Calibri", Font.BOLD, 22));
		lblHOF.setBackground(Color.ORANGE);
		lblHOF.setBounds(664, 13, 130, 35);
		frame.getContentPane().add(lblHOF);
		
		HOFPanel1.setForeground(Color.BLACK); //first hall of fame panel.
		HOFPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		HOFPanel1.setBackground(SystemColor.menu);
		HOFPanel1.setBounds(393, 50, 210, 133);
		if(BioController.getCurrentHallOfFameNumber() >= 1){ 
			HOFPanel1.add(BioController.displayHallOfFameBiomorph(0)); //load up first hall of fame biomorph
		}
		frame.getContentPane().add(HOFPanel1);
		
		HOFPanel2.setForeground(Color.BLACK); //second hall of fame panel.
		HOFPanel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		HOFPanel2.setBackground(SystemColor.menu);
		HOFPanel2.setBounds(615, 50, 210, 133);
		if(BioController.getCurrentHallOfFameNumber() >= 2){  //load up second hall of fame biomorph
			HOFPanel2.add(BioController.displayHallOfFameBiomorph(1));
		}
		frame.getContentPane().add(HOFPanel2);
		
		HOFPanel3.setForeground(Color.BLACK); //third hall of fame panel.
		HOFPanel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		HOFPanel3.setBackground(SystemColor.menu);
		HOFPanel3.setBounds(837, 50, 210, 133);
		if(BioController.getCurrentHallOfFameNumber() >= 3){  //load up third hall of fame biomorph
			HOFPanel3.add(BioController.displayHallOfFameBiomorph(2));
		}
		frame.getContentPane().add(HOFPanel3);
		
		JLabel lblBiomorph = new JLabel("Children"); //children label
		lblBiomorph.setFont(new Font("Calibri", Font.BOLD, 22));
		lblBiomorph.setBackground(Color.ORANGE);
		lblBiomorph.setBounds(680, 217, 210, 35);
		frame.getContentPane().add(lblBiomorph);
		
		//9 panels for children biomorph, call to biocontroller to display each biomorph in relative panel.
		panelBiomorph1.setForeground(Color.BLACK);
		panelBiomorph1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph1.setBackground(SystemColor.menu);
		panelBiomorph1.setBounds(405, 252, 210, 133);
		panelBiomorph1.add(BioController.displayChildren(1));
		frame.getContentPane().add(panelBiomorph1);
		
		panelBiomorph2.setForeground(Color.BLACK);
		panelBiomorph2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph2.setBackground(SystemColor.menu);
		panelBiomorph2.setBounds(624, 252, 210, 133);
		panelBiomorph2.add(BioController.displayChildren(2));
		frame.getContentPane().add(panelBiomorph2);
		
		panelBiomorph3.setForeground(Color.BLACK);
		panelBiomorph3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph3.setBackground(SystemColor.menu);
		panelBiomorph3.setBounds(843, 252, 210, 133);
		panelBiomorph3.add(BioController.displayChildren(3));
		frame.getContentPane().add(panelBiomorph3);
		
		panelBiomorph4.setForeground(Color.BLACK);
		panelBiomorph4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph4.setBackground(SystemColor.menu);
		panelBiomorph4.setBounds(405, 387, 210, 133);
		panelBiomorph4.add(BioController.displayChildren(4));
		frame.getContentPane().add(panelBiomorph4);
		
		panelBiomorph5.setForeground(Color.BLACK);
		panelBiomorph5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph5.setBackground(SystemColor.menu);
		panelBiomorph5.setBounds(624, 387, 210, 133);
		panelBiomorph5.add(BioController.displayChildren(5));
		frame.getContentPane().add(panelBiomorph5);
		
		panelBiomorph6.setForeground(Color.BLACK);
		panelBiomorph6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph6.setBackground(SystemColor.menu);
		panelBiomorph6.setBounds(843, 387, 210, 133);
		panelBiomorph6.add(BioController.displayChildren(6));
		frame.getContentPane().add(panelBiomorph6);
		
		panelBiomorph7.setForeground(Color.BLACK);
		panelBiomorph7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph7.setBackground(SystemColor.menu);
		panelBiomorph7.setBounds(405, 524, 210, 133);
		panelBiomorph7.add(BioController.displayChildren(7));
		frame.getContentPane().add(panelBiomorph7);
		
		panelBiomorph8.setForeground(Color.BLACK);
		panelBiomorph8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph8.setBackground(SystemColor.menu);
		panelBiomorph8.setBounds(624, 524, 210, 133);
		panelBiomorph8.add(BioController.displayChildren(8));
		frame.getContentPane().add(panelBiomorph8);
		
		panelBiomorph9.setForeground(Color.BLACK);
		panelBiomorph9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph9.setBackground(SystemColor.menu);
		panelBiomorph9.setBounds(843, 524, 210, 133);
		panelBiomorph9.add(BioController.displayChildren(9));
		frame.getContentPane().add(panelBiomorph9);
		
		//panel to hold sliders
		JPanel controlPanel = new JPanel();
		controlPanel.setForeground(Color.BLACK);
		controlPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		controlPanel.setBackground(SystemColor.menu);
		controlPanel.setBounds(28, 662, 1025, 92);
		
		//Sliders to adjust probability of change.
		Dimension d2 = new Dimension(300,70);
		final LabelledSlider probSlider = new LabelledSlider(" Probability of Change  ", 0.0, 0, 20, 100);
		probSlider.setBounds(193, 13, 300, 70);
		probSlider.setPreferredSize(d2);
		final LabelledSlider changeSlider = new LabelledSlider("Amount of Change  ", 0.0, 0, 20, 100);
		changeSlider.setBounds(498, 13, 300, 70);
     	changeSlider.setPreferredSize(d2);
     	
		controlPanel.add(probSlider);
		controlPanel.add(changeSlider);
		frame.getContentPane().add(controlPanel);

		
		JPanel panelLogo = new JPanel(); //panel to hold the logo image.
		panelLogo.setForeground(Color.BLACK);
		//panelLogo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelLogo.setBackground(SystemColor.menu);
		panelLogo.setBounds(41, 50, 311, 127);
		
		// adds actual logo to the panel
		JLabel logoImage = new JLabel();
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("Untitled-2.png"));
		Image l = logoIcon.getImage();
		Image logo = l.getScaledInstance(550, 120, Image.SCALE_DEFAULT);
		ImageIcon scaledLogo = new ImageIcon(logo);
		logoImage.setIcon(scaledLogo);
		panelLogo.add(logoImage);
		frame.getContentPane().add(panelLogo);
		
		// adding to hall of fame button
		JButton btnHOF = new JButton("Add to hall of fame");
		btnHOF.setBounds(209, 487, 148, 43);
		frame.getContentPane().add(btnHOF);
		
		//label for parent biomorph.
		JLabel lblBiomorphParent = new JLabel("Parent");
		lblBiomorphParent.setFont(new Font("Calibri", Font.BOLD, 22));
		lblBiomorphParent.setBackground(Color.ORANGE);
		lblBiomorphParent.setBounds(169, 217, 188, 35);
		frame.getContentPane().add(lblBiomorphParent);
		
		// panel that holds the parent 
		panelOutput.setForeground(Color.BLACK);
		panelOutput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelOutput.setBackground(SystemColor.menu);
		panelOutput.setBounds(48, 255, 311, 175);
		panelOutput.add(BioController.displayParent());
		frame.getContentPane().add(panelOutput);
		
		JButton undoButton = new JButton("Undo");
		undoButton.setBounds(47, 436, 154, 43);
		frame.getContentPane().add(undoButton);
		
		btnMutate.setBounds(209, 436, 149, 43);
		frame.getContentPane().add(btnMutate);
		
		JButton btnSave = new JButton("Save!");
		btnSave.setBounds(47, 487, 78, 43);
		frame.getContentPane().add(btnSave);
		
		JButton btnExport = new JButton("Export!");
		btnExport.setBounds(123, 487, 78, 43);
		frame.getContentPane().add(btnExport);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(0, 0, 130, 43);
		frame.getContentPane().add(btnHome);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(130, 0, 130, 43);
		frame.getContentPane().add(btnClose);
		
		final JButton btnRemove = new JButton("Remove"); // button to remove a biomorph from the hall of fame.
		btnRemove.setBounds(393, 186, 105, 35);
		btnRemove.setVisible(false);
		frame.getContentPane().add(btnRemove);
                
        final JButton btnUse = new JButton("Use");	    // button to add the hall of fame to the current parent panel.
        btnUse.setBounds(498,186,105,35);
        btnUse.setVisible(false);
        frame.getContentPane().add(btnUse);
		
		
		//Action listeners to add hall of fame to current parent.
        	btnUse.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				panelOutput.removeAll(); //clears the parnt panel of it's current biomorph so hall of fame can be added
        				int id_to_pass = hofSelected - 1;  // hof biomorphs stored in arraylist, therefore have to subtract one from hof selected.
        				BioController.bringHOFBiomorphToMainPanel(id_to_pass); 
        				refreshHallOfFamePanels(); 
        				panelOutput.removeAll();
        				refreshAllPanels(); // repaints panels so parent panel can change to the selected hall of fame.
        				
        				btnRemove.setVisible(false); //sets the remove and use button to invisble. 
        				btnUse.setVisible(false);    // only show after it ha been clicked.
        			}	
        		});
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hofSelected == 1){
					panelOutput.removeAll();
					BioController.clearCertainHallOfFameBiomorph(0); //clear the first hall of fame in arraylist
					HOFPanel1.setBackground(SystemColor.menu);
					refreshHallOfFamePanels(); //repaint the hall of fame panels, so changes can be applied.
					hofCounter--; //decrement the counter for the amount of hall of fame biomorphs
					btnRemove.setVisible(false);
                    btnUse.setVisible(false);
				}
				else if (hofSelected == 2){
					panelOutput.removeAll();
					BioController.clearCertainHallOfFameBiomorph(1); //clear the second hall of fame in arraylist
					HOFPanel2.setBackground(SystemColor.menu);
					refreshHallOfFamePanels();						//repaint the hall of fame panels, so changes can be applied.
					hofCounter--;	//decrement the counter for the amount of hall of fame biomorphs
					btnRemove.setVisible(false);
                     btnUse.setVisible(false);
				}
				else if (hofSelected == 3){
					panelOutput.removeAll();
					BioController.clearCertainHallOfFameBiomorph(2); //clear the third hall of fame in arraylist
					HOFPanel3.setBackground(SystemColor.menu);
					refreshHallOfFamePanels();						//repaint the hall of fame panels, so changes can be applied.
					hofCounter--;	//decrement the counter for the amount of hall of fame biomorphs
					btnRemove.setVisible(false);
                    btnUse.setVisible(false);
					
				}
			}
		});	
		
		
		btnHome.addActionListener(new ActionListener() { //direct to exit prompt only if changes have been made.
			public void actionPerformed(ActionEvent e) {
				if (changes == true){
					if (!exit()){
						new StartScreen().getFrame().setVisible(true);
						frame.dispose();	
					}
					
				} else {
					new StartScreen().getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});	
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});	
		
	
		
		//Action listener for the hall of fame button.
		btnHOF.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(BioController.getCurrentHallOfFameNumber() < 3){ //only proceed if there aren't three biomorphs in hall of fame already
					BioController.saveCurrentParentToHallOfFame(); //saves the selected biomorph as the parent.
					panelOutput.removeAll();
					refreshHallOfFamePanels();
					hofCounter++;
				}
			}
		});
		
		//Action listener for the undo button. Goes to the previous biomorph
		undoButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panelOutput.removeAll(); // remove the current parent panel.
				BioController.undoOneBiomorph(); // calls biocontroller method, so previous biomorph can be retrieved.
				refreshAllPanels(); //repaint panels so changes can be applied.
			}
		});
		
		//Action listener for mutuate button. Mutates the biomorpbhs from what is selected
		btnMutate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Only allow mutation to occur if more than one panel is selected.
				if(!panelsSelected.isEmpty())
				{
					//  mutate one biomorph
					if(panelsSelected.size() == 1)
					{
						panelOutput.removeAll();
						BioController.mutuateBiomorphOne();
						refreshAllPanels();	
						changes = true;
					}
					else // mutate two selected.
					{
						panelOutput.removeAll();
						BioController.mutateBiomorphMultiple(panelsSelected.get(0),panelsSelected.get(1));
						refreshAllPanels();
						changes = true;
					}
				}

				//reset all the panel's background colour.
				for (int i = 0; i < panels.length; i++){
					panels[i].setBackground(SystemColor.menu);
				}
			}
		});
		
		//Action listener for save button. Directs it to save screen.
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaveBiomorph().getFrame().setVisible(true);
			}
		});
		
		//Action listener for export button. Directs it to save screen.
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportBiomorph();

			}
		});

		
		///////////////////////////////////////////   Mouse Listener so panels can be clicked!\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		HOFPanel1.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				HOFPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HOFPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		
		
			public void mouseClicked(MouseEvent e) {
			
				if(hofCounter != 0) // only allow panel to be clicked if it contains a bimorph.
				{
					if (hofSelected != 1 ){
						for (int i = 0; i < hofPanels.length; i++){
							hofPanels[i].setBackground(SystemColor.menu);
							HOFPanel1.setBackground(Color.GREEN);
							hofSelected = 1;
							btnRemove.setBounds(498, 181, 105, 35);
							btnRemove.setVisible(true);
                            btnUse.setBounds(393, 181, 105, 35);
                            btnUse.setVisible(true);
						}
						HofInstructions();
					} else {
						hofSelected = 0;
						HOFPanel1.setBackground(SystemColor.menu);
						btnRemove.setVisible(false);
                        btnUse.setVisible(false);
					}
				}
			}
		});
		
		HOFPanel2.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				HOFPanel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HOFPanel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		
		
			public void mouseClicked(MouseEvent e) {
				
				if(hofCounter == 2 || hofCounter == 3)
				{
					if (hofSelected != 2){
						for (int i = 0; i < hofPanels.length; i++){
							hofPanels[i].setBackground(SystemColor.menu);
							HOFPanel2.setBackground(Color.GREEN);
							btnRemove.setBounds(720, 181, 105, 35);
							btnRemove.setVisible(true);
                            btnUse.setBounds(615, 181, 105, 35);
                            btnUse.setVisible(true);
							hofSelected = 2;
						}
						HofInstructions();
					} else {
						hofSelected = 0;
						HOFPanel2.setBackground(SystemColor.menu);
						btnRemove.setVisible(false);
                                                btnUse.setVisible(false);
					}
				}
			}
		});
		
		HOFPanel3.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				HOFPanel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HOFPanel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		
			public void mouseClicked(MouseEvent e) {
			if(hofCounter == 3)
			{
				if (hofSelected != 3  )
				{
					
						for (int i = 0; i < hofPanels.length; i++){
							hofPanels[i].setBackground(SystemColor.menu);
							HOFPanel3.setBackground(Color.GREEN);
							hofSelected = 3;
							btnRemove.setBounds(942, 181, 105, 35);
							btnRemove.setVisible(true);
                            btnUse.setBounds(837, 181, 105, 35);
                            btnUse.setVisible(true);
						}
						HofInstructions();
					} 
					else 
					{
						hofSelected = 0;
						HOFPanel3.setBackground(SystemColor.menu);
						btnRemove.setVisible(false);
                        btnUse.setVisible(false);
					}
					
				}
			}
		});
		
		panelBiomorph1.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				BioController.setNextToMutate(1);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
			}
		
			public void mouseClicked(MouseEvent e) {
				panelClicked(1-1);
			}
			});
		
		
		panelBiomorph2.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				BioController.setNextToMutate(2);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				panelClicked(2-1);	
			}
			});
		
		panelBiomorph3.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				BioController.setNextToMutate(3);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				panelClicked(3-1);

			}
			});
		
		panelBiomorph4.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				BioController.setNextToMutate(4);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				panelClicked(4-1);

			}
			});
		
		panelBiomorph5.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				BioController.setNextToMutate(5);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				panelClicked(5-1);

			}
			});
		
		panelBiomorph6.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				BioController.setNextToMutate(6);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				panelClicked(6-1);

			}
			});
	
		panelBiomorph7.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				BioController.setNextToMutate(7);	
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				panelClicked(7-1);


			}
			});
		
		panelBiomorph8.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				BioController.setNextToMutate(8);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				panelClicked(8-1);


			}
			});
		
		panelBiomorph9.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				BioController.setNextToMutate(9);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				panelClicked(9-1);
			}
			});
		
		JMenuBar menuBar = new JMenuBar();
		
        //create menus
		JMenu file = new JMenu("File");
		JMenu hallOfFame = new JMenu("Hall Of Fame");
		JMenu lineOption = new JMenu("Line Options");
		JMenu colours = new JMenu("Colour Scheme");
		JMenu lineThickness = new JMenu("Line Thickness");
		JMenu history = new JMenu("History");
         
		//Create menu items
		JMenuItem newBiomorph = new JMenuItem("New Biomorph");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem export = new JMenuItem("Export");
		JMenuItem help = new JMenuItem("Help");
	
		JMenuItem clearHOF = new JMenuItem("Clear Hall of Fame");
		JMenuItem clearHOF1 = new JMenuItem("Remove Biomorph 1");
		JMenuItem clearHOF2 = new JMenuItem("Remove Biomorph 2");
		JMenuItem clearHOF3 = new JMenuItem("Remove Biomorph 3");
		
		JMenuItem black = new JMenuItem("Default: Black");
		JMenuItem red = new JMenuItem("Red");
		JMenuItem green = new JMenuItem("Green");
		JMenuItem blue = new JMenuItem("Blue");
		JMenuItem greyScale = new JMenuItem("Grey Scale");
		
		JMenuItem thin = new JMenuItem("Thin");
		JMenuItem medium = new JMenuItem("Medium");
		JMenuItem thick = new JMenuItem("Thick");
		
		JMenuItem viewHistory = new JMenuItem("View History");
		JMenuItem clearHistory = new JMenuItem("Clear History");
            
		//Add items to the menus
		file.add(newBiomorph);
		file.add(save);
		file.add(export);
		file.add(help);
		
		hallOfFame.add(clearHOF1);
		hallOfFame.add(clearHOF2);
		hallOfFame.add(clearHOF3);
		hallOfFame.add(clearHOF);
		
		
		colours.add(black);
		colours.add(red);
		colours.add(blue);
		colours.add(green);
		colours.add(greyScale);
		
		lineThickness.add(thin);
		lineThickness.add(medium);
		lineThickness.add(thick);		
		
		history.add(viewHistory);
		history.add(clearHistory);
            
		//Add menus
		menuBar.add(file);
		menuBar.add(hallOfFame);
		menuBar.add(lineOption);
		menuBar.add(history);
		
		lineOption.add(colours);
		lineOption.add(lineThickness);
		
		frame.setJMenuBar(menuBar);

		
		//Listener to allow user to clear hall of fame via menu bar.
		clearHOF.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				panelOutput.removeAll();
				BioController.clearHallOfFame();
				refreshHallOfFamePanels();
			}
		});
		
		//Listener to allow user to clear new biomorph via menu bar.
		newBiomorph.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (changes == true){
					if (!exit()){
						new BiomorphStartUp().getFrame().setVisible(true);
						frame.dispose();	
					}
					
				} else {
					new BiomorphStartUp().getFrame().setVisible(true);
					frame.dispose();
				}
				
			}
		});
		
		//Listener to allow user to click help button via menu bar.
		help.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new HelpScreen().getFrame().setVisible(true);
			}	
		});
		
		//Listener to allow user to click export button via menu bar.
		export.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				exportBiomorph();
			}	
		});
		
		//Listener to allow user to click save button via menu bar.
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new SaveBiomorph().getFrame().setVisible(true);
			}	
		});
		
		//Listeners to allow colour schemes to be clicked on via the menu bar.
		black.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				colourChoice = -1;
				panelOutput.removeAll();
				refreshAllPanels();
			}	
		});
		
		red.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				colourChoice = 0;
				panelOutput.removeAll();
				refreshAllPanels();
			}	
		});
		
		
		blue.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				colourChoice = 1;
				panelOutput.removeAll();
				refreshAllPanels();
			}	
		});
		
		green.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				colourChoice = 2;
				panelOutput.removeAll();
				refreshAllPanels();
			}	
		});

		
		greyScale.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				colourChoice = 3;
				panelOutput.removeAll();
				refreshAllPanels();
			}	
		});
		
		//Listeners to allow line thickness to be chosen via the menu bar.
		thin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				lineThicknessChoice = 1;
				panelOutput.removeAll();
				refreshAllPanels();
			}	
		});
		
		medium.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				lineThicknessChoice = 2;
				panelOutput.removeAll();
				refreshAllPanels();
			}	
		});
		
		thick.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				lineThicknessChoice = 3;
				panelOutput.removeAll();
				refreshAllPanels();
			}	
		});
		
		
		//Listeners to allow hitory to be clicked via a menu bar.
		viewHistory.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new History().getFrame().setVisible(true);
			}	
		});
		
		clearHistory.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			clearHistory();
			}
			});
		
			//allows key shortcuts
		 	file.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK), "save");
	        file.getActionMap().put("save", new AbstractAction() {
				private static final long serialVersionUID = -3278863802954479650L;

				@Override
	            public void actionPerformed(ActionEvent e) {
	            	new SaveBiomorph().getFrame().setVisible(true);
	            }
	        });	
	        
	        file.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK), "undo");
	        file.getActionMap().put("undo", new AbstractAction() {

				private static final long serialVersionUID = -4995258529742317659L;

				@Override
	            public void actionPerformed(ActionEvent e) {
	            	panelOutput.removeAll();
					BioController.undoOneBiomorph();
					refreshAllPanels();
	            }
	        });
	        			
	}
	
	//method that repaints the hall of fame panels, to show the changes.
	private void refreshHallOfFamePanels(){
		BioController.loadHallOfFameBiomorphs();
		panelOutput.add(BioController.displayParent());
		panelOutput.repaint();
		panelOutput.revalidate();
		int i = 0;
		int numberToLoop = BioController.getCurrentHallOfFameNumber();
		for(JPanel onePanel : hofPanels){
			onePanel.removeAll();
			if(i < numberToLoop){
				onePanel.add(BioController.displayHallOfFameBiomorph(i));
			}
			onePanel.validate();
			onePanel.repaint();
			i++;
		}
	}
	
	//method that repaints the child biomorphs and the parent biomorphs.
	private void refreshAllPanels(){
		panelOutput.add(BioController.displayParent());
		panelOutput.repaint();
		panelOutput.revalidate();
		int i = 1;
		for (JPanel onePanel : panels){ //loops through all the child and parent biomorphs.
			onePanel.removeAll();
			onePanel.add(BioController.displayChildren(i));
			onePanel.validate();
			onePanel.repaint();
			i++;
		}
		
		for (int x = 0; x <= panelsSelected.size(); x++){ //clears arraylist.
			if (!panelsSelected.isEmpty()){
				panelsSelected.remove(0);
			}
		}
	}
	//getter so frame can be accessed..
	public JFrame getFrame() {
			return this.frame;
	}

	public void exportBiomorph(){ //method to access frame as a png
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		String filename = f.getAbsolutePath();
		BufferedImage pingImage = new BufferedImage(panelOutput.getSize().width, panelOutput.getSize().height, BufferedImage.TYPE_INT_ARGB); 
		Graphics g = pingImage.createGraphics();
		panelOutput.paint(g); 
		g.dispose();
		Export.export(filename, pingImage);
	}
	
	public static int getColourChoice()
	{
		return colourChoice;
	}
	
	public static int getLineThickness()
	{
		return lineThicknessChoice;
	}
	
	public static int getLineAmount()
	{
		return lineAmountChoice;
	}
	
	public void panelClicked(int panel){
		
		if (!panelsSelected.isEmpty()){  
			if (panelsSelected.get(0) == panel + 1){ //if first element in arraylist, is equal to selected biomorph panel, then slot to be removed is that.
				slot = 0;			
			} else {  // else slot is in the second element.
				slot = 1;
			}
		}
		
		if (panels[panel].getBackground()==Color.GREEN){
			panels[panel].setBackground(SystemColor.menu);
			panelsSelected.remove(slot);
			
		} else if (panelsSelected.size() < 2){
			panels[panel].setBackground(Color.GREEN);
			BioController.setNextToMutate(panel + 1);
			panelsSelected.add(panel+1);
		}
	}
	
	private boolean exit(){ //if user opts to not quit, directs them to save screen.
		int response = JOptionPane
				.showConfirmDialog(frame,
						"Are you sure you want to quit? All unsaved changes will be lost", "Quit",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			frame.dispose();
			return false;
		}
		else if (response == JOptionPane.NO_OPTION) {
			new SaveBiomorph().getFrame().setVisible(true);	
		}
		return true;
	}
        
	private boolean exitNoChange(){ //no changes have been made, so users are not directed to save screen regardless.
		int response = JOptionPane
				.showConfirmDialog(frame,
						"Are you sure you want to quit?", "Quit",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			BioController.exportLogToFile();
			frame.dispose();
			return false;
		}
		return true;
	}
	
	public void HofInstructions(){ //instructions on how to use the hall of fame.
		if (attempts <1){
			JOptionPane.showMessageDialog(null, "<html><body>Click on the use button to add this artwork to the parent panel. <br>If you"
					+ " want to remove this artwork from the hall of fame, click on the remove button below!</body></html>");
			attempts++;
		} else {
			
		}
	}
	
	private boolean clearHistory(){ //clears history.
		int response = JOptionPane
				.showConfirmDialog(frame,
						"Are you sure you want to clear the history?\n You will not be able to undo your work previous to this point", "Clear History",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				BioController.clearHistoryData();
				BioController.resetCache();
				return true;
			} else if (response == JOptionPane.NO_OPTION) {
				frame.dispose();
			}
		return false;
	}
	
	public static void exported(boolean exported){ //waits for confirmation that file has been exported successfully.
	
		if (exported == true){
			JOptionPane.showMessageDialog(null, "File Successfully Exported!");
		} else if (exported == false){
			JOptionPane.showMessageDialog(null, "Incorrect File!");
		}
	}
	
	public static void setChanged(boolean changed){ //method that tracks whether there have been any changes.
			changes = changed;
	}
	

	
}
