package genetica;

public class genReal extends gen{
	private double genotipo;
	private double fenotipo;
	private double min;
	private double max;
	
	public genReal(genReal gen) {
		this.genotipo=gen.getGenotipoReal();
		fenotipo=gen.getFenotipo();
		min=gen.getMin();
		max=gen.getMax();
	}
	public genReal() {}
	public void setFenotipo(double valor) {
		fenotipo=valor;
	}

	public double getGenotipoReal() {
		return genotipo;
	}

	/**Establece el genotipo y el fenotipo del gen*/
	public void setGenotipo(double d) {
		d%=max+min;
		if(d > max)
			d-=min;
		genotipo=d;
		fenotipo=genotipo;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public Double getFenotipo() {
		return fenotipo;
	}
	public double getAleatorio() {
		double valor=Math.random()%max + min;
		if(valor > max)
			return (valor-min);
		return valor;
	}
	
}
