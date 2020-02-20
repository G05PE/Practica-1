package model;

import java.util.ArrayList;
import java.util.List;

import cruces.algoritmoCruce;
import cruces.monopunto;
import cruces.uniforme;
import funciones.funcion;
import funciones.funcion1;
import funciones.funcion2;
import funciones.funcion3;
import funciones.funcion4;
import poblacion.poblacion;
import seleccion.algoritmoEstocasticoUniv;
import seleccion.algoritmoRuleta;
import seleccion.algoritmoSeleccion;
import seleccion.algoritmoTorneoDeter;
import seleccion.algoritmoTorneoProb;

public class manager {
	
	private List<observer> observers;
	private double best [][];
	private double bestGen [][];
	private double average [][];
	private algoritmoCruce algCruce;
	private algoritmoSeleccion algSel;
	private poblacion poblacion;
	private funcion funcion;
	private int generation=0;
	private int idFun;
	private int maxIter;
	private int tamPob;
	private double pCruc;
	private double pMut;
	private int posMejor;
	
	public manager() {
		observers=new ArrayList<observer>();
		iniciarDatos();
	}
	public void iniciarDatos() {
		tamPob=10;
		maxIter=10;
		pCruc=0.6;
		pMut=0.02;
		posMejor=0;
	}
	public void addObserver(observer o) {
		if(!observers.contains(o)) {
			observers.add(o);
			//o.onRegistre(workers, tasks);
		}
	}
	
	public void iniciarPoblacion(int tam, double precision) {
		poblacion=new poblacion(tam, precision, funcion);
		poblacion.iniciarPoblacion();
		best=new double[2][poblacion.getSize()];
		bestGen=new double[2][poblacion.getSize()];
		average=new double[2][poblacion.getSize()];
		
	}
	public void start(int tam, double precision) {
		
		iniciarPoblacion(tam, precision);
		evaluarPoblacion();
		generation++;
		while(generation < maxIter) {
			poblacion=algSel.ini(poblacion);
			reproduccion();
			evaluarPoblacion();
			generation++;
		}
		for(int i=0; i < observers.size(); i++) {
			observers.get(i).onNextGeneration( best, bestGen, average);
		}
	}
	private void evaluarPoblacion() {
		evaluarMejorAbs();
		evaluarMejorGen();
		evaluarMedia();
	}
	private void evaluarMedia() {
		average[0][generation]=generation;
		average[1][generation]=poblacion.getAverage();
	}
	private void evaluarMejorGen() {
		bestGen[0][generation]=generation;
		bestGen[1][generation]=poblacion.getBestGen();
	}
	private void evaluarMejorAbs() {
		best[0][generation]=generation;
		if(generation==0 || funcion.best(poblacion.getBest(), best[1][generation-1])) {
			best[1][generation]=poblacion.getBest();
		}
		else
		{
			best[1][generation]=best[1][generation-1];
		}
	}
	private void reproduccion() {
		//algCruce.cruzar();
	}
	public void establecerFuncion(int f, int tam ) {
		idFun=f;
		switch(f) {
		case 1:
			funcion=new funcion1();
			break;
		case 2:
			funcion=new funcion2();
			break;
		case 3:
			funcion=new funcion3(tam);
			break;
		case 4:
			funcion=new funcion4(tam);
			break;
			default:
				funcion=new funcion1();
				break;
		
		}
		for(int i=0; i < observers.size(); i++) {
			observers.get(i).onChangedFunction(funcion, tam);
		}
	}
	
	public void establecerMetodoCruce(int metodo, double probCruce) {
		switch(metodo) {
		case 0://Monopunto
			algCruce=new monopunto(probCruce, poblacion);
			break;
		case 1://Uniforme
			algCruce=new uniforme();
			break;
		}
	}
	public void establerMetodoSeleccion(int metodo, int k) {
		switch(metodo)
		{
		case 0://ruleta
			algSel=new algoritmoRuleta();
			break;
		case 1:
			algSel=new algoritmoTorneoDeter(k, funcion);
			break;
		case 2:
			algSel=new algoritmoTorneoProb(k, funcion);
			break;
		case 3:
			algSel=new algoritmoEstocasticoUniv();
			break;
		}
	}
	public double[][] getBest() {
		return best;
	}
	public double[][] getBestGen() {
		return bestGen;
	}
	public double[][] getAverage() {
		return average;
	}

}
