package cruces;

import genetica.gen;
import poblacion.individuo;
import poblacion.poblacion;

public class uniforme extends algoritmoCruce{ 
	
	//Por cada alelo del padre se pregunta por la probabilidad de cruce, si la supera se cambia	
	@Override
	public poblacion cruzar(poblacion seleccionados, double prob) {
		super.ini(prob, seleccionados);
		seleccionaReproductores();
		
		//Copia seleccionados a los reproductores
		for(int i = 0; i < getReproductoresSize(); i += 2) {
			setDescendienteAt(i, new individuo(getReproductorAt(i)));
			setDescendienteAt(i+1, new individuo(getReproductorAt(i+1)));
			//Recorro los genes
			for(int j = 0; j < getReproductorAt(i).getLongitud(); j++) {
				int size=getReproductorAt(i).getCromosoma().get(j).getGenotipo().size();
				for(int k=0; k < size; k++ ) {
					if(Math.random()%1 < getProbCruce()) {
						getDescendienteAt(i).cruzarBit(j, k, getReproductor(i+1));
						getDescendienteAt(i+1).cruzarBit(j, k, getReproductor(i));
					}
				}
			}
		}
		return getDescendientes();	
	}	
}
