/**
 * DESCRIPTION OF THE CLASS
 * @author Ibrahim Farah
 */

package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class StartScreen{
    private JFrame frame;
	JPanel panel1 = new JPanel();
	JPanel panelOne = new JPanel();
	JPanel panelLogo = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel2Top = new JPanel();
	JPanel panel2Middle = new JPanel();
	JPanel panel2Bottom = new JPanel();
	JButton newButton = new JButton(); 

    public StartScreen(){
    	
		frame = new JFrame("Ultimate Evolution");
		frame.setBounds(100, 100, 1000, 500);
		Dimension d = new Dimension (900,500); 
		frame.setPreferredSize(d);
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		
		

    	
    	
    	//.............................................. Add Logo ....................................................\\
		JPanel logoPanel = new JPanel();
		
		JLabel logoImage = new JLabel();
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("Untitled-2.png"));
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
		frame.setLayout(new GridLayout(2,1));
		//panel1
		panel1.setLayout(new GridLayout(1,1));
		panelLogo.setLayout(new GridLayout(1,1));
		
		//panel2
		panel2.setLayout(new GridLayout(3,1));
		panel2Top.setLayout(new FlowLayout());
		panel2Middle.setLayout(new FlowLayout());
		panel2Bottom.setLayout(new FlowLayout());
		
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

		frame.add(panel1);
		frame.add(panel2);
		
		
        //Listener if window is crossed off
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
                
                
		//Action listeners for new button. Directs it to the main screen of the UI.
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BiomorphStartUp().getFrame().setVisible(true);
				frame.setVisible(false);

			}
		});
		
		//Action listeners for load button. Directs it to the loading screen.
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoadBiomorph().getFrame().setVisible(true);
				frame.setVisible(false);
			}
		});
		
		//Action listeners for help button. Directs it to the help screen.
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HelpScreen().getFrame().setVisible(true);
			}
		});

		frame.setVisible(true);
    }
    
    
	//Default exit of the system
	private void exit(){
		int response = JOptionPane
				.showConfirmDialog(frame,
						"Do you really want to quit?", "Quit",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			frame.dispose();
                        System.exit(0);
		}
	}
	
	public JFrame getFrame() {
		return this.frame;
}

}
