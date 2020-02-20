package seleccion;

import java.util.ArrayList;
import java.util.List;

import poblacion.individuo;
import poblacion.poblacion;

public abstract class algoritmoSeleccion {
	private poblacion poblacion;
	private List<individuo> seleccionados;
	
	public algoritmoSeleccion(poblacion p) {
		poblacion=p;
		seleccionados=new ArrayList<individuo>();
	}
	
	public abstract poblacion seleccionar();
	public int getSizePoblacion() {
		return poblacion.getSize();
	}
	
	public individuo getIndividuo(int i) {
		return poblacion.getIndividuo(i);
	}
	
	public void addSeleccionado(individuo i) {
		seleccionados.add(i);
	}
	
	public poblacion getPoblacion() {
		return poblacion;
	}
}
