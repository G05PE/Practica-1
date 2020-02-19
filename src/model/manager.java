package model;

import java.util.ArrayList;
import java.util.List;
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
	private poblacion poblacion;
	private funcion funcion;
	private int idFun;
	private algoritmoSeleccion algSel;
	private int generation=0;
	
	public manager() {
		observers=new ArrayList<observer>();
	}
	public void addObserver(observer o) {
		if(!observers.contains(o)) {
			observers.add(o);
			//o.onRegistre(workers, tasks);
		}
	}
	
	public void iniciarPoblacion(int tam, double precision) {
		poblacion=new poblacion(tam, precision, funcion);
		//AVISAR observers
		
	}
	
	public void nextGen() {
		for(int i=0; i < 100; i++) {
			generation++;
			observers.get(0).onNextGeneration(generation, poblacion.getBest()+1, 
					poblacion.getBestGen()-i, poblacion.getAverage()+i);
		}
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
	public void establerMetodoSeleccion(int metodo, int k) {
		switch(metodo)
		{
		case 0://ruleta
			algSel=new algoritmoRuleta(poblacion);
			break;
		case 1:
			algSel=new algoritmoTorneoDeter(poblacion, k, funcion);
			break;
		case 2:
			algSel=new algoritmoTorneoProb(poblacion, k, funcion);
			break;
		case 3:
			algSel=new algoritmoEstocasticoUniv(poblacion);
			break;
		}
	}

}
