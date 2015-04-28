/**
 * @author Ibrahim Farah
 */

package view;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.Font;

import javax.swing.JScrollPane;

import model.BioController;

public class LoadBiomorph {

	private JFrame frame;
	JPanel panelBiomorphs = new JPanel(); // panel to contain all of the loaded biomorphs.
	JPanel panelLoaded = new JPanel(); // panel to contain the selected biomorph 
	JScrollPane scrollPane = new JScrollPane(); // scroll pane that will contain all saved biomorphs.


	/**
	 * Create the application.
	 */
	public LoadBiomorph() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 947, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//set the horizontal scrollbar to never appear
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//set the horizontal scrollbar to never appear7
		
		JButton btnImport = new JButton("Import Own Bomorph");
		btnImport.setBounds(49, 128, 201, 52);
		frame.getContentPane().add(btnImport);
		
		panelBiomorphs.setForeground(Color.BLACK);
		panelBiomorphs.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorphs.setBackground(SystemColor.menu);
		
		panelLoaded.setBounds(549, 195, 311, 172);
		panelLoaded.setForeground(Color.BLACK);
		panelLoaded.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelLoaded.setBackground(SystemColor.menu);
		frame.getContentPane().add(panelLoaded);
		
		JLabel lblChooseFromList = new JLabel();
		//("Choose from list of saved biomorphs, or click the import button on the left to import your own!");
		lblChooseFromList.setText("<html><body>Choose from list of saved biomorphs, or click the<br>import button on the left to import your own!</body></html>");
		lblChooseFromList.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblChooseFromList.setBackground(Color.ORANGE);
		lblChooseFromList.setBounds(49, 57, 841, 52);
		frame.getContentPane().add(lblChooseFromList);
		
		JLabel lblLoadYourBiomorph = new JLabel("Load Your Biomorph!");
		lblLoadYourBiomorph.setFont(new Font("Calibri", Font.BOLD, 22));
		lblLoadYourBiomorph.setBackground(Color.ORANGE);
		lblLoadYourBiomorph.setBounds(321, 13, 236, 35);
		frame.getContentPane().add(lblLoadYourBiomorph);
		
		scrollPane.setBounds(50, 178, 441, 310);
		frame.getContentPane().add(scrollPane);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(610, 380, 201, 52);
		frame.getContentPane().add(btnNext);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartScreen().getFrame().setVisible(true);
				frame.dispose();

			}
		});
		btnHome.setBounds(610, 467, 201, 52);
		frame.getContentPane().add(btnHome);

		
		//Action listener for export button. Directs it to the main screen of the UI.
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				//Import(filename);
				panelLoaded.add(new ImagePanel(filename));
				
				
				frame.setVisible(true);
			}
		});
		
		loadBiomorphs();
	}
	
	public void loadBiomorphs(){		
		int i = BioController.getNumOfSavedBiomorphs();
		System.out.println(i);
		scrollPane.getViewport().add(panelBiomorphs);
		
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
}
