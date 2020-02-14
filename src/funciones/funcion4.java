package funciones;

import java.util.ArrayList;
import java.util.List;

public class funcion4 extends funcion{
	
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

	public void calcularFuncion(List<Double> x) {//No probada
		setX(x);
		establecerMinimosMaximos();
		if(rangoCorrecto()) {
			double resultado=0;
			for(int i=0; i < getSize(); i++) {
				resultado+=Math.sin(getX(i)*Math.pow(
						Math.sin((i+1)*Math.pow(getX(i), 2)/Math.PI), 20));
			}
			setRes(-resultado);
		}
	}
	
}
