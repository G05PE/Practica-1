package funciones;

import java.util.ArrayList;
import java.util.List;

import genetica.gen;
import model.adaptacion;
import poblacion.individuo;
import poblacion.poblacion;

public abstract class funcion {
	private List<Double> minX;
	private List<Double> maxX;
	private adaptacion adp;
	private int size;
	
	public funcion(int var) {
		setSize(var);
		establecerMinimosMaximos();
	}
	
	public abstract boolean worst(double fitness, double fitness2);
	public abstract boolean best(double fitness, double best);
	public abstract double calcularFuncion(List<Double> fenotipos);
	public abstract void establecerMinimosMaximos();
	public abstract void addElite(List<individuo> objetivo, List<individuo> fuente, double tamElite);
	
	public void setAdapt(adaptacion a) {
		adp=a;
	}
	public adaptacion getAdapt() {
		return adp;
	}
	public double getMinX(int i) {
		return minX.get(i);
	}
	public double getMaxX(int i) {
		return maxX.get(i);
	}
	public int getSize() {
		return size;
	}
	void setMinX(List<Double> min) {
		minX=min;
	}
	protected void setMaxX(List<Double> max) {
		maxX=max;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public void adaptar(poblacion p) {
		adp.adaptar(p);
	}

	public void desadaptar(poblacion p) {
		adp.deshacer(p);
	}
	
}
