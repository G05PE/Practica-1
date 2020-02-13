package funciones;

public class funcion2 {
	private double x, y;
	private double res=0;
	private final double minX=-10;
	private final double maxX=10;
	private final double minY=-10;
	private final double maxY=10;
	
	public funcion2(double x, double y) {
		if(rangoCorrecto(x, y)) {
			this.x=x;
			this.y=y;
			res=calcularFuncion2();
		}
	}
	public boolean rangoCorrecto(double x1, double x2){
		if(x >= minX && x <= maxX){
			if(y >= minY && y <= maxY){
				return true;
			}
		}
		return false;
	}
	/*expcomponent = exp( abs(1 - (sqrt(X .^2 + Y .^ 2) / pi)) );
      scores = -abs(sin(X) .* cos(Y) .* expcomponent);*/
	public double calcularFuncion2() {
		double resultado=0;
		double excomponent=Math.exp(Math.abs(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))/Math.PI));
		resultado= -Math.abs(Math.sin(x) * Math.cos(y) * excomponent);
		return resultado;
	}
	public double getRes() {
		return res;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
