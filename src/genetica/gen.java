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
	
	public gen(gen gen) {
		rand=new Random();
		fenotipo=gen.getFenotipo();
		funcion=gen.getFuncion();
		tam=gen.getTam();
		genotipo=new ArrayList<Boolean>();
		for(int i=0; i < gen.getGenotipo().size(); i++) {
			genotipo.add(new Boolean(gen.getGenotipo().get(i)));
		}
	}
	
	public double getTam() {
		return tam;
	}

	public funciones.funcion getFuncion() {
		return funcion;
	}

	public void generarGen() {
		genotipo=new ArrayList<Boolean>();
		rand=new Random();
		for(int i=0; i < tam; i++) {
			genotipo.add(new Boolean(rand.nextBoolean()));
		}
	}
	
	public void calcularFenotipo() {
		
	}
	public double getFenotipo() {
		return fenotipo;
	}
	public void setBit(int i, Boolean bit) {
		Boolean newBit=new Boolean(bit.booleanValue());
		genotipo.set(i, newBit);
	}
	public List<Boolean> getGenotipo() {
		return genotipo;
	}
	public void setFenotipo(double d) {
		fenotipo=d;
	}
}
