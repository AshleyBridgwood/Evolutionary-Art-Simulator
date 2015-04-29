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

public class History {

	private JFrame frame;
	private JPanel biomorphPanel = new JPanel();

	public History() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		biomorphPanel.setForeground(Color.BLACK);
		biomorphPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		biomorphPanel.setBackground(SystemColor.menu);
		biomorphPanel.setBounds(190, 132, 311, 175);
		BioController.generateBiomorphs();
		biomorphPanel.add(BioController.displayParent());
		frame.getContentPane().add(biomorphPanel);
		
		JLabel lblChooseYourBiomorph = new JLabel("Biomorph History!");
		lblChooseYourBiomorph.setFont(new Font("Calibri", Font.BOLD, 22));
		lblChooseYourBiomorph.setBackground(Color.ORANGE);
		lblChooseYourBiomorph.setBounds(239, 13, 236, 35);
		frame.getContentPane().add(lblChooseYourBiomorph);
		
		JPanel navPanel = new JPanel();
		navPanel.setBounds(0, 373, 711, 70);
		frame.getContentPane().add(navPanel);
		navPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		navPanel.setLayout(null);
		
	
		//Action listener for the generate button. Regenerates a new biomorph
		/*btnGenerate.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			}
		});*/
	} 
	
	public JFrame getFrame() {
		return this.frame;
}
}
