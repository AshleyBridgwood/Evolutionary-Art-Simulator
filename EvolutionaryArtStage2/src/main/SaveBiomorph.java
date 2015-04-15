package main;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class SaveBiomorph {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveBiomorph window = new SaveBiomorph();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaveBiomorph() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 685, 286);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panel.setBounds(0, 189, 679, 62);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.CYAN);
		btnSave.setBounds(432, 13, 98, 38);
		panel.add(btnSave);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(557, 13, 98, 38);
		panel.add(btnNewButton);
		
		JLabel lblName = new JLabel("Author Name");
		lblName.setFont(new Font("Calibri", Font.BOLD, 22));
		lblName.setBounds(85, 35, 144, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblLevelOfAccess = new JLabel("Level Of Access");
		lblLevelOfAccess.setFont(new Font("Calibri", Font.BOLD, 22));
		lblLevelOfAccess.setBounds(85, 89, 144, 16);
		frame.getContentPane().add(lblLevelOfAccess);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Calibri", Font.BOLD, 22));
		lblDate.setBounds(85, 139, 144, 16);
		frame.getContentPane().add(lblDate);
		
		txtName = new JTextField();
		txtName.setBounds(274, 32, 286, 24);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setEnabled(false);
		txtDate.setColumns(10);
		txtDate.setBounds(274, 131, 286, 24);
		frame.getContentPane().add(txtDate);
		
		JRadioButton publicAccess = new JRadioButton("Public");
		publicAccess.setBounds(274, 86, 127, 25);
		frame.getContentPane().add(publicAccess);
		
		JRadioButton readOnly = new JRadioButton("Read Only");
		readOnly.setBounds(398, 86, 127, 25);
		frame.getContentPane().add(readOnly);
		
		//group the two radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(publicAccess);
	    group.add(readOnly);
	    
	    
		//Action listener for save button. Confirmation of saved file.
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        JOptionPane.showMessageDialog(null, "File Successfully Saved");
				frame.setVisible(false);

			}
		});


	}
	
	//getter so mainscreen can access the main frame.
	public JFrame getFrame() {
			return this.frame;
	}
}
