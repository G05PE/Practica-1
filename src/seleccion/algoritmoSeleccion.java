package seleccion;

import java.util.ArrayList;
import java.util.List;

import funciones.funcion;
import poblacion.individuo;
import poblacion.poblacion;

public abstract class algoritmoSeleccion {
	//private poblacion poblacion;
	private poblacion seleccionados;
	
	public abstract void seleccionar(poblacion p);
	public abstract poblacion ini(poblacion p);
	
	/*public int getSizePoblacion() {
		return poblacion.getSize();
	}
	*/
	/*public individuo getIndividuo(int i) {
		return poblacion.getIndividuo(i);
	}
	*/
	public void addSeleccionado(individuo i) {
		seleccionados.addIndividuo(i);
	}
	
	public poblacion getSeleccionados() {
		return seleccionados;
	}
	
	public void iniSeleccionados(int tam, double prec, funcion f) {
		seleccionados=new poblacion(tam, prec, f);
	}
	/*public poblacion getPoblacion() {
		return poblacion;
	}*/
}
