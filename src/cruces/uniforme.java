	package cruces;

import poblacion.poblacion;

public class uniforme extends algoritmoCruce{ //Tema 3 pagina 12

	
	
	
	public uniforme(double probCruce, poblacion seleccionados) {
		super(probCruce, seleccionados);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public poblacion cruzar() {
		seleccionaReproductores();
		creaDescendientes();
		return descendientes;
	}


/*	public poblacion iniciarPoblacion(poblacion pb, float porcnt) {
		poblacion ret = new poblacion();
		boolean existeGen;

		for(int i = 0; i < pb.getSize() - 1; i+=2) {
			for(int p = 0; p < pb.getIndividuo(i).getLongitud() - 1; p++){
				if(Math.random() <= porcnt) { //Genera cruce
          					
					gen aux, aux2;
					aux = pb.getIndividuo(i).getCromosoma().getGen(p);
         				aux2 = pb.getIndividuo(i+1).getCromosoma().getGen(p);
            
					pb.getIndividuo(i).getCromosoma().setGen(p, aux);
					pb.getIndividuo(i+1).getCromosoma().getGen(p, aux2);
          
				}
			}
		}
		
		return ret;
	}*/
	
}
