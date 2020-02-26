package cruces;

import poblacion.individuo;
import poblacion.poblacion;

public class aritmetico extends algoritmoCruce {


	private int num_sele_cruce;
	private double alpha;


	public aritmetico() {
		num_sele_cruce = 0;
	}

	@Override
	public poblacion cruzar(poblacion seleccionados, double prob) {
		seleccionaReproductores();
		alpha = Math.random()%1;

		for(int i = 0; i < getSeleccionados().getSize() - 1; i+=2) {
			individuo padre1 = getReproductor(i);
			individuo padre2 = getReproductor(i + 1);

			for(int j = 0; j < getReproductor(i).getLongitud(); j++) {

				double media1 = ((alpha*padre1.getCromosomaAt(j).getFenotipo())+((1 - alpha)*padre2.getCromosomaAt(j).getFenotipo()))/2;
				double media2 = ((alpha*padre2.getCromosomaAt(j).getFenotipo())+((1 - alpha)*padre1.getCromosomaAt(j).getFenotipo()))/2;

				//Crea hijo1
				//Crea hijo2
			}

		}

		return getDescendientes();

	}


	private void seleccionaReproductores() {

		for(int i = 0; i < getSeleccionados().getSize(); i++) {
			if(Math.random()%1 < getProbCruce()) {
				addReprpoductor(getSeleccionadoConcreto(i));
				num_sele_cruce++;
			}		
		}

		if(this.sizeReproductor() % 2 != 0) {
			borraUltimoReproductor();
			num_sele_cruce--;
		}		
	}


}