package funciones;

import java.util.ArrayList;
import java.util.List;

public class funcion4 extends funcion{
	
	private int size;
	
	public funcion4(List<Double> x) {
		super(x);
		size=x.size();
		establecerMinimosMaximos();
		super.ini();
	}
	
	public void establecerMinimosMaximos() {
		List<Double>minimos=new ArrayList<Double>();
		for(int i=0; i < size; i++) {
			minimos.add(0.0);
		}
		super.setMinX(minimos);
		
		List<Double>maximos=new ArrayList<Double>();
		for(int i=0; i < size; i++) {
			maximos.add(Math.PI);
		}
		super.setMaxX(maximos);
	}

	public void calcularFuncion() {
		double resultado=0;
		for(int i=0; i < size; i++) {
			resultado+=Math.sin(getX(i)*Math.pow(
					Math.sin((i+1)*Math.pow(getX(i), 2)/Math.PI), 20));
		}
		setRes(-resultado);
	}
	
}
