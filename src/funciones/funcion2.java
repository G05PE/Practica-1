package funciones;

import java.util.ArrayList;
import java.util.List;

public class funcion2 extends funcion{
	
	public funcion2(List<Double> x) {
		super(x);
		establecerMinimosMaximos();
		super.ini();
	}
	
	public void establecerMinimosMaximos() {
		List<Double>minimos=new ArrayList<Double>(2);
		for(int i=0; i < 2; i++) {
			minimos.add(-10.0);
		}
		super.setMinX(minimos);
		
		List<Double>maximos=new ArrayList<Double>(2);
		for(int i=0; i < 2; i++) {
			maximos.add(10.0);
		}
		super.setMaxX(maximos);
	}

	/*expcomponent = exp( abs(1 - (sqrt(X .^2 + Y .^ 2) / pi)) );
      scores = -abs(sin(X) .* cos(Y) .* expcomponent);*/
	public void calcularFuncion() {
		double resultado=0;
		double raiz=Math.sqrt(Math.pow(getX(0), 2) + Math.pow(getX(1), 2));
		double excomponent=Math.exp(Math.abs( 1 - raiz/Math.PI));
		resultado= -Math.abs(Math.sin(getX(0)) * Math.cos(getX(1)) * excomponent);
		setRes(resultado);
	}
}
