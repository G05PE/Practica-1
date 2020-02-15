package seleccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import poblacion.individuo;
import poblacion.poblacion;

public class algoritmoRuleta extends algoritmoSeleccion{
	private poblacion poblacion;
	private List<Double> probSeleccion;
	private List<individuo> seleccionados;
	private double totalFitness;
	
	public algoritmoRuleta(poblacion p) {
		poblacion=p;
		iniciar();
	}
	
	public void iniciar() {
		probSeleccion=new ArrayList<Double>();
		seleccionados=new ArrayList<individuo>();
		asignarProbabilidades();
		seleccionar();
	}

	private void seleccionar() {
		Random r=new Random();
		for(int j=0; j < poblacion.getSize(); j++) {
			double valor=r.nextDouble() % 1;
			int i=0;
			while(i < probSeleccion.size() && valor > probSeleccion.get(i)) {
				i++;
			}
			if(probSeleccion.get(i-1) > valor) i--;
			seleccionados.add(poblacion.getIndividuo(i));
		}
	}

	private void asignarProbabilidades() {
		calcularTotalFitness();
		for(int i=0; i < poblacion.getSize(); i++) {
			double prob=0;
			prob=poblacion.getIndividuo(i).getFitness()/totalFitness;
			if(i > 0) {
				prob +=probSeleccion.get(i-1);
			}
			probSeleccion.add(prob);
		}
	}

	private void calcularTotalFitness() {
		totalFitness=0;
		for(int i=0; i < poblacion.getSize(); i++) {
			totalFitness += poblacion.getIndividuo(i).getFitness();
		}
	}
}
