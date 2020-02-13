package funciones;

import java.util.ArrayList;
import java.util.List;

public class funcion1 extends funcion{
	
	public funcion1(List<Double> x) {
		super(x);
		establecerMinimosMaximos();
		super.ini();
	}
	public void establecerMinimosMaximos() {
		List<Double>minimos=new ArrayList<Double>(2);
		minimos.add(-3.0);
		minimos.add(4.1);
		super.setMinX(minimos);
		
		List<Double>maximos=new ArrayList<Double>(2);
		maximos.add(12.1);
		maximos.add(5.8);
		super.setMaxX(maximos);
	}
	
	/*@Override
	public boolean rangoCorrecto() {
		if(getX(1) >= getMinX(1) && getX(1) <= getMaxX(1)) {
			if(getX(2) >= getMinX(2) && getX(2) <= getMaxX(2)) {
				return true;
			}
		}
		return false;
	}*/
	
	/*21.5 + x1.sen(4pi x1)+x2.sen(20pi x2)*/
	public void calcularFuncion() {
		double resultado=0;
		resultado=21.5 + getX(0)*Math.sin(4*Math.PI*getX(0)) + getX(1)*Math.sin(20*Math.PI*getX(1));
		setRes(resultado);
	}
	
}
