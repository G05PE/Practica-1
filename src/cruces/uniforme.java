package cruces;

import poblacion.poblacion;

public class uniforme extends algoritmoCruce{//Tema 2 pag 52

	@Override
	public poblacion iniciarPoblacion(poblacion pb, float porcnt) {
		poblacion a = new poblacion();
		int tamCromosoma = pb.getIndividuo(0).getLongitud();
		boolean existeGen;

		for(int i = 0; i < pb.getSize() - 1; i+=2) {
			for(int p = 0; p < tamCromosoma - 1; p +=2){
				if(Math.random() < porcnt) {//no es menos es ==
					existeGen = a.getIndividuo(i).getCromosoma().get(p) != null;//Accediendo a elemento no existente
					a.getIndividuo(i).getCromosoma().set(p, a.getIndividuo(i+1).getCromosoma().get(p));//Mal planteado, gen es x1 o x2 no alelos
					a.getIndividuo(i+1).getCromosoma().set(p, existeGen);
				}
			}
		}
		
		return a;
	}

	
}
