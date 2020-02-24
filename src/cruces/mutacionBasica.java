package cruces;

import genetica.gen;
import poblacion.individuo;
import poblacion.poblacion;

public class mutacionBasica extends mutacion{

	double probMutacion;
	poblacion poblacion;

	//Constructor
	public mutacionBasica(double probMutacion, poblacion poblacion){
		super(probMutacion, poblacion);
		this.probMutacion = probMutacion;
		this.poblacion = poblacion;
	}

	@Override
	
	
	//Esto me parece que no tiene mucho sentido per oes lo que pone en la Pag 55 Tema 2
	public poblacion mutar(){

		for(int i = 0; i < poblacion.getSize(); i++) {
			Boolean mutado = false;
			mutarIndividuo(poblacion.getIndividuo(i), mutado);
			//if(mutado) poblacion.getIndividuo(i).setFitness(poblacion.getIndividuo(i).evalua());
		}
		return poblacion;
	}

	public individuo mutarIndividuo(individuo ind, Boolean mutado) {
		individuo ret = ind;
		
		for(int i = 0; i < ind.getCromosoma().size(); i++){
			double rand = Math.random()%1;
			if(rand < probMutacion){
				ret.setGen(i, invierte(ind.getCromosomaAt(i)));
				mutado = true;
			}
		}
		
		return ret;
	}

	private gen invierte(gen entrada) {
		gen salida = entrada;
		for(int i = 0; i < entrada.getTam(); i++) {
			salida.setBit(i, !entrada.getGenotipo().get(i));
		}
		return salida;
	}



}

