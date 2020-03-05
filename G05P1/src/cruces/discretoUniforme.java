package cruces;

import poblacion.poblacion;

public class discretoUniforme extends algoritmoCruce{ 
	
	//Por cada alelo del padre se pregunta por la probabilidad de cruce, si la supera se cambia	
	@Override
	public poblacion cruzar(poblacion seleccionados, double prob) {
		ini(prob, seleccionados);
		for(int i = 0; i < seleccionados.getSize() - 1; i += 2) {
			setDescendienteAt(i, getSeleccionadoConcreto(i));
			setDescendienteAt(i+1, getSeleccionadoConcreto(i + 1));
					
			for(int j = 0; j < getDescendienteAt(i).getLongitud(); j++) {
				if(Math.random()%1 < getProbCruce()) {
					double aux = getDescendienteAt(i).getGenotipoReal(j);
					double aux2 = getDescendienteAt(i+1).getGenotipoReal(j);	
					getDescendienteAt(i).setGenReal(j, aux2);
					getDescendienteAt(i+1).setGenReal(j, aux);	
				}
			}
		}
		
		return getDescendientes();	
	}

}
