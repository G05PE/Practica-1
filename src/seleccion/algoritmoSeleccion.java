package seleccion;

import java.util.ArrayList;
import java.util.List;

import poblacion.individuo;
import poblacion.poblacion;

public abstract class algoritmoSeleccion {
	private poblacion poblacion;
	private List<Double> probSeleccion;
	private List<individuo> seleccionados;
	
	public algoritmoSeleccion(poblacion p) {
		poblacion=p;
		probSeleccion=new ArrayList<Double>();
		seleccionados=new ArrayList<individuo>();
	}
	
	public abstract void seleccionar();
	public int getSizePoblacion() {
		return poblacion.getSize();
	}
	
	public double getProbSeleccion(int i) {
		return probSeleccion.get(i);
	}
	
	public individuo getIndividuo(int i) {
		return poblacion.getIndividuo(i);
	}
	
	public void addSeleccionado(individuo i) {
		seleccionados.add(i);
	}
	
	public void addProbabilidad(double p) {
		probSeleccion.add(p);
	}
}
