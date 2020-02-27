package cruces;

import java.util.Random;

import genetica.gen;
import poblacion.individuo;
import poblacion.poblacion;

public class mutacionUniforme extends mutacion{

	@Override
	public poblacion mutar(poblacion poblacion, double probMutacion){

		for(int i = 0; i < poblacion.getSize(); i++) {//Recorro los individuos
			Boolean mutado = false;
			mutado = mutarIndividuo(poblacion.getIndividuo(i), probMutacion);
			if(mutado) poblacion.getIndividuo(i).calcularFitness();
		}
		return poblacion;
	}

	public boolean mutarIndividuo(individuo ind, double probMutacion) {
		boolean mutado=false;
		for(int i = 0; i < ind.getCromosoma().size(); i++){//Recorro los genes
				if(muta(ind.getCromosomaAt(i), probMutacion)) {
					mutado=true;
					ind.recalcularFenotipo(i);
				}
			}
		return mutado;
	}

	private boolean muta(gen entrada, double probMutacion) {
		boolean mutado=false;
		
		for(int i = 0; i < entrada.getTam(); i++) {//Recorre los bits
			Random r = new Random();
			double rand = Math.random()%1;
			
			if(rand < probMutacion){
				//Esto solo sirve para valores binarios, no para la funcion 4
				Boolean valor = false;
				if(r.nextInt()%1 == 1)valor = true;
				
				entrada.setBit(i, valor);
				mutado=true;
			}
		}	
		return mutado;
	}

}
