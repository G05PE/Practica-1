package cruces;

import poblacion.individuo;
import poblacion.poblacion;

public class aritmetico extends algoritmoCruce {


	private int num_sele_cruce;
	private double alpha;


	public aritmetico() {}

	@Override
	public poblacion cruzar(poblacion seleccionados, double prob) {
		
		ini(prob, seleccionados);
		seleccionaReproductores();
		alpha = Math.random()%1;

		for(int i = 0; i < getReproductoresSize() - 1; i+=2) {
			individuo padre1 = getReproductor(i);
			individuo padre2 = getReproductor(i + 1);
			cruceAritmetico(i, padre1, padre2);
		}
		return getDescendientes();
	}



	private void cruceAritmetico(int i, individuo padre1, individuo padre2) {
		individuo hijo1 = new individuo(padre1);
		individuo hijo2 = new individuo(padre2);
		
		//Mira todos los genes
		for(int j = 0; j < getReproductor(i).getLongitud(); j++) { 

			double media1 = ((alpha*padre1.getCromosomaAt(j).getvalorReal())+((1 - alpha)*padre2.getCromosomaAt(j).getvalorReal()))/2;
			double media2 = ((alpha*padre2.getCromosomaAt(j).getvalorReal())+((1 - alpha)*padre1.getCromosomaAt(j).getvalorReal()))/2;

			//Cambia los valores en el array fenotipos, en cada fenotipo y en el genotipo de cada individuo
			hijo1.setFenotiposAt(j, media1);
			hijo1.getCromosoma().get(j).setvalorReal(media1);
			
			//Cambiar genotipo ??
			hijo2.setFenotiposAt(j, media2);
			hijo2.getCromosoma().get(j).setvalorReal(media2);

		}
		
		setDescendienteAt(i, hijo1);
		setDescendienteAt(i+1, hijo2);
	}		
}