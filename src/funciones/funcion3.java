package funciones;
import java.util.ArrayList;
import java.util.List;

public class funcion3 extends funcion{
	
	public funcion3(int var) {
		super(var);
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
	
	public double calcularFuncion(List<Double> fitness) {
		double res=1;
		double aux=0;
		for(int i=0; i < getSize(); i++) {
			for(int j=1; j <= 5; j++) {
				aux=aux + j*Math.cos((j+1)*fitness.get(i)+j);
			}
			res=res*aux;
			aux=0;
		}
		return res;
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
