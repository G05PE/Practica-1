package cruces;

import java.util.Random;

import genetica.gen;
import genetica.genReal;
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
		for(int i = 0; i < ind.getLongitud(); i++){//Recorro los genes
				if(muta((genReal)ind.getCromosomaAt(i), probMutacion)) {
					mutado=true;
					ind.recalcularFenotipo(i);
				}
			}
		return mutado;
	}

	private boolean muta(genReal entrada, double probMutacion) {
		boolean mutado=false;
		
		for(int i = 0; i < entrada.getTam(); i++) {//Recorre los bits
			Random r = new Random();
			double rand = Math.random()%1;
			
			if(rand < probMutacion){
				double valor=0;
				if(r.nextInt()%1 == 1)
					valor=entrada.getAleatorio();
				entrada.setGenotipo(valor);
				mutado=true;
			}
		}	
		return mutado;
	}

}
