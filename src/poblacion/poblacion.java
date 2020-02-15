package poblacion;

import java.util.ArrayList;
import java.util.List;

import funciones.funcion;

public class poblacion {
	
	private List<individuo> poblacion;
	private int tam=0;
	
	public poblacion(int tam, double prec, funcion fun) {
		poblacion=new ArrayList<individuo>();
		this.tam=tam;
		iniciarPoblacion(fun, prec);	
	}
	
	public void iniciarPoblacion(funcion funcion, double precision) {
		
		for(int i=0; i < tam; i++) {
			individuo cromosoma=new individuo(funcion, precision);
			poblacion.add(cromosoma);
		}
	}
	
	public individuo getIndividuo(int i) {
		return new individuo(poblacion.get(i));
	}
	
	public void setIndividuos(List<individuo> nuevos) {
		poblacion=nuevos;
	}
	
	public int getSize() {
		return tam;
	}
}
