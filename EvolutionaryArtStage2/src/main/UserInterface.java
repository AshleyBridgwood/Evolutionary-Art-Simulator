/**
 * @author Ibrahim Farah
 */
package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import main.LabelledSlider;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UserInterface extends MouseAdapter{

	private JFrame frame;
	private JButton btnMutate;
	JPanel panelBiomorph1 = new JPanel();
	JPanel panelBiomorph2 = new JPanel();
	JPanel panelBiomorph3 = new JPanel();
	JPanel panelBiomorph4 = new JPanel();
	JPanel panelBiomorph5 = new JPanel();
	JPanel panelBiomorph6 = new JPanel();
	JPanel panelBiomorph7= new JPanel();
	JPanel panelBiomorph8 = new JPanel();
	JPanel panelBiomorph9 = new JPanel();

	
	JPanel[] panels = {panelBiomorph1,panelBiomorph2, panelBiomorph3, panelBiomorph4, panelBiomorph5, panelBiomorph6, 
			panelBiomorph7, panelBiomorph8, panelBiomorph9};


	/**	
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =	new JFrame();
		
		frame.setBounds(100, 100, 1093, 875);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		
		JLabel lblHOF = new JLabel("Hall Of Fame");
		lblHOF.setFont(new Font("Calibri", Font.BOLD, 22));
		lblHOF.setBackground(Color.ORANGE);
		lblHOF.setBounds(469, 0, 130, 35);
		frame.getContentPane().add(lblHOF);
		
		JPanel HOFPanel1 = new JPanel();
		HOFPanel1.setForeground(Color.BLACK);
		HOFPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		HOFPanel1.setBackground(SystemColor.menu);
		HOFPanel1.setBounds(207, 36, 210, 133);
		frame.getContentPane().add(HOFPanel1);
		
		JPanel HOFPanel2 = new JPanel();
		HOFPanel2.setForeground(Color.BLACK);
		HOFPanel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		HOFPanel2.setBackground(SystemColor.menu);
		HOFPanel2.setBounds(429, 36, 210, 133);
		frame.getContentPane().add(HOFPanel2);
		
		JPanel HOFPanel3 = new JPanel();
		HOFPanel3.setForeground(Color.BLACK);
		HOFPanel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		HOFPanel3.setBackground(SystemColor.menu);
		HOFPanel3.setBounds(651, 36, 210, 133);
		frame.getContentPane().add(HOFPanel3);
		
		JLabel lblBiomorph = new JLabel("Biomorph Children");
		lblBiomorph.setFont(new Font("Calibri", Font.BOLD, 22));
		lblBiomorph.setBackground(Color.ORANGE);
		lblBiomorph.setBounds(254, 193, 210, 35);
		frame.getContentPane().add(lblBiomorph);
		
		panelBiomorph1.setForeground(Color.BLACK);
		panelBiomorph1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph1.setBackground(SystemColor.menu);
		panelBiomorph1.setBounds(22, 241, 210, 133);
		panelBiomorph1.add(BioController.displayChildren(1));
		frame.getContentPane().add(panelBiomorph1);
		
		panelBiomorph2.setForeground(Color.BLACK);
		panelBiomorph2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph2.setBackground(SystemColor.menu);
		panelBiomorph2.setBounds(241, 241, 210, 133);
		panelBiomorph2.add(BioController.displayChildren(2));
		frame.getContentPane().add(panelBiomorph2);
		
		panelBiomorph3.setForeground(Color.BLACK);
		panelBiomorph3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph3.setBackground(SystemColor.menu);
		panelBiomorph3.setBounds(460, 241, 210, 133);
		panelBiomorph3.add(BioController.displayChildren(3));
		frame.getContentPane().add(panelBiomorph3);
		
		panelBiomorph4.setForeground(Color.BLACK);
		panelBiomorph4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph4.setBackground(SystemColor.menu);
		panelBiomorph4.setBounds(22, 376, 210, 133);
		panelBiomorph4.add(BioController.displayChildren(4));
		frame.getContentPane().add(panelBiomorph4);
		
		panelBiomorph5.setForeground(Color.BLACK);
		panelBiomorph5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph5.setBackground(SystemColor.menu);
		panelBiomorph5.setBounds(241, 376, 210, 133);
		panelBiomorph5.add(BioController.displayChildren(5));
		frame.getContentPane().add(panelBiomorph5);
		
		panelBiomorph6.setForeground(Color.BLACK);
		panelBiomorph6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph6.setBackground(SystemColor.menu);
		panelBiomorph6.setBounds(460, 376, 210, 133);
		panelBiomorph6.add(BioController.displayChildren(6));
		frame.getContentPane().add(panelBiomorph6);
		
		panelBiomorph7.setForeground(Color.BLACK);
		panelBiomorph7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph7.setBackground(SystemColor.menu);
		panelBiomorph7.setBounds(22, 513, 210, 133);
		panelBiomorph7.add(BioController.displayChildren(7));
		frame.getContentPane().add(panelBiomorph7);
		
		panelBiomorph8.setForeground(Color.BLACK);
		panelBiomorph8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph8.setBackground(SystemColor.menu);
		panelBiomorph8.setBounds(241, 513, 210, 133);
		panelBiomorph8.add(BioController.displayChildren(8));
		frame.getContentPane().add(panelBiomorph8);
		
		panelBiomorph9.setForeground(Color.BLACK);
		panelBiomorph9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorph9.setBackground(SystemColor.menu);
		panelBiomorph9.setBounds(460, 513, 210, 133);
		panelBiomorph9.add(BioController.displayChildren(9));
		frame.getContentPane().add(panelBiomorph9);
		
		JLabel lblFinalOutput = new JLabel("Final Output");
		lblFinalOutput.setFont(new Font("Calibri", Font.BOLD, 22));
		lblFinalOutput.setBackground(Color.ORANGE);
		lblFinalOutput.setBounds(821, 195, 120, 35);
		frame.getContentPane().add(lblFinalOutput);
		
		JPanel panelOutput = new JPanel();
		panelOutput.setForeground(Color.BLACK);
		panelOutput.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelOutput.setBackground(SystemColor.menu);
		panelOutput.setBounds(736, 237, 311, 175);
		panelOutput.add(BioController.displayParent());
		frame.getContentPane().add(panelOutput);
		
		btnMutate = new JButton("Mutate !");
		btnMutate.setBounds(736, 414, 311, 43);
		frame.getContentPane().add(btnMutate);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setForeground(Color.BLACK);
		controlPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		controlPanel.setBackground(SystemColor.menu);
		controlPanel.setBounds(22, 662, 1025, 153);
		controlPanel.setLayout(new GridLayout(2,1));
		
		//Sliders to adjust genes of bio-morph.
		//probability sliders
		Dimension d2 = new Dimension(300,70);
		JPanel sliderPanel = new JPanel();
		final LabelledSlider probSlider = new LabelledSlider(" Probability of Change  ", 0.0, 0, 20, 100);
		probSlider.setBounds(55, 5, 300, 70);
		probSlider.setPreferredSize(d2);
		final LabelledSlider widthSlider = new LabelledSlider(" Adjust Width of Biomorph  ", 0.0, 0, 20, 100);
		widthSlider.setBounds(360, 5, 300, 70);
     	widthSlider.setPreferredSize(d2);	
		final LabelledSlider BranchSlider = new LabelledSlider(" Adjust Thickness of Biomorph  ", 0.0, 0, 20, 100);
		BranchSlider.setBounds(665, 5, 300, 70);
		BranchSlider.setPreferredSize(d2);
		
		//Button Control
		JPanel buttonPanel = new JPanel();
		JButton helpButton = new JButton("Help"); 
		//Action listeners for load button. Directs it to the loading screenI.
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HelpScreen().getFrame().setVisible(true);
			}
		});
		
		
		helpButton.setBounds(611, 13, 166, 56);
		JButton undoutton = new JButton("Undo");
		undoutton.setBounds(168, 13, 166, 56);
		JButton menuButton = new JButton("Home"); 
		menuButton.setBounds(388, 13, 166, 56);
		buttonPanel.setLayout(null);
		
		
		buttonPanel.add(helpButton);
		buttonPanel.add(undoutton);
		buttonPanel.add(menuButton);
		sliderPanel.setLayout(null);
		sliderPanel.add(probSlider);
		sliderPanel.add(widthSlider);
		sliderPanel.add(BranchSlider);
		controlPanel.add(sliderPanel);
		controlPanel.add(buttonPanel);

		frame.getContentPane().add(controlPanel);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setForeground(Color.BLACK);
		panelLogo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelLogo.setBackground(SystemColor.menu);
		panelLogo.setBounds(736, 470, 311, 127);
		
		// add logo to panel 4.
		JLabel logoImage = new JLabel();
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("untitled-2.png"));
		Image l = logoIcon.getImage();
		Image logo = l.getScaledInstance(550, 120, Image.SCALE_DEFAULT);
		ImageIcon scaledLogo = new ImageIcon(logo);
		logoImage.setIcon(scaledLogo);
		panelLogo.add(logoImage);
		frame.getContentPane().add(panelLogo);
		
		JButton btnSave = new JButton("Save!");
		btnSave.setBounds(736, 603, 311, 43);
		frame.getContentPane().add(btnSave);
		
		//Action listener for new button. Directs it to the main screen of the UI.
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartScreen().getFrame().setVisible(true);
				frame.setVisible(false);

			}
		});
		
		//Action listener for new button. Directs it to the main screen of the UI.
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaveBiomorph().getFrame().setVisible(true);
			}
		});

		
		///////////////////////////////////////////   Mouse Listener so panels can be clicked!\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		panelBiomorph1.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < panels.length; i++){
					panels[i].setBackground(SystemColor.menu);
				}
				panelBiomorph1.setBackground(Color.GREEN);
			}
			});
		
		
		panelBiomorph2.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < panels.length; i++){
					panels[i].setBackground(SystemColor.menu);
				}
				panelBiomorph2.setBackground(Color.GREEN);
			}
			});
		
		panelBiomorph3.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < panels.length; i++){
					panels[i].setBackground(SystemColor.menu);
				}
				panelBiomorph3.setBackground(Color.GREEN);
			}
			});
		
		panelBiomorph4.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < panels.length; i++){
					panels[i].setBackground(SystemColor.menu);
				}
				panelBiomorph4.setBackground(Color.GREEN);
			}
			});
		
		panelBiomorph5.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < panels.length; i++){
					panels[i].setBackground(SystemColor.menu);
				}
				panelBiomorph5.setBackground(Color.GREEN);
			}
			});
		
		panelBiomorph6.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < panels.length; i++){
					panels[i].setBackground(SystemColor.menu);
				}
				panelBiomorph6.setBackground(Color.GREEN);
			}
			});
	
		panelBiomorph7.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < panels.length; i++){
					panels[i].setBackground(SystemColor.menu);
				}
				panelBiomorph7.setBackground(Color.GREEN);
			}
			});
		
		panelBiomorph8.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < panels.length; i++){
					panels[i].setBackground(SystemColor.menu);
				}
				panelBiomorph8.setBackground(Color.GREEN);
			}
			});
		
		panelBiomorph9.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBiomorph9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelBiomorph9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < panels.length; i++){
					panels[i].setBackground(SystemColor.menu);
				}
				panelBiomorph9.setBackground(Color.GREEN);
			}
			});
	}
	
	//getter so startscreen can access the main frame.
	public JFrame getFrame() {
			return this.frame;
	}
}