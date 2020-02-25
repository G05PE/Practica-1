package cruces;

import genetica.gen;
import poblacion.individuo;
import poblacion.poblacion;

public class mutacionBasica extends mutacion{

	@Override
	public poblacion mutar(poblacion poblacion, double probMutacion){

		for(int i = 0; i < poblacion.getSize(); i++) {//Recorro los individuos
			Boolean mutado = false;
			mutado=mutarIndividuo(poblacion.getIndividuo(i), probMutacion);
			if(mutado) {
				poblacion.getIndividuo(i).calcularFitness();
			}
		}
		return poblacion;
	}

	public boolean mutarIndividuo(individuo ind, double probMutacion) {
		boolean mutado=false;
		for(int i = 0; i < ind.getCromosoma().size(); i++){//Recorro los genes
				if(invierte(ind.getCromosoma(i), probMutacion)) {
					mutado=true;
					ind.recalcularFenotipo(i);
				}
			}
		return mutado;
	}

	private boolean invierte(gen entrada, double probMutacion) {
		boolean mutado=false;
		for(int i = 0; i < entrada.getTam(); i++) {//Recorre los bits
			double rand = Math.random()%1;
			if(rand < probMutacion){
				entrada.setBit(i, !entrada.getGenotipo().get(i));
				mutado=true;
			}
		}	
		return mutado;
	}
}


