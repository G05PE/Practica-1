package seleccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class algoritmoEstocasticoUniv extends algoritmoSeleccion {

	private double totalFitness;
	private List<Double> probSeleccion;
	private double distancia;
	
	public algoritmoEstocasticoUniv(poblacion.poblacion p) {
		super(p);
		probSeleccion=new ArrayList<Double>();
		asignarProbabilidades();
		distancia=(double)1/getSizePoblacion();
		seleccionar();
	}

	@Override
	public void seleccionar() {
		int j=0;
		Random rand=new Random();
		double r;
		for(int k=0; k < getSizePoblacion();) {
			r=rand.nextDouble()%distancia;
			j=0;
			while(j < getSizePoblacion()) {
				while(j < getSizePoblacion() && r > probSeleccion.get(j)) {
					j++;
				}
				if(j < getSizePoblacion()) {
					if(j > 0 &&  probSeleccion.get(j-1) > r) j--;
					addSeleccionado(getIndividuo(j));
					r+=distancia;
					k++;
				}
			}
		}
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
