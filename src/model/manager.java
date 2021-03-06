package model;

import java.util.ArrayList;
import java.util.List;

import cruces.*;
import funciones.*;
import poblacion.individuo;
import poblacion.poblacion;
import seleccion.*;

public class manager {

	private List<observer> observers;
	private algoritmoSeleccion algSel;
	private algoritmoCruce algCruce;
	private poblacion poblacion;
	private double bestGen [][];
	private double average [][];
	private double best [][];
	private List<Double> bestVars;;
	private mutacion algMut;
	private funcion funcion;
	private int codificacion;//0=binario, 1=real
	private double probToler;
	private double probElite;
	private double probCruc;
	private double probMut;	
	private int generation;
	private elite elite;
	private int maxIter;
	private int tamPob;

	public manager() {
		observers=new ArrayList<observer>();
		bestVars=new ArrayList<Double>();
		elite=new elite();
		iniciarDatos();
	}
	public void iniciarDatos() {
		probToler=0.001;
		probElite=0.05;
		codificacion=0;
		generation=0;
		probCruc=0.6;
		probMut=0.02;
		maxIter=100;
		tamPob=100;
	}
	public void addObserver(observer o) {
		if(!observers.contains(o)) {
			observers.add(o);
		}
	}

	public void iniciarPoblacion() {
		poblacion=new poblacion(tamPob, probToler, funcion);
		poblacion.iniciarPoblacion(codificacion);
		best=new double[2][maxIter];
		bestGen=new double[2][maxIter];
		average=new double[2][maxIter];
		
	}
	public void start() {
		generation=0;
		iniciarPoblacion();
		evaluarPoblacion();
		generation++;
		while(generation < maxIter) {
			elite.escogerElites(poblacion, probElite);
			adaptar();
			seleccion();
			desadaptar();
			reproduccion();
			mutacion();
			elite.incluirElites(poblacion);
			evaluarPoblacion();
			generation++;
		}
		
		for(int i=0; i < observers.size(); i++) {
			observers.get(i).onFinished( best, bestGen, average, bestVars);
		}
	}
	private void desadaptar() {
		funcion.desadaptar(poblacion);
	}
	private void adaptar() {
		funcion.adaptar(poblacion);
	}
	private void seleccion() {
		poblacion=algSel.ini(poblacion, funcion);
	}
	private void mutacion() {
		algMut.mutar(poblacion, probMut);
	}
	private void evaluarPoblacion() {
		evaluarMejor();
		evaluarMedia();
	}
	private void evaluarMedia() {
		average[0][generation]=generation;
		average[1][generation]=poblacion.getAverage();
	}
	
	private void evaluarMejor() {
		best[0][generation]=generation;
		bestGen[0][generation]=generation;
		bestGen[1][generation]=poblacion.getBest();
		if(generation==0 || funcion.best(bestGen[1][generation], best[1][generation-1])) {
			best[1][generation]=bestGen[1][generation];
			bestVars.clear();
			bestVars.add(best[1][generation]);
			individuo mejor=poblacion.getMejorInd();
			for(int i=0; i < mejor.getLongitud(); i++) {
				bestVars.add(mejor.getCromosomaAt(i).getvalorReal());
			}
		}
		else
		{
			best[1][generation]=best[1][generation-1];
		}
	}
	private void reproduccion() {
		if(algCruce!=null) {
			algCruce.cruzar(poblacion, probCruc);
		}else {
			System.out.println("No se ha inicializado el algoritmo de cruce");
		}
	}
	public void establecerFuncion(int f, int tam ) {
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
	}
	public void establerMetodoSeleccion(int metodo) {
		switch(metodo)
		{
		case 0://ruleta
			algSel=new algoritmoRuleta();
			break;
		case 1:
			algSel=new algoritmoTorneoDeter();
			break;
		case 2:
			algSel=new algoritmoTorneoProb();
			break;
		case 3:
			algSel=new algoritmoEstocasticoUniv();
			break;
		case 4:
			algSel=new algoritmoTruncamiento();
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
			algCruce=new monopunto();
			break;
		case 1:
			algCruce=new uniforme();
			break;
		case 2:
			algCruce=new aritmetico();
			break;
		case 3:
			algCruce=new discretoUniforme();
			break;
		case 4:
			//algCruce=new monopuntoReal();
			break;
		default:
			break;
		}
	}
	
	public void setMutationFunct(int i) {
		switch(i) {
		case 0:
			algMut=new mutacionBasica();
			break;
		case 1:
			algMut=new mutacionUniforme();
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
	public void establecerCodificacion(int i) {
		codificacion=i;
	}

}

