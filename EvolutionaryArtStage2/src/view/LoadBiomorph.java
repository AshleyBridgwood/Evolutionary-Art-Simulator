/**
 * @author Ibrahim Farah
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
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
    boolean panelSelected = false;
    



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
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		
		JScrollPane scrollPane = new JScrollPane(mainPanel); // scroll pane that will contain all saved biomorphs.
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//set the horizontal scrollbar to never appear
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//set the horizontal scrollbar to never appear
		scrollPane.setBounds(50, 178, 672, 448);
		frame.getContentPane().add(scrollPane);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(770, 430, 154, 52);
		frame.getContentPane().add(btnRemove);
		
		panelBiomorphs.setForeground(Color.BLACK);
		panelBiomorphs.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelBiomorphs.setBackground(SystemColor.menu);
		
		panelLoaded.setBounds(770, 253, 311, 172);
		panelLoaded.setForeground(Color.BLACK);
		panelLoaded.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		panelLoaded.setBackground(SystemColor.menu);
		frame.getContentPane().add(panelLoaded);
		
		JLabel lblChooseFromList = new JLabel();
		//("Choose from list of saved biomorphs, or click the import button on the left to import your own!");
		lblChooseFromList.setText("<html><body>Hover the list of file names to see the biomorphs. Click on the filename so you can load it into the main screen!"
				+ "<br>Click the 'remove' button, to be able to browse the list again! </body></html>");
		lblChooseFromList.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblChooseFromList.setBackground(Color.ORANGE);
		lblChooseFromList.setBounds(77, 72, 971, 80);
		frame.getContentPane().add(lblChooseFromList);
		
		JLabel lblLoadYourBiomorph = new JLabel("Load Your Biomorph!");
		lblLoadYourBiomorph.setFont(new Font("Calibri", Font.BOLD, 22));
		lblLoadYourBiomorph.setBackground(Color.ORANGE);
		lblLoadYourBiomorph.setBounds(415, 24, 236, 35);
		frame.getContentPane().add(lblLoadYourBiomorph);
		
		JButton btnNext = new JButton("Load Biomorph"); 
		btnNext.setBounds(927, 430, 154, 52);
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
		btnHome.setBounds(0, 0, 148, 52);
		frame.getContentPane().add(btnHome);

		
		//Action listener for export button. Directs it to the main screen of the UI.
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSelected = false;
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
			for (int x = 0; x < loadedNames.size(); x++){
			     final JPanel panel = new JPanel();
					panel.setForeground(Color.RED);
					panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), null));
					panel.setPreferredSize(new Dimension(487, 797));
					if(x < numberOfLoops){
						final JLabel fileName = new JLabel(loadedNames.get(x));
						panel.add(fileName);
						final String path = fileName.getText();

						
						//add mouse listener to each panel, so they can be loaded.
						panel.addMouseListener(new MouseListener() {
							@Override
							public void mouseClicked(MouseEvent e) {
							
							if (panelSelected == false){
								BioController.loadBiomorphsFromFile(path); 
								panelLoaded.removeAll();
								panelLoaded.add(BioController.displayParent());
								panelLoaded.repaint();
								panelLoaded.revalidate();
								panelSelected = true;
							}
							else
							{
								panelSelected = false;
							}
							
								
							}
							
							@Override
							public void mouseEntered(MouseEvent e) {
								if (panelSelected == false){
									panel.setBackground(Color.GREEN);
									BioController.loadBiomorphsFromFile(path); 
									panelLoaded.removeAll();
									panelLoaded.add(BioController.displayParent());
									panelLoaded.repaint();
									panelLoaded.revalidate();
								}
							}

							@Override
							public void mouseExited(MouseEvent e) {
								if (panelSelected == false){
									panel.setBackground(SystemColor.menu);
									panelLoaded.removeAll();
								}
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
