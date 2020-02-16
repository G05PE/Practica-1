package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;

import control.controller;
import funciones.funcion;
import model.observer;

public class graphPanel extends JPanel implements observer {
	private controller ctrl;
	
	public graphPanel(controller c) {
		ctrl=c;
		ctrl.addObserver(this);
		initGUI();
	}

	private void initGUI() {

		DefaultXYDataset ds = new DefaultXYDataset();
		ds.addSeries("Absolute best", new double[][] {{ 2007, 2008, 2009, 2010, 2011, 2012, 
			2013, 2014, 2015, 2016, 2017 }, { 25, 29.1, 32.1, 32.9, 31.9, 25.5, 20.1, 
				18.4, 15.3, 11.4, 9.5 }});
        ds.addSeries("Best of generation", new double[][] {{ 2007, 2008, 2009, 2010, 2011, 2012, 2013, 
        	2014, 2015, 2016, 2017 }, { 67.7, 63.1, 60.2, 50.6, 41.1, 31.8, 27.6, 20.4, 
        		17.3, 12.3, 8.1 }});
        ds.addSeries("Generation average", new double[][] {{ 2009, 2010, 2011, 2012, 2013, 2014, 
        	2015, 2016, 2017 }, { 0.2, 6.4, 14.6, 25.3, 30.1, 34.3, 43.2, 47.3, 58.4 }});

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(2));
        renderer.setSeriesStroke(1, new BasicStroke(2));
        renderer.setSeriesStroke(2, new BasicStroke(2));

        JFreeChart chart = ChartFactory.createXYLineChart("Genetic Algorithm", "Evaluation", 
				"Generation", ds);

        //chart.getXYPlot().getRangeAxis().setRange(0, 100);
        //((NumberAxis) chart.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#'%'"));
        chart.getXYPlot().setRenderer(renderer);

		ChartPanel panel = new ChartPanel( chart );
		this.add(panel);
		this.setVisible(true);
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
