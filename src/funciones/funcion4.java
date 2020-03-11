package funciones;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import model.adaptarMin;
import poblacion.individuo;

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
		double sen1, sen2, valor, fit;
		for(int i=0; i < getSize(); i++) {
			fit=fitness.get(i);
			sen1=Math.sin(fit);
			valor= ((i+2)*Math.pow(fit, 2))/Math.PI;
			sen2=Math.pow(Math.sin(valor), 20);
			resultado+=sen1*sen2;
		}
		return -resultado;
	}
	
	public double truncar(double x) {
		String st=x+"";
		double res;
		String st2="";
		for(int i=0; i < st.length() && i < 10; i++) {
			st2+=st.charAt(i);
		}
		res=Double.parseDouble(st2);
		return res;
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

	@Override
	public void addElite(List<individuo> objetivo, List<individuo> fuente, double tamElite) {
		for(int i=0; i < tamElite; i++) {
			objetivo.add(new individuo(fuente.get(i)));
		}
	}
	
}
