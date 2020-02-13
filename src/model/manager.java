package model;

import java.util.ArrayList;
import java.util.List;
import funciones.funcion;
import poblacion.poblacion;

public class manager {
	
	private List<observer> observers;
	private poblacion poblacion;
	private funcion funcion;
	
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
		poblacion=new poblacion(tam, precision);
		//AVISAR observers
	}
	public void establecerFuncion(int f) {
		funcion=f;
		for(int i=0; i < observers.size(); i++) {
			observers.get(i).onChangedFunction(funcion);
		}
	}

}
