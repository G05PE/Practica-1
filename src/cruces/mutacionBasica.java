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
			if(mutado) poblacion.getIndividuo(i).calcularFitness();
		}
		return poblacion;
	}

	public boolean mutarIndividuo(individuo ind, double probMutacion) {
		//individuo ret = ind;
		boolean mutado=false;
		for(int i = 0; i < ind.getCromosoma().size(); i++){//Recorro los genes
			/*double rand = Math.random()%1;
			if(rand < probMutacion){
				ret.setGen(i, invierte(ind.getCromosomaAt(i)));
				mutado = true;*/
				mutado|=invierte(ind.getCromosoma(i), probMutacion);
			}
		return mutado;
	}

	private boolean invierte(gen entrada, double probMutacion) {
		gen salida = entrada;//esto es un puntero OJO
		boolean mutado=false;
		for(int i = 0; i < entrada.getTam(); i++) {//Recorre los bits
			double rand = Math.random()%1;
			if(rand < probMutacion){
				salida.setBit(i, !entrada.getGenotipo().get(i));
				mutado=true;
			}
		}	
		return mutado;
	}
}

