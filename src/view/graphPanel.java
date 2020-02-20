package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import control.controller;
import funciones.funcion;
import model.observer;

public class graphPanel extends JPanel implements observer {
	private controller ctrl;
	private double best[][];
	private double bestGen[][];
	private double average[][];
	private int tam;
	//private JButton ver;
	public graphPanel(controller c) {
		ctrl=c;
		ctrl.addObserver(this);
		this.setLayout(new BorderLayout());
	}

	private void initGUI() {
		
		XYSeries series1 = new XYSeries("Mejor absoluto");
		XYSeries series2 = new XYSeries("Mejor generación");
		XYSeries series3 = new XYSeries("Media generación");
		for(int i=0; i < tam; i++) {
			series1.add(best[0][i], best[1][i]);
			series2.add(bestGen[0][i], bestGen[1][i]);
			series3.add(average[0][i], average[1][i]);
		}
		XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Algoritmo genético",
                "Generaciones",
                "Fitness",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
        ChartPanel panel = new ChartPanel( chart );
        panel.removeAll();
        panel.validate();
        panel.repaint();
        panel.setVisible(true);
        this.add(panel);
        this.setVisible(true);
		/*DefaultXYDataset ds = new DefaultXYDataset();
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

        chart = ChartFactory.createXYLineChart("Genetic Algorithm", "Evaluation", 
				"Generation", ds);

        chart.getXYPlot().getRangeAxis().setRange(0, 100);
        ((NumberAxis) chart.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#'%'"));
        chart.getXYPlot().setRenderer(renderer);

		panel = new ChartPanel( chart );
		this.add(panel);
		this.setVisible(true);*/
	}
	
	@Override
	public void onNextGeneration( double[][] best, double[][] bestGen, double[][] average) {
		this.best=best;
		this.bestGen=bestGen;
		this.average=average;
		tam=10;
		initGUI();
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
