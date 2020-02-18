package view;

import control.controller;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainWindow {
	private static JFrame gui;
	private static JPanel setings;
	private static JPanel graphic;

	
	public mainWindow(controller ctlr) { 
		
		//Window configuration
		gui = new JFrame("Practica 1");
		setings = new SetingsPanel(ctlr);
		gui.setAlwaysOnTop(true);
		gui.setVisible(true);
		gui.setBounds(150, 150, 720, 480);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Add configuration panel
        gui.setLayout(new BorderLayout());
        gui.add(setings, BorderLayout.WEST);
       
        //TODO add graphic
	}

	 
}
