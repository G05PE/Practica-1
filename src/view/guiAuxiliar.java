package view;

import javax.swing.JToolBar;

import control.controller;

public class guiAuxiliar {
	private JToolBar panel;
	private JToolBar bar;
	private controller ctlr;
	
	public guiAuxiliar(controller crtl) {

		this.ctlr = ctlr;
		this.panel = new JToolBar();
		this.bar = new JToolBar();
		
	}
}
