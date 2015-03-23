/**
 * DESCRIPTION OF THE CLASS
 * @author Ibrahim Farah
 * @author Ashley Bridgwood
 *
 */

package main;

import main.LabelledSlider;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;



public class UI {
	
	
	private JFrame mainFrame;

	//Main panels (5 vertical) Each panel would be split up into further sub-panels.
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	//Panel 2
	JPanel panel2Left = new JPanel();
	JPanel child1Panel = new JPanel();       // actual output
	JPanel panel2Centre = new JPanel();
	JPanel child2Panel = new JPanel();      // actual output
	JPanel panel2Right = new JPanel();
	JPanel child3Panel = new JPanel();
	JPanel panel2Gap = new JPanel();
	JPanel panel2Gap2= new JPanel();
	
	//Panel 3
	JPanel panel3Left = new JPanel();
	JPanel child4Panel = new JPanel();       // actual output
	JPanel panel3Centre = new JPanel();
	JPanel child5Panel = new JPanel();       // actual output
	JPanel panel3Right = new JPanel();
	JPanel child6Panel = new JPanel();
	
	//Partition between children biomorph, and actual output.
	JPanel panel3Gap = new JPanel();
	// Panel for actual output.
	JPanel panel3Output = new JPanel();
	JPanel output = new JPanel();

	
	//Panel 4
	JPanel panel4Left = new JPanel();
	JPanel child7Panel = new JPanel();       // actual output
	JPanel panel4Centre = new JPanel();
	JPanel child8Panel = new JPanel();       // actual output
	JPanel panel4Right = new JPanel();
	JPanel child9Panel = new JPanel();      // actual output
	
	//Panel Section for biomorph to be manipulated.
	JPanel panel4Gap = new JPanel();
	JPanel panel4Gap2 = new JPanel();
	JPanel saveBiomorph = new JPanel();
	JPanel panelLogo = new JPanel();

	
	//Panel 5
	JPanel panel5Top = new JPanel();
	JPanel panel5Bottom = new JPanel();
	


	
	public UI(){
		
		//Images (adds banner image to the top panel)
		JPanel headingPanel = new JPanel();
		JPanel imagePanel = new JPanel();
		
		JLabel bannerImage = new JLabel();
		ImageIcon bannerIcon = new ImageIcon(getClass().getResource("Banner.jpg"));
		Image i = bannerIcon.getImage();
		Image scaledImage = i.getScaledInstance(1400, 120, Image.SCALE_DEFAULT);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		bannerImage.setIcon(scaledIcon);
		imagePanel.add(bannerImage);
		headingPanel.add(imagePanel);
		panel1.add(bannerImage);
		
		// add logo to panel 4.
		JPanel logoPanel = new JPanel();
			
		JLabel logoImage = new JLabel();
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("untitled-2.png"));
		Image l = logoIcon.getImage();
		Image logo = l.getScaledInstance(550, 120, Image.SCALE_DEFAULT);
		ImageIcon scaledLogo = new ImageIcon(logo);
		logoImage.setIcon(scaledLogo);
		logoPanel.add(logoImage);
		panelLogo.add(logoPanel);
		




		
		///////////////////////////////////////////               1. Create containers to hold components \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

		//mainFrame
		setMainFrame(new JFrame("Graphical User Interface"));
		//mainFrame properties
		Dimension d = new Dimension (1400,1000); //dimensions set to be used as parameter for mainFrame.setPreferedSize(d) method.
		getMainFrame().setPreferredSize(d); // not set in step 2 because mainFrame variable not initialised.
		getMainFrame().setResizable(false);
		
		
		///////////////////////////////////////////               2. Specify Layout Manager \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\



		//mainFrame layout set to (5,1).
		getMainFrame().setLayout(new GridLayout(5,1));
		
		//panel1
		panel1.setLayout(new GridLayout(1,1));
		
		/* PANEL 2 */
		//panel 2 - Split into three different panels going horizontally - 3 children.
		panel2.setLayout(new GridLayout(1,5));
		//panel 2 left is the first child, out of three on that line. - Split into one panel for the actual biomorph output.
		panel2Left.setLayout(new GridLayout(1,1));
		//panel 2 centre is the second child, out of three on that line. - Split into one panel for the actual biomorph output.
		panel2Centre.setLayout(new GridLayout(1,1));
		//panel 2 right is the third child, out of three on that line. - Split into one panel for the actual biomorph output.
		panel2Right.setLayout(new GridLayout(1,1));
		//panel 2 .. empty panels, so it's alligned with the panel that contains the actual output.
		panel2Gap.setLayout(new GridLayout(1,1));
		panel2Gap2.setLayout(new GridLayout(1,1));
		
		/* PANEL 3 */
		//panel 3 - Split into three different panels going horizontally - 3 children.
		panel3.setLayout(new GridLayout(1,5));
		//panel 2 left is the first child, out of three on that line. - Split into one panel for the actual biomorph output.
		panel3Left.setLayout(new GridLayout(1,1));
		//panel 2 centre is the second child, out of three on that line. - Split into one panel for the actual biomorph output.
		panel3Centre.setLayout(new GridLayout(1,1));
		//panel 2 right is the third  child, out of three on that line. - Split into one panel for the actual biomorph output.
		panel3Right.setLayout(new GridLayout(1,1));
		
		//Gap to split the children bio-morph and the actual output.
		panel3Gap.setLayout(new GridLayout(1,1));
		//Actual output.
		panel3Output.setLayout(new GridLayout(1,1));

		
		/* PANEL 4 */
		//panel 4 - Split into three different panels going horizontally - 3 children.
		panel4.setLayout(new GridLayout(1,5));
		//panel 2 left is the first child, out of three on that line. -  Split into one panel for the actual biomorph output.
		panel4Left.setLayout(new GridLayout(1,1));
		//panel 2 centre is the second child, out of three on that line. -  Split into one panel for the actual biomorph output.
		panel4Centre.setLayout(new GridLayout(1,1));
		//panel 2 right is the third child, out of three on that line. -  Split into one panel for the actual biomorph output.
		panel4Right.setLayout(new GridLayout(1,1));

		//panel 4
		panel4Gap2.setLayout(new GridLayout(2,1));
		saveBiomorph.setLayout(new FlowLayout());
		panelLogo.setLayout(new GridLayout(1,1));

		
		/* PANEL 5 */
		//panel 5 - Split into two vertical panels. One for the sliders and one for the log.
		panel5.setLayout(new GridLayout(2,1));
		panel5Top.setLayout(new GridLayout (1,3));
		panel5Bottom.setLayout(new GridLayout (1,3));
		
		
		

		///////////////////////////////////////////               3. Components \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
		TitledBorder child1 = new TitledBorder("Child 1");
		child1Panel.setBorder(child1);
		TitledBorder child2 = new TitledBorder("Child 2");
		child2Panel.setBorder(child2);
		TitledBorder child3 = new TitledBorder("Child 3");
		child3Panel.setBorder(child3);
		TitledBorder child4 = new TitledBorder("Child 4");
		child4Panel.setBorder(child4);
		TitledBorder child5 = new TitledBorder("Child 5");
		child5Panel.setBorder(child5);
		TitledBorder child6 = new TitledBorder("Child 6");
		child6Panel.setBorder(child6);
		TitledBorder child7 = new TitledBorder("Child 7");
		child7Panel.setBorder(child7);
		TitledBorder child8 = new TitledBorder("Child 8");
		child8Panel.setBorder(child8);
		TitledBorder child9 = new TitledBorder("Child 9");
		child9Panel.setBorder(child9);
		TitledBorder biomorph = new TitledBorder("Output");
		output.setBorder(biomorph);
		TitledBorder systemLog= new TitledBorder("Control Panel");
		panel5Bottom.setBorder(systemLog);
		
		
		//Sliders to adjust genes of bio-morph.
		
		//probability sliders
		Dimension d2 = new Dimension(300,70);

		final LabelledSlider lengthSlider = new LabelledSlider(" Probability of Change  ", 0.0, 0, 20, 100);
		lengthSlider.setPreferredSize(d2);
		
		final LabelledSlider widthSlider = new LabelledSlider(" Adjust Width of Biomorph  ", 0.0, 0, 20, 100);
		widthSlider.setPreferredSize(d2);
		
		final LabelledSlider BranchSlider = new LabelledSlider(" Adjust Thickness of Biomorph  ", 0.0, 0, 20, 100);
		BranchSlider.setPreferredSize(d2);
		
		
		
		//Buttons for control panel and button to save biomorph.

		JButton nextButton = new JButton(); 
		JButton prevButton = new JButton();
		JButton firstButton = new JButton(); 
		JButton saveButton = new JButton(); 

		
		//button properties set
		nextButton.setText("Next");
		prevButton.setText("Previous");
		firstButton.setText("First");
		saveButton.setText("Save");

		
	
		
		
		///////////////////////////////////////////               4. Add panels to mainframe \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

		//(5,1)
		getMainFrame().add(panel1);
		getMainFrame().add(panel2);
		getMainFrame().add(panel3);
		getMainFrame().add(panel4);
		getMainFrame().add(panel5);
		
		
		/* Panel 2*/
		//(1,3) Second panel has the three horizontal panels added to it.
		panel2.add(panel2Left);
		panel2.add(panel2Centre);
		panel2.add(panel2Right);
		panel2.add(panel2Gap);
		panel2.add(panel2Gap2);

		//(1,1) - Contains panel for the child biomorph output.
		panel2Left.add(child1Panel);
		//(1,1) - Contains panel for the child biomorph output.
		panel2Centre.add(child2Panel);
		//(1,1) - Contains panel for the child biomorph output.
		panel2Right.add(child3Panel);
		
		/* Panel 3*/
		//(1,3) Second panel has the three horizontal panels added to it.
		panel3.add(panel3Left);
		panel3.add(panel3Centre);
		panel3.add(panel3Right);
		panel3.add(panel3Gap);
		panel3.add(panel3Output);
		
	    //(1,1) - Contains panel for the child biomorph output.
		panel3Left.add(child4Panel);
		//(1,1) - Contains panel for the child biomorph output.
		panel3Centre.add(child5Panel);
		//(1,1) - Contains panel for the child biomorph output.
		panel3Right.add(child6Panel);
		//(1,1) add biomorph to output panel.
		panel3Output.add(output);
		

		/* Panel 4*/
		//(1,3) Fourth panel has the three horizontal panels added to it.
		panel4.add(panel4Left);
		panel4.add(panel4Centre);
		panel4.add(panel4Right);
		panel4.add(panel4Gap);
		panel4.add(panel4Gap2);

		//(1,1) - Contains panel for the child biomorph output.
		panel4Left.add(child7Panel);
		//(1,1) - Contains panel for the child biomorph output.
		panel4Centre.add(child8Panel);
		//(1,1) - Contains panel for the child biomorph output.
		panel4Right.add(child9Panel);
		//Add panel to save the biomorph and logo to this panel.
		panel4Gap2.add(saveBiomorph);
		panel4Gap2.add(panelLogo);
		saveBiomorph.add(saveButton);


		/* Panel 5*/
		//(2,1) Split into two vertical panels. One for the sliders, and one for the log.
		panel5.add(panel5Top);
		panel5.add(panel5Bottom);
		panel5Top.add(lengthSlider);
		panel5Top.add(widthSlider);
		panel5Top.add(BranchSlider);
		panel5Bottom.add(firstButton);
		panel5Bottom.add(nextButton);
		panel5Bottom.add(prevButton);
		//panel5Bottom.add(firstButton + nextButton + prevButton);
		

		//Exit prompt
		getMainFrame().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		//Add menu
	       //create menus
			JMenuBar menuBar = new JMenuBar();
			
			JMenu file = new JMenu("File");
			JMenu edit = new JMenu("Edit");
			JMenu view = new JMenu("View");
			JMenu tools = new JMenu("Tools");
			JMenu help = new JMenu("Help");
	            
			//Create menu items
			JMenuItem save = new JMenuItem("Save");
			JMenuItem load = new JMenuItem("Load");
			JMenuItem exit = new JMenuItem("Exit");
			JMenuItem error = new JMenuItem("Error Log");
			JMenuItem signature = new JMenuItem("Upload Signature");
			JMenuItem export = new JMenuItem("Export");
			JMenuItem profile = new JMenuItem("Profile");
	            
			//Add items to the menu
			file.add(profile);
			file.add(save);
			file.add(load);
			file.add(export);
			file.add(exit);
	            
			tools.add(signature);
	            
			help.add(error);

			//Add menus
			menuBar.add(file);
			menuBar.add(edit);
			menuBar.add(view);
			menuBar.add(tools);
			menuBar.add(help);
		
		getMainFrame().setJMenuBar(menuBar);
		getMainFrame().pack();
		getMainFrame().setVisible(true);
		
		//Listeners for the menu bar:
		//Exit
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}	
		});
                


	}
	
	//Default exit of the system
	private void exit(){
		int response = JOptionPane
				.showConfirmDialog(getMainFrame(),
						"Do you really want to quit?", "Quit",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			getMainFrame().dispose();
		}
	}

	
	//getters and setters so startscreen can access the main frame.
	public JFrame getMainFrame() {
		return this.mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}


}


