package seleccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import poblacion.poblacion;

public class algoritmoRuleta extends algoritmoSeleccion{
	private double totalFitness;
	private List<Double> probSeleccion;
	
	public algoritmoRuleta(poblacion p) {
		super(p);
		probSeleccion=new ArrayList<Double>();
		asignarProbabilidades();
		seleccionar();
	}

	public poblacion seleccionar() {
		Random r=new Random();
		for(int j=0; j < getSizePoblacion(); j++) {
			double valor=r.nextDouble() % 1;
			int i=0;
			while(i < getSizePoblacion() && valor > probSeleccion.get(i)) {
				i++;
			}
			if(i > 0 && probSeleccion.get(i-1) > valor) i--;
			addSeleccionado(getIndividuo(i));
		}
		return getPoblacion();
	}

	public void asignarProbabilidades() {
		calcularTotalFitness();
		for(int i=0; i < getSizePoblacion(); i++) {
			double prob=0;
			prob=getIndividuo(i).getFitness()/totalFitness;
			if(i > 0) {
				prob +=probSeleccion.get(i-1);
			}
			probSeleccion.add(prob);
		}
	}

	private void calcularTotalFitness() {
		totalFitness=0;
		for(int i=0; i < getSizePoblacion(); i++) {
			totalFitness += getIndividuo(i).getFitness();
		}
	}
}
