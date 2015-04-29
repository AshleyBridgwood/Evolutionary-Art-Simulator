/**
 * @author Ibrahim Farah
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
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
	JPanel mainPanel = new JPanel();
    ArrayList<String> loadedNames = BioController.getSavedFileNames();



	/**
	 * Create the application.
	 */
	public LoadBiomorph() {
		initialize();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1128, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane(mainPanel); // scroll pane that will contain all saved biomorphs.
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//set the horizontal scrollbar to never appear
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//set the horizontal scrollbar to never appear
		scrollPane.setBounds(50, 178, 672, 448);
		frame.getContentPane().add(scrollPane);
		
		JButton btnImport = new JButton("Import Own Bomorph");
		btnImport.setBounds(49, 128, 201, 52);
		frame.getContentPane().add(btnImport);
		
		panelBiomorphs.setForeground(Color.BLACK);
		panelBiomorphs.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorphs.setBackground(SystemColor.menu);
		
		panelLoaded.setBounds(770, 178, 311, 172);
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
		
		JButton btnNext = new JButton("Load Biomorph"); 
		btnNext.setBounds(831, 369, 201, 52);
		frame.getContentPane().add(btnNext);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BioController.startMainScreen();
				frame.setVisible(false);
			}
		});
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartScreen().getFrame().setVisible(true);
				frame.dispose();

			}
		});
		btnHome.setBounds(831, 456, 201, 52);
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

		mainPanel.setForeground(Color.BLACK);
		mainPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		mainPanel.setBackground(SystemColor.menu);
		mainPanel.setPreferredSize(new Dimension(487, 797));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

       int numberOfLoops = loadedNames.size();
       int id = 0;
			for (int x = 0; x < 16; x++){
			     final JPanel panel = new JPanel();
					panel.setForeground(Color.RED);
					panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), null));
					panel.setPreferredSize(new Dimension(487, 797));
					if(x < numberOfLoops){
						panel.add(new JLabel(loadedNames.get(x)));
						BioController.setLoadId(x);
						
						//add mouse listener to each panel, so they can be loaded.
						panel.addMouseListener(new MouseListener() {
							@Override
							public void mouseClicked(MouseEvent e) {
								panel.setBackground(Color.GREEN);
								BioController.loadBiomorphsFromFile(loadedNames); 
								
								panelLoaded.removeAll();
								BioController.loadHallOfFameBiomorphs();
								panelLoaded.add(BioController.displayParent());
								panelLoaded.repaint();
								panelLoaded.revalidate();
							}
							
							@Override
							public void mouseEntered(MouseEvent e) {	
							}

							@Override
							public void mouseExited(MouseEvent e) {
							}

							@Override
							public void mousePressed(MouseEvent e) {
							}

							@Override
							public void mouseReleased(MouseEvent e) {
							}

						});
					}
				 mainPanel.add(panel);

			}
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
}
