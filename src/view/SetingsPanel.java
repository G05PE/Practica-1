package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;

import control.controller;
import funciones.funcion;
import model.observer;

public class SetingsPanel extends JPanel implements observer{

	private JPanel panel;
	private controller ctlr;
	private JButton start;
	//Constructor
	public SetingsPanel(controller ctlr) {
		this.ctlr = ctlr;
		initFileds();
	}
	
	
	//TODO all listeners
	
	private void initFileds() {
		
		this.setLayout(new GridLayout(1,1));
		JToolBar bar=new JToolBar();
		bar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,2));
		JSeparator sep0=new JSeparator();
		bar.add(sep0);
		
		start=new JButton();
		start.setIcon(new ImageIcon("icons/start.png"));
		start.setToolTipText("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		bar.add(start);
		JSeparator sep1=new JSeparator();
		bar.add(sep1);
		
		bar.setVisible(true);
		this.add(bar);
		this.setVisible(true);
		/*JPanel function = new JPanel();

		//---------------------------------------------------------------------------
		//Header
		JLabel header = new JLabel("Parámetros");
		header.setFont(new Font("Verdana", Font.PLAIN, 15));
		this.add(header);
		
		
		//---------------------------------------------------------------------------
		this.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.LINE_START);
		//Function tools
		
		JPanel func = new JPanel();
		func.setLayout(new BoxLayout(func, BoxLayout.X_AXIS));
		func.add(new JLabel("Función: "), BorderLayout.WEST);
		
		JComboBox list = new JComboBox<>();
		list.addItem("func 1");
		list.addItem("func 2");
		list.addItem("func 3");
		func.add(list, BorderLayout.EAST);
		this.add(func);

		JPanel parameters = new JPanel();
		parameters.setLayout(new BoxLayout(parameters, BoxLayout.X_AXIS));
		parameters.add(new JLabel("Parametros función: "));
		JSpinner sp1 =new JSpinner(new SpinnerNumberModel(2, 1, 50, 1));
		parameters.add(sp1);
		this.add(parameters);
		
		
		//---------------------------------------------------------------------------
		this.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.LINE_START);
		//Evolutive tools
		
		JPanel pobl = new JPanel();
		pobl.setLayout(new BoxLayout(pobl, BoxLayout.X_AXIS));
		pobl.add(new JLabel("Tamaño de población: "), BorderLayout.WEST);
		JSpinner sp2 =new JSpinner(new SpinnerNumberModel(100, 1, 15000, 10));
		parameters.add(sp2);
		this.add(pobl);

		JPanel generations = new JPanel();
		generations.setLayout(new BoxLayout(generations, BoxLayout.X_AXIS));
		generations.add(new JLabel("Numero de generaciones: "));
		JSpinner sp3 =new JSpinner(new SpinnerNumberModel(100, 1, 15000, 10));
		parameters.add(sp3);
		this.add(generations);
		
		this.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.LINE_START);
		
		this.add(new JLabel("Cruce: "));
		this.add(new JTextField("50"));
		
		
		//---------------------------------------------------------------------------
		this.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.LINE_START);
		
		
		//TODO seleccion
		//TODO cruce
		
		//---------------------------------------------------------------------------
		this.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.LINE_START);
	
		
		JPanel cruce = new JPanel();
		cruce.setLayout(new BoxLayout(cruce, BoxLayout.X_AXIS));
		cruce.add(new JLabel("Tamaño de población: "), BorderLayout.WEST);
		JSpinner sp4 =new JSpinner(new SpinnerNumberModel(100, 1, 15000, 10));
		parameters.add(sp4);
		this.add(cruce);

		JPanel mut = new JPanel();
		mut.setLayout(new BoxLayout(generations, BoxLayout.X_AXIS));
		//mut.add(new JLabel("Numero de generaciones: "));
		JSpinner sp5 =new JSpinner(new SpinnerNumberModel(100, 1, 15000, 10));
		parameters.add(sp5);
		this.add(mut);
		

		JPanel precision = new JPanel();
		precision.setLayout(new BoxLayout(cruce, BoxLayout.X_AXIS));
		//precision.add(new JLabel("Tamaño de población: "), BorderLayout.WEST);
		JSpinner sp6 =new JSpinner(new SpinnerNumberModel(10, 1, 100, 1));
		parameters.add(sp6);
		this.add(precision);

		
		//---------------------------------------------------------------------------
		this.add(new JSeparator(JSeparator.HORIZONTAL), BorderLayout.LINE_START);		
		
		JPanel etilistmo = new JPanel();
		etilistmo.add(new JCheckBox("Elitismo", true));
		JSpinner sp7 = new JSpinner(new SpinnerNumberModel(2, 1, 100, 1));
		parameters.add(sp7);
		this.add(etilistmo);*/
	}
	
	private void start() {
		ctlr.nextGen();
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


	@Override
	public void onNextGeneration(int generation, double best, double bestGen, double average) {
		// TODO Auto-generated method stub
		
	}
}
