package funciones;
public class funcion1 {
	private double x1, x2;
	private double res=0;
	private final double minX1=-3;
	private final double maxX1=12.1;
	private final double minX2=4.1;
	private final double maxX2=5.8;
	
	public funcion1(double x1, double x2) {
		if(rangoCorrecto(x1, x2)) {
			this.setX1(x1);
			this.setX2(x2);
			res=calcularFuncion1();
		}
	}
	public boolean rangoCorrecto(double x1, double x2){
		if(x1 >= minX1 && x1 <= maxX1){
			if(x2 >= minX2 && x2 <= maxX2){
				return true;
			}
		}
		return false;
	}
	
	/*21.5 + x1.sen(4pi x1)+x2.sen(20pi x2)*/
	public double calcularFuncion1() {
		double resultado=0;
		resultado=21.5 + x1*Math.sin(4*Math.PI*x1) + x2*Math.sin(20*Math.PI*x2);
		return resultado;
	}
	public double getRes() {
		return res;
	}
	public double getX1() {
		return x1;
	}
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public double getX2() {
		return x2;
	}
	public void setX2(double x2) {
		this.x2 = x2;
	}
	
}
