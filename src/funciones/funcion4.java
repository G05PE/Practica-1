package funciones;

import java.util.ArrayList;
import java.util.List;

public class funcion4 extends funcion{
	
	public funcion4(int var) {
		super(var);
	}

	public void establecerMinimosMaximos() {
		List<Double>minimos=new ArrayList<Double>();
		for(int i=0; i < getSize(); i++) {
			minimos.add(0.0);
		}
		super.setMinX(minimos);
		
		List<Double>maximos=new ArrayList<Double>();
		for(int i=0; i < getSize(); i++) {
			maximos.add(Math.PI);
		}
		super.setMaxX(maximos);
	}

	public double calcularFuncion(List<Double> x) {//No probada
		setX(x);
		double resultado=0;
		for(int i=0; i < getSize(); i++) {
			resultado+=Math.sin(getX(i)*Math.pow(
					Math.sin((i+1)*Math.pow(getX(i), 2)/Math.PI), 20));
		}
		setRes(-resultado);
		return -resultado;
	}

	@Override
	public boolean best(double fitness, double best) {
		return fitness < best;
	}

	@Override
	public boolean worst(double fitness, double fitness2) {
		return fitness > fitness2;
	}
	
}
