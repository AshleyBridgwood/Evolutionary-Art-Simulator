/**
 * Displays the help screen
 * 
 * @author Ibrahim Farah
 * 
 */

package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.IOException;

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
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2); //centralises frame
		
		JLabel lblUltimateEvolution = new JLabel("Ultimate Evolution : Help Screen");
		lblUltimateEvolution.setBounds(196, 30, 413, 27);
		lblUltimateEvolution.setFont(new Font("Calibri", Font.BOLD, 26));
		lblUltimateEvolution.setBackground(Color.ORANGE);
		frame.getContentPane().add(lblUltimateEvolution);
		

		try {
	       textArea.read(new FileReader("src/view/Help.txt"), null); //reads text file and adds it to the JTextArea
	       textArea.setEditable(false);
	       
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane(textArea); // adds the textarea to the scroll pane.
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//set the horizontal scrollbar to never appear
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//set the horizontal scrollbar to never appear
		scrollPane.setBounds(26, 94, 729, 382);
		frame.getContentPane().add(scrollPane);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(0, 1, 140, 56);
		frame.getContentPane().add(btnHome);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new StartScreen().getFrame().setVisible(true);
				frame.setVisible(false);
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
