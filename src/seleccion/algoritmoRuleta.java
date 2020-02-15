package seleccion;

import java.util.Random;
import poblacion.poblacion;

public class algoritmoRuleta extends algoritmoSeleccion{
	private double totalFitness;
	
	public algoritmoRuleta(poblacion p) {
		super(p);
		asignarProbabilidades();
		seleccionar();
	}

	public void seleccionar() {
		Random r=new Random();
		for(int j=0; j < getSizePoblacion(); j++) {
			double valor=r.nextDouble() % 1;
			int i=0;
			while(i < getSizePoblacion() && valor > getProbSeleccion(i)) {
				i++;
			}
			if(getProbSeleccion(i-1) > valor) i--;
			addSeleccionado(getIndividuo(i));
		}
	}

	public void asignarProbabilidades() {
		calcularTotalFitness();
		for(int i=0; i < getSizePoblacion(); i++) {
			double prob=0;
			prob=getIndividuo(i).getFitness()/totalFitness;
			if(i > 0) {
				prob +=getProbSeleccion(i-1);
			}
			addProbabilidad(prob);
		}
	}

	private void calcularTotalFitness() {
		totalFitness=0;
		for(int i=0; i < getSizePoblacion(); i++) {
			totalFitness += getIndividuo(i).getFitness();
		}
	}
}
