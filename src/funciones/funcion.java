package funciones;

import java.util.ArrayList;
import java.util.List;

import genetica.gen;

public abstract class funcion {
	private List<Double> x;
	private double res;
	private List<Double> minX;
	private List<Double> maxX;
	
	public boolean rangoCorrecto(){
		this.x=x;
		int i=0;
		while(i < x.size()) {
			if(x.get(i) < minX.get(i) || x.get(i) > maxX.get(i))
			{
				return false;
			}
			i++;
		}
		return true;
	}
	public abstract void calcularFuncion(List<Double> x);
	public abstract void establecerMinimosMaximos();
	public void test(List<Double> x) {
		calcularFuncion(x);
		System.out.println("El resultado es "+ res);
	}
	public double getMinX(int i) {
		return minX.get(i);
	}
	public double getMaxX(int i) {
		return maxX.get(i);
	}
	public double getRes() {
		return res;
	}
	protected void setRes(double res) {
		this.res=res;
	}
	public int getSize() {
		return x.size();
	}
	public double getX(int i) {
		return x.get(i);
	}
	public void setX(List<Double> x) {
		this.x=new ArrayList<Double>(x);
	}
	protected void setMinX(List<Double> min) {
		minX=min;
	}
	protected void setMaxX(List<Double> max) {
		maxX=max;
	}
	
}
