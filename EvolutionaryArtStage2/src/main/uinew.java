/**
 * UI.java
 * 
 * @author Ashley Bridgwood <bridgwa1@aston.ac.uk>
 *
 */
package main;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class uinew {
	
	private JFrame frame;
	private JPanel panel_child;
	private JPanel panel_command;
	
	public uinew(){
		
		frame = new JFrame("Evolutionary Art Generator");	
		//600 = width, 400 height
		frame.setMinimumSize(new Dimension(600, 400));
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		//Child Panel
		panel_child = new JPanel();
		TitledBorder titled = new TitledBorder("Biomorph");
		panel_child.setBorder(titled);
		//panel_child.setBorder(BorderFactory.createEtchedBorder());
		panel_child.setSize(new Dimension(400, 400));
		//panel_child.add(new Biomorph(), BorderLayout.SOUTH);
		
            
		//Buttons
		JButton next = new JButton("Generate Biomorph");
		
		//Button Listners
		//Next Button
		next.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_child.repaint();
			}
		});
		
		
		
		
		//Controll Panel
		//panel_command = new JPanel(new FlowLayout());
		panel_command = new JPanel();
		panel_command.add(next);
			
		//Set the background colours
		//panel_child.setBackground(Color.ORANGE);
		panel_command.setBackground(Color.BLUE);
		
		//Exit prompt
		frame.addWindowListener(new WindowAdapter() {
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
		
		frame.setJMenuBar(menuBar);
		
		//Listeners for the menu bar:
		//Exit
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}	
		});
                
		//Get frame container (the frames panel)
		Container cont = frame.getContentPane();
                
		//Layout to allow adjacent panels
		cont.setLayout(new BoxLayout(cont, BoxLayout.X_AXIS));
                
		//set border
		((JPanel) cont).setBorder(new EmptyBorder(6, 6, 6, 6));
                
		//container pane
		JPanel right_cont = new JPanel(new FlowLayout());
		
		//Adding the parent panel, and command panel to the right panel
		right_cont.add(panel_command);
                
		right_cont.setBorder(new EmptyBorder(6, 6, 6, 6));
                
		right_cont.setLayout(new BoxLayout(right_cont, BoxLayout.Y_AXIS));
		right_cont.setMaximumSize(new Dimension(300, 800));
                
		//Add panel to the frame
		cont.add(panel_child);
		
		cont.add(right_cont);
                
		frame.pack();
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
		}
	}
}

