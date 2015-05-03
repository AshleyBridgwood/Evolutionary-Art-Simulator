/**
 * @author Ibrahim Farah
 */

package view;


import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

import model.BioController;

public class SaveBiomorph {

	private JFrame frame;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */

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
		frame.setBounds(100, 100, 685, 244);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panel.setBounds(0, 131, 679, 62);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.CYAN);
		btnSave.setBounds(432, 13, 98, 38);
		panel.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(557, 13, 98, 38);
		panel.add(btnCancel);
		
		JLabel lblName = new JLabel("Author Name");
		lblName.setFont(new Font("Calibri", Font.BOLD, 22));
		lblName.setBounds(85, 35, 144, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblLevelOfAccess = new JLabel("Level Of Access");
		lblLevelOfAccess.setFont(new Font("Calibri", Font.BOLD, 22));
		lblLevelOfAccess.setBounds(85, 89, 144, 16);
		frame.getContentPane().add(lblLevelOfAccess);
		
		txtName = new JTextField();
		txtName.setBounds(274, 32, 286, 24);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
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
				
				int size = BioController.getNumOfSavedBiomorphs();
				
				String fileName= txtName.getText().replaceAll("\\W","") + size;
				BioController.saveCurrentBiomorphsToFile(fileName);
				frame.dispose();
			}
		});
		
		//Action listener for save button. Confirmation of saved file.
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		//Exit prompt
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
					getFrame().dispose();
			}	
		});
		
	}

	//getter so mainscreen can access the main frame.
	public JFrame getFrame() {
			return this.frame;
	}
	
	public static void saved(boolean saved){
		if (saved == true){
			JOptionPane.showMessageDialog(null, "File Successfully Saved");
			UserInterface.setChanged(false);
		} else {
			JOptionPane.showMessageDialog(null, "File not saved!");
		}
	}
	
}
