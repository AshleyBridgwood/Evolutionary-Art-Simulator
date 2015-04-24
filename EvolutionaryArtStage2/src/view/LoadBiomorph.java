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

public class LoadBiomorph {

	private JFrame frame;
	JPanel panelImported = new JPanel();



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
		
		JButton btnImport = new JButton("Import Own Bomorph");
		btnImport.setBounds(49, 128, 201, 52);
		frame.getContentPane().add(btnImport);
		

		panelImported.setBounds(549, 195, 311, 172);
		panelImported.setForeground(Color.BLACK);
		panelImported.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelImported.setBackground(SystemColor.menu);
		frame.getContentPane().add(panelImported);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
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
				panelImported.add(new ImagePanel(filename));
				
				
				frame.setVisible(true);
			}
		});
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
}
