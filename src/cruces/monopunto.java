package cruces;

import poblacion.poblacion;

public class monopunto extends algoritmoCruce{
	
	@Override
	public poblacion iniciarPoblacion(poblacion pb, float porcnt) {
		
		poblacion a = new poblacion(), b = new poblacion();
		boolean existeGen;
		int tamCromosoma = pb.getIndividuo(0).getLongitud();
		int aux;
		
		for(int i = 0; i < pb.getSize(); i++) {
			if(Math.random() < porcnt) {
				a.add(pb.getIndividuo(i).getCromosoma()); //Añadimos un nuevo cromosoma a la población
				
			}
			else  b.getIndividuo(i).getCromosoma();
		}
		
		for(int i = 0; i < a.getSize() - 1; i+=2) {
			aux = (int) ((Math.random() * tamCromosoma - 2) + 1); //Cuidado con el  -2
			for(int p = 0; p < aux; p++) {
				existeGen = a.getIndividuo(i).getCromosoma().get(p) != null;
				a.getIndividuo(i).getCromosoma().set(p, a.getIndividuo(i + 1).getCromosoma().get(p)); //Metemos el gen p del siguiente elemento
			}
		}
		
		return pb;
	}
}
