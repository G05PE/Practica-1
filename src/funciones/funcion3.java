package funciones;
import java.util.ArrayList;
import java.util.List;

public class funcion3 {
	
	private List<Double> x;
	private double res=1;
	private final double minX=-10;
	private final double maxX=10;
	
	//Constructor con una x
	public funcion3(double x1){
		x=new ArrayList<Double>();
		x.add(x1);
		if(rangoCorrecto()) {
			calcularFuncion3();
		}
		else{
			x.clear();
		}
	}
	
	//Constructor con 2 x
	public funcion3(double x1, double x2){
		x=new ArrayList<Double>();
		x.add(x1);
		x.add(x2);
		if(rangoCorrecto()) {
			calcularFuncion3();
		}
		else {
			x.clear();
		}
	}
	
	public boolean rangoCorrecto(){
		int i=0;
		while(i < x.size()) {
			if(x.get(i) < minX || x.get(i) > maxX)
			{
				return false;
			}
			i++;
		}
		return true;
	}
	
	
	public void calcularFuncion3() {
		double resultado=0;
		for(int i=0; i < x.size(); i++) {
			for(int j=1; j <= 5; j++) {
				resultado=resultado + j*Math.cos((j+1)*x.get(i)+j);
			}
			res=res*resultado;
		}
	}
	
	public double getRes() {
		return res;
	}
	public List<Double> getX() {
		return x;
	}
	public void setX(double x1, double x2) {
		x.clear();
		x.add(x1);
		x.add(x2);
	}
	public void setX1(double x1) {
		x.set(1, x1);
	}
	public void getX2(double x2) {
		x.set(2, x2);
	}
}
