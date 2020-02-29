package model;

import poblacion.poblacion;

public abstract class adaptacion {
	private final double c=1.05;
	private double limit;
	
	public void setLimit(double l) {
		limit=l;
	}
	public double getLimit() {
		return limit;
	}
	public double getC() {
		return c;
	}
	
	public void adaptar(poblacion p) {
		establecerLimite(p);
		ajustar(p);
	}
	public abstract void deshacer(poblacion p);
	protected abstract void ajustar(poblacion p);
	protected abstract void establecerLimite(poblacion p);
}
