package funciones;

import java.util.ArrayList;
import java.util.List;

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
	public double calcularFuncion(List<Double> fenotipos) {
		double resultado=0;
		resultado=21.5 + fenotipos.get(0)*Math.sin(4*Math.PI*fenotipos.get(0)) + 
				fenotipos.get(1)*Math.sin(20*Math.PI*fenotipos.get(1));
		return resultado;
	}
	@Override
	public boolean best(double fitness, double best) {
		return fitness > best;
	}
	@Override
	public boolean worst(double fitness, double fitness2) {
		return fitness < fitness2;
	}
	
}
