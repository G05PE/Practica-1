package funciones;

import java.util.ArrayList;
import java.util.List;

public class funcion4 {
	private List<Double> x;
	private double res=0;
	private final double minX=0;
	private final double maxX=Math.PI;
	
	public funcion4(List<Double> x) {
		this.x=x;
		if(rangoCorrecto()) {
			calcularFuncion4();
		}
		else {
			x.clear();
		}
	}
	public boolean rangoCorrecto(){
		int i=0;
		while(i < x.size()) {
			if(x.get(i) < minX || x.get(i) > maxX)
			{
				return false;
			}
			i++;
		}
		return true;
	}
	
	public void calcularFuncion4() {
		double resultado=0;
		for(int i=0; i < x.size(); i++) {
			//TO DO
		}
		res=-resultado;
	}
	
	public double getRes() {
		return res;
	}
	public List<Double> getX() {
		return x;
	}
	public void setX(List<Double> x) {
		this.x=new ArrayList<Double>(x);
	}
}
