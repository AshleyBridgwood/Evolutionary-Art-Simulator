/**
 * @author Ibrahim Farah
 */
package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LoadBiomorph {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadBiomorph window = new LoadBiomorph();
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
	public LoadBiomorph() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
            //Create frame and bounds
            frame = new JFrame();
            frame.setBounds(100, 100, 450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            //Top panel
            JPanel headerPanel = new JPanel();
            JLabel header = new JLabel("Load file");
            header.setFont(new Font("", Font.BOLD, 25));
            headerPanel.setSize(450, 50);
            headerPanel.add(header);
            
            //Command panel
            JPanel command = new JPanel();
            final JTextField fileLoc = new JTextField(20);
            JButton load = new JButton("Load");
            JButton cancel = new JButton("Cancel");
            
            
            /*
            *   Middle panel. Pictures amd chose from file button
            */
            JPanel filePanel = new JPanel();
            
            //***   File dir
            //***
            //***   Hardcoded dir. Will change to loaded files after save is done
            //***   Assumes 3 images are in the dir
            File dir = new File("D:\\Desktop\\MPic");
            File[] files = dir.listFiles();
            
            for(int i = 0; i < 3; i++){
                //JLabel logoImage = new JLabel();
                JRadioButton pic = new JRadioButton();
		ImageIcon logoIcon = new ImageIcon(files[i].toString());
		Image l = logoIcon.getImage();
		Image logo = l.getScaledInstance(128, 128, Image.SCALE_DEFAULT);
		ImageIcon scaledLogo = new ImageIcon(logo);
                pic.setIcon(scaledLogo);
                
                pic.setName(files[i].toString());
                picListener(pic, fileLoc);
		filePanel.add(pic);
                
            }
            JButton chooseFile = new JButton("Choose from file");
            chooseFile.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent ae) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.showOpenDialog(null);
                        File file = fileChooser.getSelectedFile();
                        fileLoc.setText(file.toString());
                    
                }
            
            });
            
            
            filePanel.add(chooseFile);
            
            fileLoc.setEnabled(false);
            command.add(fileLoc);
            command.add(load);
            command.add(cancel);
            
            //Add panels top frame
            frame.add(header);
            frame.add(filePanel);
            frame.add(command);
            
            //Layout
            frame.setLayout(new GridLayout(3, 1));
            
            
            
            frame.pack();
                
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
        
        private void picListener(final JRadioButton pic, final JTextField text){
            pic.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent ae) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    //pic.setBackground(Color.blue);
                    text.setText(pic.getName());
                    
                    
                }
            
            });
        }
}
