/**
 * DESCRIPTION OF THE CLASS
 * @author Ibrahim Farah
 */

package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class StartScreen{
    private JFrame startFrame;
	JPanel panel1 = new JPanel();
	JPanel panelOne = new JPanel();
	JPanel panelLogo = new JPanel();

	JPanel panel2 = new JPanel();
	JPanel panel2Top = new JPanel();
	JPanel panel2Middle = new JPanel();
	JPanel panel2Bottom = new JPanel();
	
	JButton newButton = new JButton(); 

    
    public StartScreen(){
    	
    	//.............................................. Initialise Main Screen ....................................................\\
		//mainFrame
		startFrame = new JFrame("Graphical User Interface");
		//mainFrame properties
		Dimension d = new Dimension (900,500); //dimensions set to be used as parameter for mainFrame.setPreferedSize(d) method.
		startFrame.setPreferredSize(d); // not set in step 2 because mainFrame variable not initialised.
		startFrame.setResizable(false);

    	
    	
    	//.............................................. Add Logo ....................................................\\
		JPanel logoPanel = new JPanel();
		
		JLabel logoImage = new JLabel();
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("untitled-2.png"));
		Image l = logoIcon.getImage();
		Image logo = l.getScaledInstance(550, 200, Image.SCALE_DEFAULT);
		ImageIcon scaledLogo = new ImageIcon(logo);
		logoImage.setIcon(scaledLogo);
		logoPanel.add(logoImage);
		panelLogo.add(logoPanel);
		
	    
    	//.............................................. Components ....................................................\\

		//Buttons for control panel and button to save biomorph.
		JButton loadButton = new JButton();
		JButton helpButton = new JButton(); 

		
		//button properties set
		newButton.setText("New Biomorph");
		loadButton.setText("Existing Biomorph");
		helpButton.setText("Help");
    	
    	//.............................................. Specify Layout Manager ....................................................\\

    	
		//mainFrame layout set to (2,1).
		startFrame.setLayout(new GridLayout(2,1));
		//panel1
		panel1.setLayout(new GridLayout(1,1));
		panelLogo.setLayout(new GridLayout(1,1));
		
		//panel2
		panel2.setLayout(new GridLayout(3,1));
		panel2Top.setLayout(new GridLayout(1,1));
		panel2Middle.setLayout(new GridLayout(1,1));
		panel2Bottom.setLayout(new GridLayout(1,1));
		
		panel2Top.add(newButton);
		panel2Middle.add(loadButton);
		panel2Bottom.add(helpButton);


		
    	//.............................................. Adding Components to Panel ....................................................\\

		panelOne.add(panelLogo);
		panel1.add(panelOne);
		panel2.add(panel2Top);
		panel2.add(panel2Middle);
		panel2.add(panel2Bottom);


    	//.............................................. Add Panels to Mainframe ....................................................\\

		startFrame.add(panel1);
		startFrame.add(panel2);
		
		
		//Action listeners for new button. Directs it to the main screen of the UI.
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BioController.start();
				startFrame.setVisible(false);

			}
		});
		
		//Action listeners for load button. Directs it to the loading screen.
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoadBiomorph().getFrame().setVisible(true);
				startFrame.setVisible(false);
			}
		});
		
		//Action listeners for help button. Directs it to the help screen.
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HelpScreen().getFrame().setVisible(true);
			}
		});
		
        //display frame
		startFrame.pack();
		startFrame.setVisible(true);
    }
    
    
	//Default exit of the system
	@SuppressWarnings("unused")
	private void exit(){
		int response = JOptionPane
				.showConfirmDialog(startFrame,
						"Do you really want to quit?", "Quit",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			startFrame.dispose();
		}
	}
	
	public JFrame getFrame() {
		return this.startFrame;
}

}
