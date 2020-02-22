package cruces;

import java.util.List;

import genetica.gen;
import poblacion.individuo;
import poblacion.poblacion;

public class uniforme extends algoritmoCruce{ //Tema 3 pagina 12

	
	public uniforme(double probCruce, poblacion seleccionados) {
		super(probCruce, seleccionados);
	}

	
	//Por cada alelo se pregunta por la probabilidad de cruce, si la supera se cambia
	//sino se queda igual
	
	@Override
	public poblacion cruzar() {
		for(int i = 0; i < getSeleccionados().getSize(); i++) {
			individuo indActual = getSeleccionadoConcreto(i);
			addDescendiente(indActual);
			
			for(int j = 0; j < indActual.getCromosoma().size(); j++) {
				gen genAct = indActual.getCromosomaAt(i);			
				for(int k = 0; k < genAct.getGenotipo().size(); k++) {
					
					boolean alelo = genAct.getGenotipo().get(k);
					
					if(Math.random() < getProbCruce()) {
						getDescendiente
					}
				}
			}
		}
		creaDescendientes();
		return descendientes;
	}


	private void seleccionaReproductores() {
		
		for(int i = 0; i < getSeleccionados().getSize(); i += 2) {
			individuo ind1 = getSeleccionadoConcreto(i);
			individuo ind2 = getSeleccionadoConcreto(i + 1);
			
			if(Math.random() < getProbCruce()) addReprpoductor(ind1);
			else addReprpoductor(ind2);
		}
	}
	
	private void creaDescendientes() {
		
	}

}
