package cruces;

import genetica.gen;
import poblacion.poblacion;

public class uniforme extends algoritmoCruce{ //Tema 3 pagina 12

	
	public uniforme(double probCruce, poblacion seleccionados) {
		super(probCruce, seleccionados);
	}

	
	//Por cada alelo del padre se pregunta por la probabilidad de cruce, si la supera se cambia	
	@Override
	public poblacion cruzar() {
		for(int i = 0; i < getSeleccionados().getSize() - 1; i += 2) {
			addDescendiente(getSeleccionadoConcreto(i));
			addDescendiente(getSeleccionadoConcreto(i + 1));
					
			for(int j = 0; j < getDescendienteAt(i).getLongitud(); j++) {
				if(Math.random() < getProbCruce()) {
					gen aux = getDescendienteAt(i).getCromosomaAt(j);
					getDescendienteAt(i).setGen(j, getDescendienteAt(i+1).getCromosomaAt(j));
					getDescendienteAt(i+1).setGen(j, aux);
				}
			}
		}
		
		return getDescendientes();	
	}
	
}

