package cruces;

import poblacion.individuo;
import poblacion.poblacion;

public abstract class algoritmoCruce {
	private double probCruce;
	private poblacion seleccionados;
	private poblacion reproductores;
	private poblacion descendientes;
	
	public algoritmoCruce(double probCruce, poblacion seleccionados) {
		this.setProbCruce(probCruce);
		this.seleccionados = seleccionados;	
		reproductores = new poblacion(seleccionados.getSize(), seleccionados.getPrecision(), seleccionados.getFuncion());
		descendientes = new poblacion(seleccionados.getSize(), seleccionados.getPrecision(), seleccionados.getFuncion());
	}

	public abstract poblacion cruzar();
	
	public double getProbCruce() {
		return probCruce;
	}
	
	public void setProbCruce(double probCruce) {
		this.probCruce = probCruce;
	}
	
	public int sizeReproductor() {
		return reproductores.getSize();
	}

	
	
	//Setters
	protected void borraUltimoReproductor() {
		reproductores.borraUltimo();
	}
	
	
	protected void addReprpoductor(individuo i) {
		reproductores.addIndividuo(i);
	}
	

	protected void addDescendiente(individuo i) {
		descendientes.addIndividuo(i);
	}
	
	
	
	//Getters
	protected individuo getReproductor(int i) {
		return reproductores.getIndividuo(i);
	}
	
	protected individuo getSeleccionadoConcreto(int i) {
		return seleccionados.getIndividuo(i);
	}
	
	protected poblacion getDescendientes() {
		return descendientes;
	}
	
	protected poblacion getSeleccionados() {
		return seleccionados;
	}
	
}
