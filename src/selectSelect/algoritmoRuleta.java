package selectSelect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import poblacion.poblacion;

public class algoritmoRuleta extends algoritmoSeleccion{
	private double totalFitness;
	private List<Double> probSeleccion;
	
	public algoritmoRuleta() {
		probSeleccion=new ArrayList<Double>();
	}
	public poblacion ini(poblacion p) {
		iniSeleccionados(p.getSize(), p.getPrecision(), p.getFuncion());
		asignarProbabilidades(p);
		seleccionar(p);
		getSeleccionados().iniBest();
		return getSeleccionados();
	}
	public void seleccionar(poblacion p) {
		Random r=new Random();
		for(int j=0; j < p.getSize(); j++) {
			double valor=r.nextDouble() % 1;
			int i=0;
			while(i < p.getSize() && valor > probSeleccion.get(i)) {
				i++;
			}
			if(i > 0 && probSeleccion.get(i-1) > valor) i--;
			addSeleccionado(p.getIndividuo(i));
		}
	}

	public void asignarProbabilidades(poblacion p) {
		calcularTotalFitness(p);
		for(int i=0; i < p.getSize(); i++) {
			double prob=0;
			prob=p.getIndividuo(i).getFitness()/totalFitness;
			if(i > 0) {
				prob +=probSeleccion.get(i-1);
			}
			probSeleccion.add(prob);
		}
	}

	private void calcularTotalFitness(poblacion p) {
		totalFitness=0;
		for(int i=0; i < p.getSize(); i++) {
			totalFitness += p.getIndividuo(i).getFitness();
		}
	}
}