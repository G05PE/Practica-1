package cruces;

import java.util.Random;

import poblacion.individuo;
import poblacion.poblacion;

public class monopunto extends algoritmoCruce{

	private Random r;
	private double punto;
	private int num_sele_cruce;
	
	
	public monopunto() {}

	//Seleccionar individuos a cruzarse y almacenarlos en el array reproductores
	@Override	
	public poblacion cruzar(poblacion seleccionados, double prob) {
		init(prob, seleccionados);
		seleccionaReproductores();
		creaDescendientes();
		return getDescendientes();
	}
	

	private void seleccionaReproductores() {
		num_sele_cruce = 0;
		
		for(int i = 0; i < getSeleccionados().getSize(); i++) {
			if(Math.random()%1 < getProbCruce()) {
				addReprpoductor(getSeleccionadoConcreto(i));
				num_sele_cruce++;
			}		
		}

		if(this.sizeReproductor() % 2 != 0) {
			borraUltimoReproductor();
			num_sele_cruce--;
		}		
	}
	
	
	private void creaDescendientes() {
		r=new Random();
		
		//Punto es un numero entre 0 y la logitud del cromosoma
		punto = (r.nextInt()%getSeleccionadoConcreto(0).longitudCromosoma());
		if(punto < 0) punto = -punto;
		
		for(int i = 0; i < num_sele_cruce - 1; i += 2) {
			individuo padre1 = getReproductor(i), padre2 = getReproductor(i + 1);
			individuo hijo1 = new individuo(padre1), hijo2 = new individuo(padre2);
			
			mezcla(hijo1, hijo2, padre1, padre2);
			
			setDescendienteAt(i,  hijo1);
			setDescendienteAt(i+1, hijo2);
		}
	}


	private void mezcla(individuo hijo1, individuo hijo2, individuo padre1, individuo padre2) {
		
		//Incluimos por mitades
		hijo1.cruza(punto, padre2.longitudCromosoma(), padre2);
		hijo2.cruza(0, punto, padre1);
	
		//TODO Se evalua lo del fitness 
	}
	
}
