package cruces;

import poblacion.poblacion;

public abstract class algoritmoCruce {
	private double probCruce;
	private poblacion seleccionados;
	private poblacion reproductores;
	private poblacion descendientes;
	
	public algoritmoCruce(double probCruce, poblacion seleccionados) {
		this.setProbCruce(probCruce);
		this.seleccionados=seleccionados;
		reproductores=new poblacion(seleccionados.getSize(), seleccionados.getPrecision(), 
				seleccionados.getFuncion());
		descendientes=new poblacion(seleccionados.getSize(), seleccionados.getPrecision(), 
				seleccionados.getFuncion());
	}
	
	public abstract poblacion cruzar();
	
	public double getProbCruce() {
		return probCruce;
	}
	public void setProbCruce(double probCruce) {
		this.probCruce = probCruce;
	}
	public poblacion getSeleccionados() {
		return seleccionados;
	}
	public poblacion getDescendientes() {
		return descendientes;
	}
}
