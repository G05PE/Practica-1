package model;

import java.util.ArrayList;
import java.util.List;

import cruces.algoritmoCruce;
import cruces.monopunto;
import cruces.mutacion;
import cruces.mutacionBasica;
import cruces.uniforme;
import funciones.funcion;
import funciones.funcion1;
import funciones.funcion2;
import funciones.funcion3;
import funciones.funcion4;
import poblacion.poblacion;
import selectSelect.algoritmoEstocasticoUniv;
import selectSelect.algoritmoRuleta;
import selectSelect.algoritmoSeleccion;
import selectSelect.algoritmoTorneoDeter;
import selectSelect.algoritmoTorneoProb;

public class manager {
	
	private List<observer> observers;
	private algoritmoSeleccion algSel;
	private algoritmoCruce algCruce;
	private poblacion poblacion;
	private double bestGen [][];
	private double average [][];
	private double best [][];
	private mutacion algMut;
	private funcion funcion;
	private double probToler;
	private double probElite;
	private double probCruc;
	private double probMut;	
	private int generation;
	private int maxIter;
	private int tamPob;
	private int idFun;
	
	public manager() {
		observers=new ArrayList<observer>();
		iniciarDatos();
	}
	public void iniciarDatos() {
		probToler=0.001;
		probElite=0.05;
		generation=0;
		probCruc=0.6;
		probMut=0.02;
		maxIter=100;
		tamPob=100;
	}
	public void addObserver(observer o) {
		if(!observers.contains(o)) {
			observers.add(o);
			//o.onRegistre(workers, tasks);
		}
	}
	
	public void iniciarPoblacion() {
		poblacion=new poblacion(tamPob, probToler, funcion);
		poblacion.iniciarPoblacion();
		best=new double[2][poblacion.getSize()];
		bestGen=new double[2][poblacion.getSize()];
		average=new double[2][poblacion.getSize()];
		
	}
	public void start() {
		generation=0;
		iniciarPoblacion();
		evaluarPoblacion();
		generation++;
		for(int i=0; i < observers.size(); i++) {
			observers.get(i).onNextGeneration( best, bestGen, average);
		}
		while(generation < maxIter) {
			poblacion=algSel.ini(poblacion);
			reproduccion();
			evaluarPoblacion();
			generation++;
			for(int i=0; i < observers.size(); i++) {
				observers.get(i).onNextGeneration( best, bestGen, average);
			}
		}
		for(int i=0; i < observers.size(); i++) {
			observers.get(i).onFinished();
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
		idFun=f+1;
		switch(f) {
		case 0:
			funcion=new funcion1();
			break;
		case 1:
			funcion=new funcion2();
			break;
		case 2:
			funcion=new funcion3(tam);
			break;
		case 3:
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
	public void establerMetodoSeleccion(int metodo) {
		switch(metodo)
		{
		case 0://ruleta
			algSel=new algoritmoRuleta();
			break;
		case 1:
			algSel=new algoritmoTorneoDeter(funcion);
			break;
		case 2:
			algSel=new algoritmoTorneoProb(funcion);
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
	public void setPopulationSize(int popSize) {
		tamPob=popSize;
	}
	public void setGenerationNumber(int genNum) {
		maxIter=genNum;
	}
	public void setProbCruce(double d) {
		probCruc=d;
	}
	public void setCrossFunct(int i) {
		switch(i) {
		case 0:
			//algCruce=new monopunto();
			break;
		case 1:
			//algCruce=new uniforme();
			break;
			default:
				break;
		}
	}
	public void setMutationFunct(int i) {
		switch(i) {
		case 0:
			//algMut=new mutacionBasica();
			break;
		case 1:
			//algMut=new mutacionUniforme();
			break;
			default:
				break;
		}
	}
	public void setMutationPercent(double mutPer) {
		probMut=mutPer;
	}
	public void setElitePercent(double d) {
		probElite=d;
	}
	public void setTolerancia(double tolPer) {
		probToler=tolPer;
	}
	public void reset() {
		iniciarDatos();
	}

}
