package cruces;

import poblacion.individuo;
import poblacion.poblacion;

public class monopunto extends algoritmoCruce{
	private int punto;
	
	//Seleccionar individuos a cruzarse y almacenarlos en el array reproductores
	@Override
	public poblacion cruzar(poblacion seleccionados, double prob) {
		super.seleccionaReproductores();
		creaDescendientes();
		return getDescendientes();
	}
	
	private void creaDescendientes() {
		
		//Punto es un numero entre 0 y la logitud del cromosoma
		punto = (int) (Math.random()%getSeleccionadoConcreto(0).getCromosoma().size());
		
		for(int i = 0; i < getNumSel(); i += 2) {
			individuo padre1 = getReproductor(i), padre2 = getReproductor(i + 1);
			individuo hijo1 = new individuo(padre1), hijo2 = new individuo(padre2);
			
			mezcla(hijo1, hijo2, padre1, padre2);
			
			this.addDescendiente(hijo1);
			this.addDescendiente(hijo2);
		}
	}

	private void mezcla(individuo hijo1, individuo hijo2, individuo padre1, individuo padre2) {
		
		//Incluimos por mitades
		for(int i = 0; i < punto; i++) {
			hijo1.setGen(i, padre1.getCromosomaAt(i));
			hijo2.setGen(i, padre2.getCromosomaAt(i));
		}
		
		for(int i = punto; i < padre1.getLongitud(); i++) {
			hijo1.setGen(i, padre2.getCromosomaAt(i));
			hijo2.setGen(i, padre1.getCromosomaAt(i));
		}
	
		//TODO Se evalua lo del fitness ?????
	}	
}
