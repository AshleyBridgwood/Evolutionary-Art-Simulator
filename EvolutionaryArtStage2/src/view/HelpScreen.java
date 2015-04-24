package view;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class HelpScreen {

	private JFrame frame;
	JTextArea textArea = new JTextArea();


	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public HelpScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 806, 585);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUltimateEvolution = new JLabel("Ultimate Evolution : Help Screen");
		lblUltimateEvolution.setBounds(196, 30, 413, 27);
		lblUltimateEvolution.setFont(new Font("Calibri", Font.BOLD, 26));
		lblUltimateEvolution.setBackground(Color.ORANGE);
		frame.getContentPane().add(lblUltimateEvolution);
		

		try {

	       //textArea.read(new FileReader("C:\\Users\\ibrahim\\OneDrive\\Documents\\Group\\Help.txt"), null);
	       textArea.read(new FileReader("/EvolutionaryArtStage2/src/view/Help.txt"), null);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//set the horizontal scrollbar to never appear
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//set the horizontal scrollbar to never appear7


		scrollPane.setBounds(26, 94, 729, 382);
		frame.getContentPane().add(scrollPane);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(0, 1, 140, 56);
		frame.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new UserInterface().getFrame().setVisible(true);
			}
		});
		
		//Exit prompt
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

					getFrame().dispose();
			}
			
		});
		
	}
	
	
	public JFrame getFrame() {
		return this.frame;
}
}
