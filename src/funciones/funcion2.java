package funciones;

import java.util.ArrayList;
import java.util.List;

import model.adaptarMax;
import model.adaptarMin;

public class funcion2 extends funcion{
	
	public funcion2() {
		super(2);
		super.setAdapt(new adaptarMin());
	}
	public void establecerMinimosMaximos() {
		List<Double>minimos=new ArrayList<Double>();
		for(int i=0; i < getSize(); i++) {
			minimos.add(-10.0);
		}
		super.setMinX(minimos);
		
		List<Double>maximos=new ArrayList<Double>();
		for(int i=0; i < getSize(); i++) {
			maximos.add(10.0);
		}
		super.setMaxX(maximos);
	}

	/*expcomponent = exp( abs(1 - (sqrt(X .^2 + Y .^ 2) / pi)) );
      scores = -abs(sin(X) .* cos(Y) .* expcomponent);*/
	public double calcularFuncion(List<Double> fitness) {
		double resultado=0;
		double raiz=Math.sqrt(Math.pow(fitness.get(0), 2) + Math.pow(fitness.get(1), 2));
		double excomponent=Math.exp(Math.abs( 1 - raiz/Math.PI));
		resultado= -Math.abs(Math.sin(fitness.get(0)) * Math.cos(fitness.get(1)) * excomponent);
		return resultado;
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
