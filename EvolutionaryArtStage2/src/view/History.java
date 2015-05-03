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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.Font;

import javax.swing.JScrollPane;

import model.BioController;


public class History {

	private JFrame frame;
	JPanel panelBiomorphs = new JPanel(); // panel to contain all of the loaded biomorphs.
	
	JPanel mainPanel = new JPanel();


	/**
	 * Create the application.
	 */
	public History() {
		initialize();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1128, 686);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setFont(new Font("Calibri", Font.BOLD, 26));
		lblHistory.setBackground(Color.ORANGE);
		lblHistory.setBounds(508, 15, 236, 35);
		frame.getContentPane().add(lblHistory);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartScreen().getFrame().setVisible(true);
				frame.dispose();

			}
		});
		btnHome.setBounds(0, 5, 168, 52);
		frame.getContentPane().add(btnHome);

		loadBiomorphs();
	}
	
	public void loadBiomorphs(){		

		mainPanel.setForeground(Color.BLACK);
		mainPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), null));
		mainPanel.setBackground(SystemColor.menu);
		//mainPanel.setPreferredSize(new Dimension(987, 917));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        BioController.getHistoryData();
		System.out.println("Number of items to display: " + BioController.getNumberOfItemsInHistory());	
		
        	int id = 0;
        	
        	int numberOfRows = BioController.getNumberOfItemsInHistory();
        	int times = (int) Math.ceil(numberOfRows / (float)5);  // works out multiple of 5 rounded up.. e.g 12 / 5 =  2.4 -> rounds up to 3. So 3 rows.
        	
        	System.out.println("times is : " + times);
        	
			for (int x = 0; x < times; x++){
			     JPanel panel = new JPanel();
			     panel.setForeground(Color.RED);
			     panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 0, 0), null));
			     panel.setPreferredSize(new Dimension(487, 190));
			     panel.setLayout(new GridLayout(1,5));
				for (int j = 0; j < 5; j++){
					JPanel panels = new JPanel();
					if(id < BioController.getNumberOfItemsInHistory()){
						panels.add(BioController.displayHistoryBiomorph(id));
					}
				    panels.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 0), null));
				    panel.add(panels);
				    id++;
				}
				mainPanel.add(panel);
			}
		//scrollPane.getViewport().add(mainPanel);
		
		JScrollPane scrollPane = new JScrollPane(mainPanel); // scroll pane that will contain all saved biomorphs.
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//set the horizontal scrollbar to never appear
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//set the horizontal scrollbar to never appear
		scrollPane.setBounds(49, 70, 1036, 556);
		frame.getContentPane().add(scrollPane);
		
		
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