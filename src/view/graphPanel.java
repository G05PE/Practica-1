package view;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import org.math.plot.Plot2DPanel;

import control.controller;
import funciones.funcion;
import model.observer;

public class graphPanel extends JPanel implements observer {
	private controller ctrl;
	Plot2DPanel plot;
	private int tam;
	
	public graphPanel(controller c) {
		ctrl=c;
		ctrl.addObserver(this);
		initGUI();
	}

	private void initGUI() {
		this.validate();
		this.repaint();
		// create your PlotPanel (you can use it as a JPanel)
		plot = new Plot2DPanel();
		// define the legend position
		plot.addLegend("SOUTH");
		plot.setPreferredSize(new Dimension(700,600));
		plot.setMinimumSize(new Dimension(700,600));
		plot.setMaximumSize(new Dimension(700,600));
		
		this.setPreferredSize(new Dimension(700,600));
		this.setMinimumSize(new Dimension(700,600));
		this.setMaximumSize(new Dimension(700,600));
		this.add(plot);
		this.setVisible(true);
		
	}
	
	@Override
	public void onNextGeneration( double[][] best, double[][] bestGen, double[][] average) {
		// add a line plot to the PlotPanel
		plot.removeAllPlots();
		plot.addLinePlot("Mejor absoluto", best[0], best[1]);
		plot.addLinePlot("Mejor generación", bestGen[0], bestGen[1]);
		plot.addLinePlot("Media generación", average[0], average[1]);
		this.repaint();
				
	}
	
	@Override
	public void onChangedFunction(funcion f, int tam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChangedFunctionParameters() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChangedPoblationSize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChangedGeneration() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChangedSelection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChangedMutation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChangedCruce() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChangedPrecition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChangedElitism() {
		// TODO Auto-generated method stub
		
	}

}
