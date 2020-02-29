package funciones;

import java.util.ArrayList;
import java.util.List;

import model.adaptarMin;

public class funcion4 extends funcion{
	
	public funcion4(int var) {
		super(var);
		super.setAdapt(new adaptarMin());
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

	public double calcularFuncion(List<Double> fitness) {
		double resultado=0;
		for(int i=0; i < getSize(); i++) {
			resultado+=Math.sin(fitness.get(i)*Math.pow(
					Math.sin((i+1)*Math.pow(fitness.get(i), 2)/Math.PI), 20));
		}
		return -resultado;
	}

	@Override
	public boolean best(double fitness, double best) {
		if(getAdapt().getAdaptado())
		{
			return fitness > best;
		}else {
			return fitness < best;
		}
	}

	@Override
	public boolean worst(double fitness, double fitness2) {
		if(getAdapt().getAdaptado())
		{
			return fitness < fitness2;
		}else {
			return fitness > fitness2;
		}
	}
	
}
