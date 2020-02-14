package funciones;

import java.util.ArrayList;
import java.util.List;

import genetica.gen;

public class funcion1 extends funcion{
	public funcion1() {
		super(2);
	}
	public void establecerMinimosMaximos() {
		List<Double>minimos=new ArrayList<Double>();
		minimos.add(-3.0);
		minimos.add(4.1);
		super.setMinX(minimos);
		
		List<Double>maximos=new ArrayList<Double>();
		maximos.add(12.1);
		maximos.add(5.8);
		super.setMaxX(maximos);
	}
	
	/*21.5 + x1.sen(4pi x1)+x2.sen(20pi x2)*/
	public double calcularFuncion(List<Double> x) {
		setX(x);
		double resultado=0;
		resultado=21.5 + getX(0)*Math.sin(4*Math.PI*getX(0)) + 
				getX(1)*Math.sin(20*Math.PI*getX(1));
		setRes(resultado);
		return resultado;
	}
	
}
