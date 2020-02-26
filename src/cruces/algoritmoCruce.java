package cruces;

import poblacion.individuo;
import poblacion.poblacion;

public abstract class algoritmoCruce {
	private double probCruce;
	private poblacion seleccionados;
	private poblacion reproductores;
	private poblacion descendientes;
	
	public algoritmoCruce() {}
	
	protected void init(double prob, poblacion seleccionados) {
		this.probCruce = prob;
		this.seleccionados = seleccionados;
		reproductores = new poblacion(seleccionados.getSize(), seleccionados.getPrecision(), seleccionados.getFuncion());
		descendientes = seleccionados;
	}

	public abstract poblacion cruzar(poblacion seleccionados, double prob);
	
	
	public double getProbCruce() {
		return probCruce;
	}
	
	
	public int sizeReproductor() {
		return reproductores.getSize();
	}

	protected void setSizeReproductor(int num_sele_cruce) {
		reproductores.setSize(num_sele_cruce);
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
	
	protected poblacion getReproductores() {
		return reproductores;
	}
	
	protected poblacion getSeleccionados() {
		return seleccionados;
	}
	
	
	protected individuo getDescendienteAt(int i) {
		return descendientes.getIndividuo(i);
	}
	

	protected void setDescendienteAt(int i, individuo hijo) {	
		descendientes.setIndividuoAt(i, hijo);
	}
	
}
