package poblacion;

import java.util.ArrayList;
import java.util.List;

import funciones.funcion;

public class poblacion {
	
	private List<individuo> poblacion;
	private int tam=0;
	private funcion fun;
	private double best;
	private double precision;
	
	public poblacion(int tam, double prec, funcion fun) {
		poblacion=new ArrayList<individuo>();
		this.tam=tam;
		this.fun=fun;
		precision=prec;
	}
	
	public void iniciarPoblacion() {
		
		for(int i=0; i < tam; i++) {
			individuo cromosoma=new individuo(fun, precision);
			poblacion.add(cromosoma);
		}
		iniBest();
	}
	
	public individuo getIndividuo(int i) {
		return poblacion.get(i);
	}
	
	public void setIndividuos(List<individuo> nuevos) {
		poblacion=nuevos;
	}
	
	public int getSize() {
		return tam;
	}

	public double getBest() {
		iniBest();
		for(int i=0; i < poblacion.size(); i++) {
			if(fun.best(poblacion.get(i).getFitness(), best)){
				best=poblacion.get(i).getFitness();
			}
		}
		return best;
	}

	public double getAverage() {
		double total=0;
		for(int i=0; i < poblacion.size(); i++) {
			total+=poblacion.get(i).getFitness();
		}
		return total/poblacion.size();
	}
	
	public void borraUltimo() {
		poblacion.remove(poblacion.size()-1);
		tam--;
	}
	
	public double getPrecision() {
		return precision;
	}

	public funcion getFuncion() {
		return fun;
	}
	public void iniBest() {
		best=poblacion.get(0).getFitness();
	}
	public void addIndividuo(individuo i) {
		poblacion.add(i);
	}

	public void setIndividuoAt(int i, individuo individuo) {
		poblacion.set(i, new individuo(individuo));
	}

	public void setSize(int num_sele_cruce) {
		this.tam = num_sele_cruce;
	}
}
