package funciones;
import java.util.ArrayList;
import java.util.List;

public class funcion3 extends funcion{
	
	public funcion3(List<Double> x){
		super(x);
		establecerMinimosMaximos();
		super.ini();
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
	
	public void calcularFuncion() {//Sin probar
		double res=1;
		double aux=0;
		for(int i=0; i < getSize(); i++) {
			for(int j=1; j <= 5; j++) {
				aux=aux + j*Math.cos((j+1)*getX(i)+j);
			}
			res=res*aux;
			aux=0;
		}
		setRes(res);
	}
}
