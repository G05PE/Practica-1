package genetica;

import java.util.List;
import funciones.funcion;
public class gen {
	private List<Integer> genotipo;
	private double fenotipo;
	private funcion funcion;
	private double tam;
	
	public gen(funcion f, double precision, double tam, double x) {
		funcion=f;
		this.tam=tam;
		fenotipo=x;
	}
	
}
