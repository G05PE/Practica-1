package funciones;

import java.util.List;

public abstract class funcion {
	//private List<Double> x;
	//private double res;
	private List<Double> minX;
	private List<Double> maxX;
	private int size;
	public funcion(int var) {
		setSize(var);
		//x=new ArrayList<Double>();
		establecerMinimosMaximos();
		//iniVars();
	}
	
	public abstract boolean worst(double fitness, double fitness2);
	public abstract boolean best(double fitness, double best);
	public abstract double calcularFuncion(List<Double> fenotipos);
	public abstract void establecerMinimosMaximos();
	
	/*public void iniVars() {
		for(int i=0; i < getSize(); i++) {
			double var=Math.random()%getMaxX(i) + getMinX(i);
			if(var > getMaxX(i))
				var-=getMinX(i);	
			x.add(var);
		}
	}*/
	public double getMinX(int i) {
		return minX.get(i);
	}
	public double getMaxX(int i) {
		return maxX.get(i);
	}
	public int getSize() {
		return size;
	}
	/*public double getRes() {
		return res;
	}
	protected void setRes(double res) {
		this.res=res;
	}
	public double getX(int i) {
		return x.get(i);
	}
	public void setX(List<Double> x) {
		this.x=new ArrayList<Double>(x);
	}*/
	protected void setMinX(List<Double> min) {
		minX=min;
	}
	protected void setMaxX(List<Double> max) {
		maxX=max;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
