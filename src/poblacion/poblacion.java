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
		return new individuo(poblacion.get(i));
	}
	
	public void setIndividuos(List<individuo> nuevos) {
		poblacion=nuevos;
	}
	
	public int getSize() {
		return tam;
	}

	public double getBest() {
		for(int i=0; i < poblacion.size(); i++) {
			if(fun.best(poblacion.get(i).getFitness(), best)){
				best=poblacion.get(i).getFitness();
			}
		}
		return best;
	}

	public double getBestGen() {
		double bestGen=poblacion.get(0).getFitness();
		for(int i=1; i < poblacion.size(); i++) {
			if(fun.best(poblacion.get(i).getFitness(), bestGen)){
				bestGen=poblacion.get(i).getFitness();
			}
		}
		return bestGen;
	}

	public double getAverage() {
		double total=0;
		for(int i=0; i < poblacion.size(); i++) {
			total+=poblacion.get(i).getFitness();
		}
		return total/poblacion.size();
	}
	
	public double getPrecision() {
		return precision;
	}

	public funcion getFuncion() {
		return fun;
	}	
	
	//No se si esto peta, debería borrar el último
	public void borraUltimo() {
		poblacion.remove(poblacion.size());
		tam--;
	}
	
	public void addIndividuo(individuo ind) {
		poblacion.add(ind);
	}

	public void iniBest() {
		best=poblacion.get(0).getFitness();
	}

}
