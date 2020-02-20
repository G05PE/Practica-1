package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import control.controller;
import funciones.funcion;
import model.observer;

public class graphPanel extends JPanel implements observer {
	private controller ctrl;
	private JFreeChart chart;
	private double best[][];
	private double bestGen[][];
	private double average[][];
	
	public graphPanel(controller c, double [][] best, double[][] bestGen, double [][] average) {
		this.best=best;
		this.bestGen=bestGen;
		this.average=average;
		ctrl=c;
		ctrl.addObserver(this);
		initGUI();
	}

	private void initGUI() {

		DefaultXYDataset ds = new DefaultXYDataset();
		ds.addSeries("Absolute best", best);
        ds.addSeries("Best of generation", bestGen);
        ds.addSeries("Generation average", average);

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(2));
        renderer.setSeriesStroke(1, new BasicStroke(2));
        renderer.setSeriesStroke(2, new BasicStroke(2));

        JFreeChart chart = ChartFactory.createXYLineChart("Genetic Algorithm", "Evaluation", 
				"Generation", ds);

        chart.getXYPlot().getRangeAxis().setRange(0, 100);
        ((NumberAxis) chart.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#'%'"));
        chart.getXYPlot().setRenderer(renderer);

		ChartPanel panel = new ChartPanel( chart );
		this.add(panel);
		this.setVisible(true);
	}
	
	@Override
	public void onNextGeneration(int generation, double mejor, double bestGen, double media) {
		
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
