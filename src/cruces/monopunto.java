package cruces;

import poblacion.individuo;
import poblacion.poblacion;

public class monopunto extends algoritmoCruce{
	private int punto;
	private int num_sele_cruce = 0;
	private poblacion seleccionados;
	private poblacion reproductores;
	private poblacion descendientes;
	
	public monopunto(double probCruce, poblacion seleccionados) {
		super(probCruce, seleccionados);
		this.seleccionados = seleccionados;
	}

	
	//Seleccionar individuos a cruzarse y almacenarlos en el array reproductores
	@Override
	public poblacion cruzar() {
		seleccionaReproductores();
		creaDescendientes();
		return descendientes;
	}
	

	private void seleccionaReproductores() {
		for(int i = 0; i < getSeleccionados().getSize(); i++) {
			if(Math.random()%1 < getProbCruce()) {
				reproductores.addIndividuo(getSeleccionadoConcreto(i));
				num_sele_cruce++;
			}		
		}

		if(this.sizeReproductor() % 2 != 0) {
			this.borraUltimoReproductor();
			num_sele_cruce--;
		}		
	}
	
	
	private void creaDescendientes() { //Tema 3 pg 51
		punto = (int) (Math.random()%seleccionados.getIndividuo(0).getCromosoma().get(0).getGenotipo().size());
		for(int i = 0; i < num_sele_cruce; i += 2) {
			individuo hijo1 = seleccionados.getIndividuo(i), hijo2 = seleccionados.getIndividuo(i + 1);
			mezcla(hijo1, hijo2, seleccionados.getIndividuo(i), seleccionados.getIndividuo(i + 1));
			descendientes.addIndividuo(hijo1);
			descendientes.addIndividuo(hijo2);
		}
	}
	

	private void mezcla(individuo hijo1, individuo hijo2, individuo padre1, individuo padre2) {
		
		//Incluimos por mitades
		for(int i = 0; i < punto; i++) {
			hijo1.setGen(i, padre1.getCromosomaAt(i));
			hijo2.setGen(i, padre2.getCromosomaAt(i));
		}
		
		//Suponemos que ambos padres tienen la misma longitud!?
		for(int i = punto; i < padre1.getLongitud(); i++) {
				hijo1.setGen(i, padre2.getCromosomaAt(i));
				hijo2.setGen(i, padre1.getCromosomaAt(i));
		}
	
		//TODO Se evaluan
		
	}	
}
