package model;

import java.util.ArrayList;
import java.util.List;
import funciones.funcion;
import funciones.funcion1;
import funciones.funcion2;
import funciones.funcion3;
import funciones.funcion4;
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
		poblacion=new poblacion(tam, precision, funcion);
		//AVISAR observers
	}
	public void establecerFuncion(int f, int tam ) {
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

}
