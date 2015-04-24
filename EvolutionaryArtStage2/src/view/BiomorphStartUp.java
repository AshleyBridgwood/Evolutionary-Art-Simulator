/**
 * @author Ibrahim Farah
 */

package view;

import java.awt.EventQueue;

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
	private JPanel biomorphPanel = new JPanel();

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

		

		biomorphPanel.setForeground(Color.BLACK);
		biomorphPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		biomorphPanel.setBackground(SystemColor.menu);
		biomorphPanel.setBounds(190, 132, 311, 175);
		BioController.generateBiomorphs();
		biomorphPanel.add(BioController.displayParent());
		frame.getContentPane().add(biomorphPanel);
		
		JLabel lblBiomorph = new JLabel("Biomorph");
		lblBiomorph.setFont(new Font("Calibri", Font.BOLD, 22));
		lblBiomorph.setBackground(Color.ORANGE);
		lblBiomorph.setBounds(296, 89, 120, 35);
		frame.getContentPane().add(lblBiomorph);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(190, 309, 154, 43);
		frame.getContentPane().add(btnGenerate);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(347, 309, 154, 43);
		frame.getContentPane().add(btnNext);
		
		JLabel lblChooseYourBiomorph = new JLabel("Choose Your Biomorph!");
		lblChooseYourBiomorph.setFont(new Font("Calibri", Font.BOLD, 22));
		lblChooseYourBiomorph.setBackground(Color.ORANGE);
		lblChooseYourBiomorph.setBounds(239, 13, 236, 35);
		frame.getContentPane().add(lblChooseYourBiomorph);
		
		JLabel lblClickGenerateUntil = new JLabel("Click generate until you find the biomoph of your choice!");
		lblClickGenerateUntil.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblClickGenerateUntil.setBackground(Color.ORANGE);
		lblClickGenerateUntil.setBounds(121, 50, 508, 26);
		frame.getContentPane().add(lblClickGenerateUntil);
		
		JPanel navPanel = new JPanel();
		navPanel.setBounds(0, 373, 711, 70);
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
		
		//Action listeners for new button. Directs it to the main screen of the UI.
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BioController.startMainScreen();
				frame.setVisible(false);
			}
		});
		
		//Action listener for new button. Directs it to the main screen of the UI.
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartScreen().getFrame().setVisible(true);
				frame.setVisible(false);

			}
		});
		
		//Action listener for new button. Directs it to the main screen of the UI.
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HelpScreen().getFrame().setVisible(true);
			}
		});
	}
	
	public JFrame getFrame() {
		return this.frame;
}
}
