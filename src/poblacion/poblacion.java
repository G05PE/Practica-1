package poblacion;

import java.util.ArrayList;
import java.util.List;

import funciones.funcion;

public class poblacion {
	
	private List<individuo> poblacion;
	private funcion funcion;
	private double precision;
	public poblacion(int tam, double prec, funcion fun) {
		poblacion=new ArrayList<individuo>(tam);
		precision=prec;
		funcion=fun;
		iniciarPoblacion();
	}
	
	public void iniciarPoblacion() {
		
		for(int i=0; i < poblacion.size(); i++) {
			individuo cromosoma=new individuo();
			poblacion.set(i, )
		}
	}
}
