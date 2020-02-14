package poblacion;

import java.util.ArrayList;
import java.util.List;

import funciones.funcion;

public class poblacion {
	
	private List<individuo> poblacion;
	
	public poblacion(int tam, double prec, funcion fun) {
		poblacion=new ArrayList<individuo>(tam);
		iniciarPoblacion(fun, prec);	
	}
	
	public void iniciarPoblacion(funcion funcion, double precision) {
		
		for(int i=0; i < poblacion.size(); i++) {
			individuo cromosoma=new individuo(funcion, precision);
			poblacion.add(cromosoma);
		}
	}
}
