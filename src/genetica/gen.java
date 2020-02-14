package genetica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import funciones.funcion;
public class gen {
	private List<Boolean> genotipo;
	private double fenotipo;
	private funcion funcion;
	private double tam;
	private Random rand;
	public gen(funcion f, double precision, double tam) {
		funcion=f;
		this.tam=tam;
		generarGen();
		calcularFenotipo();
	}
	public void generarGen() {
		genotipo=new ArrayList<Boolean>();
		rand=new Random();
		for(int i=0; i < tam; i++) {
			genotipo.add(rand.nextBoolean());
		}
	}
	
	public void calcularFenotipo() {
		
	}
	public double getFenotipo() {
		return fenotipo;
	}
	public List<Boolean> getGenotipo() {
		return genotipo;
	}
	public void setFenotipo(double d) {
		fenotipo=d;
	}
}
