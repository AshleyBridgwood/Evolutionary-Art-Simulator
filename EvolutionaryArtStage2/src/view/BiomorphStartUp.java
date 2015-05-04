/**
 * @author Ibrahim Farah
 */

package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.BioController;

public class BiomorphStartUp {

	private JFrame frame;
	private static JPanel biomorphPanel = new JPanel();
	static int lineAmountChoice;
	static LabelledSlider lineAmountSlider = new LabelledSlider(" Amount of Lines  ", 20, 10, 30, 1);

	public BiomorphStartUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

		

		biomorphPanel.setForeground(Color.BLACK);
		biomorphPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		biomorphPanel.setBackground(SystemColor.menu);
		biomorphPanel.setBounds(190, 144, 311, 175);
		BioController.generateBiomorphs(); //generate a new random biomorph
		biomorphPanel.add(BioController.displayParent());
		frame.getContentPane().add(biomorphPanel);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(190, 321, 154, 43);
		frame.getContentPane().add(btnGenerate);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(347, 321, 154, 43);
		frame.getContentPane().add(btnNext);
	
		lineAmountSlider.setBounds(261, 73, 150, 70); 
		frame.getContentPane().add(lineAmountSlider);
		
		JLabel lblChooseYourBiomorph = new JLabel("Choose Your Biomorph!");
		lblChooseYourBiomorph.setFont(new Font("Calibri", Font.BOLD, 22));
		lblChooseYourBiomorph.setBackground(Color.ORANGE);
		lblChooseYourBiomorph.setBounds(234, 13, 236, 35);
		frame.getContentPane().add(lblChooseYourBiomorph);
		
		JLabel lblClickGenerateUntil = new JLabel("Click generate until you find the biomoph of your choice!");
		lblClickGenerateUntil.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblClickGenerateUntil.setBackground(Color.ORANGE);
		lblClickGenerateUntil.setBounds(121, 50, 508, 26);
		frame.getContentPane().add(lblClickGenerateUntil);
		
		JPanel navPanel = new JPanel();
		navPanel.setBounds(0, 382, 711, 70);
		frame.getContentPane().add(navPanel);
		navPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		navPanel.setLayout(null);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(156, 13, 166, 44);
		navPanel.add(btnHome);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(373, 13, 166, 44);
		navPanel.add(btnHelp);
	
		//Action listener for the generate button. Regenerates a new biomorph
		btnGenerate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				biomorphPanel.removeAll();
				BioController.generateBiomorphs();
				biomorphPanel.add(BioController.displayParent());
				biomorphPanel.validate();
				biomorphPanel.repaint();
			}
		});
		
		//Action listeners for next button. Directs it to the main screen of the UI.
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BioController.startMainScreen();
				frame.setVisible(false);
			}
		});
		
		//Action listener for home button. Directs it to the home screen of the UI.
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartScreen().getFrame().setVisible(true);
				frame.setVisible(false);

			}
		});
		
		//Action listener for help button. Directs it to the help screen of the UI.
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HelpScreen().getFrame().setVisible(true);
			}
		});
}
	
	
	public static int getSliderValue()
	{
		return lineAmountSlider.getValue().intValue();
	}
	
	public JFrame getFrame() {
		return this.frame;
}
}
