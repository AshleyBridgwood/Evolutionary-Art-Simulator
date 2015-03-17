/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Nameyka
 */
public class StartScreen {
    private JFrame start;
    
    public StartScreen(){
    
        start = new JFrame("Evo Art...");
        
        JLabel lb = new JLabel("New/Existing: ");
        JRadioButton rb1 = new JRadioButton("New", true);
        JRadioButton rb2 = new JRadioButton("Exising", false);
        JButton jb = new JButton("Go!");
        ButtonGroup group = new ButtonGroup();
        
        start.setLayout(new FlowLayout());
        start.add(lb);
        start.add(rb1);
        start.add(rb2);
        start.add(jb);
        
        group.add(rb1);
        group.add(rb2);
        
        start.pack();
        start.setVisible(true);
    }
    /*public static void main(String[] args){
        new StartScreen();
    }*/
}

